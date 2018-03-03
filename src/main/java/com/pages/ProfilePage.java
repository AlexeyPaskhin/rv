package com.pages;

/**
 * Lichnyj kabinet / Profile page - /users/profile
 */
public class ProfilePage extends AbstractPage {
    private final String PROFILE_PAGE_TITLE = "Ваш профиль в казино";

    public boolean isProfilePageOpened() {
        if(this.getTitle().equals(PROFILE_PAGE_TITLE)){
            return true;
        } else {
            return false;
        }
    }
}
