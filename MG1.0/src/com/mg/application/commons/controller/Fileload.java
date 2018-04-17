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
		//���������ϴ��ļ���·��
        String wkpicpath = null;
        String hdpicpath = null;
        String errorinfo = null;
        //�����ϴ����̹�����
        boolean flag = true;
        //�����ļ������λ��
        String path = request.getSession().getServletContext().getRealPath("file");
        //ѭ����ȡ�ļ���Ϣ
        for(int i=0;i<file.length;i++){
            MultipartFile attach = file[i];
            //�ж��ļ��Ƿ�Ϊ��
            if(!attach.isEmpty()){
                //�ж��ǵڼ����ļ�
                if(i==0){
                    errorinfo = "uploadwkError";
                }else if(i==1){
                    errorinfo = "uploadhdError";
                }
            //��ȡԴ�ļ���
            String oldName= attach.getOriginalFilename();
            //��ȡԴ�ļ�����׺
            String prefixName = FilenameUtils.getExtension(oldName);
            
            int fileSize = 50000000;
            //�ж��ϴ���С���ó���500K
            if(attach.getSize()>fileSize){
            	request.getSession().setAttribute(errorinfo, "�ϴ��ļ����ô���500k");
                flag = false;
            }else{
                //�ж��ϴ���ʽ
                //�����µ��ļ�������ǰϵͳʱ��+�����+�̶���׺��
                //RandomUtils��Ҫ����jar�ļ�commons-lang.jar
//String fileName = System.currentTimeMillis()+RandomUtils.nextInt(1000000)+"personer.jpg";
                String fileName = System.currentTimeMillis()+"personer.jpg";
                //�����µ��ļ������ڽ����û��ϴ����ļ���
                File targetFile = new File(path, oldName+".mp4");
                if(!targetFile.exists()){
                    targetFile.mkdirs();
                }
                
                //���ϴ����ļ�����
                try {
                    attach.transferTo(targetFile);
                } catch (Exception e) {
                    e.printStackTrace();
                    request.getSession().setAttribute(errorinfo,"�ϴ�ʧ�ܣ�");
                    flag = false;
                } 
                
                //�����ϴ���·��
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
		// ��byte���ķ�ʽ���ļ� d:\1.gif
		FileInputStream hFile = new FileInputStream("E:/tomcat/apache-tomcat-7.0.84/webapps/MG1.0/file/2.jpg");
		//�õ��ļ���С
		int i=hFile.available();
		byte data[]=new byte[i];
		//������
		hFile.read(data);

		//�õ���ͻ���������������ݵĶ���
		HttpServletResponse response = null;
		//response.getOutputStream()
							 // response.getOutputStream().write(bytes);
		OutputStream toClient=response.getOutputStream();
		//�������
		toClient.write(data);

			toClient.flush();
			toClient.close();
			hFile.close(); 
		}
	
	@RequestMapping("/tests")//����·��
    public void getIcon(@RequestBody String index,HttpServletRequest request,
    		           HttpServletResponse response) throws IOException {//index��ָ�������ĸ���Ƶ��
	    long start=System.currentTimeMillis(); //��ȡ��ʼʱ��  
        File file = null;
        String path = null;
        System.out.println(index+"INDEX");
        path = "E:/tomcat/apache-tomcat-7.0.84/webapps/MG1.0/file/"+index+".mp4";//��ȡ�������Ƶ�ļ�
        file = new File(path);
        FileInputStream inputStream = new FileInputStream(file); //���ļ�ת���ɶ������� 
        byte[] data = new byte[(int)file.length()];  
        int length = inputStream.read(data);  
        inputStream.close();  //�رն�������
        // response.setContentType("image/jpg"); //���÷����ļ��ĸ�ʽ 
        OutputStream stream = response.getOutputStream();  
        stream.write(data);  //�Ѷ�������д�뵽baty����
        stream.flush();  
        stream.close();
        long end=System.currentTimeMillis(); //��ȡ����ʱ��  
        System.out.println("��������ʱ�䣺 "+(end-start)+"ms");
	}
    /** 
     * ����byte���飬�����ļ� 
     */  
    public static void getFile(byte[] bfile, String filePath,String fileName){  
        BufferedOutputStream bos = null;  
        FileOutputStream fos = null;  
        File file = null;  
        try {  
        	
            File dir = new File(filePath);  
            if(!dir.exists()&&dir.isDirectory()){//�ж��ļ�Ŀ¼�Ƿ����  
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
