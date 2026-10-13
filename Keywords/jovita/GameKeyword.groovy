package jovita

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class GameKeyword {

    private static final String EXPECTED_POPUP_TEXT = 'Please login first.'

    /**
     * Clicks a game's Play button as a guest and verifies the "Please login first." popup.
     */
    @Keyword
    def verifyLoginPopupOnPlayGame(TestObject gamePlayButtonObj) {
        TestObject loginPopupObj = findTestObject('Object Repository/Jovita/Modal_PleaseLogin_Message')

        if (!WebUI.waitForElementPresent(gamePlayButtonObj, 10, FailureHandling.OPTIONAL)) {
            KeywordUtil.markFailedAndStop('Game Play button element is not present: ' + gamePlayButtonObj.getObjectId())
        }

        // Make sure the popup is caused by the click, not already on screen
        if (!WebUI.verifyElementNotPresent(loginPopupObj, 1, FailureHandling.OPTIONAL)) {
            KeywordUtil.markFailedAndStop('Please login first popup was already displayed before clicking the game play button.')
        }

        // Scroll to the game card and hover to reveal the Play button
        WebUI.scrollToElement(gamePlayButtonObj, 5, FailureHandling.STOP_ON_FAILURE)
        WebUI.mouseOver(gamePlayButtonObj, FailureHandling.OPTIONAL)
        WebUI.click(gamePlayButtonObj, FailureHandling.STOP_ON_FAILURE)

        // Wait for the popup instead of sleeping
        if (!WebUI.waitForElementVisible(loginPopupObj, 10, FailureHandling.OPTIONAL)) {
            KeywordUtil.markFailedAndStop('Please login first popup was not displayed after clicking game play button.')
        }

        // Verify the popup text, not only that a popup exists
        String actualText = WebUI.getText(loginPopupObj, FailureHandling.STOP_ON_FAILURE).trim()
        if (actualText != EXPECTED_POPUP_TEXT) {
            KeywordUtil.markFailedAndStop("Popup text mismatch. Expected: '" + EXPECTED_POPUP_TEXT + "', Actual: '" + actualText + "'")
        }

        KeywordUtil.logInfo('Success: "' + actualText + '" popup verified successfully.')
    }
}
