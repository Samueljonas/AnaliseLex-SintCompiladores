// File: Lexer.jflex
package meu_analisador_c;

import java_cup.runtime.Symbol;
import meu_analisador_c.Terminals; // Será gerado pelo CUP

%%

%class Lexer
%public
%unicode
%cup // Indica que este lexer será usado com CUP
%line
%column

%{
  private Symbol symbol(int type) {
    return new Symbol(type, yyline + 1, yycolumn + 1);
  }
  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline + 1, yycolumn + 1, value);
  }
%}

// Ignorar espaços em branco e tabulações
Whitespace = [ \t\r\n]+

// Comentários (simples de linha)
LineComment = "//".*

// Identificadores
Identifier = [a-zA-Z_][a-zA-Z0-9_]*

// Números Inteiros
Number = [0-9]+

%%

<YYINITIAL> {
  {Whitespace}                { /* Ignorar */ }
  {LineComment}               { /* Ignorar */ }

  "int"                       { return symbol(Terminals.INT); }
  "main"                      { return symbol(Terminals.MAIN); }
  "if"                        { return symbol(Terminals.IF); }
  "print"                     { return symbol(Terminals.PRINT); } // Nosso comando print
  "return"                    { return symbol(Terminals.RETURN); }

  {Identifier}                { return symbol(Terminals.IDENTIFIER, yytext()); }
  {Number}                    { return symbol(Terminals.NUMBER, Integer.parseInt(yytext())); }

  "+"                         { return symbol(Terminals.PLUS); }
  "-"                         { return symbol(Terminals.MINUS); }
  "*"                         { return symbol(Terminals.TIMES); }
  "/"                         { return symbol(Terminals.DIVIDE); }
  "="                         { return symbol(Terminals.ASSIGN); }
  "=="                        { return symbol(Terminals.EQ); }
  "<"                         { return symbol(Terminals.LT); }
  ">"                         { return symbol(Terminals.GT); }
  "("                         { return symbol(Terminals.LPAREN); }
  ")"                         { return symbol(Terminals.RPAREN); }
  "{"                         { return symbol(Terminals.LBRACE); }
  "}"                         { return symbol(Terminals.RBRACE); }
  ";"                         { return symbol(Terminals.SEMI); }

  // Tratamento de erro para caracteres não reconhecidos
  .                           { System.err.println("Caractere ilegal <"+ yytext() + "> na linha " + (yyline+1) + ", coluna " + (yycolumn+1) ); }
}