package com.amazon.capabilities;

import com.amazon.enums.BrowserType;
import org.openqa.selenium.Capabilities;

public final class CapabilityManager {

    private CapabilityManager(){
    }

    private static Capabilities capabilities;

    public static Capabilities getCapabilities (BrowserType browser) {

        switch (browser){
            case FIREFOX:
                capabilities = OptionsManager.getFirefoxOptions();
                break;
            default:
                capabilities = OptionsManager.getChromeOptions();
                break;
        }
        return capabilities;
    }
}
