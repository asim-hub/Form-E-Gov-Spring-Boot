package com.example.form.Repository;

import com.example.form.Model.BankCredit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankCreditRepository extends JpaRepository<BankCredit, Long> {
    // Employees getByUserId(Long userId) throws ChangeSetPersister.NotFoundException;
}
