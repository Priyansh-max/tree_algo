public class dfs {
    
    public void dfsTraversal(tree root){
        //simple dfs
        if(root == null){
            return;
        }

        System.out.println(root.data);
        dfsTraversal(root.left);
        dfsTraversal(root.right);

    }

    public static void main(String[] args) {
        
        tree root = new tree(10);
        root.right = new tree(9);
        root.left = new tree(8);
        root.right.right = new tree(7);
        root.right.left = new tree(6);
        root.left.left = new tree(5);
        root.left.right = new tree(4);

        dfs dfsobj = new dfs();
        System.out.println("dfs traversal is as follows");

        dfsobj.dfsTraversal(root);
        //dfs traversal answer 10 8 5 4 9 6 7 
    }
}
