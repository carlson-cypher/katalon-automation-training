import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

CustomKeywords.'jovita.CommonKeyword.goToHomePage'()

String ErrMessage = ''
boolean IsFailed = false

'Call reusable login step with invalid credentials - stop if the login step itself fails'
WebUI.callTestCase(findTestCase('Test Cases/Jovita/TC00_Reusable_Login_Step'), [('username') : 'wrong_user_999', ('password') : 'wrong_password_999'], FailureHandling.STOP_ON_FAILURE)

'Wait for the invalid-login error (page reloads to /home?login) instead of a fixed sleep'
if (!WebUI.waitForElementVisible(findTestObject('Object Repository/Jovita/Login_ErrorMessage_Invalid'), 15, FailureHandling.OPTIONAL)) {
	ErrMessage += 'Invalid login error message ("Invalid username or password") was not displayed.\n'
	IsFailed = true
}

if (IsFailed || ErrMessage != '') {
	KeywordUtil.markFailed(ErrMessage)
} else {
	KeywordUtil.logInfo('Success: Invalid login error message verified successfully via reusable login step.')
}
