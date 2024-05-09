package Resources.OPERATIONS;

import javax.swing.tree.TreeNode;

public class TreeOperations {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null && targetSum == 0) {
            return false;
        }
        else {
            return hasPathSumRecursive(root, targetSum);
        }

    }
    public boolean hasPathSumRecursive(TreeNode root, int targetSum) {
        if(root == null) {
            return false;
        }
        int valor = targetSum - root.val; //22 - 5 = 17
        if(valor == 0 && root.left == null && root.right == null){
            return true;
        }
        return hasPathSum(root.left, valor) || hasPathSum(root.right, valor);
    }
    //-------------------------------------------------

    public Nodo sortByNumber(Nodo n, int num) { // [6 8 3] , 5
        Nodo current = n; //[6]
        if(current == null || current.next == null) { //lista de 0 y 1 posicion
            return current;
        }
        Nodo head = current;
        Nodo ancla = null; 
        
        while(current != null){
            
            Nodo comprobar = null; //Copia de un solo nodo
            comprobar.data= current.data; // Copia de un solo nodo
            
            if(current.data >= num){
                ancla.next = comprobar; //[]->[6]
            } else {//Siempre menor
                head = comprobar;
                comprobar.next = ancla;
            }
            //[6]->[8]
            current = current.next;
        }
        //volvemos al incio de la lista para recorrerla
        Nodo head_lista = head;
        current = head_lista;
        while(current.next != null) {
           current = current.next;
        }
        current.next = current.next.next;
        
        return head_lista;
    }

    //-------------------------------------------------

}
