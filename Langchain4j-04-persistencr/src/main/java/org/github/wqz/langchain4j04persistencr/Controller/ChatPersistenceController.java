package org.github.wqz.langchain4j04persistencr.Controller;

import cn.hutool.core.date.DateUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.github.wqz.langchain4j04persistencr.Assistant.ChatPersistenceAssistant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 聊天controller
 * @Author: wjh
 * @Date: 2025/7/3 下午5:04
 */
@RestController
@Slf4j
public class ChatPersistenceController
{
    @Resource
    private ChatPersistenceAssistant chatPersistenceAssistant;

    // http://localhost:9010/chatpersistence/redis
    @GetMapping(value = "/chatpersistence/redis")
    public String testChatPersistence()
    {
        chatPersistenceAssistant.chat(1L, "你好！我的名字是redis");
        chatPersistenceAssistant.chat(2L, "你好！我的名字是nacos");

        String chat = chatPersistenceAssistant.chat(1L, "我的名字是什么");
        System.out.println(chat);

        chat = chatPersistenceAssistant.chat(2L, "我的名字是什么");
        System.out.println(chat);

        return "testChatPersistence success : "+ DateUtil.now();
    }

}

