import treePackage.Tree;

import java.util.Random;

public class TreeImportTest {
    public static void main(String[] args){
        Tree<Integer, String> tree = new Tree();
        Random rand = new Random();
        int n = 0;
        String s;
        for(int i=1;i<11;i++){
            n = rand.nextInt(100)+1;
            s = String.format("Value: %d",i);
            tree.insertNode(n,s);
            System.out.print(" " + n);
        }

        System.out.println ( "\n\nPreorder traversal" );
        tree.preorderTraversal(); // perform preorder traversal of tree

        System.out.println ( "\n\nDescending order traversal" );
        tree.descendingOrderTraversal(); // perform inorder traversal of tree

        System.out.println ( "\n\nAscending order traversal" );
        tree.ascendingOrderTraversal();

        System.out.println ( "\n\nPostorder traversal" );
        tree.postorderTraversal(); // perform postorder traversal of tree

        System.out.println("\n\nFind by key");
        String value = tree.findByKey(n);
        System.out.println("Value: " + value);
    }
}
