public class CeilBST {
    int ans = -1;
    public void helper(tree root , int val){
        if(root == null){
            return;
        }

        if(root.data == val){
            ans = root.data;
            return;
        }

        if(root.data < val){
            helper(root.right , val);
        }
        else{
            ans = root.data;
            helper(root.left , val);
        }
        
    }

    public static void main(String[] args) {
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

        CeilBST obj = new CeilBST();

        obj.helper(root, 7); //must give 9 as output for input 7

        System.out.println(obj.ans);
    }
    
}
