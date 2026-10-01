import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

String ErrMessage = ''
boolean IsFailed = false

WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.MembersiteURL)
WebUI.maximizeWindow()

'Handle optional announcement / popup dialogs'
WebUI.waitForElementPresent(findTestObject('Object Repository/Jovita/General_Button_Popup_Close'), 2, FailureHandling.OPTIONAL)
if (WebUI.verifyElementPresent(findTestObject('Object Repository/Jovita/General_Button_Popup_Close'), 1, FailureHandling.OPTIONAL)) {
	if (WebUI.verifyElementVisible(findTestObject('Object Repository/Jovita/General_Button_Popup_Close'), FailureHandling.OPTIONAL)) {
		WebUI.click(findTestObject('Object Repository/Jovita/General_Button_Popup_Close'), FailureHandling.OPTIONAL)
	}
}

'Call reusable login step with empty credentials'
WebUI.callTestCase(findTestCase('Test Cases/Jovita/TC00_Reusable_Login_Step'), [('username') : '', ('password') : ''], FailureHandling.OPTIONAL)

WebUI.sleep(1000)

boolean usernameErr = WebUI.verifyElementPresent(findTestObject('Object Repository/Jovita/Login_ErrorMessage_UsernameRequired'), 5, FailureHandling.OPTIONAL)
boolean passwordErr = WebUI.verifyElementPresent(findTestObject('Object Repository/Jovita/Login_ErrorMessage_PasswordRequired'), 5, FailureHandling.OPTIONAL)

if (!usernameErr) {
	ErrMessage += 'Username required error message was not displayed.\n'
	IsFailed = true
}

if (!passwordErr) {
	ErrMessage += 'Password required error message was not displayed.\n'
	IsFailed = true
}

WebUI.closeBrowser()

if (IsFailed || ErrMessage != '') {
	KeywordUtil.markFailed(ErrMessage)
} else {
	KeywordUtil.logInfo('Success: Empty login validation error messages verified successfully via reusable login step.')
}
