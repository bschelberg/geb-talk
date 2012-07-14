import geb.Browser
import geb.Page

class SlaveryFootprintPage extends Page {
    static url = "http://slaveryfootprint.org"
    static at = { assert title.contains("Slavery Footprint") }
    static content = {
        takeTheSurvey { $('div#home-menu-findout a') }
        question { $('#question_text') }
        nextButton { $('#next') }

        locationInput { $('#postcode_input') }
        locationEnterButton { $('#location_enter') }
    }

    void assertQuestionIs(String expectedQuestion) {
        waitFor(8) { question.displayed }
        assert question.text() == expectedQuestion
    }

    void clickNext() {
        waitFor { nextButton.parent().@class ==~ /.+_active$/ }
        nextButton.click()
    }

    void enterLocation(String location) {
        locationInput.value(location)
        locationEnterButton.click()
    }
}

Browser.drive {
    to SlaveryFootprintPage
    at SlaveryFootprintPage

    // using elements directly...
    takeTheSurvey.click()
    waitFor(16) { question.displayed }
    assert question.text() == 'Where Do You Live?'

    // with methods...
    enterLocation('Melbourne')
    clickNext()

    assertQuestionIs("Let's Start With the Basics.")

    quit()
}
