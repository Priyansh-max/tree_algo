import java.util.*;

public class constructbt_preorder {
    public tree helper(int []preorder , int prestart , int preend , int []inorder , int inStart , int inEnd , Map<Integer , Integer> mp){
        if(prestart > preend || inStart > inEnd){
            return null;
        }

        tree root = new tree(preorder[prestart]);
        int inRoot = mp.get(root.data);
        int numLeft = inRoot - inStart;

        root.left = helper(preorder , prestart + 1 , preend + numLeft , inorder , inStart , inRoot - 1 , mp);
        root.right = helper(preorder , prestart + 1 + numLeft , preend , inorder , inRoot + 1 , inEnd , mp);

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
        int preOrder[] = new int[]{10,20,40,50,30,60};

        for(int i = 0 ; i < inOrder.length ; i++){
            mp.put(inOrder[i] , i);
        }

        constructbt_preorder obj = new constructbt_preorder();
        tree root = obj.helper(preOrder , 0 , preOrder.length - 1 , inOrder , 0 , inOrder.length - 1 , mp);
        
        obj.printTree(root);

    }

}
