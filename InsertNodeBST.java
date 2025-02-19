import java.util.LinkedList;
import java.util.Queue;

public class InsertNodeBST {

    public tree helper(tree root , int insertNode){
        if(root == null){
            return new tree(insertNode);
        }

        tree curr = root;
        while(true){
            if(insertNode < curr.data){
                if(curr.left == null){
                    curr.left = new tree(insertNode);
                    break;
                }
                curr = curr.left;
            }

            else{
                if(curr.right == null){
                    curr.right = new tree(insertNode);
                    break;
                }
                curr = curr.right;
            }

        }

        return root;
    }

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

        InsertNodeBST obj = new InsertNodeBST();

        tree newroot = obj.helper(root, 1);

        obj.printTree(newroot);


        
    }
    
}
