package com.example.form.ServiceImplement;

import com.example.form.Model.BankCredit;
import com.example.form.Repository.BankCreditRepository;
import com.example.form.Service.BankCreditService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BankCreditServiceImplement implements BankCreditService {

    @Autowired
    BankCreditRepository bankCreditRepository;

    @Override
    public List<BankCredit> getAllBankCredit() {
        return new ArrayList<>(bankCreditRepository.findAll());
    }

    @Override
    public BankCredit getBankCreditById(Long id) {
        Optional<BankCredit> bankCredit = bankCreditRepository.findById(id);
        return bankCredit.orElse(null);
    }

    @Override
    public BankCredit addBankCredit(BankCredit bankCredit) {
        return bankCreditRepository.save(bankCredit);
    }

    @Override
    public void updateBankCredit(BankCredit newBankCredit) {
        if (getBankCreditById(newBankCredit.getId()) != null) {
            bankCreditRepository.save(newBankCredit);
        }
    }

    @Override
    public void deleteBankCredit(Long id) {
        if (getBankCreditById(id) != null) {
            bankCreditRepository.deleteById(id);
        }
    }
}
