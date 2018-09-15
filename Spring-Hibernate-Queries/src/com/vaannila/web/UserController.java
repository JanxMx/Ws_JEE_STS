package com.vaannila.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.vaannila.dao.UserDAO;
import com.vaannila.domain.Contact;

public class UserController extends MultiActionController {

	private UserDAO userDAO;

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public ModelAndView list(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("contactList", userDAO.selectContact());
		modelMap.addAttribute("contact", new Contact());
		return new ModelAndView("userForm", modelMap);
	}

	public ModelAndView formDelete(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("contact", new Contact());
		return new ModelAndView("deleteForm",modelMap);
	}

	public ModelAndView add(HttpServletRequest request,
			HttpServletResponse response, Contact contact) throws Exception {
/*
System.out.println("UserController - add 1");		
System.out.println("UserController - user:" + contact); 
System.out.println("UserController - user.id:" + contact.getFirstName());
System.out.println("UserController - user.name:" + contact.getLastName());
System.out.println("UserController - user.password:" + contact.getEmail());
*/
		userDAO.insertContact(contact);
		return new ModelAndView("redirect:list.htm");
	}	
	
	public ModelAndView delete(HttpServletRequest request,
			HttpServletResponse response, Contact contact) throws Exception {
		//ModelMap modelMap = new ModelMap();
		System.out.println("contact=" + contact);
		System.out.println("contactId=" + contact.getId());
		//Contact contact = new Contact();
		//contact.setId(Long.parseLong(idContact));
		userDAO.deleteContact(contact);
		return new ModelAndView("redirect:list.htm");
	}
	
}
