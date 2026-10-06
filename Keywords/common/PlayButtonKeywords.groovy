package common

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class PlayButtonKeywords {
	
	def verifyLoginPopupOnPlay(TestObject playButton, TestObject popup) {
        WebUI.click(playButton)
        WebUI.waitForElementVisible(popup, 10)
        WebUI.verifyTextPresent('Please login first', false)
		
		if (WebUI.verifyElementVisible(
			findTestObject('Object Repository/ObjectRepository_KaiJun/Pop_Up/Please_Login_First_Panel'),
			FailureHandling.OPTIONAL)) {
		
		WebUI.click(findTestObject('Object Repository/ObjectRepository_KaiJun/Pop_Up/Please_Login_First_Panel_Ok_Button'))
		}
				
			}
		
    }

