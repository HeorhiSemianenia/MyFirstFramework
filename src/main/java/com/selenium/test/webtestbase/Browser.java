package com.selenium.test.webtestbase;

public enum Browser {
    FIREFOX("firefox"),
    CHROME("chrome");

    private String browserName;

    private Browser (String name){
        browserName = name;
    }

    public String getBrowserName() {
        return browserName;
    }

    public static Browser getByName(String name){
        for(Browser browser : values()) {
            if(browser.getBrowserName().equalsIgnoreCase(name)) {
                return browser;
            }
        }
        return null;
    }
}
