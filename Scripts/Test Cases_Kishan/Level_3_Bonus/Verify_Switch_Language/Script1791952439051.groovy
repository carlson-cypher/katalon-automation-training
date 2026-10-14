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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType

// Match the smallest element containing the exact translated text
TestObject indonesianText = new TestObject('indonesianText')
indonesianText.addProperty(
	'xpath',
	ConditionType.EQUALS,
	"//*[normalize-space(.)='Main di Telegram' and not(.//*[normalize-space(.)='Main di Telegram'])]"
)

TestObject englishText = new TestObject('englishText')
englishText.addProperty(
	'xpath',
	ConditionType.EQUALS,
	"//*[normalize-space(.)='Play on Telegram' and not(.//*[normalize-space(.)='Play on Telegram'])]"
)

try {
	WebUI.openBrowser('')
	WebUI.maximizeWindow()
	WebUI.navigateToUrl('https://behemoth-w1n.nomlaterla.com/')
	WebUI.waitForPageLoad(20)

	WebUI.waitForElementClickable(
		findTestObject('Object Repository/Page_testing only/div_OK'), 15
	)
	WebUI.click(
		findTestObject('Object Repository/Page_testing only/div_OK')
	)

	// Open the language selector
	WebUI.click(
		findTestObject('Object Repository/Page_testing only/button_Play on Telegram_cursor-pointer flex_58f52c')
	)

	// Select Indonesian
	WebUI.click(
		findTestObject('Object Repository/Language_Options/IDR_Language')
	)

	// Verify the page displays Indonesian text
	WebUI.waitForElementVisible(indonesianText, 15)
	WebUI.verifyElementText(indonesianText, 'Main di Telegram')

	// Open the language selector again
	WebUI.click(
		findTestObject('Object Repository/Page_testing only/button_Main di Telegram_cursor-pointer flex_f504f0')
	)

	// Select English
	WebUI.click(
		findTestObject('Object Repository/Page_testing only/span_ENGLISH')
	)

	// Verify the page displays English text again
	WebUI.waitForElementVisible(englishText, 15)
	WebUI.verifyElementText(englishText, 'Play on Telegram')

} finally {
	WebUI.closeBrowser()
}