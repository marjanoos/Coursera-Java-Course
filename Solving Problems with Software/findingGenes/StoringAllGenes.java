import edu.duke.*;
/**
 * Write a description of StoringAllGenes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StoringAllGenes {
    
    public int findStopCodon(String dna, int startIndex, String stopCodon) {
        startIndex = dna.indexOf("atg", startIndex);
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
        String dna = "acaagtttgtacaaaaaagcagaagggccgtcaaggcccaccatgcctattggatccaaagagaggccaacattttttgaaatttttaagacacgctgcaacaaagcagatttaggaccaataagtcttaattggtttgaagaactttcttcagaagctccaccctataattctgaacctgcagaagaatctgaacataaaaacaacaattacgaaccaaacctatttaaaactccacaaaggaaaccatcttataatcagctggcttcaactccaataatattcaaagagcaagggctgactctgccgctgtaccaatctcctgtaaaagaattagataaattcaaattagacttaggaaggaatgttcccaatagtagacataaaagtcttcgcacagtgaaaactaaaatggatcaagcagatgatgtttcctgtccacttctaaattcttgtcttagtgaaagtcctgttgttctacaatgtacacatgtaacaccacaaagagataagtcagtggtatgtgggagtttgtttcatacaccaaagtttgtgaagggtcgtcagacaccaaaacatatttctgaaagtctaggagctgaggtggatcctgatatgtcttggtcaagttctttagctacaccacccacccttagttctactgtgctcatagtcagaaatgaagaagcatctgaaactgtatttcctcatgatactactgctaatgtgaaaagctatttttccaatcatgatgaaagtctgaagaaaaatgatagatttatcgcttctgtgacagacagtgaaaacacaaatcaaagagaagctgcaagtcatggatttggaaaaacatcagggaattcatttaaagtaaatagctgcaaagaccacattggaaagtcaatgccaaatgtcctagaagatgaagtatatgaaacagttgtagatacctctgaagaagatagtttttcattatgtttttctaaatgtagaacaaaaaatctacaaaaagtaagaactagcaagactaggaaaaaaattttccatgaagcaaacgctgatgaatgtgaaaaatctaaaaaccaagtgaaagaaaaatactcatttgtatctgaagtggaaccaaatgatactgatccattagattcaaatgtagcaaatcagaagccctttgagagtggaagtgacaaaatctccaaggaagttgtaccgtctttggcctgtgaatggtctcaactaaccctttcaggtctaaatggagcccagatggagaaaatacccctattgcatatttcttcatgtgaccaaaatatttcagaaaaagacctattagacacagagaacaaaagaaagaaagattttcttacttcagagaattctttgccacgtatttctagcctaccaaaatcagagaagccattaaatgaggaaacagtggtaaataagagagatgaagagcagcatcttgaatctcatacagactgcattcttgcagtaaagcaggcaatatctggaacttctccagtggcttcttcatttcagggtatcaaaaagtctatattcagaataagagaatcacctaaagagactttcaatgcaagtttttcaggtcatatgactgatccaaactttaaaaaagaaactgaagcctctgaaagtggactggaaatacatactgtttgctcacagaaggaggactccttatgtccaaatttaattgataatggaagctggccagccaccaccacacagaattctgtagctttgaagaatgcaggtttaatatccactttgaaaaagaaaacaaataagtttatttatgctatacatgatgaaacatcttataaaggaaaaaaaataccgaaagaccaaaaatcagaactaattaactgttcagcccagtttgaagcaaatgcttttgaagcaccacttacatttgcaaatgctgattcaggtttattgcattcttctgtgaaaagaagctgttcacagaatgattctgaagaaccaactttgtccttaactagctcttttgggacaattctgaggaaatgttctagaaatgaaacatgttctaataatacagtaatctctcaggatcttgattataaagaagcaaaatgtaataaggaaaaactacagttatttattaccccagaagctgattctctgtcatgcctgcaggaaggacagtgtgaaaatgatccaaaaagcaaaaaagtttcagatataaaagaagaggtcttggctgcagcatgtcacccagtacaacattcaaaagtggaatacagtgatactgactttcaatcccagaaaagtcttttatatgatcatgaaaatgccagcactcttattttaactcctacttccaaggatgttctgtcaaacctagtcatgatttctagaggcaaagaatcatacaaaatgtcagacaagctcaaaggtaacaattatgaatctgatgttgaattaaccaaaaatattcccatggaaaagaatcaagatgtatgtgctttaaatgaaaattataaaaacgttgagctgttgccacctgaaaaatacatgagagtagcatcaccttcaagaaaggtacaattcaaccaaaacacaaatctaagagtaatccaaaaaaatcaagaagaaactacttcaatttcaaaaataactgtcaatccagactctgaagaacttttctcagacaatgagaataattttgtcttccaagtagctaatgaaaggaataatcttgctttaggaaatactaaggaacttcatgaaacagacttgacttgtgtaaacgaacccattttcaagaactctaccatggttttatatggagacacaggtgataaacaagcaacccaagtgtcaattaaaaaagatttggtttatgttcttgcagaggagaacaaaaatagtgtaaagcagcatataaaaatgactctaggtcaagatttaaaatcggacatctccttgaatatagataaaataccagaaaaaaataatgattacatgaacaaatgggcaggactcttaggtccaatttcaaatcacagttttggaggtagcttcagaacagcttcaaataaggaaatcaagctctctgaacataacattaagaagagcaaaatgttcttcaaagatattgaagaacaatatcctactagtttagcttgtgttgaaattgtaaataccttggcattagataatcaaaagaaactgagcaagcctcagtcaattaatactgtatctgcacatttacagagtagtgtagttgtttctgattgtaaaaatagtcatataacccctcagatgttattttccaagcaggattttaattcaaaccataatttaacacctagccaaaaggcagaaattacagaactttctactatattagaagaatcaggaagtcagtttgaatttactcagtttagaaaaccaagctacatattgcagaagagtacatttgaagtgcctgaaaaccagatgactatcttaaagaccacttctgaggaatgcagagatgctgatcttcatgtcataatgaatgccccatcgattggtcaggtagacagcagcaagcaatttgaaggtacagttgaaattaaacggaagtttgctggcctgttgaaaaatgactgtaacaaaagtgcttctggttatttaacagatgaaaatgaagtggggtttaggggcttttattctgctcatggcacaaaactgaatgtttctactgaagctctgcaaaaagctgtgaaactgtttagtgatattgagaatattagtgaggaaacttctgcagaggtacatccaataagtttatcttcaagtaaatgtcatgattctgttgtttcaatgtttaagatagaaaatcataatgataaaactgtaagtgaaaaaaataataaatgccaactgatattacaaaataatattgaaatgactactggcacttttgttgaagaaattactgaaaattacaagagaaatactgaaaatgaagataacaaatatactgctgccagtagaaattctcataacttagaatttgatggcagtgattcaagtaaaaatgatactgtttgtattcataaagatgaaacggacttgctatttactgatcagcacaacatatgtcttaaattatctggccagtttatgaaggagggaaacactcagattaaagaagatttgtcagatttaacttttttggaagttgcgaaagctcaagaagcatgtcatggtaatacttcaaataaagaacagttaactgctactaaaacggagcaaaatataaaagattttgagacttctgatacattttttcagactgcaagtgggaaaaatattagtgtcgccaaagagtcatttaataaaattgtaaatttctttgatcagaaaccagaagaattgcataacttttccttaaattctgaattacattctgacataagaaagaacaaaatggacattctaagttatgaggaaacagacatagttaaacacaaaatactgaaagaaagtgtcccagttggtactggaaatcaactagtgaccttccagggacaacccgaacgtgatgaaaagatcaaagaacctactctattgggttttcatacagctagcgggaaaaaagttaaaattgcaaaggaatctttggacaaagtgaaaaacctttttgatgaaaaagagcaaggtactagtgaaatcaccagttttagccatcaatgggcaaagaccctaaagtacagagaggcctgtaaagaccttgaattagcatgtgagaccattgagatcacagctgccccaaagtgtaaagaaatgcagaattctctcaataatgataaaaaccttgtttctattgagactgtggtgccacctaagctcttaagtgataatttatgtagacaaactgaaaatctcaaaacatcaaaaagtatctttttgaaagttaaagtacatgaaaatgtagaaaaagaaacagcaaaaagtcctgcaacttgttacacaaatcagtccccttattcagtcattgaaaattcagccttagctttttacacaagttgtagtagaaaaacttctgtgagtcagacttcattacttgaagcaaaaaaatggcttagagaaggaatatttgatggtcaaccagaaagaataaatactgcagattatgtaggaaattatttgtatgaaaataattcaaacagtactatagctgaaaatgacaaaaatcatctctccgaaaaacaagatacttatttaagtaacagtagcatgtctaacagctattcctaccattctgatgaggtatataatgattcaggatatctctcaaaaaataaacttgattctggtattgagccagtattgaagaatgttgaagatcaaaaaaacactagtttttccaaagtaatatccaatgtaaaagatgcaaatgcatacccacaaactgtaaatgaagatatttgcgttgaggaacttgtgactagctcttcaccctgcaaaaataaaaatgcagccattaaattgtccatatctaatagtaataattttgaggtagggccacctgcatttaggatagccagtggtaaaatcgtttgtgtttcacatgaaacaattaaaaaagtgaaagacatatttacagacagtttcagtaaagtaattaaggaaaacaacgagaataaatcaaaaatttgccaaacgaaaattatggcaggttgttacgaggcattggatgattcagaggatattcttcataactctctagataatgatgaatgtagcacgcattcacataaggtttttgctgacattcagagtgaagaaattttacaacataaccaaaatatgtctggattggagaaagtttctaaaatatcaccttgtgatgttagtttggaaacttcagatatatgtaaatgtagtatagggaagcttcataagtcagtctcatctgcaaatacttgtgggatttttagcacagcaagtggaaaatctgtccaggtatcagatgcttcattacaaaacgcaagacaagtgttttctgaaatagaagatagtaccaagcaagtcttttccaaagtattgtttaaaagtaacgaacattcagaccagctcacaagagaagaaaatactgctatacgtactccagaacatttaatatcccaaaaaggcttttcatataatgtggtaaattcatctgctttctctggatttagtacagcaagtggaaagcaagtttccattttagaaagttccttacacaaagttaagggagtgttagaggaatttgatttaatcagaactgagcatagtcttcactattcacctacgtctagacaaaatgtatcaaaaatacttcctcgtgttgataagagaaacccagagcactgtgtaaactcagaaatggaaaaaacctgcagtaaagaatttaaattatcaaataacttaaatgttgaaggtggttcttcagaaaataatcactctattaaagtttctccatatctctctcaatttcaacaagacaaacaacagttggtattaggaaccaaagtgtcacttgttgagaacattcatgttttgggaaaagaacaggcttcacctaaaaacgtaaaaatggaaattggtaaaactgaaactttttctgatgttcctgtgaaaacaaatatagaagtttgttctacttactccaaagattcagaaaactactttgaaacagaagcagtagaaattgctaaagcttttatggaagatgatgaactgacagattctaaactgccaagtcatgccacacattctctttttacatgtcccgaaaatgaggaaatggttttgtcaaattcaagaattggaaaaagaagaggagagccccttatcttagtgggagaaccctcaatcaaaagaaacttattaaatgaatttgacaggataatagaaaatcaagaaaaatccttaaaggcttcaaaaagcactccagatggcacaataaaagatcgaagattgtttatgcatcatgtttctttagagccgattacctgtgtaccctttcgcacaactaaggaacgtcaagagatacagaatccaaattttaccgcacctggtcaagaatttctgtctaaatctcatttgtatgaacatctgactttggaaaaatcttcaagcaatttagcagtttcaggacatccattttatcaagtttctgctacaagaaatgaaaaaatgagacacttgattactacaggcagaccaaccaaagtctttgttccaccttttaaaactaaatcacattttcacagagttgaacagtgtgttaggaatattaacttggaggaaaacagacaaaagcaaaacattgatggacatggctctgatgatagtaaaaataagattaatgacaatgagattcatcagtttaacaaaaacaactccaatcaagcagcagctgtaactttcacaaagtgtgaagaagaacctttagatttaattacaagtcttcagaatgccagagatatacaggatatgcgaattaagaagaaacaaaggcaacgcgtctttccacagccaggcagtctgtatcttgcaaaaacatccactctgcctcgaatctctctgaaagcagcagtaggaggccaagttccctctgcgtgttctcataaacagctgtatacgtatggcgtttctaaacattgcataaaaattaacagcaaaaatgcagagtcttttcagtttcacactgaagattattttggtaaggaaagtttatggactggaaaaggaatacagttggctgatggtggatggctcataccctccaatgatggaaaggctggaaaagaagaattttatagggctctgtgtgacactccaggtgtggatccaaagcttatttctagaatttgggtttataatcactatagatggatcatatggaaactggcagctatggaatgtgcctttcctaaggaatttgctaatagatgcctaagcccagaaagggtgcttcttcaactaaaatacagatatgatacggaaattgatagaagcagaagatcggctataaaaaagataatggaaagggatgacacagctgcaaaaacacttgttctctgtgtttctgacataatttcattgagcgcaaatatatctgaaacttctagcaataaaactagtagtgcagatacccaaaaagtggccattattgaacttacagatgggtggtatgctgttaaggcccagttagatcctcccctcttagctgtcttaaagaatggcagactgacagttggtcagaagattattcttcatggagcagaactggtgggctctcctgatgcctgtacacctcttgaagccccagaatctcttatgttaaagatttctgctaacagtactcggcctgctcgctggtataccaaacttggattctttcctgaccctagaccttttcctctgcccttatcatcgcttttcagtgatggaggaaatgttggttgtgttgatgtaattattcaaagagcataccctatacagtggatggagaagacatcatctggattatacatatttcgcaatgaaagagaggaagaaaaggaagcagcaaaatatgtggaggcccaacaaaagagactagaagccttattcactaaaattcaggaggaatttgaagaacatgaagaaaacacaacaaaaccatatttaccatcacgtgcactaacaagacagcaagttcgtgctttgcaagatggtgcagagctttatgaagcagtgaagaatgcagcagacccagcttaccttgagggttatttcagtgaagagcagttaagagccttgaataatcacaggcaaatgttgaatgataagaaacaagctcagatccagttggaaattaggaaggccatggaatctgctgaacaaaaggaacaaggtttatcaagggatgtcacaaccgtgtggaagttgcgtattgtaagctattcaaaaaaagaaaaagattcagttatactgagtatttggcgtccatcatcagatttatattctctgttaacagaaggaaagagatacagaatttatcatcttgcaacttcaaaatctaaaagtaaatctgaaagagctaacatacagttagcagcgacaaaaaaaactcagtatcaacaactaccggtttcagatgaaattttatttcagatttaccagccacgggagccccttcacttcagcaaatttttagatccagactttcagccatcttgttctgaggtggacctaataggatttgtcgtttctgttgtgaaaaaaacaggacttgcccctttcgtctatttgtcagacgaatgttacaatttactggcaataaagttttggatagaccttaatgaggacattattaagcctcatatgttaattgctgcaagcaacctccagtggcgaccagaatccaaatcaggccttcttactttatttgctggagatttttctgtgttttctgctagtccaaaagagggccactttcaagagacattcaacaaaatgaaaaatactgttgagaatattgacatactttgcaatgaagcagaaaacaagcttatgcatatactgcatgcaaatgatcccaagtggtccaccccaactaaagactgtacttcagggccgtacactgctcaaatcattcctggtacaggaaacaagcttctgatgtcttctcctaattgtgagatatattatcaaagtcctttatcactttgtatggccaaaaggaagtctgtttccacacctgtctcagcccagatgacttcaaagtcttgtaaaggggagaaagagattgatgaccaaaagaactgcaaaaagagaagagccttggatttcttgagtagactgcctttacctccacctgttagtcccatttgtacatttgtttctccggctgcacagaaggcatttcagccaccaaggagttgtggcaccaaatacgaaacacccataaagaaaaaagaactgaattctcctcagatgactccatttaaaaaattcaatgaaatttctcttttggaaagtaattcaatagctgacgaagaacttgcattgataaatacccaagctcttttgtctggttcaacaggagaaaaacaatttatatctgtcagtgaatccactaggactgctcccaccagttcagaagattatctcagactgaaacgacgttgtactacatctctgatcaaagaacaggagagttcccaggccagtacggaagaatgtgagaaaaataagcaggacacaattacaactaaaaaatatatctagggcctcatgggcccagctttcttgtacaaagtggt";
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
        int startIndex = dna.indexOf("atg", where);
        if (startIndex == -1) {
            return "";
        }
        int taaIndex = findStopCodon(dna, startIndex, "taa");
        int tgaIndex = findStopCodon(dna, startIndex, "tga");
        int tagIndex = findStopCodon(dna, startIndex, "tag");
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
        }
    }
    
    public StorageResource getAllGenes(String dna) {
        StorageResource genes = new StorageResource();
        
        int startIndex = 0;
        while (true) {
            String currentGene = findGene(dna, startIndex);
                if (currentGene.isEmpty()) {
                    break;
                }
            genes.add(currentGene);
            startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
        }    
        return genes;
    }
    
    public void testAllGenes(String dna) {
        StorageResource genes = getAllGenes(dna);
        for (String gene: genes.data()) {
            System.out.println(gene); 
        }
    }
    
    //Write the method cgRatio that has one String parameter dna, 
    //and returns the ratio of C’s and G’s in dna as a fraction of the entire strand of DNA. 
    //For example if the String were “ATGCCATAG,” then cgRatio would return 4/9 or .4444444.
    public double cgRatio(String dna) {
        int cCount = 0;
        int gCount = 0;
        int currCIndex = 0;
        int currGIndex = 0;
        int startIndex = 0;
        while ( true ) {
            currGIndex = dna.indexOf("g", startIndex);
            if (currGIndex == -1) {
                break;
            }
            gCount++;
            startIndex = currGIndex + 1;
        }
        
        startIndex = 0;
        while ( true ) {
            currCIndex = dna.indexOf("c", startIndex);
            if (currCIndex == -1) {
                break;
            }
            cCount++;
            startIndex = currCIndex + 1;
        }
        
        double liczba = dna.length();
        double ratio = (gCount+cCount)/liczba;
        return ratio;    
    }
    
    public int countCTG(String dna) {
        int startIndex = 0;
        int ctgCount = 0;
        while (dna.indexOf("ctg", startIndex) != -1) {
            int currIndex = dna.indexOf("ctg", startIndex);
            ctgCount++;
            startIndex = currIndex + 3;
        }
        return ctgCount;
    }
    
    public void processGenes(StorageResource sr) {
        int geneCount = 0;
        int ratioCount = 0;
        int currLength = 0;
        double ratio = 0.0;
        for (String gene: sr.data()) {
            if (gene.length() > 60) {
                geneCount++;
            }
            System.out.println(cgRatio(gene));
            if (cgRatio(gene) > 0.35) {
                System.out.println(gene);
                ratioCount++;
            }
            
            if (gene.length() > currLength) {
                currLength = gene.length();
            }
        }
        System.out.println("Number of strings longer than 59 characters: " + geneCount);
        System.out.println("Number of strings whose C-G-ratio is higher than 0.35: " + ratioCount);
        System.out.println("Longest gene is " + currLength);
    }
    
    public void testProcessGenes() {
        FileResource fr = new FileResource();
        String dna = fr.asString();
        
        System.out.println("liczba stringów: " + getAllGenes(dna).size());
        processGenes(getAllGenes(dna));
        
        System.out.println(countCTG(dna));
    }
}
