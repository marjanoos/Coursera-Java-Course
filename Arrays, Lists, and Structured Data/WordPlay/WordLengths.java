
/**
 * Write a description of WordLengths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;

public class WordLengths {
    
    void countWordLengths(FileResource resource, int[] counts) {
        resource = new FileResource("E:/smallHamlet.txt"); //odczytanie pliku
        String alphabet = "abcdefghijklmnoqprstuvxyz";
        for (String word : resource.words()) {
            int worLen = word.length();
            if (worLen>0) {
                if (Character.isLetter(word.charAt(0)) != true && Character.isLetter(word.charAt(worLen-1)) != true) {
                    word = word.substring(1, word.length());
                    counts[word.length()] = counts[word.length()] + 1;
            
                }
                else if (Character.isLetter(word.charAt(0)) != true && Character.isLetter(word.charAt(worLen-1)) == true) {
                    word = word.substring(1);
                    counts[word.length()] = counts[word.length()] + 1;
                }
                else if (Character.isLetter(word.charAt(worLen-1)) != true && Character.isLetter(word.charAt(0)) == true) {
                    word = word.substring(0, word.length()-1);
                    counts[word.length()] = counts[word.length()] + 1;
                }
                else {
                    counts[word.length()] = counts[word.length()] + 1;
                }
            }
        }
        
    }
    
    void testCountWordLengths() {
        FileResource resource = new FileResource();
        int[] tablica = new int[31];
        
        countWordLengths(resource, tablica);
        
        
        for (int k = 0; k < tablica.length; k++) {
            if (tablica[k] > 0) {
            System.out.println(tablica[k] + " words of length " + k);
        }
        }
        
        System.out.println("Most common word length is " + indexOfMax(tablica));
    }
    int indexOfMax(int[] values) {
        int max = 0;
        
        for (int k=0; k<values.length; k++) {
            if (values[k] > max) {
                max = values[k];
            }
        }
        
        return max;
    }
}
