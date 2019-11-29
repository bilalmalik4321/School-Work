import java.io.*;
%%
%{    static int _5[]={0,0,0,0,0};
      public static void main(String _0[])throws Exception {
	  A2 _1 = new A2(new FileReader("A2.input"));
	  while (_1.yylex()>=0);
        FileWriter _4 = new FileWriter("A2.output");
        _4.write("identifiers: "+_5[1]+"\nkeywords: "+_5[0]+"\nnumbers: "+_5[4]+"\ncomments:"+_5[3]+"\nquotedString:"+_5[2]);
        _4.close();
    }
%}
%integer
%class A2
%state _2,_3
%%
<YYINITIAL>. {yybegin(_2);}
<_2>INT|MAIN|BEGIN|STRING|REAL|WRITE|READ|IF|ELSE|RETURN|END { _5[0]++;}
<_2>[a-zA-Z][a-zA-Z0-9]* {_5[1]++;}
<_2>\"[^\"]*\" {_5[2]++;}
<_2>"/**" {yybegin(_3);}
<_3>"**/" {yybegin(_2);_5[3]++;}
<_2>[0-9]+(\.[0-9]+)? {_5[4]++;}
\r|\n|. {}
