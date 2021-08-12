/**
 * Print out total number of babies born, as well as for each gender, in a given CSV file of baby name data.
 * 
 * @author Duke Software Team 
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.File;

public class BabyBirths {
    public void printNames () {
        FileResource fr = new FileResource();
        //iterating over the CSV file
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            if (numBorn <= 100) {
                System.out.println("Name " + rec.get(0) +
                           " Gender " + rec.get(1) +
                           " Num Born " + rec.get(2));
            }
        }
    }
    
    
    public void totalBirths (FileResource fr) {
        //initializing boys, girls and total birth counters
        int totalBirths = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        
        //iterating over the CSV file
        for (CSVRecord rec : fr.getCSVParser(false)) {
            //getting the births number
            int numBorn = Integer.parseInt(rec.get(2));
            
            //updating total births number
            totalBirths += numBorn;
            
            //checking the sex, if M then increase boys count, else increase boys count
            if (rec.get(1).equals("M")) {
                totalBoys += numBorn;
            }
            else {
                totalGirls += numBorn;
            }
        }
        System.out.println("total births = " + totalBirths);
        System.out.println("female girls = " + totalGirls);
        System.out.println("male boys = " + totalBoys);
    }
    
    //testing method
    public void testTotalBirths () {
        FileResource fr = new FileResource("data/yob1900.csv");
        totalBirths(fr);
    }
    
    //method checking which rank has specific name of specific gender in specific year
    public int getRank(int year, String name, String gender) {
        //making default path with variable year passed as parameter
        String source = "data/yob"+year+".csv";
        FileResource fr = new FileResource(source);
        int currRank = 1;
        int rank = 1;
        //iterating over the CSV file
        for (CSVRecord record : fr.getCSVParser(false)) {
            
            //checking if current row is the same gender as passed as parameter
            if (record.get(1).equals(gender)) {
                
                //if yes then check if name is the same as passed as parameter
                if (record.get(0).equals(name)) {
                    
                    //if yes then update the rank and break
                    rank = currRank;
                    break;
                }
                else {
                    
                //it means that there's no such name in current year
                rank = -1;
                }
                currRank++;   
            }
            else {
            }
        }
        return rank;   
    }
    
    //testing method
    public void testGetRank() {
    System.out.println(getRank(1960, "Emily", "F"));
    }
    
    public String getName(int year, int rank, String gender) {
        //making default path with variable year passed as parameter
        String source = "data/yob"+year+".csv";
        FileResource fr = new FileResource(source);
        int currRank = 1;
        String name = null;
        int aktualnaPozycja = 1;
        //iterating over the CSV file
        for (CSVRecord record : fr.getCSVParser(false)) {
            
            //checking if current row gender is the same as passed as parameter
            if (record.get(1).equals(gender)) {
                
                //checking if current rank is the same as searched rank, then getting value of "Name" table column
                if (currRank == rank) {
                    name = record.get(0);
                    break;
                }
                else {
                
                //update value if there's no such name in the CSV file
                name = "NO NAME";
                }
                currRank++;
                
            }
            else {
            }
            
        }
        return name;
    }
    
    //testing method
    public void testGetName() {
        System.out.println(getName(1980, 350, "F"));
    }
    
    public void whatIsNameInYear(String name, int year, int newYear, String gender) {
        int rank = getRank(year, name, gender);
        String newName = getName(newYear, rank, gender);
        
        if (gender.equals("F")) {
        System.out.println(name + " born in " + year + " would be " + newName + " if she was born in " + newYear);
        }
        else {
        System.out.println(name + " born in " + year + " would be " + newName + " if he was born in " + newYear);  
        }
    }
    
    public int yearOfHighestRank(String name, String gender) {
        DirectoryResource dr = new DirectoryResource();
        int rank = 999999999;
        int hiYear = -1;
        //iterating in the files
        for (File f : dr.selectedFiles()) {
            int year = Integer.parseInt(f.getName().substring(3,7));
            int currRank = getRank(year, name, gender);
            System.out.println(year + " " + currRank + " Najwyższa ranga: " + rank);
            //checking if current rank is valid number and if is lower than current value
            if (currRank != -1 && currRank < rank) {
                rank = currRank;
                hiYear = year;
            }    
        }
        if (rank == -1) {
            return -1;
        }
        else return hiYear;
    }
    
    public double getAverageRank(String name, String gender) {
        DirectoryResource dr = new DirectoryResource();
        double total = 0.0;
        double totYears = 0;
        for (File f : dr.selectedFiles()) {
            int year = Integer.parseInt(f.getName().substring(3,7));
            int currRank = getRank(year, name, gender);
            if (currRank != -1) {
                double doubCurr = currRank; 
                total = total + doubCurr;
                totYears++;
            }
        }
        double result = total / totYears;
        return result;
    }
    
    public int getTotalBirthsRankedHigher(int year, String name, String gender) {
        String source = "data/yob"+year+".csv";
        int totalBirth = 0;
        int targetRank = getRank(year, name, gender);
        System.out.println("Celowa pozycja " + targetRank);
        FileResource fr = new FileResource(source);
        for (CSVRecord record : fr.getCSVParser(false)) {
            
            
            System.out.println("Celowa pozycja " + targetRank);
            int currBirth = Integer.parseInt(record.get(2));
            System.out.println(currBirth);
            System.out.println("-----------------");
            if (record.get(1).equals(gender)) {
                int currRank = getRank(year, record.get(0), gender);
                while (currRank < targetRank) {
                    totalBirth+=currBirth;
                    System.out.println(currRank);
                    currRank++;
                }
            }
        
        }
        return totalBirth;
    }
    
    public void tester() {
        System.out.println(getTotalBirthsRankedHigher(1990, "Emily", "F"));
    
    }
    
}
