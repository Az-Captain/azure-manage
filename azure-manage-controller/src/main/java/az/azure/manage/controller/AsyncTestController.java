package az.azure.manage.controller;

import az.azure.manage.component.AsyncTasks;
import az.azure.manage.component.AsyncTasksV2;
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
}
