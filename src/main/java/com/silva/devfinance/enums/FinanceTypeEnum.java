package com.silva.devfinance.enums;

public enum FinanceTypeEnum {
	EXPENSE("Expense"),
	INCOME("Income");
	
	FinanceTypeEnum(String name){
        this.name = name;
    }

    //Attributes
    private String name;


    //Properties
    public String getName(){
       return name;
    }
}
