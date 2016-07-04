package menu.controller

import spock.lang.Specification

class BeerControllerSpec extends Specification{

    BeerController beerController = new BeerController()

    def 'test read method'(){
        when:
        String name = beerController.read("beer-name")

        then:
        0 * _

        and:
        name == "{\"name\":\"beer-name\"}"
    }

    def 'test list method'(){
        when:
        String result = beerController.list()

        then:
        0 * _

        and:
        result == "list method not implemented yet"
    }
}
