import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import jovita.JovitaConfig as JovitaConfig

CustomKeywords.'jovita.CommonKeyword.goToHomePage'()

String ErrMessage = ''
boolean IsFailed = false
TestObject link = findTestObject('Object Repository/Jovita/Header_Sports_Button')

if (!WebUI.waitForElementClickable(link, 10, FailureHandling.OPTIONAL)) {
	ErrMessage += 'Header Sports Button is not present or not clickable.\n'
	IsFailed = true
} else {
	WebUI.click(link, FailureHandling.STOP_ON_FAILURE)

	'Poll the URL until it matches the exact expected URL (max 10 s)'
	String expectedUrl = JovitaConfig.SPORTS_URL
	String currentUrl = WebUI.getUrl()
	int waitCounter = 0
	while (currentUrl != expectedUrl && waitCounter < 10) {
		WebUI.delay(1)
		currentUrl = WebUI.getUrl()
		waitCounter++
	}

	if (currentUrl != expectedUrl) {
		ErrMessage += 'URL did not match Sports page. Expected: ' + expectedUrl + ' Actual: ' + currentUrl + '\n'
		IsFailed = true
	}
}

if (IsFailed || ErrMessage != '') {
	KeywordUtil.markFailed(ErrMessage)
} else {
	KeywordUtil.logInfo('Success: Navigated to Sports page successfully.')
}
