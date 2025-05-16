// File: AST/StatementsNode.java
package meu_analisador_c.AST;

import java.util.List;
import java.util.ArrayList;

public class StatementsNode implements Node {
    public List<StatementNode> statements;

    public StatementsNode() {
        this.statements = new ArrayList<>();
    }
    public StatementsNode(List<StatementNode> statements) {
        this.statements = statements;
    }
    public void addStatement(StatementNode stmt) {
        this.statements.add(stmt);
    }
    @Override
    public String toString(String prefix) {
        StringBuilder sb = new StringBuilder();
        sb.append(prefix).append("Statements:\n");
        for (StatementNode stmt : statements) {
            sb.append(stmt.toString(prefix + "  ")).append("\n");
        }
        if (statements.isEmpty()) {
            sb.append(prefix + "  (empty)\n");
        }
        return sb.toString().trim(); // trim para remover o último newline
    }
}