package com.pages;

/**
 * VIP page - /vip
 */
public class VipPage extends AbstractPage {
    private final String VIP_PAGE_TITLE = "VIP-клуб в «Русском Вулкане»";

    public boolean isVipPageOpened() {
        if(this.getTitle().equals(VIP_PAGE_TITLE)){
            return true;
        } else {
            return false;
        }
    }

}
