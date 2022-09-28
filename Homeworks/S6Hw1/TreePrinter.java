package Homeworks.S6Hw1;

class TreePrinter {
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
    static StringBuilder bracketPrintPreOrderNLR(Tree tree) {
        StringBuilder sb = new StringBuilder();
        if (tree != null) {
            sb.append(tree.value);
            if (tree.left != null || tree.right != null)
                sb.append("(").append(bracketPrintPreOrderNLR(tree.left)).append(",")
                        .append(bracketPrintPreOrderNLR(tree.right).append(")"));
        } else
            sb.append("nil");

        return sb;
    }
    static StringBuilder bracketPrintPostOrderLRN(Tree tree) {
        StringBuilder sb = new StringBuilder();
        if (tree != null) {
            if (tree.left != null || tree.right != null) {
                sb.append("(").append(bracketPrintPostOrderLRN(tree.left)).append(",").append(bracketPrintPostOrderLRN(tree.right).append(")"));
            }
            sb.append(tree.value);
        } else
            sb.append("nil");

        return sb;
    }
    static StringBuilder bracketPrintInOrderLNR(Tree tree) {
        StringBuilder sb = new StringBuilder();
        if (tree.left != null) {
            sb.append("(").append(bracketPrintInOrderLNR(tree.left));
            if (tree.right == null)
                sb.append(",nil");
            sb.append(")");
        }
        sb.append(tree.value);
        if (tree.right != null) {
            sb.append("(").append(bracketPrintInOrderLNR(tree.right));
            if (tree.left == null)
                sb.append("nil");
            sb.append(")");
        }
        return sb;
    }
}
