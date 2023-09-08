package com.linus.finance.challenge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.linus.finance.challenge.controller.LoanController;

@SpringBootTest
class BackendApplicationTests {

    @Autowired
    private LoanController loanController;

    @Test
    void contextLoads() {
        assertThat(loanController).isNotNull();
    }
}

