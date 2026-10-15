import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.configuration.RunConfiguration


RunConfiguration.setWebDriverPreferencesProperty('args', ['--disable-notifications'])

//WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.homeUrl)

CustomKeywords.'kaijun.PopupKeywords.closeHomepagePopup'()

// Valid Login credential 
WebUI.callTestCase(
	findTestCase('Test Cases/TestCases_KaiJun/Common/Reusable_Login_Step'),
	[('username'): 'ryantest2', ('password'): 'Testing123'],
	FailureHandling.STOP_ON_FAILURE)

//Close after login homepage pop up
if (WebUI.verifyElementVisible(
    findTestObject('Object Repository/ObjectRepository_KaiJun/Pop_Up/After_Login_Homepage_Popup'),
    FailureHandling.OPTIONAL)) {

WebUI.click(findTestObject('Object Repository/ObjectRepository_KaiJun/Pop_Up/After_Login_Homepage_Popup_Ok_button'))
}

 //Check whether Login button is no longer present
	WebUI.waitForElementNotPresent(
	findTestObject('Object Repository/ObjectRepository_KaiJun/Login/Login_Button'),
	10,
	FailureHandling.OPTIONAL)

	// Login button is absent — verify successful login indicator
	WebUI.verifyElementVisible(
		findTestObject('Object Repository/ObjectRepository_KaiJun/Account/Account_Detail_Bar')
	)
	
	// Logout to prevent affecting other test cases
	WebUI.click(findTestObject('Object Repository/Logout/Logout_Button'))

// Close browser
//WebUI.closeBrowser()