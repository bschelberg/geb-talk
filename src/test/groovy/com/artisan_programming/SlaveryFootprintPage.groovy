package com.artisan_programming

import geb.Page
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Action
import org.openqa.selenium.interactions.Actions

class SlaveryFootprintPage extends Page {
    // Subclasses must include SlaveryFootPrintModule as common
    boolean assertQuestionIs(String expectedQuestion) {
        waitFor(32) { common.question.displayed }
        assert common.question.text() == expectedQuestion

        true
    }
    
    void clickNext() {
        waitFor { common.nextButton.parent().@class ==~ /.+_active$/ }
        common.nextButton.click()
        if (common.fineTuneBubble.displayed) {
            common.fineTuneBubble.click()
            common.fineTuneClose.click()
            common.nextButton.click()
        }
    }

    void safeClick(def element) {
        def moveableElement = element

        while (moveableElement.@style.length() == 0) {
            moveableElement = moveableElement.parent()
        }

        waitFor { isOnPage(moveableElement) }
        element.click()
    }

    boolean isOnPage(def element) {
        // make sure 'left' is not a negative value
        element.@style ==~ /.*left:\s*\d.*/
    }

    protected void moveSlider(slider, int xOffset, int yOffset) {
        // Click and Drag using underlying WebDriver...
        WebElement sliderElement = slider.getElement(0)
        Action slide = new Actions(driver).dragAndDropBy(sliderElement, xOffset, yOffset).build()
        slide.perform()
    }
}
