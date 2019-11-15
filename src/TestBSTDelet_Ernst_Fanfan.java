public class TestBSTDelet_Ernst_Fanfan {
    public static void main(String[] args) {
        BST_Ernst_Fanfan<String> tree = new BST_Ernst_Fanfan<>();
        tree.insert("George");
        tree.insert("Michael");
        tree.insert("Tom");
        tree.insert("Adam");
        tree.insert("Jones");
        tree.insert("Peter");
        tree.insert("Daniel");
        printTree(tree);
        System.out.println("\nAfter delete George:");
        tree.delete("George");
        printTree(tree);
        System.out.println("\nAfter delete Adam:");
        tree.delete("Adam");
        printTree(tree);
        System.out.println("\nAfter delete Michael:");
        tree.delete("Michael");
        printTree(tree);
    }

    public static void printTree(BST_Ernst_Fanfan tree) {// Traverse tree
        System.out.print("Inorder (sorted): ");
        tree.inorder();
        System.out.print("\nPostorder: ");
        tree.postorder();
        System.out.print("\nPreorder: ");
        tree.preorder();
        System.out.print("\nThe number of nodes is " + tree.getSize());
        System.out.println();
    }
}
