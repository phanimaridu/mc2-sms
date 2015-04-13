package edu.mc2.sms.jpa.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
@Inheritance(strategy=InheritanceType.JOINED)
@JsonSerialize(include=JsonSerialize.Inclusion.NON_DEFAULT)
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="user_name")
	private String userName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="account_expire_dtt")
	private Date accountExpireDtt;

	private byte active;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="credentials_expire_dtt")
	private Date credentialsExpireDtt;

	@Column(name="e_mail")
	private String eMail;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_access_dtt")
	private Date lastAccessDtt;

	@JsonIgnore
	private String password;

	@JsonIgnore
	@Column(name="password_salt")
	private String passwordSalt;

	//bi-directional many-to-many association to Role
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name="user_in_role"
		, joinColumns={
			@JoinColumn(name="user_name")
			}
		, inverseJoinColumns={
			@JoinColumn(name="role_id")
			}
		)
	private List<Role> roles;

	public User() {
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getAccountExpireDtt() {
		return this.accountExpireDtt;
	}

	public void setAccountExpireDtt(Date accountExpireDtt) {
		this.accountExpireDtt = accountExpireDtt;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public Date getCredentialsExpireDtt() {
		return this.credentialsExpireDtt;
	}

	public void setCredentialsExpireDtt(Date credentialsExpireDtt) {
		this.credentialsExpireDtt = credentialsExpireDtt;
	}

	public String getEMail() {
		return this.eMail;
	}

	public void setEMail(String eMail) {
		this.eMail = eMail;
	}

	public Date getLastAccessDtt() {
		return this.lastAccessDtt;
	}

	public void setLastAccessDtt(Date lastAccessDtt) {
		this.lastAccessDtt = lastAccessDtt;
	}

	@JsonIgnore
	public String getPassword() {
		return this.password;
	}

	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordSalt() {
		return this.passwordSalt;
	}

	public void setPasswordSalt(String passwordSalt) {
		this.passwordSalt = passwordSalt;
	}

	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	
	
}