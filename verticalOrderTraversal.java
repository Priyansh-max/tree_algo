import java.util.*;

class NodeData{
    tree node;
    int row;
    int col;

    NodeData(tree node , int row , int col){
        this.node = node;
        this.row = row;
        this.col = col;
    }
}

public class verticalOrderTraversal {

    public TreeMap<Integer , TreeMap<Integer , PriorityQueue<Integer>>> helper(tree root){
        TreeMap<Integer , TreeMap<Integer , PriorityQueue<Integer>>> ans = new TreeMap<>(); //stores (vertical , map<level ,elements in sorted order>)
    
        Queue<NodeData> q = new LinkedList<>();
        q.add(new NodeData(root, 0, 0));
        while(!q.isEmpty()){
            NodeData current = q.poll();
            tree currentnode = current.node;
            int row = current.row;
            int col = current.col;


            if(!ans.containsKey(col)){
                ans.put(col , new TreeMap<>());
            }

            if(!ans.get(col).containsKey(row)){
                ans.get(col).put(row , new PriorityQueue<>());
            }

            ans.get(col).get(row).add(currentnode.data);


            if(currentnode.left != null){
                q.add(new NodeData(currentnode.left , row + 1, col - 1));
            }

            if(currentnode.right != null){
                q.add(new NodeData(currentnode.right, row + 1, col + 1));
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
        root.left.left.left = new tree(15);
        root.left.left.left.right = new tree(25);
        root.left.right = new tree(4);
        root.left.right.left = new tree(3);

        verticalOrderTraversal obj = new verticalOrderTraversal();
        TreeMap<Integer , TreeMap<Integer , PriorityQueue<Integer>>> ans = obj.helper(root);
        System.out.println(ans);


        //better visualising in form of list
        List<List<Integer>> lst = new ArrayList<>();

        for(TreeMap<Integer , PriorityQueue<Integer>> ys : ans.values()){ //returns the map<level , each element in that vertical>
            lst.add(new ArrayList<>());
            for(PriorityQueue<Integer> p : ys.values()){
                while(!p.isEmpty()){
                    lst.get(lst.size() - 1).add(p.poll());
                }
            }
        }

        System.out.println(lst); //this is a vertical traversal............

    }
}
