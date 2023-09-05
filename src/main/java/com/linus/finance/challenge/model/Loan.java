package com.linus.finance.challenge.model;

import javax.validation.constraints.*;

public class Loan {
        private String id;

        @NotEmpty(message = "Must provide a name")
        private String name;

        @Min(value = 0, message = "Principal should be positive")
        private double principal;

        @Min(value = 0, message = "Interest should be positive")
        private double interest;
    }