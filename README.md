geb-talk
========

Code used in presentation to MelbJVM group: Cucumber Testing with Groovy and Geb

To try out the Groovy / Geb examples:
Run src/test/groovy/test1.groovy or src/test/groovy/test2.groovy

To run the cucumbers:
mvn test
or
mvn test -DtagArg="@wikipedia"
mvn test -DtagArg="@slavery_footprint"

I don't control the websites used in the examples, so they are subject to change without warning, and the tests may break. Consider troubleshooting errors as a good way to get to know Geb really well! :)