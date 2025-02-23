public class LCA_BST {
    public tree findLCA(tree root , int ele1 , int ele2){
        if(root == null){
            return null;
        }

        if(root.data > ele1 && root.data > ele2){
            return findLCA(root.left , ele1 , ele2);
        }

        else if(root.data < ele1 && root.data < ele2){
            return findLCA(root.right , ele1 , ele2);
        }

        return root;

    }
    public static void main(String[] args) {

        //                      10 
        //                    /    \
        //                   5      13
        //                  / \      / \
        //                 3   6    11  14
        //                /\    \   
        //               2  4    9
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

        LCA_BST obj = new LCA_BST();

        tree ans = obj.findLCA(root, 2,9); //SHOULD GIVE 5

        System.out.println(ans.data);
        
    }
    
}
