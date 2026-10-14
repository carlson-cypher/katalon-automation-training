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
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.model.FailureHandling

WebUI.openBrowser('')

WebUI.navigateToUrl('https://behemoth-w1n.nomlaterla.com/')

WebUI.click(findTestObject('Object Repository/Page_testing only/div_OK'))

WebUI.callTestCase(
    findTestCase('Test Cases_Kishan/Common/Verify_Reusable_Login'),
    ['username': '', 'password': ''],
    FailureHandling.STOP_ON_FAILURE
)

WebUI.waitForElementVisible(
	findTestObject('Object Repository/Page_testing only/Page_testing only/Page_testing only/Page_testing only/Page_testing only/Username is required'), 10
)
WebUI.verifyElementText(
	findTestObject('Object Repository/Page_testing only/Page_testing only/Page_testing only/Page_testing only/Page_testing only/Username is required'),
	'Username is required.'
)

WebUI.waitForElementVisible(
	findTestObject('Object Repository/Page_testing only/Page_testing only/Page_testing only/Page_testing only/Page_testing only/Password is required'), 10
)
WebUI.verifyElementText(
	findTestObject('Object Repository/Page_testing only/Page_testing only/Page_testing only/Page_testing only/Page_testing only/Password is required'),
	'Password is required.'
)

WebUI.closeBrowser()

