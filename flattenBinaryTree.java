import java.util.LinkedList;
import java.util.Queue;

public class flattenBinaryTree {

    public void printTree(tree root) {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }

        Queue<tree> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Number of nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                tree node = queue.poll();
                System.out.print(node.data + " ");

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            System.out.println(); // Move to next level
        }
    }


    tree prev = null;
    public void helper(tree root){
        if(root == null){
            return;
        }

        helper(root.right); //very imp go right first
        helper(root.left);

        root.right = prev; //
        root.left = null;
        prev = root;

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

        flattenBinaryTree obj = new flattenBinaryTree();

        obj.helper(root);
        obj.printTree(root); //will return the flattened binary tree;
        //correct output --> 10 , 8 , 5 , 4, 3 , 9 ,6,7

        
    }
}
