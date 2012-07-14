import com.artisan_programming.WikipediaPage

this.metaClass.mixin(cucumber.runtime.groovy.Hooks)
this.metaClass.mixin(cucumber.runtime.groovy.EN)
this.metaClass.mixin(geb.Browser)

Given(~'a User is at the Wikipedia home page') { ->
    to WikipediaPage
    at WikipediaPage
}

When(~'the User searches for "([^"]+)"') { String searchTerm ->
    searchFor(searchTerm)
}

Then(~'the User should see an article about "([^"]+)"') { String expectedTitle ->
    assert title.contains(expectedTitle)
}
