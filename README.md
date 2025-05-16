# AnaliseLex-SintCompiladores
Analise léxica e sintatica de um código em C utilizando o JFlex e CUP

Para rodar use os seguintes comandos no terminal: 
1º: javac -d . -cp ".;.\java-cup-11b.jar" @(Get-ChildItem -Filter "*.java" -Recurse -File).FullName (gera o LEXER)
2º: java -cp ".;.\java-cup-11b.jar" meu_analisador_c.Main exemplo.c (gera o AST) 

Grupo: Samuel Jonas, João Carlos, Isaac Kawan
