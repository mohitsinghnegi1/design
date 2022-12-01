package com.glarimy.core.css.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Ticket {
	private Id id;
	private User user;
	private String description;
	private List<Comment> comments;
	private STATUS status;
	private Date createdAt;

	public Ticket(User user, String description) {
		this.user = user;
		this.description = description;
		this.comments = new ArrayList<Comment>();
		this.createdAt = new Date();
		this.status = STATUS.NEW;
	}

	public void add(Comment comment) {
		if (status != STATUS.ACCEPTED)
			comments.add(comment);
		else
			throw new RuntimeException();
	}

	public void accept() {
		if (status != STATUS.CLOSED)
			throw new RuntimeException();
		status = STATUS.ACCEPTED;
	}

	public void close() {
		if (status == STATUS.NEW || status == STATUS.OPEN)
			status = STATUS.CLOSED;
		else
			throw new RuntimeException();
	}

	public void open() {
		if (status == STATUS.NEW || status == STATUS.CLOSED)
			status = STATUS.OPEN;
		else
			throw new RuntimeException();
	}

	public Id getId() {
		return id;
	}

	public void setId(Id id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public String getDescription() {
		return description;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public STATUS getStatus() {
		return status;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

}
