// File: AST/PrintNode.java
package meu_analisador_c.AST;

public class PrintNode implements StatementNode {
    public ExpressionNode expression;

    public PrintNode(ExpressionNode expression) {
        this.expression = expression;
    }

    @Override
    public String toString(String prefix) {
        return prefix + "Print:\n" +
               expression.toString(prefix + "  Arg: ");
    }
}