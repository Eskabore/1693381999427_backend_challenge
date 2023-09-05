package com.linus.finance.challenge.projections;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanViewRepository extends JpaRepository<LoanView, String> {
}