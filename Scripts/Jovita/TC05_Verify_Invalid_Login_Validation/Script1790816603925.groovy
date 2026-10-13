import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import jovita.JovitaConfig as JovitaConfig
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

String ErrMessage = ''
boolean IsFailed = false

WebUI.openBrowser('')

try {
	WebUI.navigateToUrl(JovitaConfig.MEMBERSITE_URL)
	WebUI.maximizeWindow()

	'Handle optional announcement / popup dialogs'
	WebUI.waitForElementPresent(findTestObject('Object Repository/Jovita/General_Button_Popup_Close'), 2, FailureHandling.OPTIONAL)
	if (WebUI.verifyElementPresent(findTestObject('Object Repository/Jovita/General_Button_Popup_Close'), 1, FailureHandling.OPTIONAL)) {
		if (WebUI.verifyElementVisible(findTestObject('Object Repository/Jovita/General_Button_Popup_Close'), FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('Object Repository/Jovita/General_Button_Popup_Close'), FailureHandling.OPTIONAL)
		}
	}

	'Call reusable login step with invalid credentials - stop if the login step itself fails'
	WebUI.callTestCase(findTestCase('Test Cases/Jovita/TC00_Reusable_Login_Step'), [('username') : 'wrong_user_999', ('password') : 'wrong_password_999'], FailureHandling.STOP_ON_FAILURE)

	'Wait for the invalid-login error (page reloads to /home?login) instead of a fixed sleep'
	boolean invalidErr = WebUI.waitForElementVisible(findTestObject('Object Repository/Jovita/Login_ErrorMessage_Invalid'), 15, FailureHandling.OPTIONAL)
	if (!invalidErr) {
		ErrMessage += 'Invalid login error message ("Invalid username or password") was not displayed.\n'
		IsFailed = true
	}
} finally {
	WebUI.closeBrowser()
}

if (IsFailed || ErrMessage != '') {
	KeywordUtil.markFailed(ErrMessage)
} else {
	KeywordUtil.logInfo('Success: Invalid login error message verified successfully via reusable login step.')
}
