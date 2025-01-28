//given a target node task is to find all the nodes that are at a distance K.

//step 1 - assign parent points

import java.util.*;
//make sure your tree does not have repeating elements

//here using map can case some problem if the tree has multiple repeating values in such case using pair customly would be a good option because it could stop the problem of repeating elements
public class nodeAtDistanceK {
    public void makeParent(tree root , Map<tree , tree> mp){
        //simple bfs
        Queue<tree> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            tree currNode = q.poll();
            if(currNode.left != null){
                mp.put(currNode.left , currNode);
                q.add(currNode.left);
            }
            if(currNode.right != null){
                mp.put(currNode.right , currNode);
                q.add(currNode.right);
            }
        }

    }

    public List<tree> helper(tree root , Map<tree , tree> mp , int dist){ //here root denote the target node from where u want to find the nodes at distance dist;
        Queue<tree> q = new LinkedList<>();
        Map<tree , Boolean> visited = new HashMap<>();
        List<tree> lst = new ArrayList<>();
        int curr_lvl = 0;
        q.add(root);
        visited.put(root , true);
        while(!q.isEmpty()){
            int size = q.size();
            if(curr_lvl == dist){
                break;
            }
            curr_lvl++;

            for(int i = 0 ; i < size ; i++){
                tree currNode = q.poll();

                if(mp.containsKey(currNode) && !visited.containsKey(mp.get(currNode))){
                    q.add(mp.get(currNode));
                    visited.put(mp.get(currNode) , true);
                }

                if(currNode.left != null && !visited.containsKey(currNode.left)){
                    q.add(currNode.left);
                    visited.put(currNode.left , true);
                }

                if(currNode.right != null && !visited.containsKey(currNode.right)){
                    q.add(currNode.right);
                    visited.put(currNode.right , true);
                }

            }

        }

        while(!q.isEmpty()){
            tree currNode = q.poll();
            lst.add(currNode);
        }

        return lst;

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
        nodeAtDistanceK obj = new nodeAtDistanceK();
        obj.makeParent(root, mp);

        List<tree> ans = obj.helper(root.right , mp , 1);

        //nodes at a distance of 1 around node 9 ----> ans will be 10 , 6 and 7

        for(tree node : ans){
            System.out.print(node.data + " ");
        }
        
    }
    
}
