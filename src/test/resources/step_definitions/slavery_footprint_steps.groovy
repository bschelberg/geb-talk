import com.artisan_programming.*

import cucumber.table.DataTable
import com.artisan_programming.SingleRowTable
import org.junit.Assert

this.metaClass.mixin(cucumber.runtime.groovy.Hooks)
this.metaClass.mixin(cucumber.runtime.groovy.EN)
this.metaClass.mixin(geb.Browser)

Given(~'a User is at the Slavery Footprint home page') { ->
    to SlaveryFootprintHomePage
    at SlaveryFootprintHomePage
}

Given(~'the User starts taking the survey') { ->
    takeTheSurvey.click()
}

When(~'the User enters their location as "([^"]+)"') { String location ->
    at SlaveryFootprintLocationPage
    enterLocation(location)
    clickNext()
}

When(~'the User enters their details:') { DataTable detailTable ->
    SingleRowTable data = new SingleRowTable(detailTable)

    at SlaveryFootprintGenderAgePage
    switch (data.Gender.toLowerCase()) {
        case 'male':
            safeClick(genderMale)
            break

        case 'female':
            safeClick(genderFemale)
            break

        default:
            Assert.fail ("Unknown gender: ${data.Gender}")
    }
    setAge(data.Age.toInteger())
    clickNext()

    at SlaveryFootprintChildrenPage
    if (data.Children == 'none') {
        noChildren.click()
    } else {
        def children = data.Children.tokenize(',')

        children.each {
            String gender, age
            (gender, age) = it.tokenize(':')

            switch (gender.toLowerCase()) {
                case 'boy':
                    addBoy(age.toInteger())
                    break

                case 'girl':
                    addGirl(age.toInteger())
                    break

                default:
                    fail "Unknown children gender: ${gender}"
            }
        }

        clickNext()
    }

    at SlaveryFootprintHousePage
    switch (data.'Housing Situation'.toLowerCase()) {
        case 'renter':
            renter.click()
            break

        case 'owner':
            break

        case 'college student':
            break

        case 'couch surfer':
            break

        default:
            fail 'Unknown Housing Situation value: ' + data.'Housing Situation'
    }
    data.'House Items'.tokenize(',').each {
        def matcher = it.trim() =~ /^(\d+) x (.+)$/

        if (matcher.matches()) {
            for (i in 0..matcher[0][1].toInteger() - 1) {
                addHouseItem(matcher[0][2])
            }
        } else {
            addHouseItem(it.trim())
        }
    }
    clickNext()

    at SlaveryFootprintDietPage
    clickNext()

    at SlaveryFootprintToiletriesPage
    def toiletries = []
    data.Toiletries.tokenize(',').each {
        switch (it.trim().toLowerCase()) {
            case 'shaving cream':
                toiletries.add(shavingCream)
                break

            case 'sunscreen':
                toiletries.add(sunscreen)
                break

            case 'moisturiser':
                toiletries.add(moisturizer)
                break

            case 'dental floss':
                toiletries.add(dentalFloss)
                break

            case 'mouthwash':
                toiletries.add(mouthwash)
                break

            case 'toothpaste':
                toiletries.add(toothpaste)
                break

            case 'toothbrush':
                toiletries.add(toothbrush)
                break

            case 'lip gloss':
                toiletries.add(lipGloss)
                break

            case 'mascara':
                toiletries.add(mascara)
                break

            case 'concealer':
                toiletries.add(concealer)
                break

            case 'foundation':
                toiletries.add(foundation)
                break

            case 'bronzer':
                toiletries.add(bronzer)
                break

            case 'eye pencil':
                toiletries.add(eyePencil)
                break

            case 'lip stick':
                toiletries.add(lipStick)
                break

            case 'blush':
                toiletries.add(blush)
                break

            case 'nail polish remover':
                toiletries.add(nailPolishRemover)
                break

            case 'hand wash':
                toiletries.add(handSanitizer)
                break

            case 'soap':
                toiletries.add(soap)
                break

            case 'conditioner':
                toiletries.add(conditioner)
                break

            case 'body wash':
                toiletries.add(bodyWash)
                break

            case 'hairbrush':
                toiletries.add(hairbrush)
                break

            case 'aspirin':
                toiletries.add(aspririn)
                break

            case 'contact lenses':
                toiletries.add(contactLenses)
                break

            case 'womens fragrance':
                toiletries.add(womensFragrance)
                break

            case 'deodorant':
                toiletries.add(deodorant)
                break

            default:
                Assert.fail "Unkown toiletry: ${it}"
        }
    }
    selectToiletries(toiletries)
    clickNext()

    at SlaveryFootprintJewelryPage
    clickNext()

    at SlaveryFootprintElectronicsPage
    switch (data.'Electronics Level') {
        case 'technophobe':
            safeClick(technophobe)
            break

        case 'regular joe':
            safeClick(regularJoe)
            break

        case 'stereophile':
            safeClick(stereophile)
            break

        case 'gamer':
            safeClick(gamer)
            break

        case 'gadget geek':
            safeClick(gadgetGeek)
            break

        default:
            Assert.fail 'Unknown electronics level: ' + data.'Electronics Level'
    }
    clickNext()

    at SlaveryFootprintSportingPage
    data.Sports.tokenize(',').each {
        switch (it.trim()) {
            case 'baseball':
                baseball.click()
                break

            case 'football':
                football.click()
                break

            case 'cycling':
                cycling.click()
                break

            case 'soccer':
                soccer.click()
                break

            case 'skiing':
                skiing.click()
                break

            case 'camping':
                camping.click()
                break

            case 'running':
                running.click()
                break

            case 'snowboarding':
                snowboarding.click()
                break

            case 'golf':
                golf.click()
                break

            case 'snorkelling':
                snorkelling.click()
                break

            case 'surfing':
                surfing.click()
                break

            case 'waterskiing':
                waterskiing.click()
                break

            case 'fishing':
                fishing.click()
                break

            case 'snowwalking':
                snowwalking.click()
                break

            default:
                Assert.fail 'Unknown sport: ' + it.trim()
        }
    }
    clickNext()

    at SlaveryFootprintClosetPage
    clickNext()

    at SlaveryFootprintSexPage
    clickNext()

}

Then(~/my slave count should be (\d+)/) { String expectedSlaveCount ->
    at SlaveryFootprintResultsPage
    assert slaveCount.text() == expectedSlaveCount
}

void addHouseItem(String item) {
    switch (item.toLowerCase()) {
        case 'bedroom':
            addBedroomToHouse()
            break

        case 'bathroom':
            addBathroomToHouse()
            break

        case 'home office':
            addHomeOfficeToHouse()
            break

        case 'car':
            addCarToHouse()
            break

        case 'scooter':
        case 'motorcycle':
            addScooterToHouse()
            break

        default:
            fail "Unknown house item: $item"
    }
}