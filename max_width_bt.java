import java.util.*;
//width defination --> No of nodes in a particular lvl that it can fit in between the two nodes
class Pair{
    tree node;
    int idx;

    Pair(tree node , int idx){
        this.node = node;
        this.idx = idx;
    }
}

public class max_width_bt {

    public int helper(tree root , int idx){
        if(root == null){
            return 0;
        }

        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, idx));
        while(!q.isEmpty()){
            int size = q.size(); //used to identify each lvl;
            int min_lvl = q.peek().idx; //min_idx value for each lvl;
            int first = 0;
            int last = 0;

            for(int i = 0 ; i < size ; i++){ //to traverse lvl wise;
                int curr_val = q.peek().idx - min_lvl;
                tree node = q.peek().node;
                q.poll();

                if(i == 0){ //first idx for lvl
                    first = curr_val;
                }
                if(i == size-1){ //last idx for lvl
                    last = curr_val;
                }

                if(node.left != null){ //adding new value with idx starting from 0
                    q.add(new Pair(node.left , curr_val*2+1));
                }
                if(node.right != null){ //adding new value with idx starting from 1
                    q.add(new Pair(node.right , curr_val*2+2));
                }
            }
            ans = Math.max(ans , last-first + 1);
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
        root.right.right.left = new tree(2);

        max_width_bt obj = new max_width_bt();
        int ans = obj.helper(root , 0);

        System.out.print("The max width of the binary tree is -->");
        System.out.print(ans);
    }
    
}
