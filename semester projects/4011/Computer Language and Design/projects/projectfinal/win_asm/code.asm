%include "asm_io.inc"
extern _scanf
extern _printf


segment .data

number: dd 1,2,-3,-5,-6,-7
    len: equ ($-number)/4



segment .text
        global  _asm_main
        
        
  
    ; Exit application.
    ;mov edi, 0
 
        

_asm_main:
mov eax,len
mov ecx,eax
mov ebx,0
mov ebp,esp
mov edx,0
l2:
mov eax,[number+4*edx]
mov [esp+4*ebx],eax             
mov eax, [esp+4*ebx]

inc ebx
inc edx

loop l2
mov eax,len
dec eax
mov ebx,4
mul ebx
add ebp,eax
mov eax,[ebp]
call print_int

       
 
     

    
     