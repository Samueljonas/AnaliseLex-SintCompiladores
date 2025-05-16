// File: AST/BinaryOpNode.java
package meu_analisador_c.AST;

public class BinaryOpNode implements ExpressionNode {
    public ExpressionNode left;
    public String operator;
    public ExpressionNode right;

    public BinaryOpNode(ExpressionNode left, String operator, ExpressionNode right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    @Override
    public String toString(String prefix) {
        StringBuilder sb = new StringBuilder();
        sb.append(prefix).append("BinaryOp(").append(operator).append(")\n");
        sb.append(left.toString(prefix + "  L: ")); // Passa o rótulo como parte do prefixo para a próxima chamada
        sb.append("\n");
        sb.append(right.toString(prefix + "  R: "));
        return sb.toString();
    }
}