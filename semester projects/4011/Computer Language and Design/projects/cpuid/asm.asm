%include "io.inc"
%include "asm_io.inc"

section .text
global CMAIN
CMAIN:
     mov eax,1
     call print_int