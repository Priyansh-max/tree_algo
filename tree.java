public class tree {
    int data;
    tree right;
    tree left;
    
    tree(){}

    //to define each node
    tree(int data){
        this.data = data;
    }

    //to create the root with children
    tree(tree right , tree left , int data){
        this.right = right;
        this.left = left;
        this.data = data;
    }
    public static void main(String[] args) {
        tree root = new tree(10); //created roott
        root.right = new tree(5); //create right children
        root.left = new tree(0);  //created left children


        tree rightNode = new tree(12); //defined rightChild
        tree leftNode = new tree(6); //defined leftChild
        tree root1 = new tree(rightNode , leftNode , 0); //define the root

        
    }
}
