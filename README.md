# backend-challenge

The main goal of this challenge is to understand how you build software.
Take your time to read the challenge, understand the requirements and then start building it when you feel ready.

## Background

Our platform lends Loans to `Real Estate Developers` much faster and more efficiently than most of our competitors.
We then help our customers (`Investors`) to invest their money into these loans.

## Challenge

We expect you to build an event sourced CQRS application using axon. It is alright to keep both the Command & Query on the same app.
There are a couple of challenges as described below:

1. Understand AXON [HELP.MD](HELP.md) if you are not familiar with it already.

2. Create a REST Endpoint to trigger an `AXON Command`.
   1. Via this endpoint, trigger a `Loan Repayment` command. Repayments can happen using
      1. An interest portion only.
      2. A principal portion only.
      3. Both principal and interest portions.
   2. This `Loan Repayment` command should further result in Investor repayments
      1. The repaid amount (principal / interest / principal + interest) should be spread to all the Investors who originally invested in that Loan.

3. Create `AXON Query Projection` REST Endpoint(s).
   1. Create an endpoint to fetch Loans Repayments by Loan Id.
   2. Create an endpoint to fetch Investor Repayments by Investor Name.

### Assumptions:

1. Any number of Investors can invest to a single Loan.
2. An Investor can invest in any number of Loans.
3. An Investor invested to a Loan can have different interest rate than another Investor.

**Sample Models:**

A Loan Model can be as simple as 
```
Loan
(
  id,
  name,
  principal,
  interest   
)
```

An Investor Model can be as simple as
```
Investor
(
   id,
   name,
   amountInvested,
   interest,
   loanId
)
```

## Expectations

1. Source code should be in Kotlin/Java.
2. Should run in an Isolated environment (eg: Docker-compose).
3. Relevant Documentation on how to run the application.
4. Valid Tests covering for all the Scenarios.
5. Validations on API models.
6. Proper Command and Event Models.
7. Structured Commit History.
8. Efficient Database Indexing if needed.

Above all, Readable and maintainable code.

## Submission

Please create a branch and create a Pull Request once your solution is in place.
Sent out an email to: `engineering@linus-finance.com`. Please mention the respective **branch name** and **your github user name**.



