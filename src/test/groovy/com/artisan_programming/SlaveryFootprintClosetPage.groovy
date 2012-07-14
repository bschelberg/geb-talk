package com.artisan_programming

class SlaveryFootprintClosetPage extends SlaveryFootprintPage {
    static at = { assertQuestionIs('What\'s in Your Closet?'); true }
    static content = {
        common { module SlaveryFootprintModule }
    }
}
