
/**
 * Write a description of FindingManyGenes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FindingManyGenes {
    public int findStopCodon(String dna, int startIndex, String stopCodon) {
        int stopIndex = dna.indexOf(stopCodon, startIndex + 3);
        
        while (stopIndex != -1) {
            if ((stopIndex - startIndex) % 3 == 0) {
                return stopIndex;
            }
            else {stopIndex = dna.indexOf(stopCodon, stopIndex + 1);}
        }
        return -1;
    }
    
    public void testFindStopCodon() {
        String startCodon = "ATG";
        String dna = "GAAACCCCAACCTATTTAGACAGCATCATTGGCCGAAGTTGCTGGGCATGTCCACCGTGAAGTCCTCCCCGGGCGTCCCSTCCTTCAAAAGACGATAAGCT";
        int stopCodon = findStopCodon(dna, dna.indexOf(startCodon), "TAA");
        if (stopCodon == dna.length()) {System.out.println("brak stop codonu");}
        
        dna = "ATGSDFAREDSFASDGSTAA";
        stopCodon = findStopCodon(dna, dna.indexOf(startCodon), "TAA");
        if (stopCodon == dna.length()) {System.out.println("brak stop codonu");}
        
        dna = "SDFAREDSFASDGSAA";
        stopCodon = findStopCodon(dna, dna.indexOf(startCodon), "TAA");
        if (stopCodon == dna.length()) {System.out.println("brak stop codonu");}
    }
    
    public String findGene(String dna, int where) {
        int startIndex = dna.indexOf("ATG", where);
        if (startIndex == -1) {
            return "";
        }
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int minIndex = 0;
        if (taaIndex == -1 || (tgaIndex != -1 && tgaIndex < taaIndex)) {
            minIndex = tgaIndex;
        }
        else {minIndex = taaIndex;}
        if (minIndex == -1 || (tagIndex != -1 && tagIndex < minIndex)) {
            minIndex = tagIndex;
        }
        if (minIndex == -1) {
            return "";
        }
        System.out.println(dna.substring(startIndex, minIndex + 3));
        return dna.substring(startIndex, minIndex + 3);
    }
    
   
    public void printAllGenes(String dna) {
        int startIndex = 0;
        while (true) {
            String currentGene = findGene(dna, startIndex);
                if (currentGene.isEmpty()) {
                    break;
                }
            startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
            System.out.println(startIndex);
        }    
    
    }
    
    public int countGenes(String dna) {
        int startIndex = 0;
        int geneCount = 0;
        while (true) {
            String currentGene = findGene(dna, startIndex);
                if (currentGene.isEmpty()) {
                    break;
                }
            geneCount++;
            startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
        }    
        return geneCount;
    }
    
    public void testCountGenes() {
        String dna = "ATAGAGTGCTTTGATATCAGCATGTCTAGCTTTAGAATTCAGTTTAGTGCGCTGATCTGAGTCGAGATAAAATCACCAGTA";
        System.out.println(countGenes(dna));
    
        dna = "ATGTAAATGTAGATGTGA";
        System.out.println(countGenes(dna));
    
        dna = "TAATAA";
        System.out.println(countGenes(dna));
    
        dna = "ATGTAASDATGSDSDSDSDDTAAAATGTAA";
        System.out.println(countGenes(dna));
    
    }
    
    public int howMany(String stringa, String stringb) {
        int currIndex = 0;
        int occNumber = 0;
        while ( true ) {
            int stringaIndex = stringb.indexOf(stringa, currIndex);
            if (stringaIndex == -1) {
                break;
            }
            occNumber++;
            currIndex = stringb.indexOf(stringa, currIndex) + stringa.length();
        
        }
        return occNumber;
    }
    
    public void testHowMany() {
        String stringa = "SD";
        String stringb = "SDFSGAEFDSDASGASDERFDXSD";
        System.out.println(howMany(stringa, stringb));
    
        stringa = "CD";
        stringb = "SDFSGAEFDSDASGASDERFDXSD";
        System.out.println(howMany(stringa, stringb));
    
        stringa = "CD";
        stringb = "CDCDCD";
        System.out.println(howMany(stringa, stringb));
    }
}
