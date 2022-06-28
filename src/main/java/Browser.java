import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class Browser {
    public static void main(String[] args) {
        /**
         * 1. Download chrome driver file
         * 2. Help application to know where is the driver file
         * 3. Create chromeDriver Object
         * 4. Open a website in chrome browser
         * */
        /**
        String chromeDriverPath = "/Users/renxing/WebBrowserOperation/drivers/mac/chromedriver 2";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        WebDriver chromeDriver = new ChromeDriver();
        String url = "https://www.izaanschool.com/";
        chromeDriver.get(url);

        //chromeDriver.get(url);
        chromeDriver.manage().window().maximize();
        chromeDriver.findElement(By.id("navbarLandings")).click();
        //chromeDriver.navigate().back();
        chromeDriver.navigate().refresh();
        chromeDriver.findElement(By.id("navbarCourses")).click();
        chromeDriver.navigate().refresh();
        chromeDriver.findElement(By.id("navbarAboutUs")).click();
        chromeDriver.navigate().refresh();
        //chromeDriver.close();
         */
        String os="mac";
        WebDriver chromeDriver=null;
        chromeDriver=getChromeDriver(os,chromeDriver);
        String url="https://the-internet.herokuapp.com/";
        chromeDriver.get(url);

    }
    public static WebDriver getChromeDriver(String os,WebDriver chromeDriver){
String chromeDriverPath;
if(os.equalsIgnoreCase("mac")){
chromeDriverPath=System.getProperty("user.dir")+"/drivers/mac/chromedriver 2";
System.setProperty("webdriver.chrome.driver",chromeDriverPath);
chromeDriver=new ChromeDriver();
}else if(os.equalsIgnoreCase("windows")){
chromeDriverPath=System.getProperty("user.dir")+"/drivers/windows/chromedriver 2.exe";
System.setProperty("webdriver.chrome.driver",chromeDriverPath);
    chromeDriver=new ChromeDriver();
}
return chromeDriver;
    }
    public static void cleanup(WebDriver chromeDriver){
        chromeDriver.quit();
    }
    public static String uploadFile(WebDriver webDriver){
        /** Go to Upload Page
         * 1. Choose File
         * 2. Click upload
         * 3. Verify upload succeeded
         * */
        // Go to Upload Page
        webDriver.findElement(By.linkText("File Upload")).click();
        System.out.println("File Upload clicked.");
        // Choose File
        webDriver.findElement(By.id("file-upload")).sendKeys("/Users/renxing/WebBrowserOperation/data/lambda.png");
        // Click upload
        webDriver.findElement(By.id("file-submit")).click();
        // Go to the tag named h3 and get the tag value. After upload tag value shall be "File Uploaded!"
        String actualMessage =  webDriver.findElement(By.tagName("h3")).getText(); // getText() method provides you tag Value of the element or address
        System.out.println(actualMessage);
        //  Verify the message using program
        return actualMessage;
    }
    public static void selectDropDownOptionByValue(WebDriver webDriver, String value){
        webDriver.findElement(By.linkText("Dropdown")).click();
        System.out.println("In Dropdown Page");
        WebElement element = webDriver.findElement(By.id("dropdown"));
        Select select = new Select(element);
        select.selectByValue(value);
    }
    /**
     * Play with other Select method
     * */
    public static void checkACheckBox(WebDriver webDriver) {
        webDriver.findElement(By.linkText("Checkboxes")).click();
        webDriver.findElement(By.xpath("//form[@id=\"checkboxes\"]/input[1]")).click();
    }
}
