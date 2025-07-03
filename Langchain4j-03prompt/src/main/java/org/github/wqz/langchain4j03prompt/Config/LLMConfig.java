package org.github.wqz.langchain4j03prompt.Config;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import org.github.wqz.langchain4j03prompt.Assistant.LawAssistant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: 配置类
 * @Author: wjh
 * @Date: 2025/7/3 下午4:43
 */
@Configuration
public class LLMConfig {
    @Bean
    public ChatModel chatModel()
    {
        return OpenAiChatModel.builder()
                .apiKey(System.getenv("aliQwen-api"))
                .modelName("qwen-long")
                .baseUrl("https://dashscope.aliyuncs.com/compatible-mode/v1")
                .build();
    }

    @Bean
    public LawAssistant lawAssistant(ChatModel chatModel) {
        return AiServices.create(LawAssistant.class, chatModel);
    }
}
