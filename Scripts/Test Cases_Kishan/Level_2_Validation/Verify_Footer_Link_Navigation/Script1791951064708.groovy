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
	WebUI.waitForPageLoad(20)

	WebUI.click(findTestObject('Object Repository/Page_testing only/span_'))

	WebUI.click(findTestObject('Object Repository/Page_testing only/a_Login'))

	WebUI.setText(
		findTestObject('Object Repository/Object Repository_Kishan/Login/Login_Form_Username_Field'),
		'Robin'
	)

	WebUI.setEncryptedText(
		findTestObject('Object Repository/Object Repository_Kishan/Login/Login_Form_Password_Field'),
		'OCqA5p6xUz6UMtCAuE8KQg=='
	)

	WebUI.click(findTestObject('Object Repository/Page_testing only/span_LOGIN'))

	WebUI.waitForElementClickable(
		findTestObject('Object Repository/Page_testing only/button_OK'), 15
	)

	WebUI.click(findTestObject('Object Repository/Page_testing only/button_OK'))

	// Scroll to and click the Loyalty link
	def loyaltyLink = findTestObject(
		'Object Repository/Page_testing only/a_Loyalty'
	)

	WebUI.waitForElementPresent(loyaltyLink, 15)
	WebUI.scrollToElement(loyaltyLink, 10)
	WebUI.waitForElementClickable(loyaltyLink, 10)
	WebUI.click(loyaltyLink)

	// Wait for the destination page heading
	WebUI.waitForElementVisible(
		findTestObject('Object Repository/Object Repository_Kishan/Footer/Loyalty_Reward'),
		20
	)

	// Verify the destination URL
	WebUI.verifyMatch(
		WebUI.getUrl(),
		'https://behemoth-w1n.nomlaterla.com/desktop/loyalty/rewards',
		false
	)

} finally {
	WebUI.closeBrowser()
}