// File: AST/DeclarationNode.java
package meu_analisador_c.AST;

public class DeclarationNode implements StatementNode {
    public String type; // "int"
    public IdentifierNode identifier;

    public DeclarationNode(String type, IdentifierNode identifier) {
        this.type = type;
        this.identifier = identifier;
    }

    @Override
    public String toString(String prefix) {
        return prefix + "Declaration(type=" + type + ")\n" +
               identifier.toString(prefix + "  ID: ");
    }
}