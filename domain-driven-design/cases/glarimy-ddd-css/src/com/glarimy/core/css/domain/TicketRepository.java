package com.glarimy.core.css.domain;

public interface TicketRepository {
	public Ticket save(Ticket ticket);

	public Ticket update(Ticket ticket);

	public Ticket findOne(Id id);
}