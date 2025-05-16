// File: AST/IfNode.java
package meu_analisador_c.AST;

public class IfNode implements StatementNode {
    public ExpressionNode condition;
    public StatementsNode thenBranch;
    // Poderia ter um elseBranch aqui

    public IfNode(ExpressionNode condition, StatementsNode thenBranch) {
        this.condition = condition;
        this.thenBranch = thenBranch;
    }

    @Override
    public String toString(String prefix) {
        return prefix + "If:\n" +
               condition.toString(prefix + "  Cond: ") + "\n" +
               thenBranch.toString(prefix + "  Then: ");
    }
}
