import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
/**
 * Write a description of parser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class parser {
    public void tester() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        
       // System.out.println(countryInfo(parser, "Nauru"));
        
       // parser = fr.getCSVParser();
       // listExportertsTwoProducts(parser, "cotton", "flowers");
        
       //parser = fr.getCSVParser();
       //System.out.println(numberOfExporters(parser, "cocoa"));
        
       parser = fr.getCSVParser();
       bigExporters(parser, "$999,999,999,999");
    }
    
    
    public String countryInfo(CSVParser parser, String country) {
        for (CSVRecord record : parser) {
            
            String info = record.get("Country");
            String exports = record.get("Exports");
            String value = record.get("Value (dollars)");
            if (info.contains(country)) {
                System.out.println(info + ": " + exports + ": " + value);
           }   
        }
        return "NOT FOUND";
    }
    
    
    public void listExportertsTwoProducts(CSVParser parser, String exportItem1, String exportItem2) {
        for (CSVRecord record : parser) {
            String export = record.get("Exports");
            
            if (export.contains(exportItem1) && export.contains(exportItem2)) {
                String country = record.get("Country");
                System.out.println(country);
            
            }        
        }
    }
    
    public int numberOfExporters(CSVParser parser, String exportItem) {
        int count = 0;        
        for (CSVRecord record : parser) {
            String item = record.get("Exports");
            
            if (item.contains(exportItem)) {
                count++;
            }
        }        
        return count;
    }
    
    public void bigExporters(CSVParser parser, String amount) {
        for (CSVRecord record : parser) {
            String value = record.get("Value (dollars)");
            String country = record.get("Country");
            if (value.length() > amount.length()) {
                System.out.println(country + " " + value);
            }
        }  
    }
    
    public CSVRecord coldestHourInFile(CSVParser parser) {
        CSVRecord coldestTemp = null;
        
        for (CSVRecord record : parser) {
            if (coldestTemp == null) {
                coldestTemp = record;
            }
            else {
                double currentTemp = Double.parseDouble(record.get("TemperatureF"));
                double lowest = Double.parseDouble(coldestTemp.get("TemperatureF"));
                
                if (currentTemp < lowest) {
                coldestTemp = record;             
                }
            }
            
        
        }
    
        return coldestTemp;
    }
    
    public void testColdestHourInFile() {
        FileResource fr = new FileResource();
        CSVRecord lowest = coldestHourInFile(fr.getCSVParser());
        System.out.println(lowest.get("DateUTC") + " " + lowest.get("TemperatureF"));
        
    }
    
    public String fileWithColdestTemperature() {
        DirectoryResource dr = new DirectoryResource();
        CSVRecord lowestTemp = null;
        String lowestFile = null;
            for (File f : dr.selectedFiles()) {                
                FileResource fr = new FileResource(f);
                String currentFile = f.getName();
                //File currDirectory = f.getParentFile();
                //System.out.println(currDirectory);
                //System.out.println(f.getName());
                CSVRecord currentTemp = coldestHourInFile(fr.getCSVParser());
                
                if (lowestTemp == null) {
                    lowestTemp = currentTemp;
                    lowestFile = currentFile;
                }
                else {
                    double currT = Double.parseDouble(currentTemp.get("TemperatureF"));
                    double lowT = Double.parseDouble(lowestTemp.get("TemperatureF"));
                    if (currT < lowT & currT > -99) {
                    lowestTemp = currentTemp;
                    lowestFile = currentFile;
                    }
                }
                
            }
            String resultColdest = "Coldest day in file " + lowestFile;
            
            System.out.println("Coldest temperature on that day was " + lowestTemp.get("TemperatureF"));
            System.out.println("All the Temperatures on the coldest day were: ");
           
            return resultColdest;
    }
    
    public void testFileWithColdestTemperature() {
        System.out.println(fileWithColdestTemperature());
        
    }
    
    public CSVRecord lowestHumidityInFile(CSVParser parser) {
        CSVRecord lowestHum = null;
        
        for (CSVRecord record : parser) {
            if (lowestHum == null) {
                lowestHum = record;
            }
            
            else {
            
                if (record.get("Humidity").equals("N/A")) {
                    lowestHum = lowestHum;
                }
                else {
                double curr = Double.parseDouble(record.get("Humidity"));
                double lowest = Double.parseDouble(lowestHum.get("Humidity"));
                    if (curr < lowest) {
                    lowestHum = record;
                }
            }
            
            }
        
        }
        return lowestHum;
    }
    
    public void testLowestHumidityInFile() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = lowestHumidityInFile(parser);
        
        System.out.println("Lowest Humidity was " + csv.get("Humidity") + " at " + csv.get("DateUTC"));
    }
    
    public CSVRecord lowestHumidityInManyFiles() {
        CSVRecord lowest = null;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord currHum = lowestHumidityInFile(fr.getCSVParser());
            if (lowest == null) {
            lowest = currHum;
            }
            else {
                double curr = Double.parseDouble(currHum.get("Humidity"));
                double low = Double.parseDouble(lowest.get("Humidity"));
                if (low > curr) {
                lowest = currHum;
                }
            }
            
        }
    return lowest;
    }
    
    public void testLowestHumidityInManyFiles() {
        CSVRecord result = lowestHumidityInManyFiles();
        System.out.println("LowestHumidity was " + result.get("Humidity") + " at " + result.get("DateUTC"));
    }
    
    public double averageTemperatureInFile(CSVParser parser) {
        double total = 0.0;
        int tempCount = 0;
        for (CSVRecord record : parser) {
            double currTemp = Double.parseDouble(record.get("TemperatureF"));
            total = total + currTemp;
            tempCount++;
        }
        double average = total / tempCount;
        
    return average;
    }
    
    public void testAverageTemperatureInFile() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        
        System.out.println("Average temperature in file is " + averageTemperatureInFile(parser));
    
    }
    
    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, Integer value) {
        double totalTemp = 0.0;
        int higherThanValue = 0;
        for (CSVRecord record : parser) {
            Integer currHum = Integer.parseInt(record.get("Humidity"));
            double currTemp = Double.parseDouble(record.get("TemperatureF"));
            System.out.println(currTemp);
            if (currHum >= value) {
                totalTemp = totalTemp + currTemp;
                higherThanValue++;
            }
        }
        
        
        if (higherThanValue == 0) {
            System.out.println("Brak");
        }
        
            double average = totalTemp / higherThanValue;
       
        return average;
    }
    
    public void testAverageTemperatureWithHighHumidityInFile() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        System.out.println("Average Temp when high Humidity is " + averageTemperatureWithHighHumidityInFile(parser, 80));
    
    }
}
