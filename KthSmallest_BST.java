

public class KthSmallest_BST {
    int count = 0;
    public int findKthSmallest(tree root , int k){
        //do inorder traversal;
        // as inorder traversal gives the ascending order in a BST;

        //step1 - have a counter for everytime a root changes;
        //step2 - as we know that the elements are traversed in ascending order so when counter == k we break and return that root;

        //inorder LRootR;

        if(root == null){
            return -1;
        }

        int leftsubtree = findKthSmallest(root.left, k);
        if(leftsubtree != -1){
            return leftsubtree;
        }
        count++;
        if(count == k){
            return root.data;
        }
        return findKthSmallest(root.right, k);

    }
    int count2 = 0;
    public int findKthLargest(tree root , int k , int totalNodes){
        if(root == null){
            return -1;
        }

        int leftsubtree = findKthLargest(root.left , k , totalNodes);
        if(leftsubtree != -1){
            return leftsubtree;
        }

        count2++;
        if(count2 == totalNodes - k){
            return root.data;
        }

        return findKthLargest(root.right, k, totalNodes);
    }

    public int findTotalNode(tree root){
        if(root == null){
            return 0;
        }

        int leftsubtree = findTotalNode(root.left);
        int rightsubtree = findTotalNode(root.right);

        return 1 + leftsubtree + rightsubtree;


    }
    public static void main(String[] args) {
        tree root = new tree(10);
        root.right = new tree(13);
        root.left = new tree(5);
        root.right.right = new tree(14);
        root.right.left = new tree(11);
        root.left.left = new tree(3);
        root.left.left.left = new tree(2);
        root.left.left.right = new tree(4);
        root.left.right = new tree(6);
        root.left.right.right = new tree(9);

        KthSmallest_BST obj = new KthSmallest_BST();
        int ans = obj.findKthSmallest(root, 5); //5th largest is 6;

        int totalnodes = obj.findTotalNode(root);

        int ans2 = obj.findKthLargest(root, 3, totalnodes); //3rd larges is 10

        System.out.println(ans);

        System.out.println(ans2);

    }
    
}
