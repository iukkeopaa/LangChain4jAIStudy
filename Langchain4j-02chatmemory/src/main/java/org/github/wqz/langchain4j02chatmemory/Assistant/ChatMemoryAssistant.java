package org.github.wqz.langchain4j02chatmemory.Assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.UserMessage;

public interface ChatMemoryAssistant {

    String chatWithChatMemory(@MemoryId Long userId, @UserMessage String prompt);
}
