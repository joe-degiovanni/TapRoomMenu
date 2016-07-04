package menu.controller

import org.springframework.http.RequestEntity
import spock.lang.Specification

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletRequestWrapper

class DataEntryControllerSpec extends Specification {

    DataEntryController dataEntryController = new DataEntryController()

    def 'test acceptData'(){
        given:
        HttpServletRequest request = Mock()
        RequestEntity body = Mock()

        when:
        String result = dataEntryController.acceptData(request, body)

        then:
        0 * _

        and:
        result == "whoops"
    }
}