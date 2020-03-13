import java.io.*;
import java_cup.runtime.*;

%%
%implements java_cup.runtime.Scanner
%type Symbol
%function next_token
%class A4Scanner
%eofval{ return null;
%eofval}
%state _1,_2,_3,_4

_1 = \/\*\*([^*]|[\r\n]|(\*([^*]|[\r\n]))|(\*\*([^\/]|[\r\n])))*\*\*\/ 
_2 = \"([^\"])*\"
_3 = [0-9]+|[0-9]+\.[0-9]+
_4 = [a-zA-Z][a-zA-Z0-9]*
%%

{_1} 	 { }
{_2} 	 { return new Symbol(A4Symbol._22, yytext()); }
"IF" 		 { return new Symbol(2); }
"ELSE" 		 { return new Symbol(3); }
"WRITE" 	 { return new Symbol(4); }
"READ" 		 { return new Symbol(5); }
"RETURN" 	 { return new Symbol(6); }
"BEGIN" 	 { return new Symbol(7); }
"END" 		 { return new Symbol(8); }
"MAIN" 		 { return new Symbol(9); }
"INT" 		 { return new Symbol(10); }
"REAL" 		 { return new Symbol(11); }
";"			 { return new Symbol(12); }
","			 { return new Symbol(13); }
"("			 { return new Symbol(14); }
")"			 { return new Symbol(15); }
"+"			 { return new Symbol(16); }
"-"			 { return new Symbol(17); }
"*"			 { return new Symbol(18); }
"/"			 { return new Symbol(19); }
":="		 { return new Symbol(20); }
"=="		 { return new Symbol(21); }
"!="		 { return new Symbol(22); }
{_3}  	 { return new Symbol(A4Symbol.NUMBER, yytext()); }
{_4} { return new Symbol(A4Symbol.IDENTIFIER, yytext()); }
\r|\n|\t|" " { }
. 			 { return new Symbol(A4Symbol.ERROR); }