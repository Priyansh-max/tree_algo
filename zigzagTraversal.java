import java.util.*;

public class zigzagTraversal {
    public List<List<Integer>> helper(tree root){
        List<List<Integer>> lst = new ArrayList<>();
        Queue<tree> q = new LinkedList<>();
        boolean flag = true; //keeps track for left to right default enabled from left to right
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> subList = new ArrayList<>(size);

            for(int i = 0 ; i < size ; i++){
                tree currentNode = q.poll();
                
                subList.add(currentNode.data); //adding poped value according to index

                if(currentNode.left != null){
                    q.add(currentNode.left);
                }

                if(currentNode.right != null){
                    q.add(currentNode.right);
                }
            }

            if(!flag){
                Collections.reverse(subList);
            }
            flag = !flag;
            lst.add(subList);
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

        zigzagTraversal obj = new zigzagTraversal();
        List<List<Integer>> ans = obj.helper(root);
        //expected output 10 , 9  , 8 , 5 , 4 , 6 , 7 ,3

        System.out.println(ans);

        //for accessing each element
        for(List<Integer> l : ans){
            for(Integer num : l){
                System.out.println(num);
            }
        }

    }
}
