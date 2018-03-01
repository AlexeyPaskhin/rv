package com.pages;

import com.Elements.Button;
import com.Elements.Panel;

import lombok.Getter;
import org.openqa.selenium.By;
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






        public List<Panel> getAllLoteries(){
        return LOTTERIES.getAllElements();
    }
















//    public void getLotteryByIndex(){
//        List<Panel> lotteriesList  = new ArrayList<>();
//        lotteriesList.add(LOTTERIES);
//        System.out.println(lotteriesList);
//    }


    public boolean BannerExists() {
        return BANNER.isPresent();
    }

    public boolean ParticipateInLoterriesExists() {
        return PARTICIPATE_IN_LOTTERIES.isPresent();
    }

    public boolean LotteriesExists() {
        return LOTTERIES.isPresent();
    }

    public boolean LotteryResultsButtonExists() {
        return LOTTERY_RESULT.isPresent();
    }

    public boolean PaginationExists() {
        return PAGINATION_PANEL.isPresent();
    }



}
