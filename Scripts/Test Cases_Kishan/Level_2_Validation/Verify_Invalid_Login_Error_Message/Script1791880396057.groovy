import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType

try {
	WebUI.openBrowser('')
	WebUI.maximizeWindow()
	WebUI.navigateToUrl('https://behemoth-w1n.nomlaterla.com/')

	// Dismiss the initial popup
	def popupOK = findTestObject('Page_testing only/div_OK')
	WebUI.waitForElementClickable(popupOK, 15)
	WebUI.click(popupOK)

	// Opens the login form, fills the fields, and clicks Login
	WebUI.callTestCase(
		findTestCase('Test Cases_Kishan/Common/Verify_Reusable_Login'),
		['username': 'wronguser', 'password': 'WrongPass123'],
		FailureHandling.STOP_ON_FAILURE
	)

	// Verify the invalid login message
	TestObject errorMsg = new TestObject('errorMsg')
	errorMsg.addProperty(
		'xpath',
		ConditionType.EQUALS,
		"//*[normalize-space(.)='Invalid username or password' and not(.//*[normalize-space(.)='Invalid username or password'])]"
	)

	WebUI.waitForElementVisible(errorMsg, 15)
	WebUI.verifyElementText(errorMsg, 'Invalid username or password')

} finally {
	WebUI.closeBrowser()
}