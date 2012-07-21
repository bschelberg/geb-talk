package com.artisan_programming

import geb.Page

class WikipediaPage extends Page {
    static url = 'http://www.wikipedia.org'
    static at = { assert title == 'Wikipedia' }
    static content = {
        searchInput { $('input', name: 'search') }
        searchButton { $('input', name: 'go') }
    }

    void searchFor(String searchTerm) {
        searchInput.value(searchTerm)
        searchButton.click()
    }
}
