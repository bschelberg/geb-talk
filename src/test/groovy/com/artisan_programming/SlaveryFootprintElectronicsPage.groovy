package com.artisan_programming

class SlaveryFootprintElectronicsPage extends SlaveryFootprintPage {
    static at = { assertQuestionIs('When it comes to electronics, what are you?'); true }
    static content = {
        common { module SlaveryFootprintModule }

        technophobe { $('#technophobe') }
        regularJow { $('#regularjoe') }
        stereophile { $('#stereophile') }
        gamer { $('#gamer') }
        gadgetGeek { $('#gadget_geek') }
    }
}
