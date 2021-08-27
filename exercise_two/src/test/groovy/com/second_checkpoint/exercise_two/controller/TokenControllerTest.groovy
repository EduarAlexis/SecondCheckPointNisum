package com.second_checkpoint.exercise_two.controller

import com.second_checkpoint.exercise_two.constant.Constants
import com.second_checkpoint.exercise_two.dto.jwt.JwtUser
import com.second_checkpoint.exercise_two.dto.jwt.Login
import com.second_checkpoint.exercise_two.security.JwtGenerator
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import spock.lang.Specification

class TokenControllerTest extends Specification {

    private TokenController tokenController
    private JwtGenerator jwtGenerator = Stub()

    def setup() {
        tokenController = new TokenController()
        tokenController.jwtGenerator = jwtGenerator
    }

    def "Should generate an authorization"(){
        given: ""
        Login login = new Login(Constants.USER, Constants.PASSWORD)
        JwtUser jwtUser = new JwtUser()
        jwtUser.setUserName(Constants.USER)
        jwtUser.setRole(Constants.PASSWORD)
        jwtUser.setRole(Constants.USER_ROLE)

        jwtGenerator.generate(jwtUser) >>> "laksndkajsndk3i2y894y2394h3nifsbdnikbds"

        when: "Function execute"
        ResponseEntity<List<String>> result = tokenController.generate(login)

        then: "Result test"
        result.getStatusCode() == HttpStatus.OK
    }

    def "Should generate an unauthorization"(){
        given: ""
        Login login = new Login("checkpoitn2", "CHECKPOINT2")
        JwtUser jwtUser = new JwtUser()

        when: "Function execute"
        ResponseEntity<List<String>> result = tokenController.generate(login)

        then: "Result test"
        result.getStatusCode() == HttpStatus.UNAUTHORIZED
    }
}
