package az.azure.manage.service;

/**
 * @author Az
 * @date 2023/11/18
 */
public interface TaskService {

    void reportCurrentByCron();

    void delayLoop();

    void runTask();
}
