package edu.mc2.sms.jpa.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * The persistent class for the person database table.
 * 
 */
@Entity
@NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p")
@PrimaryKeyJoinColumn(name = "user_name")
@JsonSerialize(include=JsonSerialize.Inclusion.NON_DEFAULT)
public class Person extends User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dob;

	@Column(name = "eye_color")
	private Byte eyeColor;

	@Column(name = "f_name")
	private String fName;

	@Column(name = "hair_color")
	private Byte hairColor;

	private Float height;

	private String id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "joining_dtt")
	private Date joiningDtt;

	@Column(name = "l_name")
	private String lName;

	@Column(name = "m_name")
	private String mName;

	@Column(name = "picture_uri")
	private String pictureUri;

	private String prefix;

	private String race;

	private Byte sex;

	private Integer ssn;

	private String suffix;

	private Float weight;

	//many-to-one association to Contact
	@ManyToOne
	@JoinColumn(name = "contact")
	private Contact contact;

	//many-to-one association to Contact
	@ManyToOne
	@JoinColumn(name = "emr_contact")
	private Contact emrContact;

	public Person() {
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}


	public String getFName() {
		return this.fName;
	}

	public void setFName(String fName) {
		this.fName = fName;
	}


	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getJoiningDtt() {
		return this.joiningDtt;
	}

	public void setJoiningDtt(Date joiningDtt) {
		this.joiningDtt = joiningDtt;
	}

	public String getLName() {
		return this.lName;
	}

	public void setLName(String lName) {
		this.lName = lName;
	}

	public String getMName() {
		return this.mName;
	}

	public void setMName(String mName) {
		this.mName = mName;
	}

	public String getPictureUri() {
		return this.pictureUri;
	}

	public void setPictureUri(String pictureUri) {
		this.pictureUri = pictureUri;
	}

	public String getPrefix() {
		return this.prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getRace() {
		return this.race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getSuffix() {
		return this.suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public Byte getEyeColor() {
		return eyeColor;
	}

	public void setEyeColor(Byte eyeColor) {
		this.eyeColor = eyeColor;
	}

	public Byte getHairColor() {
		return hairColor;
	}

	public void setHairColor(Byte hairColor) {
		this.hairColor = hairColor;
	}

	public Float getHeight() {
		return height;
	}

	public void setHeight(Float height) {
		this.height = height;
	}

	public Byte getSex() {
		return sex;
	}

	public void setSex(Byte sex) {
		this.sex = sex;
	}

	public Integer getSsn() {
		return ssn;
	}

	public void setSsn(Integer ssn) {
		this.ssn = ssn;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Contact getEmrContact() {
		return emrContact;
	}

	public void setEmrContact(Contact emrContact) {
		this.emrContact = emrContact;
	}

	//TODO:Very Bad : Use StdKeySerializer for Map Keys
	@Override
	public String toString() {
	
		String firstName = fName == null? "" : fName;
		String middileName = mName == null? "" : mName;
		String lastName = lName == null? "" : lName;
		
		return super.getUserName() + ";" + firstName + ";" + middileName + ";" + lastName;
	}

	
	
}