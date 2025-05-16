// File: AST/ProgramNode.java
package meu_analisador_c.AST;

public class ProgramNode implements Node {
    public StatementsNode statements; // Corresponde ao corpo do main

    public ProgramNode(StatementsNode statements) {
        this.statements = statements;
    }

    @Override
    public String toString(String prefix) {
        return prefix + "Program (main body):\n" +
               statements.toString(prefix + "  ");
    }
}