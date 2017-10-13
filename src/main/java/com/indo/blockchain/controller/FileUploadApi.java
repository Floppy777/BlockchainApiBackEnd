package com.indo.blockchain.controller;

import java.io.File;
import java.nio.file.Paths;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @author florian
 *
 */
@RestController
@RequestMapping(value = "/uploadFile")
public class FileUploadApi {
	
	private final static String PATH = "/home/files";

	@RequestMapping(value = "/contract", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> uploadFile(@RequestParam("uploadfile") MultipartFile uploadfile) {
		try {
			if(!uploadfile.isEmpty()){
				String filename = uploadfile.getOriginalFilename();
				System.out.println(filename);
				String filepath = Paths.get(PATH, filename).toString();
				System.out.println(filepath);
				
				File file = new File(filepath);
				if(!file.exists()){
					System.out.println("Creation du fichier");
					file.createNewFile();
					uploadfile.transferTo(file);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}

}
