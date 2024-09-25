package az.azure.manage.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * AbortPolicy策略：默认策略，如果线程池队列满了丢掉这个任务并且抛出RejectedExecutionException异常。
 * DiscardPolicy策略：如果线程池队列满了，会直接丢掉这个任务并且不会有任何异常。
 * DiscardOldestPolicy策略：如果队列满了，会将最早进入队列的任务删掉腾出空间，再尝试加入队列。
 * CallerRunsPolicy策略：如果添加到线程池失败，那么主线程会自己去执行该任务，不会等待线程池中的线程去执行。
 * @author Az
 * @date 2024/5/26
 */
@EnableAsync
@Configuration
public class TaskPoolConfig {

    @Bean
    public Executor taskExecutor1() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(10);
        executor.setKeepAliveSeconds(60);
        executor.setThreadNamePrefix("executor-1-");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }

    @Bean
    public Executor taskExecutor11() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(2);
        executor.setKeepAliveSeconds(60);
        executor.setThreadNamePrefix("executor-11-");
        // 自定义拒绝策略
//        executor.setRejectedExecutionHandler(new RejectedExecutionHandler() {
//            @Override
//            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
//                if (!executor.isShutdown()) {
//                    System.out.println("这是自定义拒绝策略");
//                    r.run();
//                }
//            }
//        });
        executor.setRejectedExecutionHandler((r, e) -> {
            if (!e.isShutdown()) {
                System.out.println("这是自定义拒绝策略-lambda");
                r.run();
            }
        });
        return executor;
    }

    @Bean
    public Executor taskExecutor2() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(3);
        executor.setQueueCapacity(10);
        executor.setKeepAliveSeconds(60);
        executor.setThreadNamePrefix("executor-2-");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }
}
