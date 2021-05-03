package com.example.multiPartdemo.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
	
	public void uploadToLocal(MultipartFile file);
	public void uploadToDb(MultipartFile file);

}
