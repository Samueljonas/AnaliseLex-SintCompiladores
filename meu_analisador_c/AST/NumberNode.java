// File: AST/NumberNode.java
// File: AST/NumberNode.java
package meu_analisador_c.AST;

public class NumberNode implements ExpressionNode {
    public int value;
    public NumberNode(int value) { this.value = value; }
    @Override public String toString(String prefix) {
        // O prefixo já contém o rótulo (ex: "  L: ", "  Value: ")
        return prefix + "Number(" + value + ")";
    }
}