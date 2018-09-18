package mx.com.test.vo;

import org.springframework.web.multipart.MultipartFile;

public class FileUpload{
	
	MultipartFile file;

	public MultipartFile getFile() {
		System.out.println("FileUpload - getFile 1");		
		return file;
	}

	public void setFile(MultipartFile file) {
		System.out.println("FileUpload - setFile 2");
		this.file = file;
	}

}