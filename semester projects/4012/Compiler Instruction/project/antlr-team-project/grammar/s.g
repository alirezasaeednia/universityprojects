grammar s;

// parser

options {
    backtrack=true;
    // please comment it in for correct lexer generation!
    // the definitions of many operators require backtracking!
} 

start	:	blocks* EOF//s* EOF 
;

blocks	:	 function_def |BOPEN block BCLOSE | block 
	;

block	:	statements 
	;
	
statements
	:	statement statement*
	;
	
statement
	:	assign_st SEMI | if_st | function_st | while_st |do_st |for_st |switch_st
	;
	
switch_st
	: SWITCH LOPEN ID LCLOSE BOPEN case_st* BCLOSE	
	;
case_st	:	CASE LOPEN no LCLOSE BOPEN statements BCLOSE 
	;
for_st	:	FOR LOPEN(init? SEMI condition? SEMI assign_st?)LCLOSE BOPEN statements BCLOSE
	;
init	:	 assign_st w	
	;
w	:	(','assign_st)*
	;
while_st:	WHILE LOPEN condition LCLOSE BOPEN statements BCLOSE 
	;

do_st	:	DO LOPEN condition LCLOSE BOPEN statements BCLOSE
	;
function_def
	:	FUNCTION type ID LOPEN def_params LCLOSE BOPEN block (RETURN(no|STRING|ID) SEMI)?  BCLOSE
	;
def_params
	:	(type ID) m|
	;
m	:	(','(type ID))* |
	;
	
function_st
	:	ID LOPEN params LCLOSE SEMI?
	;
params	:	(e|STRING) f|
	;
f	:	(','(e|STRING))* 
	;
	
if_st:		IF LOPEN condition LCLOSE BOPEN statements BCLOSE (else_if_st)* (else_st)?
	;

else_if_st
	:	ELIF LOPEN condition LCLOSE BOPEN statements BCLOSE 
	;
	
else_st	:	ELSE BOPEN statements BCLOSE
	;
	
condition
	:	condition2 c | LOPEN condition2 LCLOSE c
	;
c	:	(b_op condition2)* | (b_op LOPEN condition2 LCLOSE)*
	;
	
b_op	:	B_AND|B_OR
	;
	
condition2
	:	e conOp e	
	;

e	:	(g (op g)*) 
	;
	

g	:	'-'?(ID|no)(COPEN e CCLOSE)* |LOPEN g (op g)* LCLOSE 
	;

assign_st
	:	type  ID r | ID (COPEN e CCLOSE)* r
	;	
	
r	:	ASSIGN v |
	;
	
v	:	'{'e n'}'|e | '{' v(',' v)* '}'
	;
	
n	:	(',' e)*
	;

type	:	type1 (COPEN CCLOSE)*
	;
	
type1	:	T_INT|T_FLOAT|T_CHAR|T_STRING	
	;
	
no	:	INT|FLOAT
	;
op	:	POWER|REM|PLUS|SUB|MULTIPLY|DIVIDE|SLL|SRL|AND|OR|XOR
	;
	
conOp	:	NEQ|EQ|GT|GEQ|LT|LEQ|B_AND|B_OR
	;


s	:	ID|INT|FLOAT|STRING|CHAR|SWITCH|CASE|ELIF|ELSE|WHILE|DO|FOR|FUNCTION|RETURN|T_INT|
		T_FLOAT|T_CHAR|T_STRING|SEMI|POWER|REM|PLUS|SUB|MULTIPLY|DIVIDE|ASSIGN|SLL|SRL|AND|OR|XOR|
		B_AND|B_OR|LOPEN|LCLOSE|BOPEN|BCLOSE|EQ|GT|GEQ|LT|LEQ|NEQ|COPEN|CCLOSE
	 ;
	 
//lexer


//KeyWords


//branches
SWITCH	:	'switch' 
	;
	
CASE	:	'case'
	;
	
IF	:	'if'
	;
ELIF	:	'elif'
	;
ELSE	:	'else'
	;
//conditions

EQ	:	'=='
	;
GT	:	'>'
	;
GEQ	:	'>='
	;

LT	:	'<'
	;
	
LEQ	:	'<='
	;

NEQ	:	'!='
	;



//loops

WHILE	:	'while'
	;
	
DO	:	'do'
	;
	
FOR	:	'for'
	;

//functions

FUNCTION:	'function'
	;
	
RETURN	:	'return'
	;
	
//Types

T_INT	:	'int'
	;
	
T_FLOAT	:	'float'
	;
	
T_CHAR	:	'char'
	;
	
T_STRING:	'string'
	;
	
// statement END

SEMI	:	';'
	;
	
// Arithmatic operand


POWER	:	'^^'
	;

REM	:	'%'
	;	
	
PLUS	:	'+'
	;
	
SUB	:	'-'
	;

MULTIPLY:	'*'
	;
	
DIVIDE	:	'/'
	;

ASSIGN	:	'='
	;
	
//Bitwise operand
	
SLL	:	'<<'
	;

SRL	:	'>>'
	;

AND	:	'&'
	;

OR	:	'|'
	;

XOR	:	'^'
	;

//Bolean operand

B_AND	:	'&&'
	;
B_OR	:	'||'
	;


//Seperator

LOPEN	:	'('
	;
	
LCLOSE	:	')'
	;
BOPEN	:	'{'
	;
	
BCLOSE	:	'}'
	;
	
COPEN	:	'['
	;
	
CCLOSE	:	']'
	;
	

ID  :	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
    ;

INT :	 '0'..'9'+
    ;

FLOAT
    :   ('0'..'9')+ '.' ('0'..'9')* EXPONENT?
    |   '.' ('0'..'9')+ EXPONENT?
    |   ('0'..'9')+ EXPONENT
    ;

COMMENT
    :   '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    |   '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
    ;

WS  :   ( ' '
        | '\t'
        | '\r'
        | '\n'
        ) {$channel=HIDDEN;}
    ;

STRING
    :  '"' ( ESC_SEQ | ~('\\'|'"') )* '"'
    ;

CHAR:  '\'' ( ESC_SEQ | ~('\''|'\\') ) '\''
    ;

fragment
EXPONENT : ('e'|'E') ('+'|'-')? ('0'..'9')+ ;

fragment
HEX_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F') ;

fragment
ESC_SEQ
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    |   UNICODE_ESC
    |   OCTAL_ESC
    ;

fragment
OCTAL_ESC
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;

fragment
UNICODE_ESC
    :   '\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
    ;
