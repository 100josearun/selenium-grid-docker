package com.amazon.capabilities;

import com.amazon.enums.BrowserType;
import org.openqa.selenium.Capabilities;

public final class CapabilityManager {

    private CapabilityManager(){
    }

    private static Capabilities capabilities;

    public static Capabilities getCapabilities (BrowserType browser) {
        if (browser.name().equalsIgnoreCase("firefox"))
            capabilities = OptionsManager.getFirefoxOptions();
        else
            capabilities = OptionsManager.getChromeOptions();
        return capabilities;
    }
}
