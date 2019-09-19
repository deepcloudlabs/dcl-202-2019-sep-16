package com.example.banking.service;

import com.example.banking.entity.InsufficientBalanceException;

/**
  * @author Binnur Kurt <binnur.kurt@gmail.com>
  *
  */
public abstract interface TransferService {
      public abstract void transfer(String fromIban,
    		  String toIban,double amount) throws InsufficientBalanceException;
}
