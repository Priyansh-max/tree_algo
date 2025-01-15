public class max_pathSumofBT {
    static int maxi = 0;
    static int ls = 0;
    static int rs = 0;

    public int helper(tree root){
        if(root == null){
            return 0;
        }

        int lh = Math.max(0 , helper(root.left));
        int rh = Math.max(0 , helper(root.right));
        
        maxi = Math.max(maxi , root.data + lh + rh);

        ls =  root.data + lh; //this gives the max sum path from left half
        rs =  root.data + rh; //this gives the max sum path from right half
        return root.data + Math.max(lh , rh);
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

        max_pathSumofBT obj = new max_pathSumofBT();
        int ans = obj.helper(root);
        System.out.println(ls);
        System.out.println(rs);
        System.out.println(ans); //returns the max sum for root node
        System.out.println(maxi); //returns the max_pathsum 
        //answer must be 44 for our case
        
    }
    
}
