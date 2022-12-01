package com.glarimy.core.css.infra;

import java.util.HashMap;
import java.util.Map;

import com.glarimy.core.css.domain.Id;
import com.glarimy.core.css.domain.Ticket;
import com.glarimy.core.css.domain.TicketRepository;
import com.glarimy.generic.framework.Singleton;

@Singleton
public class InMemoryTicketRepository implements TicketRepository {
	private Map<Id, Ticket> tickets;
	private static InMemoryTicketRepository INSTANCE;

	private InMemoryTicketRepository() {
		tickets = new HashMap<Id, Ticket>();
	}

	public static synchronized InMemoryTicketRepository getInstance() {
		if (INSTANCE == null)
			INSTANCE = new InMemoryTicketRepository();
		return INSTANCE;
	}

	@Override
	public Ticket save(Ticket ticket) {
		ticket.setId(new Id(tickets.size() + 1));
		tickets.put(ticket.getId(), ticket);
		return ticket;
	}

	@Override
	public Ticket update(Ticket ticket) {
		tickets.put(ticket.getId(), ticket);
		return ticket;
	}

	@Override
	public Ticket findOne(Id id) {
		return tickets.get(id);
	}
}
