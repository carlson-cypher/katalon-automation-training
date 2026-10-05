import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

WebUI.waitForElementPresent(findTestObject('Object Repository/Jovita/Login_Button'), 10, FailureHandling.OPTIONAL)

if (WebUI.verifyElementPresent(findTestObject('Object Repository/Jovita/Login_Button'), 5, FailureHandling.OPTIONAL)) {
	if (WebUI.verifyElementVisible(findTestObject('Object Repository/Jovita/Login_Button'), FailureHandling.OPTIONAL)) {
		WebUI.click(findTestObject('Object Repository/Jovita/Login_Button'), FailureHandling.OPTIONAL)
		
		WebUI.waitForElementPresent(findTestObject('Object Repository/Jovita/Login_Username_Input'), 10, FailureHandling.OPTIONAL)
		
		if (username != null && username != '') {
			WebUI.sendKeys(findTestObject('Object Repository/Jovita/Login_Username_Input'), username, FailureHandling.OPTIONAL)
		}
		
		if (password != null && password != '') {
			WebUI.sendKeys(findTestObject('Object Repository/Jovita/Login_Password_Input'), password, FailureHandling.OPTIONAL)
		}
		
		WebUI.waitForElementPresent(findTestObject('Object Repository/Jovita/Login_Button_Submit'), 5, FailureHandling.OPTIONAL)
		WebUI.click(findTestObject('Object Repository/Jovita/Login_Button_Submit'), FailureHandling.OPTIONAL)
	}
}
