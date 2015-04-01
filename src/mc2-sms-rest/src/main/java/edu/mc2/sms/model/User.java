package edu.mc2.sms.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
	
public class User {

	private String userName;
	@JsonIgnore
	private String password;
	private boolean active;
	private Date createdTS;
	private Date modifiedTS;
	private Date lastAccessTS;
	private Date credentialsExpireTS;
	private Date accountExpireTS;
	
	private List<String> roles;

	
	public User() {
		super();
	}

	public User(String userName, String password, boolean active,
			Date createdTS, Date modifiedTS, Date lastAccessTS,
			Date credentialsExpireTS, Date accountExpireTS) {
		super();
		this.userName = userName;
		this.password = password;
		this.active = active;
		this.createdTS = createdTS;
		this.modifiedTS = modifiedTS;
		this.lastAccessTS = lastAccessTS;
		this.credentialsExpireTS = credentialsExpireTS;
		this.accountExpireTS = accountExpireTS;
	}

	public User(String userName, String password, boolean active,
			Date createdTS, Date modifiedTS, Date lastAccessTS,
			Date credentialsExpireTS, Date accountExpireTS, List<String> roles) {
		super();
		this.userName = userName;
		this.password = password;
		this.active = active;
		this.createdTS = createdTS;
		this.modifiedTS = modifiedTS;
		this.lastAccessTS = lastAccessTS;
		this.credentialsExpireTS = credentialsExpireTS;
		this.accountExpireTS = accountExpireTS;
		this.roles = roles;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getCreatedTS() {
		return createdTS;
	}

	public void setCreatedTS(Date createdTS) {
		this.createdTS = createdTS;
	}

	public Date getModifiedTS() {
		return modifiedTS;
	}

	public void setModifiedTS(Date modifiedTS) {
		this.modifiedTS = modifiedTS;
	}

	public Date getLastAccessTS() {
		return lastAccessTS;
	}

	public void setLastAccessTS(Date lastAccessTS) {
		this.lastAccessTS = lastAccessTS;
	}

	public Date getCredentialsExpireTS() {
		return credentialsExpireTS;
	}

	public void setCredentialsExpireTS(Date credentialsExpireTS) {
		this.credentialsExpireTS = credentialsExpireTS;
	}

	public Date getAccountExpireTS() {
		return accountExpireTS;
	}

	public void setAccountExpireTS(Date accountExpireTS) {
		this.accountExpireTS = accountExpireTS;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password
				+ ", active=" + active + ", createdTS=" + createdTS
				+ ", modifiedTS=" + modifiedTS + ", lastAccessTS="
				+ lastAccessTS + ", credentialsExpireTS=" + credentialsExpireTS
				+ ", accountExpireTS=" + accountExpireTS + ", roles=" + roles
				+ "]";
	}
	
	
}
