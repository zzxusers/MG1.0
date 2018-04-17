package com.mg.application.commons.controller;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.GZIPInputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.util.DateUtil;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.mg.application.user.util.Get_json;

@Controller
public class Fileload {
	@RequestMapping(value="/FileUpload",produces={"application/json;charset=utf-8"},method=RequestMethod.POST)
	@ResponseBody
    public String  springUpload(HttpServletRequest request,@RequestParam MultipartFile[] file) throws IllegalStateException, IOException{
		//定义两个上传文件的路径
        String wkpicpath = null;
        String hdpicpath = null;
        String errorinfo = null;
        //定义上传过程管理标记
        boolean flag = true;
        //定义文件保存的位置
        String path = request.getSession().getServletContext().getRealPath("file");
        //循环读取文件信息
        for(int i=0;i<file.length;i++){
            MultipartFile attach = file[i];
            //判断文件是否为空
            if(!attach.isEmpty()){
                //判断是第几个文件
                if(i==0){
                    errorinfo = "uploadwkError";
                }else if(i==1){
                    errorinfo = "uploadhdError";
                }
            //获取源文件名
            String oldName= attach.getOriginalFilename();
            //获取源文件名后缀
            String prefixName = FilenameUtils.getExtension(oldName);
            
            int fileSize = 50000000;
            //判断上传大小不得超过500K
            if(attach.getSize()>fileSize){
            	request.getSession().setAttribute(errorinfo, "上传文件不得大于500k");
                flag = false;
            }else{
                //判断上传格式
                //定义新的文件名，当前系统时间+随机数+固定后缀，
                //RandomUtils需要引入jar文件commons-lang.jar
//String fileName = System.currentTimeMillis()+RandomUtils.nextInt(1000000)+"personer.jpg";
                String fileName = System.currentTimeMillis()+"personer.jpg";
                //创建新的文件，用于接收用户上传的文件流
                File targetFile = new File(path, oldName+".mp4");
                if(!targetFile.exists()){
                    targetFile.mkdirs();
                }
                
                //将上传的文件保存
                try {
                    attach.transferTo(targetFile);
                } catch (Exception e) {
                    e.printStackTrace();
                    request.getSession().setAttribute(errorinfo,"上传失败！");
                    flag = false;
                } 
                
                //更新上传的路径
                if(i==0){
                    wkpicpath = path + File.separator + fileName;
                }else if(i==1){
                    hdpicpath = path + File.separator + fileName;
                }                
            }            
           }        
        }
		return JSON.toJSONString(errorinfo);  
     
    }
	
	@RequestMapping(value="/returnFile",produces={"application/json;charset=utf-8"},method=RequestMethod.POST)
	@ResponseBody
	public void file() throws IOException{
		// 以byte流的方式打开文件 d:\1.gif
		FileInputStream hFile = new FileInputStream("E:/tomcat/apache-tomcat-7.0.84/webapps/MG1.0/file/2.jpg");
		//得到文件大小
		int i=hFile.available();
		byte data[]=new byte[i];
		//读数据
		hFile.read(data);

		//得到向客户端输出二进制数据的对象
		HttpServletResponse response = null;
		//response.getOutputStream()
							 // response.getOutputStream().write(bytes);
		OutputStream toClient=response.getOutputStream();
		//输出数据
		toClient.write(data);

			toClient.flush();
			toClient.close();
			hFile.close(); 
		}
	
	@RequestMapping("/tests")//请求路径
    public void getIcon(@RequestBody String index,HttpServletRequest request,
    		           HttpServletResponse response) throws IOException {//index是指定播放哪个视频的
	    long start=System.currentTimeMillis(); //获取开始时间  
        File file = null;
        String path = null;
        System.out.println(index+"INDEX");
        path = "E:/tomcat/apache-tomcat-7.0.84/webapps/MG1.0/file/"+index+".mp4";//获取具体的视频文件
        file = new File(path);
        FileInputStream inputStream = new FileInputStream(file); //将文件转换成二进制流 
        byte[] data = new byte[(int)file.length()];  
        int length = inputStream.read(data);  
        inputStream.close();  //关闭二进制流
        // response.setContentType("image/jpg"); //设置返回文件的格式 
        OutputStream stream = response.getOutputStream();  
        stream.write(data);  //把二进制流写入到baty数组
        stream.flush();  
        stream.close();
        long end=System.currentTimeMillis(); //获取结束时间  
        System.out.println("程序运行时间： "+(end-start)+"ms");
	}
    /** 
     * 根据byte数组，生成文件 
     */  
    public static void getFile(byte[] bfile, String filePath,String fileName){  
        BufferedOutputStream bos = null;  
        FileOutputStream fos = null;  
        File file = null;  
        try {  
        	
            File dir = new File(filePath);  
            if(!dir.exists()&&dir.isDirectory()){//判断文件目录是否存在  
                dir.mkdirs();  
            }  
            file = new File(filePath+"\\"+fileName);  
            fos = new FileOutputStream(file);  
            bos = new BufferedOutputStream(fos);  
            bos.write(bfile);  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            if (bos != null) {  
                try {  
                    bos.close();  
                } catch (IOException e1) {  
                    e1.printStackTrace();  
                }  
            }  
            if (fos != null) {  
                try {  
                    fos.close();  
                } catch (IOException e1) {  
                    e1.printStackTrace();  
                }  
            }  
        }  
    }  
}
