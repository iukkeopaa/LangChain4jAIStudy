package org.github.wqz.langchain4j01helloworld.Config;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: 大模型得配置类
 * @Author: wjh
 * @Date: 2025/7/3 下午3:32
 */

@Configuration
public class LLMConfig {

    @Bean
    public ChatModel chatModelQwen(){

        return OpenAiChatModel.builder()
                .apiKey(System.getenv("aliapi"))
                .modelName("qwen-plus")
                .baseUrl("https://dashscope.aliyuncs.com/compatible-mode/v1")
                .build();
    }

}
