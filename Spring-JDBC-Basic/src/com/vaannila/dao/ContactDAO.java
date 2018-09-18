
package com.vaannila.dao;

import java.util.List;

import com.vaannila.domain.Contact;

public interface ContactDAO {
	
	public void insertContact(Contact contact) ;
	public List<Contact> selectContact() ;

}
