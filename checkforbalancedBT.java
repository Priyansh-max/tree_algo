public class checkforbalancedBT {

    public int heightoftree(tree root){
        if(root == null){
            return 0;
        }

        int ls = heightoftree(root.left);
        int rs = heightoftree(root.right);

        return 1 + Math.max(ls , rs);
    }

    public boolean helper(tree root){
        if(root == null){
            return true;
        }

        int lh = heightoftree(root.left);
        int rh = heightoftree(root.right);

        if(Math.abs(lh - rh) > 1){
            return false;
        }

        boolean leftsubtree = helper(root.left);
        boolean rightsubtree = helper(root.right);

        return !(!leftsubtree || !rightsubtree);
    }

    public int checkforbalance(tree root){
        if(root == null){
            return 0;
        }

        int lh = checkforbalance(root.left);
        int rh = checkforbalance(root.right);

        if(lh == -1 || rh == -1){
            return -1;
        }

        if(Math.abs(lh - rh) > 1){
            return -1;
        }
        return 1 + Math.max(lh , rh);
    }

    public static void main(String[] args) {
        tree root = new tree(10);
        root.right = new tree(9);
        root.left = new tree(8);
        root.right.right = new tree(7);
        root.right.left = new tree(6);
        root.left.left = new tree(5);
        root.left.right = new tree(4);
        root.left.right.left = new tree(3);

        checkforbalancedBT obj = new checkforbalancedBT();
        boolean ans = obj.helper(root); //this method takes O(N2)

        int final_ans = obj.checkforbalance(root); //this method takes O(N)

        if(final_ans == -1){
            System.out.println("false");
        }
        else{
            System.out.println("true");
        }

    }
    
}
