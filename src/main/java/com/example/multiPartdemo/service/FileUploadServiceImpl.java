package com.example.multiPartdemo.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.multiPartdemo.model.UploadedFile;
import com.example.multiPartdemo.repository.FileUploadRepository;

@Service
public class FileUploadServiceImpl implements FileUploadService{

	private String uplaodFolderPath = "/Users/anishau/Desktop/uploaded_";
	
	@Autowired
	private FileUploadRepository fileUploadRepository;
	
	@Override
	public void uploadToLocal(MultipartFile file) {

		try {
			byte[] data = file.getBytes();
			Path path = Paths.get(uplaodFolderPath+file.getOriginalFilename());
			Files.write(path, data);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void uploadToDb(MultipartFile file) {
		
		UploadedFile uploadedFile = new UploadedFile();
		try {
			uploadedFile.setFileData(file.getBytes());
			uploadedFile.setFileType(file.getContentType());
			uploadedFile.setFileName(file.getOriginalFilename());
			fileUploadRepository.save(uploadedFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
