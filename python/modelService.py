from langchain import LLMChain
from langchain.document_loaders import TextLoader
from langchain.text_splitter import CharacterTextSplitter
from langchain_experimental.text_splitter import SemanticChunker 
from langchain.embeddings.openai import OpenAIEmbeddings
from langchain.vectorstores import Chroma
from langchain.prompts import PromptTemplate
from langchain.memory import ConversationBufferMemory
from langchain.chains import ConversationalRetrievalChain
from langchain.prompts.chat import ChatPromptTemplate, SystemMessagePromptTemplate, HumanMessagePromptTemplate
from langchain_community.chat_models import ChatOllama
from langchain.text_splitter import RecursiveCharacterTextSplitter


loader = TextLoader("D:/workspace_wanda/test/file")
documents = loader.load()

#文本分割
text_splitter = CharacterTextSplitter(separator="\n",chunk_size=50, chunk_overlap=0)
documents = text_splitter.split_documents(documents)

embedding = OpenAIEmbeddings()

# load data to Chroma db
db = Chroma.from_documents(documents,model,persist_directory='./')


llm = ChatOllama(base_url="http://localhost:11434", model="deepseek-r1:1.5b",temperature=0.1)

retriever = db.as_retriever()
memory = ConversationBufferMemory(memory_key="chat_history", return_messages=True)
qa = ConversationalRetrievalChain.from_llm(llm, retriever, memory=memory)
result = qa({"question": "什么样的行为被视为是受贿行为，可以被量刑?"})
#print(result)
print(result["answer"])   
    