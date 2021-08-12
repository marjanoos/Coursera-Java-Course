
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class CaesarCipher {
    String encrypt(String input, int key) {
        StringBuilder encrypted = new StringBuilder(input);
        
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String encAlph = alphabet.substring(key) + alphabet.substring(0,key);
        String lowAlph = alphabet.toLowerCase();
        String lowEncAlph = encAlph.toLowerCase();
        
        for (int k=0; k<encrypted.length(); k++) {
            char currChar = encrypted.charAt(k);
     
            int position = alphabet.indexOf(currChar);
            int lowPosition = lowAlph.indexOf(currChar);
            if (position != -1) {
                char newChar = encAlph.charAt(position);
                
                encrypted.setCharAt(k, newChar);
            }
            else if (lowPosition != -1) {
            char newChar = lowEncAlph.charAt(lowPosition);
                
            encrypted.setCharAt(k, newChar);
            }
            
            
        }
        String result = encrypted.toString();
        return result;
    }
    
    void testCeasar() {
        FileResource fr = new FileResource();
        String message = fr.asString();
        int key = 15;
        String encrypted = encrypt(message, key);
        System.out.println("key is " + key + "\n" + encrypted);
    }
    
    String encryptTwoKeys(String input, int key1, int key2) {
        StringBuilder encrypted = new StringBuilder(input);
        
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alph1 = alphabet.substring(key1) + alphabet.substring(0,key1);
        String alph2 = alphabet.substring(key2) + alphabet.substring(0,key2);
        String lowAlph = alphabet.toLowerCase();
        String lowEncAlph1 = alph1.toLowerCase();
        String lowEncAlph2 = alph2.toLowerCase();
        
        for (int k=0; k<encrypted.length(); k++) {
            char currChar = encrypted.charAt(k);
     
            int position = alphabet.indexOf(currChar);
            int lowPosition = lowAlph.indexOf(currChar);
            if (position != -1) {
                if (k%2 == 0) {
                    char newChar = alph1.charAt(position);
                
                    encrypted.setCharAt(k, newChar);
                }
                else {
                    char newChar = alph2.charAt(position);
                
                    encrypted.setCharAt(k, newChar);
                }
            }
            
            else if (lowPosition != -1) {
                if (k%2 == 0) {
                    char newChar = lowEncAlph1.charAt(lowPosition);
                
                    encrypted.setCharAt(k, newChar);
                }
                else {
                    char newChar = lowEncAlph2.charAt(lowPosition);
                
                    encrypted.setCharAt(k, newChar);
                }
            }
        }
        String result = encrypted.toString();
        return result;
    }
    void testTwoKeys() {
        System.out.println(encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 8,21));
    
    }
}
