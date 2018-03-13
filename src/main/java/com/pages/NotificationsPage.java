package com.pages;

/**
 * User profile / Notifications page - /users/notifications
 */
public class NotificationsPage extends AbstractPage {
    private final String NOTIFICATIONS_PAGE_TITLE = "Сообщения";

    public boolean isNotificationsPageOpened() {
        if (this.getTitle().equals(NOTIFICATIONS_PAGE_TITLE)) {
            return true;
        } else {
            return false;
        }
    }
}
