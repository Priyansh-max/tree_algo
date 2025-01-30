import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class constructbt_postorder {
    public tree helper(int []postorder , int postStart , int postEnd , int []inorder , int inStart , int inEnd , Map<Integer , Integer> mp){
        if(postStart > postEnd || inStart > inEnd){
            return null;
        }
        tree root = new tree(postorder[postEnd]);
        int inRoot = mp.get(root.data);
        int numLeft = inRoot - inStart;

        root.left = helper(postorder , postStart, postStart + numLeft - 1, inorder , inStart , inRoot - 1 , mp);
        root.right = helper(postorder , postStart + numLeft , postEnd - 1 , inorder , inRoot + 1 , inEnd , mp);

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
        Map<Integer , Integer> mp = new HashMap<>();

        int inOrder[] = new int[]{40,20,50,10,60,30};
        int postOrder[] = new int[]{40, 50, 20, 60, 30, 10}; 

        for(int i = 0 ; i < inOrder.length ; i++){
            mp.put(inOrder[i] , i);
        }

        constructbt_postorder obj = new constructbt_postorder();
        tree root = obj.helper(postOrder , 0 , postOrder.length - 1 , inOrder , 0 , inOrder.length - 1 , mp);
        
        obj.printTree(root);

    }
    
}
