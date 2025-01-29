public class countNodeinCT {

    public int countNodes(tree root){
        if(root == null){
            return 0;
        }

        int lh = findLftHeight(root);
        int rh = findRgHeight(root);

        if(lh == rh){
            return (1<<lh) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);

    }

    public int findLftHeight(tree root){
        int count = 0;
        while(root != null){
            count++;
            root = root.left;
        }

        return count;
    }

    public int findRgHeight(tree root){
        int count = 0;
        while(root != null){
            count++;
            root = root.right;
        }

        return count;
    }

    public static void main(String[] args) {
        //input a complete binary tree;;
        //a complete binary tree is either a full binary tree and all levels filled or a exception when the last lvl should have all the nodes to the left only

        tree root = new tree(10);
        root.left = new tree(9);
        root.right = new tree(8);
        root.left.left = new tree(7);
        root.left.right = new tree(6);
        root.right.left = new tree(5);
        root.right.right = new tree(4);
        root.left.left.left = new tree(3);
        root.left.left.right = new tree(2);
        root.left.right.left = new tree(1);

        countNodeinCT obj = new countNodeinCT();
        int ans = obj.countNodes(root);

        System.out.println("The total node in the given complete binary tree is --> " + ans);

        
    }
    
}
