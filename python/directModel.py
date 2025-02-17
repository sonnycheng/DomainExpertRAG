from langchain_ollama import ChatOllama

class DirectModel:
    
    def __init__(self):
        self = self
    
    def getModelResponse(self,question): 
        
        llm = ChatOllama(base_url="http://localhost:11434", model="deepseek-r1:1.5b")
        # µ÷ÓÃ
        print(question) 
        result = llm.invoke(question)

        #print(result)
        print(result)
        return result   
    