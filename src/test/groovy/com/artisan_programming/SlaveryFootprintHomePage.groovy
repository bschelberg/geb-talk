package com.artisan_programming

import geb.Page

class SlaveryFootprintHomePage extends Page {
    static url = "http://slaveryfootprint.org"
    static at = { assert title.contains("Slavery Footprint") }
    static content = {
        takeTheSurvey(to: SlaveryFootprintLocationPage) { $('div#home-menu-findout a') }
    }
}
