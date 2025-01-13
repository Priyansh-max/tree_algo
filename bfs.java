import java.util.*;

public class bfs {
    public void bfsTraversal(tree root){
        if(root == null){
            return;
        }

        Queue<tree> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            tree currentNode = q.poll();
            System.out.println(currentNode.data);

            if(currentNode.left != null){
                q.add(currentNode.left);
            }
            if(currentNode.right != null){
                q.add(currentNode.right);
            }

        }
    }

    public static void main(String[] args) {
        tree root = new tree(10);
        root.right = new tree(9);
        root.left = new tree(8);
        root.right.right = new tree(7);
        root.right.left = new tree(6);
        root.left.left = new tree(5);
        root.left.right = new tree(4);

        bfs obj = new bfs();
        //expected output -- 10 8 9 5 4 6 7
        obj.bfsTraversal(root);

    }
}
