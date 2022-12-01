package com.glarimy.library;

public class LibraryBuilder {
	private boolean audit;
	private boolean notifications;

	public LibraryBuilder withAudit() {
		audit = true;
		return this;
	}

	public LibraryBuilder withNotifications() {
		notifications = true;
		return this;
	}

	public Library build() {
		Library library = InMemoryLibrary.getInstance();
		if (audit) {
			library = new AuditProxy(library);
		}
		if (notifications) {
			library = new NotificationProxy(library);
		}
		return library;
	}
}
