package mx.com.test.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.com.test.validator.FileUploadValidator;
import mx.com.test.vo.FileUpload;
//import mx.com.test.vo.FileVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;


@Controller
//@SessionAttributes("fileUpload")
public class FileUploadController {

	private FileUploadValidator fileUploadValidator;

	@Autowired
	public void setFileUploadValidator(FileUploadValidator fileUploadValidator) {
		this.fileUploadValidator = fileUploadValidator;
	}	
/*	
	public FileUploadController(){
		System.out.println("FileUploadController - paso 1");		
		setCommandClass(FileUpload.class);
		System.out.println("FileUploadController - paso 2");		
		setCommandName("fileUploadForm");
	}
 
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
		HttpServletResponse response, Object command, BindException errors)
		throws Exception {
		System.out.println("FileUploadController - onSubmit - paso 3");
		FileUpload file = (FileUpload)command;
		System.out.println("FileUploadController - onSubmit - paso 4");		
		MultipartFile multipartFile = file.getFile();
		System.out.println("FileUploadController - onSubmit - paso 5");		
		String fileName="";
		System.out.println("FileUploadController - onSubmit - paso 6");
		if(multipartFile!=null){
			fileName = multipartFile.getOriginalFilename();
			//do whatever you want
			System.out.println("FileUploadController - onSubmit - paso 7");			
		}
		System.out.println("FileUploadController - onSubmit - paso 8");		
		return new ModelAndView("FileUploadSuccess","fileName",fileName);
 
	}
*/
	
	/*
	public FileUploadController(){
		System.out.println("FileUploadController - paso 1");		
		setCommandClass(FileUpload.class);
		System.out.println("FileUploadController - paso 2");		
		setCommandName("fileUploadForm");
	}
	*/

	@RequestMapping("/fileUploadForm.htm")
	public String fileUploadForm(ModelMap model) {
		System.out.println("fileUploadForm - entro al fileUploadForm");
		//model.addAttribute("fileUpload",new FileVO());
		//model.addAttribute(new FileVO());
		//System.out.println("fileUploadForm - seteo el attributo fileUpload");
		return "FileUploadForm";
	}

	@RequestMapping("/fileUploadSuccess.htm")
	public ModelAndView fileUploadSuccess(HttpServletRequest request,
			//HttpServletResponse response,@ModelAttribute("archivo") Object command, BindingResult result, BindException errors) {
			HttpServletResponse response, Object command, BindingResult result) {
			//@ModelAttribute("fileUpload") FileVO fileVO, BindingResult result) {
		System.out.println("FileUploadController - onSubmit - paso 3aa");
		System.out.println("FileUploadController - onSubmit - command =" + command);
		System.out.println("FileUploadController - onSubmit - paso 3bb");
		
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		System.out.println("FileUploadController - onSubmit - paso 3cc");
        MultipartFile multipartFile = multipartRequest.getFile("file");
        System.out.println("FileUploadController - onSubmit - paso 3dd");
        
        /*
        Files file = new Files();
        file.setFilename(multipartFile.getOriginalFilename());
        file.setNotes(ServletRequestUtils.getStringParameter(request, "notes"));
        file.setType(multipartFile.getContentType());
        file.setFile(multipartFile.getBytes());
        */
		
        byte[] byteFile = null;
        try {
			byteFile =(byte[]) multipartFile.getBytes();
			System.out.println("multipart files=" + byteFile.length);
		} catch (IOException e) {
			e.printStackTrace();
		}
        System.out.println("paso multipart");
		
		
		//Object fileT = request.getParameter("file");
		//System.out.println("FileUploadController - onSubmit - paso 3b");
		/*
		MultipartFile file2 = (MultipartFile)fileVO.getFileData(); 
		try {
			System.out.println("data:" + new String(file2.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		//if (result.hasErrors()) { 
//		FileUpload file = (FileUpload)command;
		//Byte[] file = (Byte[])command;
//		System.out.println("FileUploadController - onSubmit - paso 3c");		
		//fileUploadValidator.validate(command, result);
		//if (result.hasErrors()) {
        
        if(multipartFile!=null && multipartFile.getSize()>0) {
//			System.out.println("FileUploadController - onSubmit - paso 4a=" + file);
//			System.out.println("Multipart size=" + file);
			//FileUpload file = (FileUpload)fileVO.getFileData();
			/*
			 * FileUpload file = (FileUpload)command;
			System.out.println("FileUploadController - onSubmit - paso 4");		
			MultipartFile multipartFile = file.getFile();
			System.out.println("FileUploadController - onSubmit - paso 5");		
			String fileName="";
			System.out.println("FileUploadController - onSubmit - paso 6");
			if(multipartFile!=null){
				fileName = multipartFile.getOriginalFilename();
				//do whatever you want
				System.out.println("FileUploadController - onSubmit - paso 7");			
			}
			System.out.println("FileUploadController - onSubmit - paso 8");	
			*/
        
        	String fileName = multipartFile.getOriginalFilename();
        	//String destinyDir="C:/workspace-sts/Spring-UploadFiles/pdfFiles/";
        	String destinyDir="C:/Temp/";
//    		boolean resultado = false;
//    		InputStream is;
    		try {
//    			is = new FileInputStream(sourceDir + fileName);
    			OutputStream os = new FileOutputStream(destinyDir + fileName);
/*    			
    		    // Transfer bytes from in to out
    		    byte[] buf = new byte[1024];
    		    int len;
    		    while ((len = is.read(buf)) > 0) {
    		        os.write(buf, 0, len);
    		    }
    	    */
    			os.write(multipartFile.getBytes());
    		    
    		    os.close();
//    			is.close();
    			
//    		    resultado = true;
/*    		    
    		} catch (FileNotFoundException e) {
    			System.out.println("error al leer el archivo origen: " + fileName);
    			//logger.error("error al leer el archivo: " + sourceDir + fileName, e);
    			System.out.println("---------");
    			//e.printStackTrace();
    			 * 
    			 */
    		} catch (IOException e) {
    			System.out.println("error al copiar el archivo: " + destinyDir + fileName);
    			//logger.error("error al leer el archivo: " + sourceDir + fileName, e);
    			System.out.println("---------");
    			//e.printStackTrace();
    		}
        
			return new ModelAndView("FileUploadSuccess","fileName",fileName);
		}else{
			return new ModelAndView("FileUploadError", "message", "parece que trono esta madre");			
		}

	}	
}