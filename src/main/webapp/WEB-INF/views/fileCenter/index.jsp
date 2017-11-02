    <%@ page language="java" contentType="text/html; charset=UTF-8"  
        pageEncoding="UTF-8"%>  
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
    <html>  
    <head>  
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
    <script src="js/jquery.min.js" type="text/javascript"></script>  
    </head>  
    <script type="text/javascript">  
    function upload() {  
        mydata = document.getElementById("mydata").value;  
        a = document.getElementById("upform");
        formData = new FormData(a);  
        /* formData.append("myfile1",$("#myfile1")[0].files[0]);  
        formData.append("myfile2",$("#myfile2")[0].files[0]);  
        formData.append("mydata", mydata); */  
        alert(formData);
        $.ajax({    
            contentType:"multipart/form-data",  
            url:"/uploadFile",    
            type:"POST",  
            data:formData,  
            dataType:"text",  
            processData: false,  // 告诉jQuery不要去处理发送的数据  
            contentType: false,   // 告诉jQuery不要去设置Content-Type请求头  
            success: function(data){  
                document.getElementById("tip").innerHTML = data;  
            }  
        });  
    }  
    </script>  
    <body>  
      <form id = "upform" name="upform" action="" method="POST" enctype="multipart/form-data">   
        <input type ="file" name="file" id="myfile1" multiple/><br/>   
        <input type ="file" name="file" id="myfile2" multiple/><br/>  
        说几句吧：<input type="text" name="mydata" id="mydata"/><br/>  
        <input type="button" value="确定" onclick="upload()"/><br/>   
      </form>   
      <div id="tip"></div>  
    </body>  
    </html>  