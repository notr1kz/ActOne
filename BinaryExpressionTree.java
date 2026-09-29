/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actone;

/**
 *
 * @author Administrator
 */
import java.util.Scanner;
import java.util.Stack;

public class BinaryExpressionTree {
     class Node {

    String data;
    Node leftChild;
    Node rightChild;

    public Node(String key) {
        data = key;
        leftChild = rightChild = null;
    }
}

    Node root = null;

    // Build the expression tree from a user-entered postfix expression
    void buildFromPostfix(String postfix) {
        Stack<Node> stack = new Stack<>();
        String[] tokens = postfix.trim().split("\\s+");

        for (String token : tokens) {
            Node node = new Node(token);
            if (isOperator(token)) {
                node.rightChild = stack.pop();  // pop right operand first
                node.leftChild = stack.pop();   // then left operand
            }
            stack.push(node);
        }
        root = stack.pop();
    }

    boolean isOperator(String token) {
        return token.equals("+") || token.equals("-")
            || token.equals("*") || token.equals("/");
    }

    void inorder_traversal(Node node) {
        if (node != null) {
            boolean isOp = isOperator(node.data);
            if (isOp) System.out.print("(");
            inorder_traversal(node.leftChild);
            System.out.print(node.data);
            inorder_traversal(node.rightChild);
            if (isOp) System.out.print(")");
        }
    }

    // Recursively evaluates the tree and returns the numeric result.
    public int rslt(Node node) {
        if (node == null) return 0;

        if (node.leftChild == null && node.rightChild == null) {
            return Integer.parseInt(node.data);   // leaf = operand
        }

        int leftVal = rslt(node.leftChild);
        int rightVal = rslt(node.rightChild);

        switch (node.data) {
            case "+": return leftVal + rightVal;
            case "-": return leftVal - rightVal;
            case "*": return leftVal * rightVal;
            case "/": return leftVal / rightVal;
            default:
                throw new IllegalArgumentException("Unknown operator: " + node.data);
        }
    }

    public static void main(String[] args) {
        BinaryExpressionTree tree = new BinaryExpressionTree();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a postfix expression (space-separated, e.g. 6 4 + 8 * 9 5 2 7 1 * + * - +):");
        String postfix = sc.nextLine();

        tree.buildFromPostfix(postfix);

        System.out.println("Inorder traversal: ");
        tree.inorder_traversal(tree.root);
        System.out.println();

        int result = tree.rslt(tree.root);
        System.out.println("Evaluated result: " + result);

        sc.close();
    }
}
