package com.pages;

import com.Elements.Button;
import com.Elements.Element;
import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class CurrentLotteryPage extends AbstractPage {
    private Button GET_A_RAFFLE_TICKET = new Button(By.xpath("//span[text()='Получить лотерейный билет']/.."));
    private Element LOTTERY_IS_FINISHED_INFO = new Element(By.xpath("//h3[@class='lottery-info__close-title' and text() ='Лотерея завершена']"));

}
