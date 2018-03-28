package com.pages;

/**
 * User profile / Notifications page - /users/notifications
 */
public class NotificationsPage extends AbstractPage {
    private final String NOTIFICATIONS_PAGE_TITLE = "Сообщения";

    public boolean isNotificationsPageOpened() {
        return this.getTitle().equals(NOTIFICATIONS_PAGE_TITLE);
    }
}
