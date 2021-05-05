package com.cucumberBaby.Utility;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;


public class CsvOperations {
	
	private CsvOperations() {
		throw new IllegalStateException("Utility class");
	}



	private static final Logger log = (Logger) LogFactory.getLog(CsvOperations.class);
	static String folder = "./resources/data/";
	
	public static Map<String, String> readDataByTest(String file, String scenario) throws IOException 
	{ 
		Map<String, String> data = new LinkedHashMap<>();
        FileReader filereader = null; 
        CSVReader csvReader = null; 
	    try { 
	    	filereader = new FileReader(folder + file + ".csv");
	    	csvReader = new CSVReader(filereader);
	        String[] nextRecord; 
	        String[] headers = null;
	        String[] values = null;
	        //Get Scenario ID to extract data from CSV file.
	        String scenarioId = scenario.split("--")[0];
	        	        
	        //Reading line by line to get Headers and Data from Scenario Id
	        while ((nextRecord = csvReader.readNext()) != null) {
	        	if (csvReader.getLinesRead() == 1){
		            headers = nextRecord;
	        	}else {
	        		if(nextRecord[0].contains(scenarioId)) {
	        			values = nextRecord;
	        			break;
	        		}
	        	}

	        }
	        //Put information in HashMap to return
	        if((headers != null) && (values != null)) {
	        	for (int i=0;i<headers.length;i++) {
					data.put(headers[i], values[i]);
		        }
	        }
	        
	        //Adding row number information
	        data.put("row", String.valueOf(csvReader.getLinesRead()-1));
	        csvReader.close();
	        filereader.close();
	    } 
	    catch (Exception e) { 
	    	log.error(e.getMessage());
	    }
	    return data;
	} 
	
	public static void updateCSV(String file, String replace, int row, int col) throws IOException{
		FileReader filereader = null;
		CSVReader csvReader = null; 
		FileWriter filewriter = null; 
        CSVWriter csvWriter = null; 
		try{
			filereader = new FileReader(folder + file + ".csv");
			csvReader = new CSVReader(filereader); 
			List<String[]> csvBody = csvReader.readAll();
			// get CSV row column  and replace with by using row and column
			csvBody.get(row)[col] = replace;
			csvReader.close();
			filereader.close();

			// Write to CSV file which is open
			filewriter = new FileWriter(folder + file + ".csv"); 
	        csvWriter = new CSVWriter(filewriter); 
			csvWriter.writeAll(csvBody);
			csvWriter.flush();
			csvWriter.close();
			filewriter.flush();
			filewriter.close();
		} 
		catch (Exception e) { 
			log.error(e.getMessage());
	    }

	}
	

}