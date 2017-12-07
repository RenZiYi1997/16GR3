package com.rzy.t7.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author S01
 * 任子屹
 *
 */
public class FileAction extends ActionSupport {
	private String username;//上传者用户名
	private File uploadFile;//上传的文件
	
	private String uploadFileFileName;//上传文件的名称
	private String uploadFileContentType;//文件上传类型
	
	public String upload() {
		if(uploadFile!=null) {
			/*
			 * 上传的业务：
			 * 1，读取上传的文件：
			 * 		读：输入流--》先获取上传文件的输入流
			 * 2，保存到服务器：
			 * 		写之前：创建保存的文件（localhost:8081/StrutsT07/upload/uploadFileFileName）创建文件
			 * 		写:输出流-->根据创建的文件，写入数据
			 * */
			try {
				//读取上传的文件：
				InputStream is = new FileInputStream(uploadFile);
				String savePath = ServletActionContext.getServletContext().getRealPath("/")+"upload";
				File file = new File(savePath);
				if(!file.exists()) {
					file.mkdirs();
				}
				//写:输出流
				OutputStream os = new FileOutputStream(savePath+"/"+uploadFileFileName);
				//添加缓冲区
				//根据创建的文件，写入数据
				byte[] buffer = new byte[8096];
				int len = 0;
				while((len=is.read(buffer)) != -1) {
					os.write(buffer, 0, len);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				super.addFieldError("uploadFile", "文件未找到!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				super.addFieldError("uploadFile", "文件保存失败!");
			}
		}else {
			//文件未找到
			super.addFieldError("uploadFile", "文件未找到");
		}
		return "uplaodSuccess";
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public File getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}
	public String getUploadFileFileName() {
		return uploadFileFileName;
	}
	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}
	public String getUploadFileContentType() {
		return uploadFileContentType;
	}
	public void setUploadFileContentType(String uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}
}
