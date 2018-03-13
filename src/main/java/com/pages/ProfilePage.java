package com.pages;

/**
 * Lichnyj kabinet / Profile page - /users/profile
 */
public class ProfilePage extends AbstractPage {
    private final String PROFILE_PAGE_TITLE = "Ваш профиль в казино";

    public boolean isProfilePageOpened() {
       return this.getTitle().equals(PROFILE_PAGE_TITLE);

    }
}
