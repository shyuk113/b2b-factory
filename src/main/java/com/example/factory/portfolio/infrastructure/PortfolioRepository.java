package com.example.factory.portfolio.infrastructure;

import com.example.factory.portfolio.domain.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
}
