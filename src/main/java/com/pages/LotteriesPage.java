package com.pages;

import com.Elements.Button;
import com.Elements.Panel;

import com.popups.FastRegisterPopup;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;

import javax.annotation.Nullable;
import java.util.List;

@Getter
public class LotteriesPage extends AbstractPage {
    private Button PARTICIPATE_IN_LOTTERIES = new Button(By.xpath("//a[@class='get_a_raffle_ticket']"));
    private Panel LOTTERY_ITEM_ANY = new Panel(By.xpath("//div[@class='lottery_item cf']"));
    private Panel LOTTERY_ITEM_DISPLAYED = new Panel(By.xpath("//div[@class='lottery_item cf' and @style='display: block;']"));
    private Panel NOT_FINISHED_LOTTERY = LOTTERY_ITEM_DISPLAYED.getSubPanelByXpath("//a/span[text()='Подробнее']");
    private Panel FINISHED_LOTTERY = LOTTERY_ITEM_DISPLAYED.getSubPanelByXpath("//a/span[text()='Результаты']");
    private Panel PRIZE_FUND_TEXT = LOTTERY_ITEM_DISPLAYED.getSubPanelByXpath("//p[text()='Призовой фонд:']");
    private Panel PRIZE_FUND_VALUE = LOTTERY_ITEM_DISPLAYED.getSubPanelByXpath("//p[@class='prize_mini']");
    private Panel START_DATE_TEXT = LOTTERY_ITEM_DISPLAYED.getSubPanelByXpath("//p[@class='start_mini']");
    private Panel END_DATE_TEXT = LOTTERY_ITEM_DISPLAYED.getSubPanelByXpath("//p[@class='end_mini']");
    private Panel RIBBON_FINISHED_LOTTERY = LOTTERY_ITEM_DISPLAYED.getSubPanelByXpath("//div[contains(text(), 'Завершена')]");
    private Panel RIBBON_NOT_FINISHED_LOTTERY = LOTTERY_ITEM_DISPLAYED.getSubPanelByXpath("//div[contains(text(), 'Сейчас')]");
    private Button LOTTERY_RESULT = LOTTERY_ITEM_ANY.getSubButtonByXpath("//a[@class='results_mini_btn']");

    private Panel DEFAULT_BANNER = new Panel(By.xpath("//img[@class='all_lotteries_img']"));
    private Panel BANNER_ACTIVE = new Panel(By.xpath("//a[contains(@class,'baner_container')]"));
    private Panel PRIZE_BANNER_BLOCK = BANNER_ACTIVE.getSubPanelByXpath("//p[@class='prize']");
    private Panel BEGINING_LOTTERY_BANNER_BLOCK = BANNER_ACTIVE.getSubPanelByXpath("//div[@class='beginning_lottery']");
    private Panel ENDING_LOTTERY_BANNER_BLOCK = BANNER_ACTIVE.getSubPanelByXpath("//div[@class='ending_lottery']");

    private Panel PAGINATION_PANEL = new Panel(By.xpath("//ul[@class='pagination-buttons']"));
    private Button NEXT_PAGE_BUTTON = new Button(By.xpath("//li[@class='pagination-buttons__button pagination-buttons__button--next']"));
    private Button PARTICIPATE_IN_THE_LOTTERY = new Button(By.xpath("//span[text()='Участвовать в лотереях']/.."));
    private Button CURRENT_LOTTERY_BUTTON = new Button(By.xpath("//span[text()='Текущая лотерея']/.."));

    @Nullable
    private Panel CURRENT_LOTTERY_PANEL = new Panel(By.xpath("//div[@class='lottery_item cf']"));

    @Nullable
    private Button LotteryImage = CURRENT_LOTTERY_PANEL.getSubButtonByXpath("//a");

    public List<Panel> getAllLotteries() {
        return LOTTERY_ITEM_ANY.getAllElements();
    }

    public Panel getLotteryByIndex(int index) {
            return getAllLotteries().get(index);
    }

    public String getLotteryLink() {
        if (this.getCURRENT_LOTTERY_PANEL() != null) {
            return getLotteryImage().getAttribute("href");
        } else
            return null;
    }

    public String getLotteryLink(int index) {
        return null;
    }

    public boolean bannerExists() {
        return BANNER_ACTIVE.isPresent();
    }

    public boolean participateInLoterriesExists() {
        return PARTICIPATE_IN_LOTTERIES.isPresent();
    }

    public boolean lotteriesExists() {
        return LOTTERY_ITEM_ANY.isPresent();
    }

    public boolean lotteryResultsButtonExists() {
        return LOTTERY_RESULT.isPresent();
    }

    public boolean paginationExists() {
        return PAGINATION_PANEL.isPresent();
    }

    @Step
    public LotteriesPage clickNextPage() {
        NEXT_PAGE_BUTTON.click();
        return this;
    }

    @Step
    public FastRegisterPopup clickParticipateInTheLottery() {
        PARTICIPATE_IN_THE_LOTTERY.click();
        return new FastRegisterPopup();
    }

    @Step
    public CurrentLotteryPage clickCurrentLottery() {
        CURRENT_LOTTERY_BUTTON.click();
        return new CurrentLotteryPage();
    }
}
