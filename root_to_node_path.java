import java.util.*;
public class root_to_node_path {

    public boolean helper(tree node , ArrayList<Integer> lst , int x){
        if(node == null){
            return false;
        }
        lst.add(node.data);

        if(node.data == x){
            return true;
        }

        boolean lft = helper(node.left , lst , x); //checks for left subtree to find the node
        boolean rgt = helper(node.right , lst , x);

        if(lft || rgt){
            return true;
        }

        lst.remove(lst.size() - 1);
        return false;
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

        root_to_node_path obj = new root_to_node_path(); //obj to call the helper method
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the node you want the path for --> ");
        int value = sc.nextInt();
        ArrayList<Integer> lst = new ArrayList<>(); //creatinf reference arraylist
        boolean ans = obj.helper(root , lst , value); //passing values

        if(ans){
            System.out.println("Path found");
            for(int i : lst){
                System.out.print(i + " ");
            }
        }
        else{
            System.out.println("Path not found");
        }




        
    }
    
}
