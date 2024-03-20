package com.example.demo.model;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "Offre") //esm table f BD
public class Offre implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long idOffre;
	
	@Column
	private String titre;
	
	@Column
	private String description;
	
	@Column
	private String categorie;
	
	@Column
	private String lieu;
	
	@Column
	private String image;
	
	@Column
	private Timestamp LastUpdate;
	
	@Column
	private Date createdAt;
	
	@ManyToOne 
    @JoinColumn(name = "idUser")
    private User user;

}
