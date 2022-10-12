package com.example.form.Service;

import com.example.form.Model.BankCredit;

import java.util.List;

public interface BankCreditService {
    List<BankCredit> getAllBankCredit();
    BankCredit getBankCreditById(Long id);
    BankCredit addBankCredit(BankCredit bankCredit);
    void updateBankCredit(BankCredit newBankCredit);
    void deleteBankCredit(Long id);
}
