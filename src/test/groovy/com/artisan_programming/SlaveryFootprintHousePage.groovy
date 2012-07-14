package com.artisan_programming

import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Action
import org.openqa.selenium.interactions.Actions

class SlaveryFootprintHousePage extends SlaveryFootprintPage {
    static at = { assertQuestionIs('What\'s Under Your Roof?'); true }
    static content = {
        common { module SlaveryFootprintModule }

        housingSituation { String label -> $('a', class: startsWith('whats_under_your_roof-option'), text: label) }
        renter { housingSituation('Renter') }
        owner { housingSituation('Owner') }
        collegeStudent { housingSituation('College Student') }
        couchSurfer { housingSituation('Couch Surfer') }

        additionRoom { $('#home .ui-droppable') }
        houseItem { String name -> $('li.rooms.item', text: name).find('.ui-draggable') }
        bedroom { houseItem('Bedrooms') }
        bathroom { houseItem('Bathrooms') }
        homeOffice { houseItem('Home Office') }
        car { houseItem('Car') }
        scooter { houseItem('Scooter Motorcycle') }
    }

    void addBedroomToHouse() {
        dragItemToHouse(bedroom)
    }

    void addBathroomToHouse() {
        dragItemToHouse(bathroom)
    }

    void addHomeOfficeToHouse() {
        dragItemToHouse(homeOffice)
    }

    void addCarToHouse() {
        dragItemToHouse(car)
    }

    void addScooterToHouse() {
        dragItemToHouse(scooter)
    }

    private void dragItemToHouse(item) {
        WebElement itemElement = item.getElement(0)
        WebElement roomElement = additionRoom.getElement(0)
        Action drop = new Actions(driver).dragAndDrop(itemElement, roomElement).build()
        drop.perform()
    }
}
