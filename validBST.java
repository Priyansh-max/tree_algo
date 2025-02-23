
public class validBST {

    public boolean checkValidBST(tree root , int inrange , int outrange){
        if(root == null){
            return true;
        }

        if(root.data < inrange || root.data > outrange){
            return false;
        }

        boolean leftsubtree = checkValidBST(root.left , inrange , root.data);
        boolean rightsubtree = checkValidBST(root.right, root.data, outrange);

        return leftsubtree && rightsubtree;
    }
    public static void main(String[] args) {
        //is a valid BST
        tree root = new tree(10);
        root.right = new tree(13);
        root.left = new tree(5);
        root.right.right = new tree(14);
        root.right.left = new tree(11);
        root.left.left = new tree(3);
        root.left.left.left = new tree(2);
        root.left.left.right = new tree(4);
        root.left.right = new tree(6);
        root.left.right.right = new tree(9);

        //not a valid BST
        tree root1 = new tree(10);
        root1.right = new tree(9);
        root1.left = new tree(8);
        root1.right.right = new tree(7);
        root1.right.left = new tree(6);
        root1.left.left = new tree(5);
        root1.left.right = new tree(4);
        root1.left.right.left = new tree(3);

        validBST obj = new validBST();
        boolean ans = obj.checkValidBST(root , Integer.MIN_VALUE , Integer.MAX_VALUE);

        boolean ans1 = obj.checkValidBST(root1 , Integer.MIN_VALUE , Integer.MAX_VALUE);


        System.out.println(ans);
        
        System.out.println(ans1);
    }
    
}
