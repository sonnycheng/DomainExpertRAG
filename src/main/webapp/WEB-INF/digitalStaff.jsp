<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>电子员工页面</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!-- Set render engine for 360 browser -->
<meta name="renderer" content="webkit">
<!-- No Baidu Siteapp-->
<meta http-equiv="Cache-Control" content="no-siteapp" />
</head>
<style>
    * {
    box-sizing: border-box;
    font-family: 'Source Sans Pro', sans-serif;
    font-weight: 300;
}
.floated-parent {
    overflow: auto;
}
section {
    width: 100%;
    height: 100vh;
    background-color: #EFEFEF;
}
li{
list-style:none;
}
#message-box {
    position: absolute;
    left: 0;
    right: 0;
    bottom: 0;
    top: 0;
    margin: auto;
    
    box-shadow: 0px 0px 59px 5px rgba(0, 0, 0, 0.18);
    overflow: hidden;
    width: 70%;
    height: 70%;
    max-width: 1000px;
    background-color: white;
}
nav {
    display: inline-block;
    float: left;
    width: 15%;
    height: 100%;
    padding: 20px;
    text-align: center;
    background-color: #777;
    overflow: scroll;
}
@media only screen and (max-width: 1000px) {
    nav {
        width: 25%;
    }
}
@media only screen and (max-width: 600px) {
    nav {
        width: 30%;
    }
}
::-webkit-scrollbar {
    width: 0px;
    /* remove scrollbar space */
    
    background: transparent;
    /* optional: just make scrollbar invisible */
}
.message-area {
    display: inline-block;
    float: left;
    width: 85%;
    height: 100%;
}
@media only screen and (max-width: 1000px) {
    .message-area {
        width: 85%;
    }
}
@media only screen and (max-width: 600px) {
    .message-area {
        width: 70%;
    }
}
.message-area #current-contact {
    width: 100%;
    height: 15%;
    border-bottom: 1px solid grey;
}
.message-area #current-contact h3 {
    text-align: center;
    text-transform: uppercase;
    font-weight: 300;
    letter-spacing: .1em;
    line-height: 75px;
    margin: auto;
}
.message-area #conversation-area {
    height: 75%;
    width: 100%;
    padding: 10px 40px;
    overflow: scroll;
}
@media only screen and (max-width: 600px) {
    .message-area #conversation-area {
        padding: 10px;
    }
}
.message-area #conversation-area .conversation {
    display: none;
}
.message-area #conversation-area .current {
    display: initial;
}
.message-area #conversation-area .text-bubble {
    width: 50%;
    padding: 20px 10px;
    margin: 7px;
    border-radius: 5px;  
    width: fit-content;
    max-width: 80%;
}
@media only screen and (max-width: 600px) {
    .message-area #conversation-area .text-bubble {
        width: 80%;
    }
}
.message-area #conversation-area .sent {
    background-color: #1abc9c;
    color: white;
    float: right;
    clear: both;
    font-size:13px;
}
.message-area #conversation-area .recieved {           
    background-color: #6495ed;
    color: black;
    clear: both;
    font-size:13px;
}
.message-area #conversation-area .notread {
    background-color: #00FF00;
    color: red;
    float: right;
    clear: both;
}
.message-area #text-input {
    height: 10%;
    width: 100%;
}
.message-area #text-input input {
    width: 100%;
    height: 100%;
    resize: none;
    border: none;
    font-size:17px;
    border-top: 1px solid black;
    padding: 20px 20px 20px 50px;
}
.message-area #text-input input:focus {
    outline: 0;
}
.chip {
    display: block;
    width: 80%;
    margin: 15px auto;
    border-radius: 50%;
    border: 3px solid white;
    -webkit-transition: -webkit-transform 0.2s cubic-bezier(0.87, -0.41, 0.19, 1.44);
    transition: transform 0.2s cubic-bezier(0.87, -0.41, 0.19, 1.44);
}
.chip:hover {
    transform: scale(1.05, 1.05);
}
</style>
<body>
<!--  <script src="assets/js/jquery.min.js"></script> -->
<section>
    <h3 style="text-align:center;font-size:35px">通用大模型数据增强垂直应用--领域专家</h3>  
    <div id="message-box">
        <nav id="nav">
            <img src="${ctx}/assets/images/admin.jpg" class="contact chip" id="chip-0"><span id="navp-00" style="font-size:14px;color:#FFCC00">法律顾问</span><span id="navp-01" style="font-size:10px"></span>
            <!--  
            <img src="${ctx}/assets/images/others.jpg" class="contact chip" id="chip-2">
            <img src="${ctx}/assets/images/self.jpg" class="contact chip" id="chip-3"> -->
            <!--  <img src="${ctx}/assets/images/others.jpg" class="contact chip" id="chip-4">-->
        </nav>
        <div class="message-area">
            <div id="current-contact">
                <h3>员工:张三</h3>
            </div>
            <div id="conversation-area">               
                 <div class="conversation current" id="chat-0" title="Dave">   
                     <!--                
                    <p class="text-bubble sent">21-11-29 21:46:39</br>Hey dude, what's up?</p>
                    <p class="text-bubble recieved">21-11-29 21:58:28</br>What are your plans tonight?</p>
                 
                    <p class="text-bubble recieved">Not much! Gonna watch these dota finals probably.</p>
                    <p class="text-bubble notread">Sounds good!</p>
                    <p class='text-bubble recieved'>no</p>  
                    -->               
                </div>

            </div>
            <form action="#" id="text-input">
                <input type="text" name="txt" onkeypress="handle(event)" id="text-content" autocomplete="off" placeholder="请在此处输入您的咨询问题......" />
            </form>
        </div>
    </div>
