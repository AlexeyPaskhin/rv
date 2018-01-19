package com.pages;

import com.Elements.Panel;
import org.openqa.selenium.By;

public abstract class AbstractPage implements IAbstractPage {

    public static String parentWindow;
    public static Panel PRELOADER = new Panel(By.id("popup_spinner"));
    public String SOCIAL_LOGIN_WINDOW = "uLogin_window";
}
