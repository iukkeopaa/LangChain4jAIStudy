package org.github.wqz.langchain4j04persistencr.Assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.UserMessage;

public interface ChatPersistenceAssistant {

    String chat(@MemoryId Long userId, @UserMessage String message);
}
