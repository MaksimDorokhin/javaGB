package Seminars.S6T1Trees;

public class Program {
    public static void main(String[] args) {
        Tree root = new Tree(1);
        Tree l1 = new Tree(3);
        Tree r1 = new Tree(2);
        Tree r1l1 = new Tree(4);
        Tree r1r1 = new Tree(5);

        r1.left = r1l1;
        r1.right = r1r1;

        Tree l1r1 = new Tree(511);
        l1r1.left = new Tree(202);
        l1.left = new Tree(31);
        l1.right = l1r1;

        root.left = l1;
        root.right = r1;
        Printer.print(root, "");
    }
}

class Tree {
    public Tree(int v) {
        value = v;
    }

    int value;
    Tree left;
    Tree right;
}

class Printer {

    static void print(Tree tree, String space) {
        if (tree != null) {
            System.out.printf("%s%d\n", space, tree.value);
            if (tree.left != null || tree.right != null) {
                print(tree.left, space + "  ");
                print(tree.right, space + "  ");
            }
        } else {
            System.out.printf("%snil\n", space);
        }
    }
}