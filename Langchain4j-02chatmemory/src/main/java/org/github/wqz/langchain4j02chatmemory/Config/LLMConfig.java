package org.github.wqz.langchain4j02chatmemory.Config;

import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.memory.chat.TokenWindowChatMemory;
import dev.langchain4j.model.TokenCountEstimator;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.openai.OpenAiTokenCountEstimator;
import dev.langchain4j.service.AiServices;
import org.github.wqz.langchain4j02chatmemory.Assistant.ChatAssistant;
import org.github.wqz.langchain4j02chatmemory.Assistant.ChatMemoryAssistant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: 配置类
 * @Author: wjh
 * @Date: 2025/7/3 下午4:09
 */
@Configuration
public class LLMConfig {
    @Bean
    public ChatModel chatModel()
    {
        return OpenAiChatModel.builder()
                .apiKey(System.getenv("aliapi"))
                .modelName("qwen-long")
                .baseUrl("https://dashscope.aliyuncs.com/compatible-mode/v1")
                .build();
    }

    @Bean(name = "chat")
    public ChatAssistant chatAssistant(ChatModel chatModel)
    {
        return AiServices.create(ChatAssistant.class, chatModel);
    }

    @Bean(name = "chatMessageWindowChatMemory")
    public ChatMemoryAssistant chatMessageWindowChatMemory(ChatModel chatModel)
    {

        return AiServices.builder(ChatMemoryAssistant.class)
                .chatModel(chatModel)
                //按照memoryId对应创建了一个chatMemory
                .chatMemoryProvider(memoryId -> MessageWindowChatMemory.withMaxMessages(100))
                .build();
    }

    @Bean(name = "chatTokenWindowChatMemory")
    public ChatMemoryAssistant chatTokenWindowChatMemory(ChatModel chatModel)
    {
        //1 TokenCountEstimator默认的token分词器，需要结合Tokenizer计算ChatMessage的token数量
        TokenCountEstimator openAiTokenCountEstimator = new OpenAiTokenCountEstimator("gpt-4");

        return AiServices.builder(ChatMemoryAssistant.class)
                .chatModel(chatModel)
                .chatMemoryProvider(memoryId -> TokenWindowChatMemory.withMaxTokens(1000,openAiTokenCountEstimator))
                .build();
    }
}
