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
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

try {
	WebUI.openBrowser('')
	WebUI.maximizeWindow()
	WebUI.navigateToUrl('https://behemoth-w1n.nomlaterla.com/')

	// Dismiss the initial popup
	def popupOK = findTestObject('Page_testing only/div_OK')
	WebUI.waitForElementClickable(popupOK, 15)
	WebUI.click(popupOK)

	// Confirm the user is logged out
	def loginLink = findTestObject('Page_testing only/a_Login')
	WebUI.waitForElementVisible(loginLink, 15)
	WebUI.verifyElementVisible(loginLink)

	// Click Play and verify "Please login first"
	CustomKeywords.'kishan.PlayButtonCheck.verifyLoginRequired'(
		findTestObject('Play button before login/Page_testing only/a_PLAY')
	)

} finally {
	WebUI.closeBrowser()
}