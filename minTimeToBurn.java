
import java.util.*;

public class minTimeToBurn{

    public void makeParent(tree root , Map<tree , tree> mp){
        //simple bfs again
        Queue<tree> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            tree currNode = q.poll();
            if(currNode.left != null){
                mp.put(currNode.left , currNode); //signifies that parent of left node is currNode;
                q.add(currNode.left);
            }
            if(currNode.right != null){
                mp.put(currNode.right , currNode);
                q.add(currNode.right);
            }
        }
        
    }
    //return int because u want to return the minimum time  
    //takes input -- tree node ---> the node from where u want to burn the tree 
    //takes input -- the hashmap containing the parent pointers

    public int helper(tree node , Map<tree , tree> mp){
        int ans = 0;
        Queue<tree> q = new LinkedList<>();
        Map<tree , Boolean> visited = new HashMap<>();

        q.add(node);
        visited.put(node , true);

        while(!q.isEmpty()){
            int size = q.size();
            int flag = 0; //important to note the flag must be outside the for loop because a for loop denote each lvl of traversal 
            //so keep the flag variable out otherwise you will get add extra cases.....

            for(int i = 0 ; i < size;  i++){
                tree currNode = q.poll();
                if(mp.containsKey(currNode) && !visited.containsKey(mp.get(currNode))){
                    visited.put(mp.get(currNode) , true);
                    q.add(mp.get(currNode));
                    flag = 1;
                }
                if(currNode.left != null && !visited.containsKey(currNode.left)){
                    visited.put(currNode.left , true);
                    q.add(currNode.left);
                    flag = 1;
                }
                if(currNode.right != null && !visited.containsKey(currNode.right)){
                    visited.put(currNode.right , true);
                    q.add(currNode.right);
                    flag = 1;
                }
            }
            if(flag == 1){
                ans++;
            }
        }
        return ans;
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

        Map<tree , tree> mp = new HashMap<>();
        minTimeToBurn obj = new minTimeToBurn();

        obj.makeParent(root, mp);
        int ans = obj.helper(root.right, mp);

        System.out.println("The min time to burn the binary tree starting with node " + root.right.data + " is " + ans);


        
    }
}