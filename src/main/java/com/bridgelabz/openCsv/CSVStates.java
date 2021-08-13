package com.bridgelabz.openCsv;

import com.opencsv.bean.CsvBindByName;

public class CSVStates {
	@CsvBindByName(column = "state name")
	public String stateName;

	@CsvBindByName(column = "state code")
	public String stateCode;
	@CsvBindByName(column = "sr no")
	public int srNo;
	@CsvBindByName(column = "tin")
	public int tin;

	public CSVStates() {
	}

	public CSVStates(String stateName, String stateCode, int srNo, int tin) {
		this.stateName = stateName;
		this.stateCode = stateCode;
		this.srNo = srNo;
		this.tin = tin;
	}
	

}
