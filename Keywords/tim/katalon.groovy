package tim
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import java.time.Duration

public class katalon {

    /**
     * While logged out: hover a game card, click its Play button,
     * then verify the "Please login first" popup appears.
     */
    @Keyword
 def verifyLoginPopupOnPlay(TestObject playButton, TestObject loginPopup) {
        WebUI.waitForElementPresent(playButton, 15)
        WebElement btn = WebUI.findWebElement(playButton, 10)

        // Find the hover parent (Tailwind "group"); fall back to two levels up
        WebElement card = (WebElement) WebUI.executeJavaScript(
            "return arguments[0].closest('.group') || arguments[0].parentElement.parentElement;",
            Arrays.asList(btn))
        KeywordUtil.logInfo('Hover target class: ' + card.getAttribute('class'))

        // Scroll the card into view BEFORE hovering (works for sliders/carousels)
        WebUI.executeJavaScript(
            "arguments[0].scrollIntoView({block: 'center', inline: 'center'});",
            Arrays.asList(card))
        WebUI.delay(1)

        // Real mouse hover; retry until the Play button is visible
        WebDriver driver = DriverFactory.getWebDriver()
        boolean shown = false
        for (int i = 0; i < 3 && !shown; i++) {
            new Actions(driver).moveToElement(card).pause(Duration.ofMillis(500)).perform()
            shown = WebUI.waitForElementVisible(playButton, 3, FailureHandling.OPTIONAL)
        }
        if (!shown) {
            KeywordUtil.logInfo('Play button not visible after hover, falling back to JS click')
        }

        // Normal click if possible, otherwise JavaScript click
        try {
            WebUI.click(playButton)
        } catch (Exception e) {
            WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(btn))
        }

        WebUI.waitForElementVisible(loginPopup, 10, FailureHandling.STOP_ON_FAILURE)
        WebUI.verifyElementVisible(loginPopup, FailureHandling.STOP_ON_FAILURE)
    }
}