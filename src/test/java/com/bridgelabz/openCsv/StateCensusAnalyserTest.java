package com.bridgelabz.openCsv;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.bridgelabz.openCsv.CensusAnalyserException.CensusExceptionType;

public class StateCensusAnalyserTest {
	StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();

	public static final String CENSUS_CSV_FILE = "C:/Users/RAHUL DESHPANDE/eclipse-workspace/censusanalysis/src/esources/IndianStateCensus.csv";
	public static final String INCORRECT_FILE = "C:/Users/RAHUL DESHPANDE/eclipse-workspace/censusanalysis/src/esources/Contacts.txt";
	public static final String INCORRECT_CSV_FILE = "C:/Users/RAHUL DESHPANDE/eclipse-workspace/censusanalysis/src/esources/Contacts.csv";
	public static final String WRONGDELIMITER_CENSUS_CSV = "C:/Users/RAHUL DESHPANDE/eclipse-workspace/censusanalysis/src/esources/stateCensusDelimiter.csv";
	public static final String INCORRECT_HEADER_CSV = "C:/Users/RAHUL DESHPANDE/eclipse-workspace/censusanalysis/src/esources/stateCensusDelimiter.csv";


	@Test
	public void givenIndiaCensusDataCsvShouldReturnExactCount() throws CensusAnalyserException {
		int numberOfEntries = stateCensusAnalyser.loadStateCensusData(CENSUS_CSV_FILE);
		Assert.assertEquals(29, numberOfEntries);


	}

	@Test
	public void GivenTheStateCensusCsvFile_IfDoesntExist_ShouldThrowCensusAnalyserException() throws IOException {
		try {
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			stateCensusAnalyser.loadStateCensusData(INCORRECT_FILE);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusExceptionType.CENSUS_FILE_PROBLEM, e.exceptionType);
		}
	}

	@Test
	public void givenWrongTypeCSVFile_ShouldThrowExceptionOfType_IncorrectTypeOfCSV() {
		try {
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			stateCensusAnalyser.loadStateCensusData(INCORRECT_CSV_FILE);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusExceptionType.INCORRECT_TYPE_ISSUE, e.exceptionType);
		}
	}

	@Test
	public void givenCsvFile_IFDelimiterIsWrong_ShouldThrowExceptionOfDelimiterISSUE() {
		try {
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			stateCensusAnalyser.loadStateCensusData(WRONGDELIMITER_CENSUS_CSV);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusExceptionType.DELIMITER_ISSUE, e.exceptionType);
		}
	}

	@Test
	public void givenCsvFile_WrongHeaderShouldThrowExceptionOfTypeIncorrectHeader() {
		try {
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			stateCensusAnalyser.loadStateCensusData(INCORRECT_HEADER_CSV);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusExceptionType.INCORRECT_HEADER, e.exceptionType);
		}
	}

	@Test
	public void givenIndiaStateCodeDataCsv_ShouldReturnExactCount() {
		try {
			int numberOfEntries = stateCensusAnalyser.loadIndianStateData(STATE_CSV_FILE);
			Assert.assertEquals(37, numberOfEntries);
		} catch (CensusAnalyserException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void GivenTheStateCsvFile_IfDoesntExist_ShouldThrowCensusAnalyserException() throws IOException {
		try {
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			stateCensusAnalyser.loadIndianStateData(INCORRECTSTATE_FILE);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusExceptionType.CENSUS_FILE_PROBLEM, e.exceptionType);
		}
	}

	@Test
	public void givenStateWrongTypeCSVFile_ShouldThrowExceptionOfType_IncorrectTypeOfCSV() {
		try {
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			stateCensusAnalyser.loadIndianStateData(INCORRECTSTATE_CSV_FILE);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusExceptionType.INCORRECT_TYPE_ISSUE, e.exceptionType);
		}
	}

	@Test
	public void givenStateCsvFile_IFDelimiterIsWrong_ShouldThrowExceptionOfDelimiterISSUE() {
		try {
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			stateCensusAnalyser.loadIndianStateData(WRONGDELIMITERSTATE_CENSUS_CSV);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusExceptionType.DELIMITER_ISSUE, e.exceptionType);
		}
	}

	@Test
	public void givenStateCsvFile_WrongHeaderShouldThrowExceptionOfTypeIncorrectHeader() {
		try {
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			stateCensusAnalyser.loadIndianStateData(INCORRECTSTATE_HEADER_CSV);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusExceptionType.INCORRECT_HEADER, e.exceptionType);
		}
	}
}