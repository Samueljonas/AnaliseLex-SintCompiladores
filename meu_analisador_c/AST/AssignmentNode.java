// File: AST/AssignmentNode.java
package meu_analisador_c.AST;

public class AssignmentNode implements StatementNode {
    public IdentifierNode identifier;
    public ExpressionNode expression;

    public AssignmentNode(IdentifierNode identifier, ExpressionNode expression) {
        this.identifier = identifier;
        this.expression = expression;
    }

    @Override
    public String toString(String prefix) {
        StringBuilder sb = new StringBuilder();
        sb.append(prefix).append("Assignment:\n");
        sb.append(identifier.toString(prefix + "  To: "));
        sb.append("\n");
        sb.append(expression.toString(prefix + "  Value: "));
        return sb.toString();
    }
}