package com.artisan_programming

class SlaveryFootprintSexPage extends SlaveryFootprintPage {
    static at = { assertQuestionIs('How Many Times Have You Paid for Sex?'); true }
    static content = {
        common { module SlaveryFootprintModule }
    }
}
