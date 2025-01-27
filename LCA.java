public class LCA {
    //A lowest common ancestor in simple terms is a parent which is common to both the given nodes like a common node from where we can reach both the nodes going forward

    public tree helper(tree root , tree node1 , tree node2){
        if(root == null || root == node1 || root == node2){
            return root;
        } //return null if root is null or else return root when it is either node1 or node2

        tree left = helper(root.left , node1 , node2);  //go left
        tree right = helper(root.right , node1 , node2); //go right

        if(left == null){ //return non-null value
            return right;
        }
        else if(right == null){ //return non-null value
            return left;
        }
        else{
            return root; //return base case 
        }
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

        LCA obj = new LCA();

        tree ans = obj.helper(root, root.left.right.left , root.right.right); //helper(10 , 3 , 7) (LCA(3,7));

        System.out.println(ans.data); //expected ans 10





    }
    
}