</section>
</body>
<!--  <script src="https://wow.techbrood.com/libs/jquery/jquery-1.11.1.min.js"></script>-->
<script src="${ctx}/assets/js/jquery.min.js"></script>
<script type="text/javascript">

    //新建WebSocket对象，最后的/websocket对应服务器端的@ServerEndpoint("/websocket")
    // var socket = new WebSocket('wss://localhost:8089/huzhou/imserver/${clientId}');
    // 联系 admin 的 user id 列表;
    var arrList = [];
    var firstId;
    var missReadMap = new Map();
    var i=1;
    
    // arrList.push(1);
    
    function handle(e) {
        
        if (e.keyCode == 13) {
                       
            var content = document.getElementById("text-content").value;
            // console.log(content);
            var time = new Date().Format("yyyy-MM-dd hh:mm:ss");
            var html = "<p class='text-bubble sent'>" + time+"</br>"+content + "</p>";           
            $(html).appendTo('.current');

            var divs = document.getElementsByClassName("conversation current");
            var divId = divs[0].id;
         
            var num = divId.substr(divId.lastIndexOf("-")+1,divId.length);
            if(num==0){
                  num = firstId;                 
            }	
            var toUserId  = parseInt(num);          
            
            var objDiv = document.getElementById("conversation-area");
            objDiv.scrollTop = objDiv.scrollHeight;
            document.getElementById("text-content").value = "";
            
            

            var myAjax = new XMLHttpRequest();
            // 设置请求的url参数，这是做准备工作
            myAjax.open('POST','/model/room/service');
            // 发送请求
            myAjax.send(content);
            myAjax.onreadystatechange = function () {
              if (myAjax.readyState == 4 && myAjax.status == 200) {
            	  alert("这是后台推送的消息："+myAjax.responseText);
            	  var time = new Date().Format("yyyy-MM-dd hh:mm:ss");
            	  // alert("nickname："+nickname);
			      var message = JSON.stringify({
			              content : myAjax.responseText,
			              nickname : '张三',              
			              date: time,
			              isSelf:  false
			      });                
                 console.log(JSON.parse(message));
                 addMessage(message);
              }
            }
    
        }
    
        return false;
    }
    $("#text-input").submit(function(e) {
        e.preventDefault();
    });
    
    
    /**    
    $('#chip2').click(function(){
    	$('#conversation-area').find('.conversation').hide();
    	$('#chat-2').show();
    }
    );   
    **/
    
    $(".chip").click(function() {

    	// alert("run into click!");
	    var selector = $(this).attr('id');
	    
	    var num = selector.substr(selector.lastIndexOf("-")+1,selector.length);		    
	    selector = "chat-" + num;
	    
	    $(".conversation").removeClass('current');
	    $("#" + selector).addClass("current");
	    name = $("#" + selector).attr('title');
	    $("#current-contact h3").html(name);
	    $('#conversation-area').find('.conversation').hide();
	    $('#'+selector).show();
     });

      //接收到消息的回调方法 
      // socket.onmessage = function(event) {          
      //     addMessage(event.data);          
      //  } 
      

      //将消息显示在网页上
       function setMessageInnerHTML(innerHTML) {
      	 addMessage(innerHTML);
       }

       
       // 把消息添加到聊天内容中
       function addMessage(message) {
      	    alert(message);    	
	        message = JSON.parse(message);
	        var num = message.fromId;
	        // 判断该 id 是否在列表的  list 内，如果不在，就新生一个 nav 和内容的 div;
	        var index = arrList.indexOf(num);
			
			var selector;
			if(num==firstId){
				selector = "chat-0";
			}else{
				selector = "chat-" + num;				
			}

			alert('index:'+index);		    
		    
			if(index>-1){				
				 		        
		        var divs = document.getElementsByClassName("conversation current");
		        var divId = divs[0].id;		        
				
				// var html = "<p class='text-bubble recieved'>" + message.date+"</br>"+message.content + "</p>"; 
				// var divId = 'chat-'+  String(num); 
				// alert("append div:"+divId);       
		        //  $(html).appendTo('#'+divId);
		        var childP=$('<p></p>');                //创建一个子div
                childP.attr('id','p128-1');             //给子div设置id                              
                                                      	    			            
		         if(divId==selector){			        
			         childP.addClass('text-bubble recieved');
			         childP.html(message.date+"</br>"+message.content); 
			         childP.appendTo('.current');
			     }else{			                	
			         childP.addClass('text-bubble notread');
			         childP.html(message.date+"</br>"+message.content); 
			         childP.click(function(event){   	    	          
                           $(this).removeClass("text-bubble notread");
                           $(this).addClass("text-bubble recieved");
                           // 从 map 中删除;
                           // reduceMissRead(num);
    	    	
    	             });
   	             
			         var divId2;
			         if(num==firstId){
			        	divId2 = 'chat-0' ;
				     }else{
				    	divId2 = 'chat-'+  String(num); 
					 }
			        					
					 childP.appendTo('#'+divId2);

					 // 统计未读消息数，并进行刷新
			         // countMissRead(num);					
				  }

		         var objDiv = document.getElementById("conversation-area");
	             objDiv.scrollTop = objDiv.scrollHeight;
	             document.getElementById("text-content").value = "";
	             
			}else{
				
				var size = Object.keys(arrList).length;
				
				if(size==0){
					// this num will be first message to admin;
					firstId = num;
					
					var html = "<p class='text-bubble recieved'>" + message.date+"</br>"+message.content + "</p>";        
			        $(html).appendTo('#chat-0');
			        			        
			        // $("#navp-00").html(message.nickname);
			        			       	       
			        $("#chat-0").addClass("current");
			        $("#chat-0").attr('title',message.nickname);
			        $("#chat-0").show();
			        // $("#current-contact h3").html(message.nickname); 

			        // img 显示			      
			        // $("#chip-0").show();
			        
				}else{
					// 生成 nav 和  div
					createNavAndDiv(num,message.nickname);
					// 将消息推过去, 不是 current
					var divs = document.getElementsByClassName("conversation current");
			        var divId = divs[0].id;			      
					
					// var html = "<p class='text-bubble recieved'>" + message.date+"</br>"+message.content + "</p>"; 
					// var divId = 'chat-'+  String(num); 
					// alert("append div:"+divId);       
			        //  $(html).appendTo('#'+divId);
			        var childP=$('<p></p>');                //创建一个 p 
                    childP.attr('id','p128-1');             //给子div设置id              
                                                                           	    			            
			         if(divId==selector){				         
				         childP.addClass('text-bubble recieved');
				         childP.html(message.date+"</br>"+message.content);
				         childP.appendTo('.current');
				     }else{				         
				         // css 样式改变
				         childP.addClass('text-bubble notread');
				         childP.html(message.date+"</br>"+message.content);
				         childP.click(function(event){	    	    	         
	                           $(this).removeClass("text-bubble notread");
	                           $(this).addClass("text-bubble recieved");
	                           // 从 map 中删除;
	                           // reduceMissRead(num);
	    	    	
	    	             });

				         var divId2 = 'chat-'+  String(num); 						    
						 childP.appendTo('#'+divId2);

						 // 统计未读消息数，并进行刷新
				         // countMissRead(num);	    	             			         
					  }			         
				}

				arrList.push(num);
				
		        var objDiv = document.getElementById("conversation-area");
	            objDiv.scrollTop = objDiv.scrollHeight;
	            // document.getElementById("text-content").value = "";		      
			}	        
       }

       
     Date.prototype.Format = function (fmt) {
  	     var o = {
	  	    "y+": this.getFullYear(),
	  	    "M+": this.getMonth() + 1,                 //月份
	  	    "d+": this.getDate(),                    //日
	  	    "h+": this.getHours(),                   //小时
	  	    "m+": this.getMinutes(),                 //分
	  	    "s+": this.getSeconds(),                 //秒
	  	    "q+": Math.floor((this.getMonth() + 3) / 3), //季度
	  	    "S+": this.getMilliseconds()             //毫秒
	  	  };
	  	  
	  	  for (var k in o) {
	  	    if (new RegExp("(" + k + ")").test(fmt)){
	  	      if(k == "y+"){
	  	        fmt = fmt.replace(RegExp.$1, ("" + o[k]).substr(4 - RegExp.$1.length));
	  	      }
	  	      else if(k=="S+"){
	  	        var lens = RegExp.$1.length;
	  	        lens = lens==1?3:lens;
	  	        fmt = fmt.replace(RegExp.$1, ("00" + o[k]).substr(("" + o[k]).length - 1,lens));
	  	      }
	  	      else{
	  	        fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
	  	      }
	  	    }
	  	  }
  	  return fmt;
  	}
</script>
</html>

