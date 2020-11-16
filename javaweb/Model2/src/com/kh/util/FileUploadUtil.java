package com.kh.util;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class FileUploadUtil {
	
	private static String getUploadPath(HttpServletRequest request) {
		ServletContext application =  request.getServletContext(); // 내장객체 - application
		String saveDirectory = application.getRealPath("upload");
		System.out.println("saveDirectory :" + saveDirectory); // saveDirectory 콘솔
		return saveDirectory;
	} //getUploadPath

	public static MultipartRequest upload(HttpServletRequest request) { // 파일 업로드 only !!!!
		
		String saveDirectory = getUploadPath(request);
		int maxSize = 5 * 1024 * 1024; // 5MB
		
		try {
			MultipartRequest multi = new MultipartRequest(
					request,                      // 요청 정보를 담고 있는 객체
					saveDirectory,                // 파일 저장 위치
					maxSize,                      // 허용 가능한 파일의 최대 크기
					"utf-8",       				  // 인코딩
					new DefaultFileRenamePolicy() // 파일 이름이 중복될 때 처리할 객체
					);
			System.out.println("파일 업로드 완료");
			return multi;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	} //upload
	
	public static boolean delete(HttpServletRequest request, String fileName) {
		
		String saveDirectory = getUploadPath(request);
		File f = new File(saveDirectory + File.separator + fileName); // File.separator 슬래시/ 라고 보면 됨
		if (f.exists()) {
			boolean result = f.delete();
			return result;
		}
		return false;
	} //delete
	
} //FileUploadUtil
