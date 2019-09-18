package com.example.animals.domain;

/**
  * @author Binnur Kurt <binnur.kurt@gmail.com>
  *
  */
public abstract class Animal {
	protected int legs;

	public Animal(int legs) {
		this.legs = legs;
	}

	public int getLegs() {
		return legs;
	}
    public void walk() {
    	System.out.println("Animal with "
               + legs 
               + " legs is walking now...");
    }

	abstract public void eat();
}







