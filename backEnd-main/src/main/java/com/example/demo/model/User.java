package com.example.demo.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long idUser;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private Date dateNaissance;
	
	@Column
	private String mail;
	
	@Column
	private int tel;
	
	@Column
	private String genre;
	
	@Column
	private String pwd;
	
	@Column
	private Date signInDate;
	
	@Column
	private String eduLevel;
	
	@Column
	private String etablissement;
	
	@Column 
	private String description;
	
	@Column
	private String role;
	
	@Column
	private String image;

	
	
	public Long getId() {
		return idUser;
	}

	public void setId(Long id) {
		this.idUser = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int l) {
		this.tel = l;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Date getSignInDate() {
		return signInDate;
	}

	public void setSignInDate(Date signInDate) {
		this.signInDate = signInDate;
	}

	public String getEduLevel() {
		return eduLevel;
	}

	public void setEduLevel(String eduLevel) {
		this.eduLevel = eduLevel;
	}

	public String getEtablissement() {
		return etablissement;
	}

	public void setEtablissement(String etablissement) {
		this.etablissement = etablissement;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	
	
	

	
}
