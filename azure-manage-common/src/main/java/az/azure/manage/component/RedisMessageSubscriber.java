package az.azure.manage.component;

import az.azure.manage.constants.RedisChanelConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;

/**
 * @author Az
 * @date 2024/5/15
 */
@Component
@Slf4j
public class RedisMessageSubscriber implements MessageListener {
    @Resource
    private RedisMessageListenerContainer redisMessageListenerContainer;

    /**
     * 订阅消息：将订阅者添加到指定的频道
     */
    @PostConstruct
    public void subscribeToChannel() {
        redisMessageListenerContainer.addMessageListener(this, new ChannelTopic(RedisChanelConstants.CHANNEL_GLOBAL_NAME));
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        String channel = new String(message.getChannel(), StandardCharsets.UTF_8);
        String receiveMessage = new String(message.getBody(), StandardCharsets.UTF_8);
        log.info("Received message: {}, from channel: {} ", receiveMessage, channel);
    }
}
