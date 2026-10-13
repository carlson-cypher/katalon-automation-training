import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

CustomKeywords.'jovita.CommonKeyword.goToHomePage'()

String ErrMessage = ''
boolean IsFailed = false

TestObject languageDropdown = findTestObject('Object Repository/Jovita/Header_Language_Dropdown')
TestObject optionIndonesian = findTestObject('Object Repository/Jovita/Header_Language_Option_Indonesian')
TestObject optionEnglish = findTestObject('Object Repository/Jovita/Header_Language_Option_English')
// The header Login button label is translated: "Login" (English) / "Masuk" (Indonesian)
TestObject loginTextEnglish = findTestObject('Object Repository/Jovita/Login_Button_Text_English')
TestObject loginTextIndonesian = findTestObject('Object Repository/Jovita/Login_Button_Text_Indonesian')

'Precondition: page starts in English, otherwise the switch cannot be proven'
if (!WebUI.waitForElementVisible(loginTextEnglish, 10, FailureHandling.OPTIONAL)) {
	ErrMessage += 'Precondition failed: page did not start in English (Login button "Login" not found).\n'
	IsFailed = true
} else {
	'Switch to Indonesian'
	WebUI.click(languageDropdown, FailureHandling.STOP_ON_FAILURE)
	WebUI.waitForElementClickable(optionIndonesian, 5, FailureHandling.OPTIONAL)
	WebUI.click(optionIndonesian, FailureHandling.STOP_ON_FAILURE)

	'Verify the page language changed: Login button now reads "Masuk"'
	if (!WebUI.waitForElementVisible(loginTextIndonesian, 10, FailureHandling.OPTIONAL)) {
		ErrMessage += 'Failed to verify page language switched to Indonesian (Login button "Masuk" was not found).\n'
		IsFailed = true
	}

	'Switch back to English (also leaves the shared browser in English for the next test cases)'
	WebUI.click(languageDropdown, FailureHandling.STOP_ON_FAILURE)
	WebUI.waitForElementClickable(optionEnglish, 5, FailureHandling.OPTIONAL)
	WebUI.click(optionEnglish, FailureHandling.STOP_ON_FAILURE)

	'Verify the page language changed back: Login button reads "Login" again'
	if (!WebUI.waitForElementVisible(loginTextEnglish, 10, FailureHandling.OPTIONAL)) {
		ErrMessage += 'Failed to verify page language switched back to English (Login button "Login" was not found).\n'
		IsFailed = true
	}
}

if (IsFailed || ErrMessage != '') {
	KeywordUtil.markFailed(ErrMessage)
} else {
	KeywordUtil.logInfo('Success: Language switched to Indonesian and back to English successfully.')
}
