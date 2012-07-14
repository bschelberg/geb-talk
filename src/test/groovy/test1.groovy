import geb.Browser

Browser.drive {
    go "http://www.wikipedia.org"

    assert title == "Wikipedia"

    $("form#searchform").with {
        search = "geb"
    }
    $('.searchButton').click()

    assert title.contains('Geb')

    quit()
}
