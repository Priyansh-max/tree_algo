public class searchBST {
    public tree helper(tree root , int val){ //return the node where node.data == val;
        while(root != null && root.data != val){
            root = val < root.data ? root.left : root.right;
        }
        return root;
    }

    public static void main(String[] args) {
        //this is BST 
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

        searchBST obj = new searchBST();

        tree ans = obj.helper(root, 4);

        System.out.println(ans); //returing the tree node;
        System.out.println(ans.data); //verify it the same val
    
    }


    
}
