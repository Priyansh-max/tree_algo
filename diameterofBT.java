public class diameterofBT {
    static int maxi = 0;

    public int helper(tree root){
        if(root == null){
            return 0;
        }
        int lh = helper(root.left);
        int rh = helper(root.right);

        maxi = Math.max(maxi , lh + rh);

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
        root.left.right.left.right = new tree(2);

        diameterofBT obj = new diameterofBT();
        int ans = obj.helper(root);
        System.out.println(ans); //this returns the height of the binary tree;

        System.out.println(maxi); //this returns the diameter of the binary tree;

    }
    
}
