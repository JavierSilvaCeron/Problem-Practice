package Resources.OPERATIONS;

public class matrixOperations {

    //Dado un 0 en una matriz convierte en otra (copia de la primera) toda la fila y columna adyacentes a 0
    private static int[][] ceroMatrix(int[][] array) {
        //Creamos nuevos arrays con el tamanno de la matriz dada
        boolean[] new_array_columnas = new boolean[array[0].length]; //creamos la array vacia
        boolean[] new_array_filas = new boolean[array.length]; //creamos la array vacia
        
        //Recorremos matriz y asignamos F->T en arrays si encontramos 0s en la matriz
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[0].length; j++) {
                if(array[i][j] == 0){ //array[filas][columnas]
                    new_array_columnas[j] = true;
                    new_array_filas[i] = true;
                }
            }
        }
        for(int i = 0; i < new_array_filas.length; i++) {
            if(new_array_filas[i] == true) {
                turnRowArray0(array, i);
            }
        }
        for(int i = 0; i < new_array_columnas.length; i++) {//En otro for por si la matriz no es cuadrada
            if(new_array_columnas[i] == true) {
                turnColumnArray0(array, i);
            }
        }
        
        return array;
    }

    private static void turnColumnArray0(int[][] array, int column){ //2
        for(int i = 0; i < array.length; i++){
            array[i][column] = 0;
        } 
    }
    private static void turnRowArray0(int[][] array, int row){
        for(int j = 0; j < array.length; j++){
            array[row][j] = 0;
        } 
    }

    //----------------------------------------------------------------------

    private static void printArray(int[][] array){
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[0].length ;j++){ 
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    //----------------------------------------------------------------------

    private static boolean rotateMatrix90(int[][] matrix) {
        //   ( 1 | 2 | 3 ) 
        //   ( 4 | 5 | 6 ) 
        //   ( 7 | 8 | 9 )
        int n = matrix.length;
        if(n < 1){
            return false;
        }
        
        for(int layer = 0; layer < n / 2; layer++) {
            int first = layer; //Donde empieza el primer valor
            int last = n - 1 - layer;
            for(int i = first; i < last; i++) {
                int off_set = i - first;
                int aux = matrix[first][i];
                matrix[first][i] = matrix[last - off_set][first];
                matrix[last - off_set][first] = matrix[last][last - off_set];
                
                matrix[last][last - off_set] = matrix[i][last];
                matrix[i][last] = aux;

            }
        }
        //printMatrix(matrix);
        return true;
    }


}
