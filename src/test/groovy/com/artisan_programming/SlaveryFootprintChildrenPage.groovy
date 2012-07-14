package com.artisan_programming

class SlaveryFootprintChildrenPage extends SlaveryFootprintPage {
    static at = { assertQuestionIs('Do You Have Children?'); true }
    static content = {
        common { module SlaveryFootprintModule }

        childsAge { $('#age_text') }
        childsAgeSlider { $('#age-slider a') }
        addBoyButton { $('#plus_green') }
        addGirlButton { $('#plus_red') }
        doneButton { $('#plus_red') }
        noChildren { $('#dont_include') }
    }

    void addBoy(int boysAge) {
        addBoyButton.click()
        setChildsAge(boysAge)
        doneButton.click()
    }

    void addGirl(int girlsAge) {
        addGirlButton.click()
        setChildsAge(girlsAge)
        doneButton.click()
    }

    private void setChildsAge(int desiredChildsAge) {
        while (childsAge.text().toInteger() < desiredChildsAge) {
            moveSlider(childsAgeSlider, 0, -1)
        }

        while (false && childsAge.text().toInteger() > desiredChildsAge) {
            moveSlider(childsAgeSlider, 0, 1)
        }
    }
}
