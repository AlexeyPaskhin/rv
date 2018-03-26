package com.pages;

import com.Elements.Panel;
import org.openqa.selenium.By;

public class TournamentsPage extends AbstractPage {
    private final Panel BANNER = new Panel(By.xpath("//div[@class='promo-banner promo-banner--tournament']"));
    private final Panel TOURNAMENTS_PANE = new Panel(By.xpath("//div[@class='tournaments-list__item cf']"));
    private final Panel PAGINATION = new Panel(By.xpath("//ul[@class='pagination-buttons']"));

    public boolean BannerExists() {
        return BANNER.isPresent();
    }

    public boolean TournamentsExists() {
        return TOURNAMENTS_PANE.isPresent();
    }

    public boolean PaginationExists() {
        return PAGINATION.isPresent();
    }
}
