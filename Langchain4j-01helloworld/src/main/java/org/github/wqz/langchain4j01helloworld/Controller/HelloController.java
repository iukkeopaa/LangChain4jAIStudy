package org.github.wqz.langchain4j01helloworld.Controller;

import dev.langchain4j.model.chat.ChatModel;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 测试Langchain4j的功能
 * @Author: wjh
 * @Date: 2025/7/3 下午3:38
 */

@RestController
@Slf4j
public class HelloController {

    @Resource
    private ChatModel chatModel;


    //  localhost:9001/langchain4j/hello
    @GetMapping("/langchain4j/hello")
    public String hello(@RequestParam(value = "prompt", defaultValue = "你是谁") String prompt){

        String result = chatModel.chat(prompt);

        System.out.println("调用大模型的恢复得到：" + result);

        return result;

    }
}

// 大模型没有记忆功能

//1.localhost:8099/langchain4j/hello?prompt=Java是什么

//调用大模型的恢复得到：Java 是一种广泛使用的**高级编程语言**，最初由 **Sun Microsystems**（现为 Oracle 公司）于 1995 年发布。它是一种：
//
//- **面向对象的语言**
//- **跨平台（“一次编写，到处运行”）**
//- **具有自动内存管理机制（垃圾回收机制 GC）**
//- **多线程支持良好**
//
//---
//
//### ? Java 的核心特性
//
//| 特性 | 说明 |
//|------|------|
//| **跨平台性** | 使用 Java 编写的程序编译后生成字节码（bytecode），可以在任何安装了 JVM（Java 虚拟机）的设备上运行。 |
//| **面向对象（OOP）** | 支持封装、继承、多态等 OOP 特性，适合构建大型软件系统。 |
//| **自动内存管理** | Java 提供垃圾回收器（Garbage Collector, GC），自动管理内存分配和释放。 |
//| **安全性高** | Java 提供多层次的安全机制，适合网络环境和分布式系统开发。 |
//| **多线程支持** | 内置对多线程的支持，便于开发高性能并发程序。 |
//
//---
//
//### ? Java 的主要组成部分
//
//1. **JDK（Java Development Kit）**
//   Java 开发工具包，包含开发 Java 程序所需的所有工具，如编译器（`javac`）、运行器（`java`）、文档生成工具等。
//
//2. **JRE（Java Runtime Environment）**
//   Java 运行时环境，用于运行已编译的 Java 程序，包含 JVM 和类库。
//
//3. **JVM（Java Virtual Machine）**
//   Java 虚拟机，负责将字节码解释或编译成机器码并执行。
//
//---
//
//### ? Java 的应用领域
//
//| 应用方向 | 示例 |
//|----------|------|
//| **Web 开发** | Spring Boot、Servlet、JSP、JSF 等框架 |
//| **Android 应用开发** | Android SDK 主要使用 Java/Kotlin |
//| **企业级应用** | 大型后台系统、银行、电商系统 |
//| **大数据处理** | Hadoop、Spark 等基于 Java/Scala 构建 |
//| **桌面应用** | Swing、JavaFX |
//| **嵌入式系统** | 智能卡、传感器等小型设备中使用 |
//
//---
//
//### ? Java 示例代码
//
//```java
//public class HelloJava {
//    public static void main(String[] args) {
//        System.out.println("Hello, Java!");
//    }
//}
//```
//
//---
//
//### ? 学习资源推荐
//
//- 官方网站：[https://www.oracle.com/java/](https://www.oracle.com/java/)
//- 在线学习平台：
//  - [菜鸟教程 - Java](https://www.runoob.com/java/java-tutorial.html)
//  - [W3Schools - Java](https://www.w3schools.com/java/)
//  - [Java Design Patterns](https://refactoring.guru/design-patterns/java)
//
//---
//
//如果你是初学者，我可以为你提供一个完整的 Java 学习路线图，是否需要？?



//2.localhost:8099/langchain4j/hello?prompt=需要


//调用大模型的恢复得到：您好！看起来您可能有一个问题或者需要帮助，但您的消息中没有提供具体的信息。能否请您提供更多细节或明确一下需要哪方面的帮助？这样我可以更好地为您提供支持。?
