package mx.com.test.validator;

import mx.com.test.vo.FileUpload;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class FileUploadValidator implements Validator{

	@Override
	public boolean supports(Class clazz) {
		System.out.println("FileUploadValidator - supports");
		return FileUpload.class.isAssignableFrom(clazz);

	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("FileUploadValidator - validate 1");		
		FileUpload file = (FileUpload)target;
		System.out.println("FileUploadValidator - validate 2");		
		if(file.getFile().getSize()==0){
			System.out.println("FileUploadValidator - validate 3");			
			errors.rejectValue("file", "required.fileUpload");
		}
	}
	
}