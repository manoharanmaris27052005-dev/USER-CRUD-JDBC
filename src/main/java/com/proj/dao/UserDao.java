package com.proj.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.proj.entity.User;


@Repository
public class UserDao {
	@Autowired
	JdbcTemplate template;

	
		
		public void saveUser(User user) {
	        String sql = "INSERT INTO users(name, age, email) VALUES(?, ?, ?)";
	        template.update(sql, user.getName(), user.getAge(), user.getEmail());
	
		
	}

		public User getUser(int id) {
		    String sql = "SELECT * FROM users WHERE id=?";
		    
		    List<User> list = template.query(sql, (rs, rowNum) -> {
		        User u = new User();
		        u.setId(rs.getInt("id"));
		        u.setName(rs.getString("name"));
		        u.setAge(rs.getInt("age"));
		        u.setEmail(rs.getString("email"));
		        return u;
		    }, id);

		  
		    if (list.isEmpty()) {
		        return null;   
		    }

		    return list.get(0);
		}

		public void deleteUser(int id) {
			        String sql="delete from users where id=?";
			        template.update(sql,id);
			    
			   
			}


		
			 public void updateUser(User user){
			        String sql="update users set name=?,email=? where id=?";
			        template.update(sql,user.getName(),user.getEmail(),user.getId());
			    }

			 public void saveAll(List<User> users) {
				    String sql = "INSERT INTO users(name, age, email) VALUES (?, ?, ?)";

				    for (User user : users) {
				        template.update(sql, user.getName(), user.getAge(), user.getEmail());
				    }
				    
			 }

			
				
				
			 

		


	
		


			
				
			
			
			
		}
	


