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

//import com.vaannila.domain.Forum;
import com.vaannila.domain.Contact;
import com.vaannila.domain.User;

public class JDBCUserDAOImpl implements UserDAO {

	private DataSource dataSource;
	SimpleJdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
		System.out.println("JDBCUserDAOImpl - entro al datasource");
		this.dataSource = dataSource;
		jdbcTemplate = new SimpleJdbcTemplate(dataSource);
		System.out.println("JDBCUserDAOImpl - datasource:" + this.dataSource.toString());
	}
/*
	public void insertUser(User user) {
		user = new User();
		user.setId(2);
		user.setName("Juan Perez");
		user.setPassword("password");
System.out.println("JDBCUserDAOImpl - paso 1");		
		String query = "INSERT INTO HR.CONTACT (ID, FIRSTNAME, LASTNAME, EMAIL) VALUES (?,?,?,?)";
System.out.println("JDBCUserDAOImpl - paso 2");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, user.getId());
			preparedStatement.setString(2, user.getName());
			preparedStatement.setString(3, user.getPassword());
System.out.println("JDBCUserDAOImpl - paso 3");			
			preparedStatement.execute();
System.out.println("JDBCUserDAOImpl - paso 4");			
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
*/
	
	public void insertContact(Contact contact) {
		//contact = new Contact();
		//contact.setFirstName("Laura");
		//contact.setLastName("Rodriguez");
		//contact.setEmail("laura_2@hotmail.com");
System.out.println("JDBCUserDAOImpl - paso 1");		
		String query = "INSERT INTO JANX.CONTACT (ID, FIRST_NAME, LAST_NAME, EMAIL) VALUES (?,?,?,?)";
System.out.println("JDBCUserDAOImpl - paso 2");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, 11);
			preparedStatement.setString(2, contact.getFirstName());
			preparedStatement.setString(3, contact.getLastName());
			preparedStatement.setString(4, contact.getEmail());
System.out.println("JDBCUserDAOImpl - paso 3");			
			preparedStatement.execute();
System.out.println("JDBCUserDAOImpl - paso 4");			
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
		System.out.println("JDBCUserDAOImpl - entro select");
		listContact1 = jdbcTemplate.query("SELECT * FROM JANX.CONTACT",
			new ParameterizedRowMapper<Contact>() {
           		public Contact mapRow(ResultSet rs, int i) throws SQLException {
           			System.out.println("JDBCUserDAOImpl - select paso 1");
           			Contact contact = new Contact( rs.getString(1), rs.getString(2), rs.getString(3) );
           			System.out.println("JDBCUserDAOImpl - firstName: " + contact.getFirstName());
           			System.out.println("JDBCUserDAOImpl - lastName: " + contact.getLastName());
           			System.out.println("JDBCUserDAOImpl - email: " + contact.getEmail());
           			return contact;
           		}
       		}			
		);
		System.out.println("DBCUserDAOImpl - listContact1:" + listContact1.size());
		return listContact1;
	}
	
	public User selectCountry(int countryId) {
System.out.println("JDBCUserDAOImpl - entro select");		
		jdbcTemplate.queryForObject(
        "SELECT * FROM COUNTRIES",
        new ParameterizedRowMapper<User>() {
            public User mapRow(ResultSet rs, int i) throws SQLException {
System.out.println("JDBCUserDAOImpl - select paso 1");			
                return new User( rs.getInt(1), rs.getString(2),null );
            }
        },
        countryId);
		return null;
	}

	public User selectUserOld(int userId) {
		System.out.println("JDBCUserDAOImpl - entro");		
				//String query = "SELECT * FROM USER WHERE FORUM_ID=?";
				String query = "SELECT * FROM JANX.USER";
		System.out.println("JDBCUserDAOImpl - paso 1");			
				Connection connection = null;
				PreparedStatement preparedStatement = null;
				ResultSet resultSet = null;
		System.out.println("JDBCUserDAOImpl - paso 2");			
				try {
					connection = dataSource.getConnection();
		System.out.println("JDBCUserDAOImpl - paso 3");			
					preparedStatement = connection.prepareStatement(query);
		System.out.println("JDBCUserDAOImpl - paso 4: ");			
					//preparedStatement.setInt(1, forumId);
					resultSet = preparedStatement.executeQuery();
		System.out.println("JDBCUserDAOImpl - paso 5");			
					User user = null;
					
					if(resultSet.next()) {
						//forum = new Forum(resultSet.getInt("FORUM_ID"),resultSet.getString("FORUM_NAME"),resultSet.getString("FORUM_DESC"));
						user = new User(resultSet.getInt("ID"),resultSet.getString("NAME"),resultSet.getString("PASSWORD"));
					}
					return user;
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						if (resultSet != null) {
							resultSet.close();
						}
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
				return null;
			}	
}
