package com.klok.action;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.klok.base.action.BaseAction;
import com.opensymphony.xwork2.ActionSupport;

public class HandleUploadAction  extends BaseAction{
    private File file;
    private String fileFileName;
    private String fileContentType;

	public String up() {
    	System.out.println("--");
        // 实现上传
        String root = ServletActionContext.getRequest().getRealPath("/data");
        InputStream is;
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession(true);
		System.out.println("@@@@@@@@"+fileFileName);
		String[] type=fileFileName.split("\\.");
		System.out.println("@@@@@@@@"+type[0]+"|"+type[1]);
		String time = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		fileFileName="m"+time+"."+type[type.length-1];
		session.setAttribute("mfa", fileFileName);
		try {
			is = new FileInputStream(file);
	        File deskFile = new File(root, this.getFileFileName());
	        OutputStream os = new FileOutputStream(deskFile);
	        byte[] bytefer = new byte[1024];
	        int length = 0;
	        while ((length = is.read(bytefer)) != -1) {
	            os.write(bytefer, 0, length);
	        }
	        os.close();
	        is.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setDynamicUrl("/index.jsp");
		return this.DYNAMIC;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
    public String getFileFileName() {
        return fileFileName;
    }
    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }
    public String getFileContentType() {
        return fileContentType;
    }
    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

}
