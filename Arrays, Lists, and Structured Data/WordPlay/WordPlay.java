
/**
 * Write a description of WordPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordPlay {
    boolean isVowel(char ch) {
        String vowels = "aeiou";
        char lowCase = Character.toLowerCase(ch);
        if (vowels.indexOf(ch) == -1) {
            return false;   
        }
        
        else return true;
    }
    
    void testIsVowel() {
        System.out.println(isVowel('e'));
    
    }
    
    String replaceVowels(String phrase, char ch) {
        String newString = "";
        
        for (int k = 0; k < phrase.length(); k++) {
            if (isVowel(phrase.charAt(k)) == true) {
                newString = newString + ch;
            }
            else newString = newString + phrase.charAt(k);
        }
    return newString;    
    }
    
    void testReplaceVowels() {
    System.out.println(replaceVowels("Cześć, mam na imię Marcin", '*'));
    
    }
    
    String emphasize(String phrase, char ch) {
    String newString = "";
    
        for (int k=0; k<phrase.length(); k++) {
            if (Character.toLowerCase(phrase.charAt(k)) == ch) {
               if (k%2 == 0) {
                   newString = newString + '*';
               }
               else newString = newString + '+';
            }
            else newString = newString + phrase.charAt(k);
        
        }
    
    return newString;
    }
    
    void testEmphasize() {
        System.out.println(emphasize("Mary BellA Abracadabra", 'a'));
    }
}
