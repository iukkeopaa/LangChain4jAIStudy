package org.github.wqz.langchain4j02chatmemory.Controller;

import cn.hutool.core.date.DateUtil;
import jakarta.annotation.Resource;
import org.github.wqz.langchain4j02chatmemory.Assistant.ChatAssistant;
import org.github.wqz.langchain4j02chatmemory.Assistant.ChatMemoryAssistant;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description: 记忆存储的controller
 * @Author: wjh
 * @Date: 2025/7/3 下午4:10
 */
public class ChatMemoryController {

    @Resource(name = "chat")
    private ChatAssistant chatAssistant;

    @Resource(name = "chatMessageWindowChatMemory")
    private ChatMemoryAssistant chatMessageWindowChatMemory;

    @Resource(name = "chatTokenWindowChatMemory")
    private ChatMemoryAssistant chatTokenWindowChatMemory;

    @GetMapping(value = "/chatmemory/test1")
    public String chat()
    {

        String answer01 = chatAssistant.chat("你好，我的名字叫张三");
        System.out.println("answer01返回结果："+answer01);

        String answer02 = chatAssistant.chat("我的名字是什么");
        System.out.println("answer02返回结果："+answer02);

        return "success : "+ DateUtil.now()+"<br> \n\n answer01: "+answer01+"<br> \n\n answer02: "+answer02;
    }

    @GetMapping(value = "/chatmemory/test2")
    public String chatMessageWindowChatMemory()
    {
        chatMessageWindowChatMemory.chatWithChatMemory(1L, "你好！我的名字是Java.");
        String answer01 = chatMessageWindowChatMemory.chatWithChatMemory(1L, "我的名字是什么");
        System.out.println("answer01返回结果："+answer01);

        chatMessageWindowChatMemory.chatWithChatMemory(3L, "你好！我的名字是C++");
        String answer02 = chatMessageWindowChatMemory.chatWithChatMemory(3L, "我的名字是什么");
        System.out.println("answer02返回结果："+answer02);

        return "chatMessageWindowChatMemory success : "
                + DateUtil.now()+"<br> \n\n answer01: "+answer01+"<br> \n\n answer02: "+answer02;

    }

    @GetMapping(value = "/chatmemory/test3")
    public String chatTokenWindowChatMemory()
    {
        chatTokenWindowChatMemory.chatWithChatMemory(1L, "你好！我的名字是mysql");
        String answer01 = chatTokenWindowChatMemory.chatWithChatMemory(1L, "我的名字是什么");
        System.out.println("answer01返回结果："+answer01);

        chatTokenWindowChatMemory.chatWithChatMemory(3L, "你好！我的名字是oracle");
        String answer02 = chatTokenWindowChatMemory.chatWithChatMemory(3L, "我的名字是什么");
        System.out.println("answer02返回结果："+answer02);

        return "chatTokenWindowChatMemory success : "
                + DateUtil.now()+"<br> \n\n answer01: "+answer01+"<br> \n\n answer02: "+answer02;
    }
}
