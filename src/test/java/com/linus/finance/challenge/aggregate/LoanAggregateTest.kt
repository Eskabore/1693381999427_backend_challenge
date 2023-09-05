package com.linus.finance.challenge.aggregate

import com.linus.finance.challenge.command.CreateLoanCommand
import com.linus.finance.challenge.command.LoanRepaymentCommand
import com.linus.finance.challenge.event.LoanCreatedEvent
import com.linus.finance.challenge.event.LoanRepaymentEvent
import org.axonframework.test.aggregate.AggregateTestFixture
import org.axonframework.test.aggregate.FixtureConfiguration
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LoanAggregateTest {

    private lateinit var fixture: FixtureConfiguration<LoanAggregate>

    @BeforeEach
    fun setUp() {
        fixture = AggregateTestFixture(LoanAggregate::class.java)
    }

    @Test
    fun testLoanCreation() {
        val loanId = "sampleLoanId"
        val initialAmount = 100.0

        fixture.givenNoPriorActivity()
            .`when`(CreateLoanCommand(loanId, initialAmount))
            .expectEvents(LoanCreatedEvent(loanId, initialAmount))
    }

    @Test
    fun testLoanRepaymentWithBothPrincipalAndInterest() {
        val loanId = "sampleLoanId"
        val initialLoanAmount = 110.0
        val principalAmount = 100.0
        val interestAmount = 10.0
        fixture.given(LoanCreatedEvent(loanId, initialLoanAmount))
        .`when`(LoanRepaymentCommand(loanId, principalAmount, interestAmount))
            .expectEvents(LoanRepaymentEvent(loanId, principalAmount, interestAmount))
    }

    @Test
    fun testLoanRepaymentWithZeroPrincipalAndInterest() {
        val loanId = "sampleLoanId"
        val principalAmount = 0.0
        val interestAmount = 0.0
        fixture.givenNoPriorActivity()
            .`when`(LoanRepaymentCommand(loanId, principalAmount, interestAmount))
            .expectNoEvents() // Assuming no events should be triggered for zero repayment
    }

    @Test
    fun testLoanRepaymentWithNegativePrincipal() {
        val loanId = "sampleLoanId"
        val principalAmount = -100.0
        val interestAmount = 10.0
        fixture.givenNoPriorActivity()
            .`when`(LoanRepaymentCommand(loanId, principalAmount, interestAmount))
            .expectException(IllegalArgumentException::class.java) // Assuming an exception is thrown for negative values
    }

    @Test
    fun testLoanRepaymentWithoutLoanId() {
        val loanId = null
        val principalAmount = 100.0
        val interestAmount = 10.0
        fixture.givenNoPriorActivity()
            .`when`(LoanRepaymentCommand(loanId, principalAmount, interestAmount))
            .expectException(IllegalArgumentException::class.java) // Assuming an exception is thrown for null loan ID
    }

}
