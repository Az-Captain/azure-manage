package az.azure.manage.controller;

import az.azure.manage.component.AsyncTasks;
import az.azure.manage.component.AsyncTasksV2;
import az.azure.manage.component.AsyncTasksV3;
import cn.hutool.core.date.StopWatch;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.CompletableFuture;

/**
 * @author Az
 * @date 2024/5/22
 */
@RestController
@RequestMapping("/async")
@Slf4j
@Api(tags = "异步调用测试")
public class AsyncTestController {
    @Resource
    private AsyncTasks asyncTasks;
    @Resource
    private AsyncTasksV2 asyncTasksV2;
    @Resource
    private AsyncTasksV3 asyncTasksV3;

    @GetMapping("test")
    @ApiOperation("挨个串行执行")
    public void test() throws Exception {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        asyncTasks.doTaskOne();
        asyncTasks.doTaskTwo();
        asyncTasks.doTaskThree();
        stopWatch.stop();
        log.info("任务全部执行完成，总共花费时间为：{}", stopWatch.getTotalTimeSeconds());
    }

    @GetMapping("test/v2")
    @ApiOperation("并发执行")
    public void testV2() throws Exception {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        CompletableFuture<String> taskOne = asyncTasksV2.doTaskOne();
        CompletableFuture<String> taskTwo = asyncTasksV2.doTaskTwo();
        CompletableFuture<String> taskThree = asyncTasksV2.doTaskThree();
        CompletableFuture.allOf(taskOne, taskTwo, taskThree).join();
        stopWatch.stop();
        log.info("任务全部执行完成，总共花费时间为：{}", stopWatch.getTotalTimeSeconds());
    }

    /******************************************************
     * 线程池隔离
     * @return
     *******************************************************/

    @GetMapping("/api-1")
    @ApiOperation("测试线程池1")
    public String taskOne() throws Exception {
        CompletableFuture<String> task1 = asyncTasksV3.doTaskOne("1");
        CompletableFuture<String> task2 = asyncTasksV3.doTaskOne("2");
        CompletableFuture<String> task3 = asyncTasksV3.doTaskOne("3");

        CompletableFuture.allOf(task1, task2, task3).join();
        return "测试线程池1-ok";
    }

    @GetMapping("/api-2")
    @ApiOperation("测试线程池2")
    public String taskTwo() throws Exception {
        CompletableFuture<String> task1 = asyncTasksV3.doTaskTwo("1");
        CompletableFuture<String> task2 = asyncTasksV3.doTaskTwo("2");
        CompletableFuture<String> task3 = asyncTasksV3.doTaskTwo("3");

        CompletableFuture.allOf(task1, task2, task3).join();
        return "测试线程池2-ok";
    }

    @GetMapping("/test/v3")
    @ApiOperation("同时执行线程池1和线程池2的任务")
    public String taskV3() throws Exception {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        // 线程池1
        CompletableFuture<String> task11 = asyncTasksV3.doTaskOne("11");
        CompletableFuture<String> task12 = asyncTasksV3.doTaskOne("12");
        CompletableFuture<String> task13 = asyncTasksV3.doTaskOne("13");

        // 线程池2
        CompletableFuture<String> task21 = asyncTasksV3.doTaskTwo("21");
        CompletableFuture<String> task22 = asyncTasksV3.doTaskTwo("22");
        CompletableFuture<String> task23 = asyncTasksV3.doTaskTwo("23");

        CompletableFuture.allOf(task11, task12, task13, task21, task22, task23).join();
        stopWatch.stop();
        log.info("总共耗时：{}s",stopWatch.getTotalTimeSeconds());
        return "总共耗时："+stopWatch.getTotalTimeSeconds();
    }

    @GetMapping("/test/rejected")
    @ApiOperation("配置拒绝策略")
    public String testRejected() throws Exception {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        CompletableFuture<String> task1 = asyncTasksV3.doTaskOneOne("11");
        CompletableFuture<String> task2 = asyncTasksV3.doTaskOneOne("22");
        CompletableFuture<String> task3 = asyncTasksV3.doTaskOneOne("33");
        CompletableFuture<String> task4 = asyncTasksV3.doTaskOneOne("44");
        CompletableFuture<String> task5 = asyncTasksV3.doTaskOneOne("55");

        CompletableFuture.allOf(task1,task2,task3,task4,task5).join();
        stopWatch.stop();
        return "总执行时间"+stopWatch.getTotalTimeMillis();
    }

}
