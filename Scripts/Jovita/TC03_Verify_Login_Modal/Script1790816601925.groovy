import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
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

WebUI.waitForElementPresent(findTestObject('Object Repository/Jovita/Login_Button'), 10, FailureHandling.OPTIONAL)

if (WebUI.verifyElementPresent(findTestObject('Object Repository/Jovita/Login_Button'), 5, FailureHandling.OPTIONAL)) {
	if (WebUI.verifyElementVisible(findTestObject('Object Repository/Jovita/Login_Button'), FailureHandling.OPTIONAL)) {
		WebUI.click(findTestObject('Object Repository/Jovita/Login_Button'), FailureHandling.OPTIONAL)
		
		WebUI.waitForElementPresent(findTestObject('Object Repository/Jovita/Login_Username_Input'), 10, FailureHandling.OPTIONAL)
		
		if (!WebUI.verifyElementVisible(findTestObject('Object Repository/Jovita/Login_Username_Input'), FailureHandling.OPTIONAL)) {
			ErrMessage += 'Username input field is not visible in Login modal.\n'
			IsFailed = true
		}
	} else {
		ErrMessage += 'Login Button element is not visible.\n'
		IsFailed = true
	}
} else {
	ErrMessage += 'Login Button element is not present.\n'
	IsFailed = true
}

WebUI.closeBrowser()

if (IsFailed || ErrMessage != '') {
	KeywordUtil.markFailed(ErrMessage)
} else {
	KeywordUtil.logInfo('Success: Login modal appeared and Username input field is visible.')
}
