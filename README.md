本项目通过本地 ollama 和 deepseek1.5b(最小配)，代码实现本地知识库，不依赖第三方工具：dify, anythingLLM 等

本项目入口:http://localhost:8089/model/chat/consult, 运行环境是：

1).jdk1.8；

2).python3.10.11；

3).使用向量数据库；

目前的展示情况：
![Image text](https://github.com/sonnycheng/DomainExpertRAG/blob/main/src/main/resources/static/img/llm_pic1.jpg)
![Image text](https://github.com/sonnycheng/DomainExpertRAG/blob/main/src/main/resources/static/img/llm_pic2.jpg)

后续需要持续优化的地方包括：

1).代码迁移到langchain4j 上，纯Java 实现；

2).增加提示词，优化输出；

3).embedding 使用模型调优，并且通过rerank 打分 query 查询结果, 优化输出质量；

4).对接知识图谱，增加推理能力；

5).优化查询性能,包括增加语义缓存和精准缓存；

6).优化代码性能，提高大模型应用的并发性能，包括：向量数据库缓存等

