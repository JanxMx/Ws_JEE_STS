package com.vaannila.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import com.vaannila.domain.Contact;

public class ContactDAOImpl implements ContactDAO {

	private DataSource dataSource;
	SimpleJdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new SimpleJdbcTemplate(dataSource);
	}
	
	public void insertContact(Contact contact) {

		String query = "INSERT INTO JANX.CONTACT (ID, FIRST_NAME, LAST_NAME, EMAIL) VALUES (?,?,?,?)";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, contact.getId());		// Make this part automatic
			preparedStatement.setString(2, contact.getFirstName());
			preparedStatement.setString(3, contact.getLastName());
			preparedStatement.setString(4, contact.getEmail());
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	
	public List<Contact> selectContact() {
		List<Contact> listContact1 = new ArrayList<Contact>();
		listContact1 = jdbcTemplate.query("SELECT * FROM JANX.CONTACT",
			new ParameterizedRowMapper<Contact>() {
           		public Contact mapRow(ResultSet rs, int i) throws SQLException {
           			Contact contact = new Contact( rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4) );
           			System.out.println("------------ Contact ------------");
           			System.out.println("id: " + contact.getId());
           			System.out.println("firstName: " + contact.getFirstName());
           			System.out.println("lastName: " + contact.getLastName());
           			System.out.println("email: " + contact.getEmail());
           			return contact;
           		}
       		}			
		);
		System.out.println("DBCUserDAOImpl - listContact1:" + listContact1.size());
		return listContact1;
	}
	
}
