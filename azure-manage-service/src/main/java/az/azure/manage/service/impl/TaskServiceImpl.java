package az.azure.manage.service.impl;

import az.azure.manage.service.TaskService;
import cn.hutool.core.date.LocalDateTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author Az
 * @date 2023/11/18
 */
@Service("taskService")
@Slf4j
public class TaskServiceImpl implements TaskService {
    @Override
    @Scheduled(cron = "0 */1 * * * * ")
    public void reportCurrentByCron() {
        log.info("定时每一分钟,执行时间为{}", LocalDateTimeUtil.formatNormal(LocalDateTime.now()));
    }

    @Override
    public void delayLoop() {

    }

    @Override
    public void runTask() {

    }
}
