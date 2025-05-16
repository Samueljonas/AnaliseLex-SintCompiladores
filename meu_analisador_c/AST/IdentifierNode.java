// File: AST/IdentifierNode.java
package meu_analisador_c.AST;

public class IdentifierNode implements ExpressionNode {
    public String name;
    public IdentifierNode(String name) { this.name = name; }
    @Override public String toString(String prefix) { return prefix + "Identifier(" + name + ")"; }
}