package com.example.banking.service;

/**
  * @author Binnur Kurt <binnur.kurt@gmail.com>
  *
  */
public abstract interface TransferService {
      public abstract boolean transfer(String fromIban,
    		  String toIban,double amount);
}
