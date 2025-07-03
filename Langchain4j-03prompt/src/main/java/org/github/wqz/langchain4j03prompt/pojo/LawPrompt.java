package org.github.wqz.langchain4j03prompt.pojo;

import dev.langchain4j.model.input.structured.StructuredPrompt;
import lombok.Data;

/**
 * @Description:提示词
 * @Author: wjh
 * @Date: 2025/7/3 下午4:42
 */
@Data
@StructuredPrompt("根据中国{{legal}}法律，解答以下问题：{{question}}")
public class LawPrompt {

    private String legal;
    private String question;
}
