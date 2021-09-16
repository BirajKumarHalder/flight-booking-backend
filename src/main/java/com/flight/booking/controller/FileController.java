package com.flight.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.flight.booking.service.FileService;

@RestController
@RequestMapping("flight")
@CrossOrigin
public class FileController {

	@Autowired
	private FileService fileService;

	@PostMapping("upload-file")
	public int uploadFile(@RequestPart("file") MultipartFile file) {
		return fileService.uploadFile(file);
	}

}
