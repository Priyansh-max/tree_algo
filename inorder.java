public class inorder {
    //inorder - Left Root Right
    public void inorderTraversal(tree root){
        if(root == null){
            return;
        }
        inorderTraversal(root.left);
        System.out.println(root.data);
        inorderTraversal(root.right);

        //for preorder
        //root left right

        //for postorder
        //left right root
    }

    public static void main(String[] args) {
        tree root = new tree(10);
        root.right = new tree(9);
        root.left = new tree(8);
        root.right.right = new tree(7);
        root.right.left = new tree(6);
        root.left.left = new tree(5);
        root.left.right = new tree(4);

        inorder obj = new inorder();
        //expected answer -- 5 8 4 10 6 9 7
        obj.inorderTraversal(root);
    }
    
}
