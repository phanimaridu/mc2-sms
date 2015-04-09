package edu.mc2.sms.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the person database table.
 * 
 */
@Entity
@NamedQuery(name="Person.findAll", query="SELECT p FROM Person p")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="user_name")
	private String userName;

	private String address;

	@Column(name="e_mail")
	private String eMail;

	@Column(name="first_name")
	private String firstName;

	@Lob
	@Column(name="future_use")
	private String futureUse;

	@Column(name="last_name")
	private String lastName;

	private String phone;

	private String sex;

	//bi-directional one-to-one association to User
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_name")
	private User user;

	public Person() {
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEMail() {
		return this.eMail;
	}

	public void setEMail(String eMail) {
		this.eMail = eMail;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFutureUse() {
		return this.futureUse;
	}

	public void setFutureUse(String futureUse) {
		this.futureUse = futureUse;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}