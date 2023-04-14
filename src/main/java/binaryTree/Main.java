package binaryTree;

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.add(4).add(2).add(1).add(3).add(6).add(5).add(7);

        tree.printTree();

        if(tree.isInTree(5)){
            System.out.println("2 in tree");
        } else {
            System.out.println("2 not in tree");
        }
    }
}
