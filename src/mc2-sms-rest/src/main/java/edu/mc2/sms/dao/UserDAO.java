package edu.mc2.sms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import edu.mc2.sms.model.User;

@Repository
public class UserDAO extends GenericDao<User, String>{

	
	@Override
	public void insert(User user) {
		// TODO Auto-generated method stub
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String key) {
		// TODO Auto-generated method stub
		
	}

	//TODO:Use params
	@Override
	public List<User> find(int startIndex, int maxResults) {
		String SQL = "SELECT * FROM USER";
		List<User> users = null;
		try{
			users = getJdbcTemplate().query(SQL, new UserDAO.UserRowMapper());
		}catch(EmptyResultDataAccessException e){
			//log exception and return empty list
			users = new ArrayList<User>();
		}
		return users;
	}

	@Override
	public long getCount() {
		String SQL = "SELECT COUNT(*) FROM USER";
		return getJdbcTemplate().queryForObject(SQL, Long.class);
	}

	//write a single query to get all results
	@Override
	public User find(String userName) {
		String SQL = "SELECT * FROM USER WHERE user_name = ?";
		User user = null;
		try{
			user = getJdbcTemplate().queryForObject(SQL, new Object[]{userName}, new UserRowMapper());
			
			//Query for user roles here
			String roleSQL = "SELECT r.name FROM user_in_role uie INNER JOIN role r ON r.id = uie.role_id WHERE user_name = ?";
			user.setRoles(getJdbcTemplate().queryForList(roleSQL,new Object[]{user.getUserName()},String.class));
			
		}catch(EmptyResultDataAccessException e){
			//log exception
		}
	
		return user;
	}

	
	
	private static final class UserRowMapper implements RowMapper<User>{

		@Override
		public User mapRow(ResultSet rs, int rowNo) throws SQLException {
			/*
			 * user_name varchar 
			 * password varchar 
			 * active tinyint 
			 * created_ts datetime 
			 * modified_ts datetime 
			 * last_access_ts datetime
			 * credentials_expire_ts datetime 
			 * account_expire_ts datetime
			 */

			User user = new User(rs.getString("user_name"),rs.getString("password"),
								 rs.getBoolean("active"),rs.getDate("created_ts"),
								 rs.getDate("modified_ts"),rs.getDate("last_access_ts"),
								 rs.getDate("credentials_expire_ts"),rs.getDate("account_expire_ts"));
			
			
			return user;
		}
		
	}

}
