package Resources;

import java.util.HashMap;

public class !IntegerOperations {

    public int romanToInt(String s) {// Ej: III
        s = s + "0";
        HashMap<Character, Integer> diccionario = new HashMap<>();
        diccionario.put('I', 1);  
        diccionario.put('V', 5);
        diccionario.put('X', 10);
        diccionario.put('L', 50);
        diccionario.put('C', 100);
        diccionario.put('D', 500);
        diccionario.put('M', 1000);
        int resultado = 0 ;
        
        for(int i = 0; i < s.length() - 1; i++) {
            char letra = s.charAt(i);  // letra = I
            char letra_siguiente = s.charAt(i+1); //letra_siguiente = I
            int valor_letra = diccionario.get(letra); //valor_letra = 1
            int valor_letra_siguiente = diccionario.getOrDefault(letra_siguiente,0); //valor_letra_siguiente = 1
            if(valor_letra < valor_letra_siguiente) {
                resultado -= valor_letra; 
            }else {
                resultado += valor_letra;
            }
            //resultado = 0 -> 1
        }
        return resultado;   
    }

    //-------------------------------------------------------------------------------
    
    public static int hammingWeight(int n) {
        String palabra = Integer.toBinaryString(n);
        System.out.println("->"+palabra);
        int resultado = 0;
        for(int i = 0; i < palabra.length(); i++) {
            if(palabra.charAt(i) == '1'){
            resultado ++;
            }
        }
        return resultado;
    }

    //-------------------------------------------------------------------------------
   
    public int subtractProductAndSum(int n) {
        if(n == 0){
            return n;
        }
        String palabra = Integer.toString(n);
        int product_of_digit = 1;//1*num=num
        int sum_of_digit = 0; //0+num=num
        for(int i = 0; i < palabra.length(); i++){
            int valor_caracter = Character.getNumericValue(palabra.charAt(i));
            product_of_digit = product_of_digit * valor_caracter;
            sum_of_digit = sum_of_digit + valor_caracter;
        }
        return product_of_digit - sum_of_digit;
    }

    //-------------------------------------------------------------------------------
   

}
