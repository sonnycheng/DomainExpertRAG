from flask import Flask,jsonify, request
from pathlib import Path
#from service.modelService import ModelService
from modelService import ModelService
import sys
sys.stdout = open(sys.stdout.fileno(), mode='w', encoding='utf-8', buffering=1)
from directModel import DirectModel

app = Flask(__name__)
app.debug=True
#app.config['JSON_AS_ASCII'] = False
app.json.ensure_ascii = False

@app.route('/hello')
def hello():
    return jsonify(message='Hello World!')

@app.route('/greet',methods=['GET','POST'])
def greet():
    
    result = ''
    if request.method == 'POST':
        # 处理POST请求
        data = request.form if request.form else request.json
        # 例如，你可以这样处理表单数据或JSON数据
        message = data.get('message')
        modelService = ModelService()
        vectorstore = modelService.getDomainVector()
        result = modelService.initQa(vectorstore,message)
        
        #print(reply.content)
    elif request.method == 'GET':
        # 处理GET请求
        result = request.args.get('message', None)  # 获取URL参数
        # 例如，你可以这样处理GET请求中的参数
        print(result)
        
    print(result)
    return result
#   return jsonify(message=f"Hello,{name}!")

#URL 进行 GET 请求: http://localhost:6678/modelService?message=John&age=30
@app.route('/modelService',methods=['GET','POST'])
def modelService():
    
    reply = ''
    if request.method == 'POST':
        # 处理POST请求
        data = request.form if request.form else request.json
        # 例如，你可以这样处理表单数据或JSON数据
        message = data.get('message')
        directModel = DirectModel()
        reply =directModel.getModelResponse(message)
        
        print(reply.content)
    elif request.method == 'GET':
        # 处理GET请求
        message = request.args.get('message', None)  # 获取URL参数
        # 例如，你可以这样处理GET请求中的参数
        print(message)

    result = 'reply:'+ message
    return reply.content

@app.route('/add')
def add():
    data = request.get_json()
    num1 = data.get('num1')
    num2 = data.get('num2')
    if num1 is None or num2 is None:
        return jsonify({"error":"Invalid input"}),400 
    result = num1 + num2  
    return jsonify(result = result)


if __name__ == '__main__':
    print("this is my first flask!")
    # check if exist chroma.sqlite3 file
    path = '../chroma.sqlite3'
    file_path = Path(path)
    if not file_path.exists():
       print("knowledge vetor need to be filled!")
       modelService = ModelService();
       modelService.scanDomainVector("","")
    else:
       print("knowledge vetor db have been created!")
    app.run(port=6678)