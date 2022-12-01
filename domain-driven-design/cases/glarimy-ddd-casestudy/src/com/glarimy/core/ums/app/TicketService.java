package com.glarimy.core.ums.app;

import com.glarimy.core.css.domain.Comment;
import com.glarimy.core.css.domain.Id;
import com.glarimy.core.css.domain.STATUS;
import com.glarimy.core.css.domain.Ticket;

public interface TicketService {
	public Ticket raise(Ticket ticket);

	public void update(Id ticketId, Comment comment);

	public void update(Id ticketId, STATUS status);

}
