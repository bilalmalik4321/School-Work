java JLex.Main A3.lex
java java_cup.Main -parser CalcParser -symbols CalcSymbol A3.cup
javac calc.lex.java
javac CalcParser.java CalcSymbol.java CalcParserUser.java
java CalcParserUser


