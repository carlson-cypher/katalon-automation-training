import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

CustomKeywords.'jovita.CommonKeyword.goToHomePage'()

String ErrMessage = ''
boolean IsFailed = false

'Call reusable login step with empty credentials - stop if the login step itself fails'
WebUI.callTestCase(findTestCase('Test Cases/Jovita/TC00_Reusable_Login_Step'), [('username') : '', ('password') : ''], FailureHandling.STOP_ON_FAILURE)

'Wait for the validation messages instead of a fixed sleep'
if (!WebUI.waitForElementVisible(findTestObject('Object Repository/Jovita/Login_ErrorMessage_UsernameRequired'), 10, FailureHandling.OPTIONAL)) {
	ErrMessage += 'Username required error message ("Username is required.") was not displayed.\n'
	IsFailed = true
}

if (!WebUI.waitForElementVisible(findTestObject('Object Repository/Jovita/Login_ErrorMessage_PasswordRequired'), 5, FailureHandling.OPTIONAL)) {
	ErrMessage += 'Password required error message ("Password is required.") was not displayed.\n'
	IsFailed = true
}

if (IsFailed || ErrMessage != '') {
	KeywordUtil.markFailed(ErrMessage)
} else {
	KeywordUtil.logInfo('Success: Empty login validation error messages verified successfully via reusable login step.')
}
