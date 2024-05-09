package Resources;

public class !TreeOperations {
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


}
