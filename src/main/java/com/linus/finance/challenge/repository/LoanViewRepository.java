package com.linus.finance.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.linus.finance.challenge.projection.LoanView;

import java.util.UUID;

public interface LoanViewRepository extends JpaRepository<LoanView, UUID> {
    // Custom query methods can be added here if needed
}