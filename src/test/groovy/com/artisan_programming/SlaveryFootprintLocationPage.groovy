package com.artisan_programming

class SlaveryFootprintLocationPage extends SlaveryFootprintPage {
    static at = { assertQuestionIs('Where Do You Live?'); true }
    static content = {
        common { module SlaveryFootprintModule }

        locationInput { $('#postcode_input') }
        locationEnterButton { $('#location_enter') }
    }

    void enterLocation(String location) {
        waitFor { locationInput.displayed }
        locationInput.value(location)
        safeClick(locationEnterButton)
    }
}
