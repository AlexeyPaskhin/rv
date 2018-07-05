package com.pages;

import com.Elements.Button;
import org.openqa.selenium.By;

public class Footer extends AbstractPage {
    private Button FB_GROUP_BUTTON = new Button(By.xpath("//div[@class='bottom-content']//a[@title='Казино Русский Вулкан в Facebook']"));
    private Button TWITTER_GROUP_BUTTON = new Button(By.xpath("//div[@class='bottom-content']//a[@title='Казино Русский Вулкан в Twitter']"));
    private Button OK_GROUP_BUTTON = new Button(By.xpath("//div[@class='bottom-content']//a[@title='Казино Русский Вулкан в Одноклассниках']"));
    private Button VK_GROUP_BUTTON = new Button(By.xpath("//div[@class='bottom-content']//a[@title='Казино Русский Вулкан в VK']"));
    private Button YOUTUBE_GROUP_BUTTON = new Button(By.xpath("//div[@class='bottom-content']//a[@title='Казино Русский Вулкан на Youtube']"));
    private Button GOOGLE_GROUP_BUTTON = new Button(By.xpath("//div[@class='bottom-content']//a[@title='Казино Русский Вулкан на Google+']"));
    private Button INSTAGRAM_GROUP_BUTTON = new Button(By.xpath("//div[@class='bottom-content']//a[@title='Казино Русский Вулкан в Instagram']"));


}
