package com.kh.util;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class FileUploadUtil {
	
	private static String getSaveDirectory(HttpServletRequest request) {
		ServletContext application = request.getServletContext();
		String saveDirectory = application.getRealPath("upload");
		return saveDirectory;
	} //getSaveDirectory

	public static MultipartRequest upload(HttpServletRequest request) {
		
		String saveDirectory = getSaveDirectory(request);
		
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
	
	public static boolean delete (HttpServletRequest request, String fileName) {
		
		String saveDirectory = getSaveDirectory(request);
		
		File f = new File(saveDirectory + File.separator + fileName);
		if (f.exists()) {
			boolean result = f.delete();
			return result;
		}
		
		return false;
	} //delete
	
} //FileUploadUtil
