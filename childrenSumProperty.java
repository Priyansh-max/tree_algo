public class childrenSumProperty {

    public void helper(tree root){
        if(root == null){
            return;
        }
        int child = 0;
        if(root.left != null){
            child += root.left.data;
        }
        if(root.right != null){
            child += root.right.data;
        }

        if(child >= root.data){
            root.data = child;
        }else{
            if(root.left != null){
                root.left.data = root.data;
            }else if(root.right != null){
                root.right.data = root.data;
            }
        }

        helper(root.left);
        helper(root.right);

        int tot = 0;
        if(root.left != null){
            tot += root.left.data;
        }
        if(root.right != null){
            tot += root.right.data;
        }
        if(root.left != null || root.right != null){
            root.data = tot;
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

        childrenSumProperty obj = new childrenSumProperty();
        obj.helper(root);

        System.out.println(root.data);
    }
}
