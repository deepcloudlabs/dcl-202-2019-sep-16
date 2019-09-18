package com.example.banking.app;

import com.example.banking.entity.AccountStatus;

/**
  * @author Binnur Kurt <binnur.kurt@gmail.com>
  *
  */
public class StudyEnum {

	public static void main(String[] args) {
		for (AccountStatus status : AccountStatus.values()) {
			System.out.println(status.ordinal()+" : "+status.name());
			System.out.println(status.getCode()+" : "+status.name());
		}

	}

}
