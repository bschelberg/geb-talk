package com.artisan_programming

import geb.Page

class SlaveryFootprintResultsPage extends Page {
    static at = {
        waitFor(8) { $('#results_map').displayed }
        assert $('#results_map').displayed
        true
    }
    static content = {
        slaveCount { $('h2.slave_header .two') }
    }
}
