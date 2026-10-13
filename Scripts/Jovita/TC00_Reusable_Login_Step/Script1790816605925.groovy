import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

TestObject loginButton = findTestObject('Object Repository/Jovita/Login_Button')
TestObject usernameInput = findTestObject('Object Repository/Jovita/Login_Username_Input')
TestObject passwordInput = findTestObject('Object Repository/Jovita/Login_Password_Input')
TestObject submitButton = findTestObject('Object Repository/Jovita/Login_Button_Submit')

'Open the login modal - stop the test if the Login button cannot be found'
if (!WebUI.waitForElementClickable(loginButton, 10, FailureHandling.OPTIONAL)) {
	KeywordUtil.markFailedAndStop('Reusable login step: Login button was not found or is not clickable.')
}
WebUI.click(loginButton, FailureHandling.STOP_ON_FAILURE)

if (!WebUI.waitForElementVisible(usernameInput, 10, FailureHandling.OPTIONAL)) {
	KeywordUtil.markFailedAndStop('Reusable login step: Login modal did not open (Username input not visible).')
}

'Fill in the credentials (empty values are allowed for validation tests)'
WebUI.setText(usernameInput, username ?: '', FailureHandling.STOP_ON_FAILURE)
WebUI.setText(passwordInput, password ?: '', FailureHandling.STOP_ON_FAILURE)

if (!WebUI.waitForElementClickable(submitButton, 5, FailureHandling.OPTIONAL)) {
	KeywordUtil.markFailedAndStop('Reusable login step: Login submit button was not found or is not clickable.')
}
WebUI.click(submitButton, FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Reusable login step: credentials submitted.')
