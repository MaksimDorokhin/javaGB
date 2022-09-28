/*
Реализовать печать бинарного дерева в скобочной форме: 1(3(31,511(202,nil)),2(4,5))
 */

package Homeworks.S6Hw1;

public class Program {
    public static void main(String[] args) {
        Tree root = new Tree(1);
        Tree l1 = new Tree(3);
        Tree r1 = new Tree(2);
        Tree r1l1 = new Tree(4);
        Tree r1r1 = new Tree(5);
        root.left = l1;
        root.right = r1;
        r1.left = r1l1;
        r1.right = r1r1;
        Tree l1r1 = new Tree(511);
        l1r1.left = new Tree(202);
        l1.left = new Tree(31);
        l1.right = l1r1;


        System.out.printf("PreOrderNLR: %s\n", TreePrinter.bracketPrintPreOrderNLR(root));
        System.out.printf("PostOrderLRN: %s\n",TreePrinter.bracketPrintPostOrderLRN(root));
        System.out.printf("InOrderLNR: %s\n",TreePrinter.bracketPrintInOrderLNR(root));
    }
}
