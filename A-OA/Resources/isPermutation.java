package Resources;

import java.util.HashMap;

public class isPermutation {
    public static boolean isPermutation(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }
        HashMap<Character, Integer> diccionario = new HashMap<>();
        for(int i = 0; i < s1.length(); i++) {
            char letra = s1.charAt(i);
            int repeticion_letra = diccionario.getOrDefault(letra, 0);
            diccionario.put(letra, repeticion_letra + 1 );   
            
        }
        for(int i = 0; i < s2.length(); i++){
            char letra = s1.charAt(i);
            int valor = diccionario.getOrDefault(letra, 0);
            if (valor != 0){
                diccionario.put(letra, valor - 1);
            } else {
                return false;
            }
        }
        return true;
        //Time Complexity: O(n) where n is the combined lenght of s1 and s2
        //Space Complexity: O(n) whene n is the number of characters of s1 plus s2
    }

    //-----------------------------------------------------------

    public static boolean isPermutedAndPalindrome(String word) {
        if(word.length() == 1 ) {
            return true;
        }
        HashMap<Character, Integer> diccionario = new HashMap<>();
        for(int i = 0; i < word.length(); i++) {
            char letra = word.charAt(i);
            int repeticion_letra = diccionario.getOrDefault(letra, 0);
            diccionario.put(letra, repeticion_letra + 1 );
            System.out.println(letra + "->" + diccionario.get(letra));//Para comprobar
        }//[r->1,e->2,a->2]
        
        boolean valor_central = false; //Palindromos impares

        for(int i = 0; i < word.length(); i++) {
            char letra = word.charAt(i);
            int valor = diccionario.get(letra); //valor = 3
            if(valor % 2 != 0) {
                if(valor_central) {
                    return false;
                }
                diccionario.put(letra, 0);
                valor_central = true;
            } 
        }
        return true;
        //Time Complexity: O(n) where n is the lengh of word
        //Space Complexity: O(n) where n is the number of characters in word
    }
}
