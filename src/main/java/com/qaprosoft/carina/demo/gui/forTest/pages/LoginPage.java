package com.qaprosoft.carina.demo.gui.forTest.pages;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.FooterMenu;
import com.qaprosoft.carina.demo.gui.components.WeValuePrivacyAd;
import com.qaprosoft.carina.demo.gui.forTest.components.LoginMenu;
import com.qaprosoft.carina.demo.gui.pages.BrandModelsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class LoginPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(id = "login_button_container")
    private LoginMenu loginMenu;

    public LoginPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

    public LoginMenu getLoginMenu() {
        return loginMenu;
    }
}
