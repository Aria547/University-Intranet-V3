package com.intranet.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class News implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	private Long pk_studentId;
	private String content;
	private Date creationDate;
	
	public News() {super();}
	public News(String content, Date creationDate) {
		this.content = content;
		this.creationDate = creationDate;
	}
	public String getContent() {return this.content;}
	public void setContent(String content) {this.content = content;}
	public Date getDate() {return this.creationDate;}
	public void setLogin(Date creationDate) {this.creationDate = creationDate;}
}
