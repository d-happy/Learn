package com.kh.util;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.kh.dao.BoardDao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class FileUploadUtil {

	public static MultipartRequest upload(HttpServletRequest request) {
		
		ServletContext application = request.getServletContext();
		String saveDirectory = application.getRealPath("upload");
		int maxSize = 5 * 1024 * 1024;
		
		try {
			MultipartRequest multi = new MultipartRequest(
					request, 
					saveDirectory, 
					maxSize, 
					"utf-8", 
					new DefaultFileRenamePolicy()
					);
			return multi;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}//upload
	
} //FileUploadUtil
