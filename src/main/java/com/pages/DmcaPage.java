package com.pages;

import com.Elements.Button;
import org.openqa.selenium.By;

/**
 * https://www.dmca.com/Protection/Status.aspx?ID=e6820e06-ad79-4bc9-b51d-8de67b24a062&refurl= [ https://rc-stable.fe.rv.dev.77xy.net/ ]
 */
public class DmcaPage extends AbstractPage {
    private static String title = "DMCA Content Protection Service - Protect Your Content";

    public Boolean isLoaded() {
        return getTitle().equals(title);
    }

}
