package com.pages;

/**
 * Personal cabinet / Bonuses page - /users/bonuses
 */
public class BonusesPage extends AbstractPage {
    private final String BONUSES_PAGE_TITLE = "История бонусов в казино";

    public boolean isBonusesPageOpened() {
        if(this.getTitle().equals(BONUSES_PAGE_TITLE)){
            return true;
        } else {
            return false;
        }
    }


}
