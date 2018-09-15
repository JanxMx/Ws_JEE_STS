package com.vaannila.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.vaannila.domain.Contact;

public class UserDAOImpl implements UserDAO {
	private SessionFactory sessionFactory;
	Session session = null;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@SuppressWarnings("unchecked") 
	public List<Contact> selectContact() {
		System.out.println("JDBCUserDAOImpl - selectContact - paso 1");
		List<Contact> listaContactos = null;
		//Session session = null;
		
		try{
			session = sessionFactory.openSession();
			System.out.println("JDBCUserDAOImpl - selectContact - Reading Record");

			Query query = session.createQuery("from Contact");

			listaContactos = query.list();
			System.out.println("Consulta - lista de Contactos = " + listaContactos.size());
			
			for(Contact contact2 : listaContactos) {
				System.out.println("id=" + contact2.getId() + 
									"- name=" + contact2.getFirstName() + " " + contact2.getLastName() +
									"- email=" + contact2.getEmail());
			}
			
			System.out.println("Done");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			session.flush();
			session.close();
		}		
		return listaContactos;
	}
	
	@Override
	public void insertContact(Contact contact) {
		System.out.println("JDBCUserDAOImpl - insertContact - paso 1");
		//Session session = null;
		try{
			session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
			session.save(contact);
            tr.commit();
			System.out.println("Registro insertado");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			session.flush();
			session.close();
		}
	}
	
	@Override
	public void deleteContact(Contact contact) {
		System.out.println("JDBCUserDAOImpl - deleteContact - paso 1");
		//Session session = null;
		try{
			session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            System.out.println("UserDAOImpl - before delete");
            //contact.setFirstName("test");
            //contact.setLastName("two");
            //contact.setEmail("test.two@baz.com.mx");
			session.delete(contact);
			//session.delete("from contact where firstname='test'");
			System.out.println("UserDAOImpl - after delete");
            tr.commit();
			System.out.println("Registro eliminado");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			session.flush();
			session.close();
		}
	}
	
}
