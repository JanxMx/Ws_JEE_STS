
package com.vaannila.dao;

import java.util.List;

import com.vaannila.domain.Contact;
//import com.vaannila.domain.User;

public interface UserDAO {
	
	//public void insertUser(User user) ;
	public void insertContact(Contact contact) ;
	public List<Contact> selectContact() ;
	//public User selectCountry(int countryId) ;
	//public User selectUser(int userId) ;
}
