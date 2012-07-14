package com.artisan_programming

class SlaveryFootprintGenderAgePage extends SlaveryFootprintPage {
    static at = { assertQuestionIs('Let\'s Start With the Basics.') }
    static content = {
        common { module SlaveryFootprintModule }

        genderFemale { $('#woman a') }
        genderMale { $('#man a') }
        age { $('span.age') }
        ageDecrease { $('#gender_and_age-volumecontrols .minus')}
        ageIncrease { $('#gender_and_age-volumecontrols .plus')}
    }

    void setAge(int desiredAge) {
        while (age.text().toInteger() < desiredAge) {
            ageIncrease.click()
        }

        while (age.text().toInteger() > desiredAge) {
            ageDecrease.click()
        }
    }
}
