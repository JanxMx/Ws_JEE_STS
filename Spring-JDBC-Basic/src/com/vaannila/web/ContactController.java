
package com.vaannila.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.vaannila.dao.ContactDAO;
import com.vaannila.domain.Contact;

public class ContactController extends MultiActionController {

	private ContactDAO contactDAO;

	public void setContactDAO(ContactDAO contactDAO) {
		this.contactDAO = contactDAO;
	}

	public ModelAndView add(HttpServletRequest request,
			HttpServletResponse response, Contact contact) throws Exception {

		contactDAO.insertContact(contact);
	
		return new ModelAndView("redirect:list.htm");
	}

	public ModelAndView list(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("contactList", contactDAO.selectContact());
	
		modelMap.addAttribute("contact", new Contact());

		return new ModelAndView("contactForm", modelMap);
	}
}
