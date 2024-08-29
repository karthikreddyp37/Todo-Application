package com.karthik.springboot.myfirstwebapp.todo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "to_do")
public class ToDo {
	
	@Id
	@GeneratedValue
	private int id;
	private String username;
	@Size(min=10,message="Enter aleast 10 characters")
	private String decription;
	private LocalDate targetDate;
	private boolean done;
	
	public ToDo()
	{
		
	}
	
	public ToDo(int id, String username, String decription, LocalDate targetDate, boolean done) {
		super();
		this.id = id;
		this.username = username;
		this.decription = decription;
		this.targetDate = targetDate;
		this.done = done;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	public LocalDate getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	@Override
	public String toString() {
		return "ToDo [id=" + id + ", username=" + username + ", description=" + decription + ", targetDate=" + targetDate
				+ ", done=" + done + "]";
	}
		
}
