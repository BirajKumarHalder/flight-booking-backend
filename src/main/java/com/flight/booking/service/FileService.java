package com.flight.booking.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.flight.booking.repository.FileRepository;
import com.flight.booking.repository.entity.FilesEntity;

@Service
public class FileService {

	@Autowired
	private FileRepository fIleRepository;

	public Integer uploadFile(MultipartFile file) {
		FilesEntity fileEntity = new FilesEntity();
		fileEntity.setFileName(file.getOriginalFilename());
		try {
			fileEntity.setFileContent(file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fIleRepository.save(fileEntity).getFileId();
	}

}
