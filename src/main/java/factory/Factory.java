package factory;

import com.microsoft.playwright.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Factory {
    Properties properties;
    private static ThreadLocal<Playwright> playwright = new ThreadLocal<>();
    private static ThreadLocal<Browser> browser = new ThreadLocal<>();
    private static ThreadLocal<BrowserContext> browserContext = new ThreadLocal<>();
    public static ThreadLocal<Page> page = new ThreadLocal<>();

    public static Playwright getPlaywright(){
        return playwright.get();
    }
    public static Browser getBrowser(){
        return browser.get();
    }
    public static BrowserContext getBrowserContext(){
        return browserContext.get();
    }
    public static Page getPage(){
        return page.get();
    }

    public Page initBrowser(Properties properties){
        String browserName = properties.getProperty("browser").trim();
        System.out.println("Browser is - " + browserName);
        playwright.set(Playwright.create());

        switch (browserName.toLowerCase()){
            case "chromium":
                browser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)));
                break;
            case "firefox":
                browser.set(getPlaywright().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false)));
                break;
            case "safari":
                browser.set(getPlaywright().webkit().launch(new BrowserType.LaunchOptions().setHeadless(false)));
                break;
            case "chrome":
                browser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false)));
                break;
            default:
                System.out.println("wrong browser!");
        }
        browserContext.set(getBrowser().newContext(new Browser.NewContextOptions().setViewportSize(1500,800)));
        page.set(getBrowserContext().newPage());
        getPage().navigate(properties.getProperty("url"));
        return getPage();
    }

    public Properties init_prop() {
        try (FileInputStream ip = new FileInputStream("./resources/config/resources.properties")) {
            properties = new Properties(); properties.load(ip);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Properties file not found", e);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file", e); }
        return properties;
    }
}
