import java.util.LinkedList;
import java.util.Queue;

public class deleteNodeBST {
    public tree helper(tree root , int deleteNode){
        //task one search deleteNode
        if(root == null){
            return null;
        }

        if(root.data == deleteNode){  //if we need to delete the root;
            tree leftsubtree = root.left;
            tree rightsubtree = root.right;
            tree lastright = leftsubtree;
            while(lastright.right != null){
                lastright = lastright.right;
            }
            lastright.right = rightsubtree;

            return leftsubtree;
        }

        tree curr = root; //or else we search for the node to delete and then get the leftsubtree and rightsubtree and and we remove the node and put the parent pointer to the leftsubtree and place the rightsubtree to the lastright of the leftsubtree
        while(true){
            if(root.data > deleteNode){
                if(root.left != null && root.left.data == deleteNode){
                    if(root.left.left == null){
                        root.left = root.left.right;
                        break;
                    }
                    else if(root.left.right == null){
                        root.left = root.left.left;
                        break;
                    }

                    tree leftsubtree = root.left.left;
                    tree rightsubtree = root.left.right;
                    tree lastright = leftsubtree;
                    while(lastright.right != null){
                        lastright = lastright.right;
                    }

                    lastright.right = rightsubtree;
                    root.left = leftsubtree;

                    break;
                }
                else{
                    root = root.left;
                }
            }
            else{
                if(root.right != null && root.right.data == deleteNode){
                    if(root.right.right == null){
                        root.right = root.right.left;
                        break;
                    }
                    else if(root.right.left == null){
                        root.right = root.right.right;
                        break;
                    }

                    tree rightsubtree = root.right.right;
                    tree leftsubtree = root.right.left;
                    tree lastleft = rightsubtree;
                    while(lastleft.left != null){
                        lastleft = lastleft.left;
                    }

                    lastleft.left = leftsubtree;
                    root.right = rightsubtree;

                    break;
                }
                else{
                    root = root.right;
                }
            }
        }

        return curr;
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

        deleteNodeBST obj = new deleteNodeBST();

        // tree deleteroot = obj.helper(root, 10); //deleting root must return root as 5;

        // obj.printTree(deleteroot);

        tree randomNode = obj.helper(root ,11);

        obj.printTree(randomNode);


        
    }
    
}
