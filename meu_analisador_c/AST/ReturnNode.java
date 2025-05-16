// File: AST/ReturnNode.java
package meu_analisador_c.AST;

public class ReturnNode implements StatementNode {
    public ExpressionNode expression;

    public ReturnNode(ExpressionNode expression) {
        this.expression = expression;
    }

    @Override
    public String toString(String prefix) {
        return prefix + "Return:\n" +
               expression.toString(prefix + "  Value: ");
    }
}
