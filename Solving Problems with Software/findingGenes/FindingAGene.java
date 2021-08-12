
/**
 * Write a description of FindingAGene here.
 * 
 * @Marcin (your name) 
 * @version (a version number or a date)
 */
public class FindingAGene {
    public String findSimpleGene(String dna, String startCodon, String stopCodon) {
        String simpleGene = "";
        dna = dna.toLowerCase();
        startCodon = startCodon.toLowerCase();
        stopCodon = stopCodon.toLowerCase();
        int startIndex = dna.indexOf(startCodon);
        if (startIndex == -1) {
            return "";
        }
        
        int stopIndex = dna.indexOf(stopCodon, startIndex+3);
        if (stopIndex == -1) {
            return "";
        }
        
        if ((stopIndex - startIndex) % 3 == 0) {
            simpleGene = dna.substring(startIndex, stopIndex+3);
        }
        return simpleGene;
    }
    
    public void testSimpleGene() {
        String dna = "ftasdfsdfasrfstasdtaa";
        System.out.println(findSimpleGene(dna,"ATG","TAA"));
        
        dna = "atgrtfdwrddsaft";
        System.out.println(findSimpleGene(dna, "ATG", "TAA"));
        
        dna = "atgsDTAsdedataa";
        System.out.println(findSimpleGene(dna, "ATG", "TAA"));
        
        dna = "atgsdtasedataa";
        System.out.println(findSimpleGene(dna, "ATG", "TAA"));
        
    }
    
    public boolean twoOccurrences (String stringa, String stringb) {
        int stringAIndex = stringb.indexOf(stringa);
        int count = 0;
        
        while (stringAIndex >=0) {
            count++;
            stringAIndex = stringb.indexOf(stringa, stringAIndex + 1);
        }
        return count >= 2;
    }
    
    public String lastPart(String stringa, String stringb) {
        int stringaIndex = stringb.indexOf(stringa);
        if (stringaIndex == -1) {
            return stringb;
        }
        System.out.println(stringaIndex);
        int lastIndex = stringb.length();
        System.out.println(lastIndex);
        String lastPart = stringb.substring(stringaIndex + stringa.length(), lastIndex);
        
        return lastPart;
    }
    
    public void test() {
        String stringa = "f";
        String stringb = "forest";
        System.out.println(lastPart(stringa, stringb));
        
    }
}
