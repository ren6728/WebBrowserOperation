import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserReferrence {
    public static void main(String[] args) {
        /**
         * 1. Download chrome driver file
         * 2. Help application to know where is the driver file
         * 3. Create chromeDriver Object
         * 4. Open a website in chrome browser
         * */
        // /Users/jahidul/IdeaProjects/WebBrowserOperation/drivers/windows/chromedriver.exe
        //  /Users/jahidul/IdeaProjects/WebBrowserOperation/drivers/mac/chromedriver
        // If OS is mac use chromedriver, if OS is Windows chromedriver.exe

        String os = "mac";
        WebDriver chromeDriver = null; // equalsIgnoreCase() mac == Mac

        String directoryPath = System.getProperty("user.dir"); // /Users/jahidul/IdeaProjects/WebBrowserOperation
        String chromeDriverPath;


        if (os.equalsIgnoreCase("mac")){
            chromeDriverPath = directoryPath + "/drivers/mac/chromedriver 2";
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
            chromeDriver = new ChromeDriver();
        }

        else if (os.equalsIgnoreCase("windows")){
            chromeDriverPath = directoryPath + "/drivers/windows/chromedriver 2.exe";
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
            chromeDriver = new ChromeDriver();
        }

        String url = "https://www.izaanschool.com/";
        chromeDriver.get(url);
        chromeDriver.close();

    }

    public void createChromeDriver(){

    }
}
