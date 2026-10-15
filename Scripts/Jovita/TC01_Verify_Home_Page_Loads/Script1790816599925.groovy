import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

CustomKeywords.'jovita.CommonKeyword.goToHomePage'()

'Verify the home page logo is visible'
if (!WebUI.waitForElementVisible(findTestObject('Object Repository/Jovita/Home_Logo_Image'), 10, FailureHandling.OPTIONAL)) {
	KeywordUtil.markFailedAndStop('Home Page Logo is not visible.')
}

KeywordUtil.logInfo('Success: Home Page loaded and Logo is visible.')
