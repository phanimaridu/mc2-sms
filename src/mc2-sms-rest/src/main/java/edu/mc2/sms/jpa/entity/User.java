package edu.mc2.sms.jpa.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="user_name")
	private String userName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="account_expire_ts")
	private Date accountExpireTs;

	private byte active;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_ts")
	private Date createdTs;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="credentials_expire_ts")
	private Date credentialsExpireTs;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_access_ts")
	private Date lastAccessTs;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modified_ts")
	private Date modifiedTs;

	@JsonIgnore
	private String password;

	//bi-directional one-to-one association to Person
	@JsonIgnore
	@OneToOne(mappedBy="user")
	private Person person;

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

	public Date getAccountExpireTs() {
		return this.accountExpireTs;
	}

	public void setAccountExpireTs(Date accountExpireTs) {
		this.accountExpireTs = accountExpireTs;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public Date getCreatedTs() {
		return this.createdTs;
	}

	public void setCreatedTs(Date createdTs) {
		this.createdTs = createdTs;
	}

	public Date getCredentialsExpireTs() {
		return this.credentialsExpireTs;
	}

	public void setCredentialsExpireTs(Date credentialsExpireTs) {
		this.credentialsExpireTs = credentialsExpireTs;
	}

	public Date getLastAccessTs() {
		return this.lastAccessTs;
	}

	public void setLastAccessTs(Date lastAccessTs) {
		this.lastAccessTs = lastAccessTs;
	}

	public Date getModifiedTs() {
		return this.modifiedTs;
	}

	public void setModifiedTs(Date modifiedTs) {
		this.modifiedTs = modifiedTs;
	}

	@JsonIgnore
	public String getPassword() {
		return this.password;
	}

	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}