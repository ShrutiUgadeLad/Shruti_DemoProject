package utilities;

import com.paulhammant.ngwebdriver.NgWebDriver;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.event.KeyEvent;
import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Utilities {

    public static final Duration TOTAL_WAIT_TIME = Duration.ofSeconds(120);

    private static final Logger LOGGER = LogManager.getLogger(Utilities.class);

    /**
     * Method to select on from dropdown using javascriptexecutor
     */
    public static void selectItem(WebDriver driver, String itemToSelect) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementsByName('" + itemToSelect + "')[0].click();");
    }

    /**
     * Method to click on the element using javascriptexecutor
     *
     * @param webElement should be the element which has the click event.
     * @param webDriver  The web driver used to execute the javascript The web
     *                   element (DOM) used to execute the javascript against
     */
    public static void clickOn(WebDriver webDriver, WebElement webElement) {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].click();", webElement);
    }

    /**
     * should shadow DOM element.
     *
     * <p>
     * The web driver used to execute the javascript The web element (DOM) used to
     * execute the javascript against
     */
    public static SearchContext expandRootElement(WebDriver driver, WebElementFacade element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        SearchContext ele = (SearchContext) js.executeScript("return arguments[0].shadowRoot", element);
        return ele;
    }

    public static SearchContext expandRootElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        SearchContext ele = (SearchContext) js.executeScript("return arguments[0].shadowRoot", element);
        return ele;
    }


    /**
     * Method to scroll to web element
     */
    public static void scrollToElement(WebElement element, WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'end', behavior: 'instant'})",
                element);
    }

    public static void scrollDown(WebDriver driver, WebElement ele) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ele);
    }

    public static void scrollDownUsingCoordinates(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,250)");
    }
    /**
     * Method to hover on web element
     */
    public static void hoverOverElementOfTypeWebElement(WebDriver driver, WebElement element) {
        Actions hover = new Actions(driver);
        hover.moveToElement(element).build().perform();
    }

    /**
     * Method to check the checkbox
     *
     * @param element
     * @param status
     */
    public static void toggleCheckBox(WebElement element, boolean status) {
        boolean ischecked = element.isSelected();
        if (status != ischecked) {
            element.click();
        }
    }

    /**
     * Method to check if RadioButton/CheckBox is checked
     *
     * @param driver
     * @param element
     */
    public static boolean isCheckBoxSelected(WebDriver driver, WebElement element) {
        boolean ischecked = false;
        ischecked = (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].checked", element);
        return ischecked;
    }

    /**
     * Method to select an item from combo box
     *
     * @param element
     * @param text
     */
    public static void selectComboBoxItemByVisibleText(WebElement element, String text) {
        Select se = new Select(element);
        se.selectByVisibleText(text);
    }

    /**
     * Method to click on RadioButton/CheckBox button using javascriptexecutor
     *
     * @param driver
     * @param element
     * @param status
     */
    public static void toggleCheckBoxSelection(WebDriver driver, WebElement element, boolean status) {
        boolean ischecked = isCheckBoxSelected(driver, element);
        if (status != ischecked) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].checked = " + status + ";", element);
        }
    }

    /**
     * Method to click on RadioButton/CheckBox button using Actions class
     *
     * @param driver
     * @param element
     * @param status
     */
    public static void toggleCheckBoxSelectionAction(WebDriver driver, WebElement element, boolean status) {
        boolean ischecked = isCheckBoxSelected(driver, element);
        if (status != ischecked) {
            Actions builder = new Actions(driver);
            Action mouseoverele = builder.moveToElement(element).build();
            mouseoverele.perform();
            Action seriesofactions = builder.moveToElement(element).click().build();
            seriesofactions.perform();
        }
    }

    /**
     * Method to mouse hover over element
     *
     * @param element
     * @param driver
     */
    public static void mouseHoverOverElement(WebDriver driver, WebElementFacade element) {
        Actions builder = new Actions(driver);
        Action mouseoverele = builder.moveToElement(element).build();
        mouseoverele.perform();
    }

    public static void mouseHoverOverElement(WebDriver driver, WebElement element) {
        Actions builder = new Actions(driver);
        Action mouseoverele = builder.moveToElement(element).build();
        mouseoverele.perform();
    }

    /**
     * Method to click on element using Actions class
     *
     * @param element
     * @param driver
     */
    public static void clickOnElement(WebDriver driver, WebElement element) {
        Actions builder = new Actions(driver);
        Action mouseoverele = builder.moveToElement(element).build();
        mouseoverele.perform();
        Action seriesofactions = builder.moveToElement(element).click().build();
        seriesofactions.perform();
    }

    /**
     * Method to clear text field and send keys
     */
    public static void sendKeysTextBox(WebElementFacade element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    public static void waitUntilVisiblityOfElementLocated(String locator, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, TOTAL_WAIT_TIME);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
    }

    public static void waitUntilTextIsPresentInElement(String locator, WebDriver driver, String txtToValidate) {
        WebDriverWait wait = new WebDriverWait(driver, TOTAL_WAIT_TIME);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(locator), txtToValidate));
    }

    public static void waitUntilInVisiblityOfElementLocated(String locator, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, TOTAL_WAIT_TIME);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(locator)));
    }

    public static void waitForAngularRequestToFinish(WebDriver driver) {
        NgWebDriver ngWebDriver = new NgWebDriver((JavascriptExecutor) driver);
        ngWebDriver.waitForAngularRequestsToFinish();
    }

    public static String randomAlphaNumericStringGeneration(int size) {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(size);

        for (int i = 0; i < size; i++) {

            int index = (int) (AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }

    public static String randomAlphaStringGeneration(int size) {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(size);

        for (int i = 0; i < size; i++) {

            int index = (int) (AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }

    public static String randomCapitalAplhabetsGeneration(int size) {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder(size);

        for (int i = 0; i < size; i++) {

            int index = (int) (AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }

    public static String randomSmallAlphabetGeneration(int size) {
        String AlphaNumericString = "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(size);

        for (int i = 0; i < size; i++) {

            int index = (int) (AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }

    public static String randomSpecialCharStringGeneration(int size) {
        String SpecialCharString = "!@?#$%&*~`!^_=:;<.,>()-";
        StringBuilder sb = new StringBuilder(size);

        for (int i = 0; i < size; i++) {

            int index = (int) (SpecialCharString.length() * Math.random());
            sb.append(SpecialCharString.charAt(index));
        }
        return sb.toString();
    }

    public static void clickOnDropdown(WebDriver driver, WebElement element) {
        Actions act = new Actions(driver);
        act.moveToElement(element).click().perform();
    }

    public static void selectAvalueFromDropdown(List<WebElement> options, String text) {
        for (int i = 0; i < options.size(); i++) {
            if (options.get(i).getText().equalsIgnoreCase((text))){
                options.get(i).click();
                break;
            }
        }
    }

    public static void clickOnAvalueFromTheList(List<WebElementFacade> options, String text) {
        for (int i = 0; i < options.size(); i++) {
            if (options.get(i).getText().equals(text)) {
                options.get(i).click();
            }
        }
    }

    public static void doubleClickOnaValueFromDropdownUsingJavascript
            (WebDriver driver, List<WebElement> options, String text) {
        for (int i = 0; i < options.size(); i++) {
            if (options.get(i).getText().equalsIgnoreCase((text))){
                options.get(i).click();
                break;
            }
        }
    }

    public static String executeJavascriptOnPseudoElement
            (WebDriver driver, String locator, String pseudoCss, String propertyValue) {
        String script = String
                .format("return window.getComputedStyle(document.querySelector('%s'),'%s').getPropertyValue('%s')"
                        , locator, pseudoCss, propertyValue);
        LOGGER.info("pseudo Script is "+script);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript(script);
    }

    public static String getCurrentDateTimeMS() {
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyMMddhhmmssMs");
        String datetime = ft.format(dNow);
        return datetime;
    }

    public static void clearUsingJavascript(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].value ='';", element);
    }

    public static void enterValuesIntoTextBoxUsingJavascript(WebDriver driver, String value, WebElementFacade element) {
        String script = String.format("arguments[0].value ='%s';", value);
        ((JavascriptExecutor) driver).executeScript(script, element);
    }

    public static void clickOnElementExecutingJavascriptByQuerySelector
            (WebDriver driver, String selector) {
        String script = String
                .format("window.document.querySelector('%s').click()"
                        , selector);
        LOGGER.info("script to click is " + script);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script);
    }

    public static void clickOnElementWithinShadowRootExecutingJavascriptByQuerySelector
            (WebDriver driver, String shadowRootElement, String selector) {
        String script = String
                .format("window.document.querySelector('%s').shadowRoot.querySelector('%s').click()"
                        , shadowRootElement, selector);
        LOGGER.info("script to click is " + script);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script);
    }

    public static String getAttributeOnElementWithinShadowRootExecutingJavascriptByQuerySelector
            (WebDriver driver, String shadowRootElementSelector, String selector, String attributeName) {
        String script = String
                .format("return document.querySelector('%s').shadowRoot.querySelector('%s').getAttribute('%s')"
                        , shadowRootElementSelector, selector, attributeName);
        LOGGER.info("script to get attribute value is " + script);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript(script);
    }

    public static String getInnerTextOfElementWithinShadowRootExecutingJavascriptByQuerySelector
            (WebDriver driver, String shadowRootElementSelector, String selector) {
        String script = String
                .format("return document.querySelector('%s').shadowRoot.querySelector('%s').innerText"
                        , shadowRootElementSelector, selector);
        LOGGER.info("script to get attribute value is " + script);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript(script);
    }

    public static boolean isCheckboxCheckedByExecutingJavascriptByQuerySelector
            (WebDriver driver, String selector) {
        String script = String
                .format("return document.querySelector('%s').checked", selector);
        LOGGER.info("script to get status of checkbox is " + script);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (boolean) js.executeScript(script);
    }

    public static String randomAlphaNumericWithSpecialCharacterStringGeneration(int size) {
        String AlphaNumericWithSplCharString = "-" + "ABCDEFGH" +  "_" + "01234789" + "nopqrstuvxyz" ;
        StringBuilder sb = new StringBuilder(size);

        for (int i = 0; i < size; i++) {

            int index = (int) (AlphaNumericWithSplCharString.length() * Math.random());
            sb.append(AlphaNumericWithSplCharString.charAt(index));
        }
        return sb.toString();
    }

    public static String randomAlphaNumericWithSpecialCharacterAndAmpersand(int size) {
        String AlphaNumericWithSplCharString = "&" + "_" + "ABCDEFGHIJK" +  "_" + "0156789" + "opqrstuvxyz";
        StringBuilder sb = new StringBuilder(size);

        for (int i = 0; i < size; i++) {

            int index = (int) (AlphaNumericWithSplCharString.length() * Math.random());
            sb.append(AlphaNumericWithSplCharString.charAt(index));
        }
        return sb.toString();
    }

    public static void clickOnPageDown(WebDriver driver, WebElementFacade element) {
        Actions at = new Actions(driver);
        at.sendKeys(Keys.PAGE_DOWN).build().perform();
    }

    public static String randomNumericStringGeneration(int size) {
        String AlphaNumericString = "0123456789";
        StringBuilder sb = new StringBuilder(size);

        for (int i = 0; i < size; i++) {

            int index = (int) (AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }

    public static void zoomInBrowser(WebDriver driver){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("document.body.style.zoom = '0.7'");
    }

    public static void zoomInBrowser(WebDriver driver, double size){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript(String.format("document.body.style.zoom = '%.2f'", size));
    }

    public static void zoomBrowserToDefault(WebDriver driver){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("document.body.style.zoom = '1'");
    }

    public static void waitUntilElementIsVisible(WebElement element, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, TOTAL_WAIT_TIME);
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    public static void clickOnElementWithoutShadowRootExecutingJavascriptByQuerySelector
            (WebDriver driver, String selector) {
        String script = String.format("window.document.querySelector('%s').click()", selector);
        LOGGER.info("script to click is " + script);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script);
    }

    public static String randomNumericGeneration(int size) {
        String numbers = "0123456789";
        StringBuilder sb = new StringBuilder(size);

        for (int i = 0; i < size; i++) {
            int index = (int) (numbers.length() * Math.random());
            sb.append(numbers.charAt(index));
        }
        return sb.toString();
    }

    public static void enterValuesIntoTextBoxUsingJavascript(WebDriver driver, String value, WebElement element) {
        String script = String.format("arguments[0].value ='%s';", value);
        ((JavascriptExecutor) driver).executeScript(script, element);
    }

    /**
     * * Method to hover on web element
     */
    public static void mousehoverOverElementOfTypeWebElement(WebDriver driver, WebElement element) {
        Actions hover = new Actions(driver);
        hover.moveToElement(element).perform();
    }

    public static String getInnerTextOfElementWithoutShadowRootExecutingJavascriptByQuerySelector
            (WebDriver driver, String selector) {
        String script = String
                .format("return document.querySelector('%s').innerText", selector);
        LOGGER.info("script to get attribute value is " + script);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript(script);
    }

    /**
     * Method to scroll to web element
     */
    public static void escapeFromElement(WebDriver driver) {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ESCAPE).build().perform();
    }

    public static String enterValueInTextBoxUsingJavascriptByQuerySelector
            (WebDriver driver, String selector, String value) {
        String script = String
                .format("return document.querySelector('%s').value='%s'", selector, value);
        LOGGER.info("script to get attribute value is " + script);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript(script);
    }

    public static List<String> getColumnData(WebDriver driver, String selector, WebElementFacade shadowRootEDSGrid) {
        List<WebElement> algorithmNameColumnDataElements = Utilities.expandRootElement(driver, shadowRootEDSGrid)
                .findElements(By.cssSelector(selector));
        List<String> algorithmNames = new ArrayList<String>();
        for (WebElement e : algorithmNameColumnDataElements) {
            algorithmNames.add(e.getText());
        }
        return algorithmNames;
    }

    public static boolean isSortedAscending(List<String> list) {
        return list.stream().sorted(String.CASE_INSENSITIVE_ORDER).collect(Collectors.toList()).equals(list);
    }

    public static boolean isSortedDescending(List<String> list) {
        return list.stream().sorted(Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList()).equals(list);
    }

    public static boolean verifyScrollBarPresent(WebDriver driver) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        return (Boolean) executor.executeScript("return document.documentElement.scrollHeight>document"
                + ".documentElement.scrollHeight;");
    }

    public static String randomPasswordGeneration(int size) {
        String test = "Test@";
        String alphaNumericString = "0123456789";
        StringBuilder sb = new StringBuilder(size);

        for (int i = 0; i < size; i++) {

            int index = (int) (alphaNumericString.length() * Math.random());
            sb.append(alphaNumericString.charAt(index));
        }
        return test.concat(sb.toString());
    }

    public static String randomSpecialCharacter(int size) {
        String SplCharString = "(* % \" # | ! ^ / & , > <)";
        StringBuilder sb = new StringBuilder(size);

        for (int i = 0; i < size; i++) {

            int index = (int) (SplCharString.length() * Math.random());
            sb.append(SplCharString.charAt(index));
        }
        return sb.toString();
    }

    public static String randomNumericGenerationWithoutZero(int size) {
        String numbers = "123456789";
        StringBuilder sb = new StringBuilder(size);

        for (int i = 0; i < size; i++) {
            int index = (int) (numbers.length() * Math.random());
            sb.append(numbers.charAt(index));
        }
        return sb.toString();
    }

    public static String getAttributeOnElementWithoutShadowRootExecutingJavascriptByQuerySelector
            (WebDriver driver, String selector, String attributeName) {
        String script = String
                .format("return document.querySelector('%s').getAttribute('%s')"
                        , selector, attributeName);
        LOGGER.info("script to get attribute value is " + script);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript(script);
    }

    public static void selectTheFirstvalueFromDropdown(List<WebElement> options) {
        if (options.size()>0) {
            options.get(0).click();
        }
    }

    public static void waitUntilInVisibilityOfElement(WebElement ele, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, TOTAL_WAIT_TIME);
        wait.until(ExpectedConditions.invisibilityOf(ele));
    }

    public static boolean isSelectedOnElementWithinShadowRootExecutingJavascriptByQuerySelector
            (WebDriver driver, String shadowRootElement, String selector) {
        String script = String
                .format("window.document.querySelector('%s').shadowRoot.querySelector('%s').isSelected()"
                        , shadowRootElement, selector);
        LOGGER.info("script to get status of isSelected is " + script);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (boolean) js.executeScript(script);

    }

    public static String getDate() {
        LocalDateTime currentSystemDate = LocalDateTime.now();
        DateTimeFormatter currentDateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
        String formattedDate = currentSystemDate.format(currentDateFormat);
        return formattedDate;
    }

    public static String getFutureDate(int days) {
        LocalDateTime currentSystemDate = LocalDateTime.now().plusDays(days);
        DateTimeFormatter currentDateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
        String formattedDate = currentSystemDate.format(currentDateFormat);
        return formattedDate;
    }

    public static String getPastDate(int days) {
        LocalDateTime currentSystemDate = LocalDateTime.now().minusDays(days);
        DateTimeFormatter currentDateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
        String formattedDate = currentSystemDate.format(currentDateFormat);
        return formattedDate;
    }

    public static boolean isFileExist(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            return false;
        }
        return true;
    }

    public static void writeFile(String filename, List<String> content) {
        File fout = new File(ConfigFileReader.getPropertyValue("fileDownloadPath")+filename);
        LOGGER.info(fout.getAbsolutePath());
        try (FileOutputStream fos = new FileOutputStream(fout)) {
            try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos))) {

                for (int i = 0; i < content.size(); i++) {
                    bw.write(content.get(i));
                    bw.newLine();
                }
            }
        }
        catch (Exception exception) {
            LOGGER.info(exception.getMessage());
            LOGGER.info(fout.getAbsolutePath());
        }

    }
    public static int fileCount(String pathname) {
        File f =new File(pathname);
        return f.list().length;
    }

    public static void deleteFile(String fileName) {
        if (isFileExist(fileName)) {
            File file = new File(fileName);
            file.delete();
        }
    }

    public static String[] stringSplit(String value) {
        return value.split(",");
    }

    public static List<String> readFile(String fileName) {
        List<String> tableContent = new ArrayList<>();
        try (FileInputStream csvFileRead = new FileInputStream(
                ConfigFileReader.getPropertyValue("fileDownloadPath")+fileName)) {
            try (Scanner sc = new Scanner(csvFileRead)) {
                while (sc.hasNextLine()) {
                    String nextLine = sc.nextLine();
                    LOGGER.info("Line No :" + nextLine);
                    tableContent.add(nextLine.replace(" \"", "").replace("\"", ""));
                }
            }
        }
        catch ( Exception ex) {
            LOGGER.info(ex.getMessage());
        }
        return tableContent;
    }

    public static String getValueWithinShadowRootExecutingJavascriptByQuerySelector
            (WebDriver driver, String shadowRootElementSelector, String selector) {
        String script = String.format("return document.querySelector('%s').shadowRoot.querySelector('%s').value",
                shadowRootElementSelector, selector);
        LOGGER.info("script to get attribute value is " + script);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript(script);
    }
}
