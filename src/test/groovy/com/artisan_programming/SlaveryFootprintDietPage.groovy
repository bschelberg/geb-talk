package com.artisan_programming

class SlaveryFootprintDietPage extends SlaveryFootprintPage {
    static at = { assertQuestionIs('What\'s on Your Plate?'); true }
    static content = {
        common { module SlaveryFootprintModule }
    }
}
