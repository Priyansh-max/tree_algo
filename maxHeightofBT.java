public class maxHeightofBT {

    public int helper(tree root){
        if(root == null){
            return 0;
        }

        int leftsubtree = helper(root.left);
        int rightsubtree = helper(root.right);

        return 1 + Math.max(leftsubtree , rightsubtree);
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

        //expected answer --- 4;

        maxHeightofBT obj = new maxHeightofBT();
        int ans = obj.helper(root);

        System.out.println("Max Height of binary tree is -- " + ans);

    }
    
}
