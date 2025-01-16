import java.util.*;

public class boundaryTraversal {
    static List<Integer> leftbound = new ArrayList<>();
    static List<Integer> rightbound = new ArrayList<>();
    static List<Integer> leaf = new ArrayList<>();
    public void leftboundary(tree root){
        if(root == null){
            return;
        }

        if(root.left == null){
            leftboundary(root.right);
        }

        leftboundary(root.left);

        if(root.left != null || root.right != null){ //adds only if it is not leaf node
            leftbound.add(root.data);
        }


    }
    public void rightboundary(tree root){
        if(root == null){
            return;
        }

        if(root.right == null){
            rightboundary(root.left);
        }

        rightboundary(root.right);
        
        if(root.left != null || root.right != null){
            rightbound.add(root.data);
        }
    }

    public void leafnodes(tree root){
        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){
            leaf.add(root.data);
        }

        leafnodes(root.left);
        leafnodes(root.right);

    }

    public void clockWiseBoundary(){
        //in clockwise you start with the rightboundary in reverse order then the leaf nodes in reverse order and finally the left boundary in the order as it is and exclude the last element of the left boundary list;

        for(int i = rightbound.size() - 1 ; i >= 0 ; i--){
            System.out.print(rightbound.get(i) + " ");
        }

        for(int i = leaf.size() - 1 ; i >= 0 ; i--){
            System.out.print(leaf.get(i) + " ");
        }

        for(int i = 0 ; i < leftbound.size() - 1 ; i++){
            System.out.print(leftbound.get(i) + " ");
        }

    }

    public void AnticlockWiseBoundary(){
        //in clockwise you start with the leftboundary in reverse order then the leaf nodes in the same order and finally the right boundary in the order as it is and exclude the last element of the right boundary list;

        for(int i = leftbound.size() - 1 ; i >= 0 ; i--){
            System.out.print(leftbound.get(i) + " ");
        }

        for(int i =0; i < leaf.size() ; i++){
            System.out.print(leaf.get(i) + " ");
        }

        for(int i = 0 ; i < rightbound.size() - 1 ; i++){
            System.out.print(rightbound.get(i) + " ");
        }

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

        boundaryTraversal obj = new boundaryTraversal();

        obj.leftboundary(root);
        System.out.println(leftbound); //this returns the leftboundary for any binary tree starting from root excluding the leaf nodes;
  
        obj.rightboundary(root);
        System.out.println(rightbound); //this returns the rightboundary for any binary tree starting from root excluding the leaf nodes

        obj.leafnodes(root);
        System.out.println(leaf); //this returns the leaf nodes for any binary tree.

        System.out.println("Clockwise boundary traversal");
        obj.clockWiseBoundary();
        System.out.println();
        System.out.println("Anti Clockwise boundary traversal");
        obj.AnticlockWiseBoundary();

    }
}
