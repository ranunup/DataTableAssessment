package steps;

import base.BaseUtil;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hook extends BaseUtil {

    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void initializeTest() {
        System.out.println("Opening the browser");

        String osName = System.getProperty("os.name");

        if (osName.contains("Windows")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");
        } else if (osName.contains("Mac")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
        }

        this.base.driver = new ChromeDriver();
    }

    @After
    public void teardownTest() {
        System.out.println("Closing the browser");
        this.base.driver.quit();
    }
}
