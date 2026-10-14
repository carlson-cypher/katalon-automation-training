package kishan

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

class PlayButtonCheck {

	@Keyword
	def verifyLoginRequired(TestObject playButton) {

		// Click the supplied Play button
		WebUI.waitForElementPresent(playButton, 15)
		WebUI.scrollToElement(playButton, 10)
		WebUI.waitForElementClickable(playButton, 10)
		WebUI.click(playButton)

		// Use your captured popup object
		TestObject loginPopup = findTestObject(
			'Play button before login/Page_testing only/div_Please login first.OK'
		)

		WebUI.waitForElementVisible(loginPopup, 15)
		WebUI.verifyElementVisible(loginPopup)

		// Verify the message, allowing punctuation and OK button text
		String popupText = WebUI.getText(loginPopup)

		WebUI.verifyMatch(
			popupText,
			'(?s).*Please login first.*',
			true
		)
	}
}