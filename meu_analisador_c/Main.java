// File: Main.java
// File: Main.java
package meu_analisador_c;

import java_cup.runtime.Symbol;
import java.io.FileReader;
import java.io.FileWriter; // Para escrever em arquivos
import java.io.PrintWriter; // Para escrever texto formatado facilmente
import java.io.IOException; // Para tratar exceções de arquivo
import meu_analisador_c.AST.Node;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Uso: java meu_analisador_c.Main <arquivo_entrada.c>");
            return;
        }

        String inputFilePath = args[0];
        // Definir nomes para os arquivos de saída
        String tokensOutputFilePath = "tokens_output.txt";
        String astOutputFilePath = "ast_output.txt";

        try {
            System.out.println("Analisando arquivo: " + inputFilePath);
            System.out.println("------------------------------------");

            // 1. Análise Léxica (Tokenização) e salvar em arquivo
            System.out.println("Gerando tokens para: " + tokensOutputFilePath);
            try (PrintWriter tokensWriter = new PrintWriter(new FileWriter(tokensOutputFilePath))) {
                Lexer lexerForTokens = new Lexer(new FileReader(inputFilePath));
                Symbol token;
                while (true) {
                    token = lexerForTokens.next_token();
                    if (token.sym == Terminals.EOF) {
                        tokensWriter.println("EOF");
                        System.out.println("Token: EOF"); // Opcional: ainda imprimir no console
                        break;
                    }
                    String tokenString = Terminals.terminalNames[token.sym];
                    if (token.value != null) {
                        tokenString += " (" + token.value + ")";
                    }
                    tokenString += " Linha: " + (token.left + 1) + ", Coluna: " + (token.right + 1);
                    tokensWriter.println(tokenString);
                    System.out.println("Token: " + tokenString); // Opcional: ainda imprimir no console
                }
            } catch (IOException e) {
                System.err.println("Erro ao escrever arquivo de tokens: " + e.getMessage());
            }
            System.out.println("------------------------------------");

            // 2. Análise Sintática e Geração da AST e salvar em arquivo
            // Resetando o lexer ou criando nova instância para o parser
            Lexer lexerForParser = new Lexer(new FileReader(inputFilePath));
            Parser parser = new Parser(lexerForParser);

            System.out.println("Gerando AST para: " + astOutputFilePath);
            try (PrintWriter astWriter = new PrintWriter(new FileWriter(astOutputFilePath))) {
                Symbol resultSymbol = parser.parse(); // Inicia a análise

                if (resultSymbol != null && resultSymbol.value instanceof Node) {
                    Node astRoot = (Node) resultSymbol.value;
                    String astString = astRoot.toString(""); // Gera a string da AST
                    astWriter.println(astString); // Escreve no arquivo
                    System.out.println("Árvore Sintática Abstrata (AST):"); // Opcional: ainda imprimir no console
                    System.out.println(astString);
                } else {
                    String errorMsg = "Parsing falhou ou não retornou uma AST válida.";
                    astWriter.println(errorMsg);
                    System.err.println(errorMsg);
                }
            } catch (IOException e) {
                System.err.println("Erro ao escrever arquivo da AST: " + e.getMessage());
            }

            System.out.println("------------------------------------");
            System.out.println("Análise concluída com sucesso!");
            System.out.println("Tokens salvos em: " + tokensOutputFilePath);
            System.out.println("AST salva em: " + astOutputFilePath);

        } catch (Exception e) { // Exception mais genérica para pegar erros do parser também
            System.err.println("Erro durante a análise: " + e.getMessage());
            e.printStackTrace();
        }
    }
}