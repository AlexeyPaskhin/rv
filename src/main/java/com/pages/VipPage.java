package com.pages;

import com.utils.CustomDataProvider;

/**
 * VIP page - /vip
 */
public class VipPage extends AbstractPage {
    String link = provider.getBasicURL() + "vip";

    private final String VIP_PAGE_TITLE = "VIP-клуб в «Русском Вулкане»";

    public boolean isVipPageOpened() {
        return this.getTitle().equals(VIP_PAGE_TITLE);
    }
}