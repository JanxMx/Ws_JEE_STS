
package com.vaannila.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.vaannila.dao.UserDAO;
import com.vaannila.domain.Contact;
//import com.vaannila.domain.User;

public class UserController extends MultiActionController {

	private UserDAO userDAO;

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public ModelAndView add(HttpServletRequest request,
			HttpServletResponse response, Contact contact) throws Exception {
System.out.println("UserController - add 1");		
System.out.println("UserController - user:" + contact); 
System.out.println("UserController - user.id:" + contact.getFirstName());
System.out.println("UserController - user.name:" + contact.getLastName());
System.out.println("UserController - user.password:" + contact.getEmail());
		userDAO.insertContact(contact);
System.out.println("UserController - add 2");		
		return new ModelAndView("redirect:list.htm");
	}

	public ModelAndView list(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
System.out.println("UserController - list 1");		
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("contactList", userDAO.selectContact());
System.out.println("UserController - list 2");		
		modelMap.addAttribute("contact", new Contact());
System.out.println("UserController - list 3");		
		return new ModelAndView("userForm", modelMap);
	}
}
