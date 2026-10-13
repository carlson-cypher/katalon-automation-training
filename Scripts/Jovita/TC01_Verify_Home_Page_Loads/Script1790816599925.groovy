import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

CustomKeywords.'jovita.CommonKeyword.goToHomePage'()

String ErrMessage = ''
boolean IsFailed = false

'Verify the home page logo is visible'
if (!WebUI.waitForElementVisible(findTestObject('Object Repository/Jovita/Home_Logo_Image'), 10, FailureHandling.OPTIONAL)) {
	ErrMessage += 'Home Page Logo is not visible.\n'
	IsFailed = true
}

if (IsFailed || ErrMessage != '') {
	KeywordUtil.markFailed(ErrMessage)
} else {
	KeywordUtil.logInfo('Success: Home Page loaded and Logo is visible.')
}
