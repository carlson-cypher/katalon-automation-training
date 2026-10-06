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

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.homeUrl)

CustomKeywords.'common.PopupKeywords.closeHomepagePopup'()


//--------------Switch to Indonesia Language---------------------
//Press Language button
WebUI.click(findTestObject('Object Repository/ObjectRepository_KaiJun/Language_Options/Language_Options'))

// Select ID language 
WebUI.click(findTestObject('Object Repository/ObjectRepository_KaiJun/Language_Options/Button_Bahasa_Indonesia'))
WebUI.waitForPageLoad(10)

// Verify the page language matches the selected language
String langId = WebUI.getAttribute(findTestObject('Object Repository/ObjectRepository_KaiJun/BHM_site/html_root'), 'lang')
WebUI.verifyEqual(langId.startsWith('id'), true)

//--------------Switch to English Language---------------------
//Press Language button
WebUI.click(findTestObject('Object Repository/ObjectRepository_KaiJun/Language_Options/Language_Options'))

// Select EN language
WebUI.click(findTestObject('Object Repository/ObjectRepository_KaiJun/Language_Options/Button_English'))
WebUI.waitForPageLoad(10)

// Verify the page language matches the selected language
String langEng = WebUI.getAttribute(findTestObject('Object Repository/ObjectRepository_KaiJun/BHM_site/html_root'), 'lang')
WebUI.verifyEqual(langEng.startsWith('en'), true)

// Close browser
WebUI.closeBrowser()