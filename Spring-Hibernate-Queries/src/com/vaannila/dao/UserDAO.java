package com.vaannila.dao;

import java.util.List;
import com.vaannila.domain.Contact;

public interface UserDAO {
	
	public List<Contact> selectContact() ;
	public void insertContact(Contact contact) ;
	public void deleteContact(Contact contact) ;
}

