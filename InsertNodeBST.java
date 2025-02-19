public class InsertNodeBST {

    public tree helper(tree root , int insertNode){
        while(root != null){
            if(root.left == null && root.right == null){
                if(root.data > insertNode){
                    root.left = new tree(insertNode);
                }
                else{
                    root.right = new tree(insertNode);
                }
            }
            if(root.data > insertNode){
                root = root.left;
            }
            if(root.data < insertNode){
                root = root.right;
            }
        }

        return root;
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

        InsertNodeBST obj = new InsertNodeBST();

        obj.helper(root, 15);

        
        
    }
    
}
