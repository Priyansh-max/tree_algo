public class checkforSymmetric {

    public boolean helper(tree node1 , tree node2){
        if (node1 == null && node2 == null) {
            return true; // Both nodes are null, symmetric
        }
        if (node1 == null || node2 == null) {
            return false; // One node is null, asymmetric
        }
        if(node1.data != node2.data){
            return false;
        }

        boolean lh = helper(node1.left , node2.right);
        boolean rh = helper(node1.right , node2.left);

        if(!lh || !rh){
            return false;
        }

        return true;
    }
    public static void main(String[] args) {
        //symmetric tree example
        tree root = new tree(1);
        root.right = new tree(2);
        root.left = new tree(2);
        root.right.right = new tree(3);
        root.left.left = new tree(3);
        

        //asymmetric tree example
        tree root1 = new tree(1);
        root1.right = new tree(2);
        root1.left = new tree(2);
        root1.right.right = new tree(3);
        root1.left.right = new tree(3);

        checkforSymmetric obj = new checkforSymmetric();

        boolean ans1 = obj.helper(root.left, root.right);
        boolean ans2 = obj.helper(root1.left , root1.right);

        System.out.println("Answer for symmetric tree : " + ans1);
        System.out.println("Answer for Asymmetric tree : " + ans2);




    }
    
}
