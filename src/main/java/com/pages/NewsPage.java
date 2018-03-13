package com.pages;

import com.Elements.Panel;
import org.openqa.selenium.By;

public class NewsPage extends AbstractPage {

    private final Panel BANNER = new Panel(By.xpath("//div[@class='desktop-slider']"));
    private final Panel NEWS_PANEL = new Panel(By.xpath("//li[@class='promo-list__item-row']"));
    private final Panel PAGINATION = new Panel(By.xpath("//ul[@class='pagination-buttons']"));

    public boolean BannerExists() {
        return BANNER.isPresent();
    }

    public boolean NewsExists() {
        return NEWS_PANEL.isPresent();
    }

    public boolean PaginationExists() {
        return PAGINATION.isPresent();
    }
}
