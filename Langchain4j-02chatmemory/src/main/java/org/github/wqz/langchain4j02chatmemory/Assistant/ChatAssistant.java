package org.github.wqz.langchain4j02chatmemory.Assistant;

public interface ChatAssistant {


    // 普通聊天对话，不带记忆功能
    String chat(String prompt);
}
