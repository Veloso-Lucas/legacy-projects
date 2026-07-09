package com.lvs.project.mscards.repository;

import com.lvs.project.mscards.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card> findBySalaryIncomeLessThanEqual(BigDecimal salaryIncome);
}
