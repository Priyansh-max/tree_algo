import java.util.*;

public class serialize_deserialize {

    //convert given tree into string
    public StringBuilder Seralize(tree root){
        StringBuilder str = new StringBuilder();

        //simple bfs
        Queue<tree> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            tree currNode = q.poll();
            if(currNode == null){
                str.append("n,");
                continue; //checking overall if node is null just simply append a hash
            }
            str.append(currNode.data + ",");
            q.add(currNode.left); //here we dont check if left or right is null and directly putting in the value there the nodes can become null;
            q.add(currNode.right);
        }
        return str;
    }

    public tree deseralize(StringBuilder str){
        if(str == null){
            return null;
        }
        Queue<tree> q = new LinkedList<>();
        String arr[] = str.toString().split(",");
        tree root = new tree(Integer.parseInt(arr[0]));
        q.add(root);
        
        for(int i = 1 ; i < arr.length ; i++){
            tree currNode = q.poll();

            if(!arr[i].equals("n")){
                currNode.left = new tree(Integer.parseInt(arr[i]));
                q.add(currNode.left);
            }
            if(!arr[++i].equals("n")){
                currNode.right = new tree(Integer.parseInt(arr[i]));
                q.add(currNode.right);
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
        root.right = new tree(9);
        root.left = new tree(8);
        root.right.right = new tree(7);
        root.right.left = new tree(6);
        root.left.left = new tree(5);
        root.left.right = new tree(4);
        root.left.right.left = new tree(3);

        serialize_deserialize obj = new serialize_deserialize();

        StringBuilder ans = obj.Seralize(root);

        System.out.println(ans);
        // 10,8,9,5,4,6,7,n,n,3,n,n,n,n,n,n,n,

        tree finaltree = obj.deseralize(ans);

        tree newroot = finaltree;
        obj.printTree(newroot);


        
    }
    
}
