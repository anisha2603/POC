package com.example.multiPartdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.multiPartdemo.model.UploadedFile;

@Repository
public interface FileUploadRepository extends JpaRepository<UploadedFile, String>{

	
}
