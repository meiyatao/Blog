package com.Blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.BufferedInputStream;  
import java.io.BufferedOutputStream;  
import java.io.File;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.Date;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
import org.apache.commons.fileupload.FileItem;  
import org.apache.commons.fileupload.disk.DiskFileItemFactory;  
import org.apache.commons.fileupload.servlet.ServletFileUpload;  
import org.apache.commons.fileupload.util.Streams; 
@Controller
public class FileController {
	private static final long serialVersionUID = 1L;  
	  
  
    @RequestMapping("/uploadFile")
    public void uploadFile(HttpServletRequest request,  
            HttpServletResponse response) throws ServletException, IOException {  
        String savePath = request.getServletContext().getRealPath("/WEB-INF/upload"); 
        String retMsg = "";//定义将返回给客户端的信息  
        try {  
            if (ServletFileUpload.isMultipartContent(request)) {  
                List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);  
                for (FileItem item : items) {  
                    if (!item.isFormField()) {// 过滤掉表单中非文件域  
                        String fileType = item.getName().substring(item.getName().lastIndexOf(".") + 1).toLowerCase();//文件类型  
                        String fileName = new Date().getTime() + "." + fileType; //保存的文件名  
                        String filePath = savePath + "\\" + fileName; //保存的文件路径  
                        System.out.println(item.getSize());
                        BufferedInputStream in = new BufferedInputStream(item.getInputStream());// 获得文件输入流  
                        BufferedOutputStream out = new BufferedOutputStream(  
                                new FileOutputStream(new File(filePath)));// 获得文件输出流  
                        Streams.copy(in, out, true);// 开始把文件写到指定的上传文件夹  
                        retMsg += "上传文件成功！";  
                        in.close();  
                        out.close();  
                    } else {  
                         retMsg += "您输入了:" + new String(item.getString().getBytes("iso-8859-1"),"utf-8");  
                    }  
                }  
            }  
            response.setContentType("text/html;charset=utf8");  
            PrintWriter pw = response.getWriter();  
            pw.print(retMsg);  
            pw.flush();  
            pw.close();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
}
