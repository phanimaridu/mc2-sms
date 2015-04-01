package edu.mc2.sms.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;


public abstract class GenericDao<ENTITY,KEY> {
	
	@Autowired
	protected JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public abstract void insert(ENTITY entity);
	public abstract void update(ENTITY entity);
	public abstract void delete(KEY key);
	public abstract ENTITY find(KEY key);
	public abstract List<ENTITY> find(int startIndex, int maxResults);
	public abstract long getCount();
	
}
