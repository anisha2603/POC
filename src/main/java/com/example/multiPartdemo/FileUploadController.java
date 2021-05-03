package com.example.multiPartdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.multiPartdemo.service.FileUploadService;

@RestController
@RequestMapping("api/v1")
public class FileUploadController {
	
	@Autowired
	private FileUploadService fileUploadService;
	
	@PostMapping("upload/local")
	public void uploadLocal(@RequestParam("file")MultipartFile multipartFile) {
		fileUploadService.uploadToLocal(multipartFile);
		
	}
	
	@PostMapping("/upload/db")
	public void uploadToDb(@RequestParam("file")MultipartFile multipartFile) {
		fileUploadService.uploadToDb(multipartFile);
}
}