%include "io.inc"

section .text
global CMAIN
CMAIN:
    mov ebp, esp; for correct debugging
     GET_DEC 1,ax
     GET_CHAR bx
     GET_DEC 1,cx
     l0:
     cmp cx,0
     je makhraj0
     jmp l1
     
     makhraj0:
     cmp bx,'/'
     je error
     cmp bx,'%'
     je error
     jmp l1
    
         error:
     PRINT_STRING "makhraj is 0"
     
     l1:
     cmp bx,'+'
     je l2
     jmp l3
     
     l2:
     add ax,cx
     PRINT_DEC 1,ax
     jmp final
     
     l3:
     cmp bx,'-'
     je l4
     jmp l5
     
     l4:
     sub ax,cx
     PRINT_DEC 1,ax
     jmp final

     
     l5:
     cmp bx,'*'
     je l6
     jmp l7

     l6:
     mul cx
     PRINT_DEC 1,ax
     jmp final

     l7:
     cmp bx,'/'
     je l8
     jmp l9

     
     l8:
     mov edx,0   ;reseting edx because of division so edx is not a random value
     div cx
     PRINT_DEC 1,al
     NEWLINE

     jmp final
     
     l9:
     cmp bx,'%'
     je l10
     jmp l11
     
     l10:
     mov edx,0      ;reseting edx because of division so edx is not a random value
     div cx
     PRINT_DEC 1,dl
     NEWLINE
     jmp final
     
     l11:
     PRINT_STRING "amalgar vujud nadarad"
     
 
     
     final:
     
     
     
     