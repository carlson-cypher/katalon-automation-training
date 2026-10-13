import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

CustomKeywords.'jovita.CommonKeyword.goToHomePage'()

String ErrMessage = ''
boolean IsFailed = false
TestObject loginButton = findTestObject('Object Repository/Jovita/Login_Button')

if (!WebUI.waitForElementClickable(loginButton, 10, FailureHandling.OPTIONAL)) {
	ErrMessage += 'Login Button is not present or not clickable.\n'
	IsFailed = true
} else {
	WebUI.click(loginButton, FailureHandling.STOP_ON_FAILURE)

	'Verify the login modal opened'
	if (!WebUI.waitForElementVisible(findTestObject('Object Repository/Jovita/Login_Username_Input'), 10, FailureHandling.OPTIONAL)) {
		ErrMessage += 'Username input field is not visible in Login modal.\n'
		IsFailed = true
	}
}

if (IsFailed || ErrMessage != '') {
	KeywordUtil.markFailed(ErrMessage)
} else {
	KeywordUtil.logInfo('Success: Login modal appeared and Username input field is visible.')
}
