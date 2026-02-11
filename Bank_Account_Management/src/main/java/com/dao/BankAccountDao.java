package com.dao;

import com.entity.BankAccounts;

public interface BankAccountDao {


    void createAccount(BankAccounts account);

    BankAccounts getAccountById(int accountNo);

    void depositAmount(int accountNo, double amount);

    void withdrawAmount(int accountNo, double amount);

    void closeAccount(int accountNo);
}
