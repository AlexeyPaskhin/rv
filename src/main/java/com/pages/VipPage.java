package com.pages;

import com.Elements.Element;
import com.utils.CustomDataProvider;
import org.openqa.selenium.By;

/**
 * VIP page - /vip
 */
public class VipPage extends AbstractPage {
    private Element vipBaner = new Element(By.xpath("//img[@alt='VIP-клуб в «Русском Вулкане»']"));

    String link = provider.getBasicURL() + "vip";

    private final String VIP_PAGE_TITLE = "VIP-клуб в «Русском Вулкане»";

    public boolean isVipPageOpened() {
        return this.getTitle().equals(VIP_PAGE_TITLE);
    }

    public Boolean isVipPageLoaded() {
        return vipBaner.isVisible();
    }
}