import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PegenationPage {


    WebDriver driver;

    private final String url = "https://demo.seleniumeasy.com/table-pagination-demo.html";

    private final By nextLink = By.xpath("//*[@class=\"next_link\"]");

    private final By tableRowVisible = By.xpath("//*[@style=\"display: table-row;\"]");

    public PegenationPage(WebDriver driver){

        this.driver = driver;

    }

    public void navigate(){

        driver.navigate().to(url);
    }

    public int numberOfRows(){
        int num = 0;

        List<WebElement> rows = driver.findElements(tableRowVisible);
        num = rows.size();

        return num;

    }

    public boolean isLastPage(){

        String attr = driver.findElement(nextLink).getAttribute("style");
        return attr.equals("display: none;");

    }

        public void clickNext(){

        if (!isLastPage());

            driver.findElement(nextLink).click();
        }


}

