package jovita

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class CommonKeyword {

	/**
	 * Navigates the already-open browser to the home page and closes the
	 * announcement popup ("POPUP TITLE TEST" with an OK button) if it shows.
	 * The site shows that popup only once per browser, so it is optional.
	 */
	@Keyword
	def goToHomePage() {
		WebUI.navigateToUrl(JovitaConfig.MEMBERSITE_URL)
		WebUI.waitForPageLoad(15)

		TestObject announcementOk = findTestObject('Object Repository/Jovita/General_Button_Popup_Close')
		if (WebUI.waitForElementClickable(announcementOk, 3, FailureHandling.OPTIONAL)) {
			WebUI.click(announcementOk, FailureHandling.STOP_ON_FAILURE)
			KeywordUtil.logInfo('Announcement popup closed.')
		}
	}
}
