package org.github.wqz.langchain4j04persistencr.Config;

import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.ChatMessageDeserializer;
import dev.langchain4j.data.message.ChatMessageSerializer;
import dev.langchain4j.store.memory.chat.ChatMemoryStore;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description: redis存储的类
 * @Author: wjh
 * @Date: 2025/7/3 下午5:04
 */
@Component
public class RedisChatMemoryStore implements ChatMemoryStore
{

    public static final String CHAT_MEMORY_PREFIX = "CHAT_MEMORY:";

    @Resource
    private RedisTemplate<String,String> redisTemplate;



    @Override
    public List<ChatMessage> getMessages(Object memoryId)
    {
        String retValue = redisTemplate.opsForValue().get(CHAT_MEMORY_PREFIX + memoryId);

        return  ChatMessageDeserializer.messagesFromJson(retValue);
    }

    @Override
    public void updateMessages(Object memoryId, List<ChatMessage> messages)
    {
        redisTemplate.opsForValue()
                .set(CHAT_MEMORY_PREFIX + memoryId, ChatMessageSerializer.messagesToJson(messages));
    }

    @Override
    public void deleteMessages(Object memoryId)
    {
        redisTemplate.delete(CHAT_MEMORY_PREFIX + memoryId);
    }
}
