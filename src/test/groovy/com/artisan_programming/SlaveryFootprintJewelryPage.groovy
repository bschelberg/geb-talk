package com.artisan_programming

class SlaveryFootprintJewelryPage extends SlaveryFootprintPage {
    static at = { assertQuestionIs('How Much Jewelry Do You Own?'); true }
    static content = {
        common { module SlaveryFootprintModule }
    }
}
