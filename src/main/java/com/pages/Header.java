package com.pages;

import com.Elements.Button;
import com.Elements.Frame;
import org.openqa.selenium.By;

public interface Header {
    Button GAMES = new Button(By.xpath("//a[@href='/games']"));
    Button LOTTERIES = new Button(By.xpath("//a[@href='/lotteries']"));
    Button TOURNAMENTS = new Button(By.xpath("//a[@href='/tournaments']"));
    Button NEWS = new Button(By.xpath("//a[@href='/news']"));
    Button VIP_CLUB = new Button(By.xpath("//a[@href='/vip']"));
    Frame BLANK_IFRAME = new Frame(By.xpath("//iframe [@src=\"/blank-iframe\"]"));

    default GamesPage clickGamesLink() {
        GAMES.click();
        return new GamesPage();
    }

    default LotteriesPage clickLotteriesLink() {
        LOTTERIES.waitForElementToBeClickable(5);
        BLANK_IFRAME.waitForElementToBeInvisible(5);
        LOTTERIES.click();
        return new LotteriesPage();
    }

    default TournamentsPage clickTournametsLink() {
        TOURNAMENTS.click();
        return new TournamentsPage();
    }

    default NewsPage clickNewsLink() {
        NEWS.click();
        return new NewsPage();
    }

    default VipPage clickVIPLink() {
        VIP_CLUB.click();
        return new VipPage();
    }
}
