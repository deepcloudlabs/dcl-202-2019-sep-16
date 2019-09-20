package com.example.banking.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.example.banking.entity.Bank;
import com.example.banking.entity.Customer;

/**
  * @author Binnur Kurt <binnur.kurt@gmail.com>
  *
  */
public class ReadBankFromFile {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
			File file = new File("c:/tmp","garanti.dat");
			try(FileInputStream fis = 
					new FileInputStream(file);
			ObjectInputStream ois = 
					new ObjectInputStream(fis);
			){
				Bank garanti = (Bank) ois.readObject();
				System.out.println("Total balance : "
						+ garanti.getTotalBalance());
				for (int i=0;i<garanti.getNumberOfCustomers();++i) {
					Customer customer = garanti.getCustomer(i);
					System.out.println(customer);
				}
			}
	}

}
