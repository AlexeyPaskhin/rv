package com.pages;

import com.Elements.Button;
import com.Elements.Panel;

import lombok.Getter;
import org.openqa.selenium.By;

import javax.annotation.Nullable;
import java.util.List;

@Getter
public class LotteriesPage extends AbstractPage {
    private final Panel BANNER = new Panel(By.xpath("//a[contains(@class,'baner_container')]"));
    private final Button PARTICIPATE_IN_LOTTERIES = new Button(By.xpath("//a[@class='get_a_raffle_ticket']"));
    private final Panel LOTTERIES = new Panel(By.xpath("//div[@class='lottery_item cf']"));
    private final Button LOTTERY_RESULT = LOTTERIES.getButtonByXpath("//a[@class='results_mini_btn']");
    private final Panel PRIZE_BANNER_BLOCK = BANNER.getPanelByXpath("//p[@class='prize']");
    private final Panel BEGINING_LOTTERY_BANNER_BLOCK = BANNER.getPanelByXpath("//p[@class='beginning_lottery']");
    private final Panel ENDING_LOTTERY_BANNER_BLOCK = BANNER.getPanelByXpath("//p[@class='ending_lottery']");
    private final Panel PAGINATION_PANEL = new Panel(By.xpath("//ul[@class='pagination-buttons']"));

    @Nullable
    private Panel CURRENT_LOTTERY = new Panel(By.xpath("//div[@class='lottery_item cf']"));
    @Nullable
    private Button LotteryImage = CURRENT_LOTTERY.getButtonByXpath("//a");

    public List<Panel> getAllLotteries() {
        return LOTTERIES.getAllElements();
    }

    public LotteriesPage getLotteryByIdendex(int index) {
        List<Panel> lotteries = getAllLotteries();
        if (lotteries.size() > index) {
            CURRENT_LOTTERY = getAllLotteries().get(index);
        }
        return this;
    }

    public String getLotteryLink() {
        if (getCURRENT_LOTTERY() != null) {
            return getLotteryImage().getAttribute("href");
        } else
            return null;
    }

    public String getLotteryLink(int index) {
        return null;
    }

    public boolean bannerExists() {
        return BANNER.isPresent();
    }

    public boolean participateInLoterriesExists() {
        return PARTICIPATE_IN_LOTTERIES.isPresent();
    }

    public boolean lotteriesExists() {
        return LOTTERIES.isPresent();
    }

    public boolean lotteryResultsButtonExists() {
        return LOTTERY_RESULT.isPresent();
    }

    public boolean paginationExists() {
        return PAGINATION_PANEL.isPresent();
    }
}
