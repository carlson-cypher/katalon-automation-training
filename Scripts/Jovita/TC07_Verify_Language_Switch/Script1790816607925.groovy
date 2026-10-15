import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

CustomKeywords.'jovita.CommonKeyword.goToHomePage'()

String ErrMessage = ''
boolean IsFailed = false

TestObject loginButton = findTestObject('Object Repository/Jovita/Login_Button')
TestObject languageDropdown = findTestObject('Object Repository/Jovita/Header_Language_Dropdown')
// The header Login button label is translated: "Login" (English) / "Masuk" (Indonesian)
Map<String, Map<String, TestObject>> languages = [
	('English')    : [option : findTestObject('Object Repository/Jovita/Header_Language_Option_English'),
	                  label  : findTestObject('Object Repository/Jovita/Login_Button_Text_English')],
	('Indonesian') : [option : findTestObject('Object Repository/Jovita/Header_Language_Option_Indonesian'),
	                  label  : findTestObject('Object Repository/Jovita/Login_Button_Text_Indonesian')]
]

'Detect the starting language from the Login button label (the site can start in either language)'
if (!WebUI.waitForElementVisible(loginButton, 10, FailureHandling.OPTIONAL)) {
	KeywordUtil.markFailedAndStop('Login button is not visible, cannot detect the page language.')
}
String startLanguage = WebUI.verifyElementPresent(languages.English.label, 1, FailureHandling.OPTIONAL) ? 'English' :
	(WebUI.verifyElementPresent(languages.Indonesian.label, 1, FailureHandling.OPTIONAL) ? 'Indonesian' : null)
if (startLanguage == null) {
	KeywordUtil.markFailedAndStop('Could not detect the page language: Login button shows neither "Login" nor "Masuk".')
}
String otherLanguage = (startLanguage == 'English') ? 'Indonesian' : 'English'
KeywordUtil.logInfo('Page started in ' + startLanguage + '; switching to ' + otherLanguage + ' and back.')

def switchTo = { String language ->
	WebUI.click(languageDropdown, FailureHandling.STOP_ON_FAILURE)
	WebUI.waitForElementClickable(languages[language].option, 5, FailureHandling.OPTIONAL)
	WebUI.click(languages[language].option, FailureHandling.STOP_ON_FAILURE)
	return WebUI.waitForElementVisible(languages[language].label, 10, FailureHandling.OPTIONAL)
}

'Switch to the other language and verify the Login button label changed'
if (!switchTo(otherLanguage)) {
	ErrMessage += 'Failed to verify page language switched to ' + otherLanguage + '.\n'
	IsFailed = true
}

'Switch back to the starting language and verify (also leaves the shared browser as it started)'
if (!switchTo(startLanguage)) {
	ErrMessage += 'Failed to verify page language switched back to ' + startLanguage + '.\n'
	IsFailed = true
}

if (IsFailed || ErrMessage != '') {
	KeywordUtil.markFailed(ErrMessage)
} else {
	KeywordUtil.logInfo('Success: Language switched from ' + startLanguage + ' to ' + otherLanguage + ' and back.')
}
