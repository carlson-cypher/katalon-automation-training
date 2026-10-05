package jovita

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class GameKeyword {

    @Keyword
    def verifyLoginPopupOnPlayGame(TestObject gamePlayButtonObj) {
        String ErrMessage = ''
        boolean IsFailed = false

        WebUI.waitForElementPresent(gamePlayButtonObj, 10, FailureHandling.OPTIONAL)

        if (WebUI.verifyElementPresent(gamePlayButtonObj, 5, FailureHandling.OPTIONAL)) {
            // Scroll down to the game card
            WebUI.scrollToElement(gamePlayButtonObj, 5, FailureHandling.OPTIONAL)
            WebUI.sleep(500)

            // Hover / MouseOver to reveal the Play button overlay
            WebUI.mouseOver(gamePlayButtonObj, FailureHandling.OPTIONAL)
            WebUI.sleep(500)

            // Click the Play button
            WebUI.click(gamePlayButtonObj, FailureHandling.OPTIONAL)

            WebUI.sleep(1500)

            TestObject loginPopupObj = findTestObject('Object Repository/Jovita/Login_ErrorMessage_Invalid')
            boolean isPopupPresent = WebUI.verifyElementPresent(loginPopupObj, 5, FailureHandling.OPTIONAL)

            if (!isPopupPresent) {
                ErrMessage += 'Please login first popup was not displayed after clicking game play button.\n'
                IsFailed = true
            }
        } else {
            ErrMessage += 'Game Play button element is not present.\n'
            IsFailed = true
        }

        if (IsFailed || ErrMessage != '') {
            KeywordUtil.markFailed(ErrMessage)
        } else {
            KeywordUtil.logInfo('Success: Please login first popup verified successfully.')
        }
    }
}
