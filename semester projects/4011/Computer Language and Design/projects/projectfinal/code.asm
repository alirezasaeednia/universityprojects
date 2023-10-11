%include "asm_io.inc"
extern _scanf

segment .data
; Write Code data here
    ms: db "rpekpkewprf[ewprfkw"
    formatin: db "%f", 0
    integer1: dd 4.89,5.95,5.8,5.9,9.9
    howmany: db "how many numbers do you want to enter?"
    %define low [integer1]
    %define high [integer1+16]
    %define lowestindex 0
    %define highestindex 4
    %define pivot 0




segment .text
        global  _asm_main
     
_asm_main:
mov ecx,5  ; dar surate taghiir eslah shavad

mov ebx,0
mov ebp,esp
l1:
fld dword[integer1+4*ebx]
inc ebx
loop l1
mov ecx,5
mov ebx,0
l2:
fstp dword [esp+4*ebx]             
mov eax, [esp+4*ebx]
call print_float
call print_nl
inc ebx
loop l2

add ebp,16                          ;BASTE BE TEDAD ANASOR TAFAVOT SHAVAD
push 0
mov ecx,highestindex

push ecx
call quicksort
ret









quicksort:
mov ebx,[esp+4]  ;ebx=4
mov ecx,[esp+8]  ;ecx=0
cmp ecx,ebx
jb l8
jmp end

end:
add esp,8
ret


l8:  
call partition
ret





partition:

mov ebx,[esp+8] ;ebx=4
mov edx,[esp+8] ;ebx=4

neg ebx
mov eax,[ebp+4*ebx]            ; pivot push shod
call print_nl
call print_float
call print_nl
push eax
mov ebx,[esp+16]
mov ecx,ebx
dec ebx
push ebx   ;i push shod
push ecx ; j push shod
jmp l9



l9:
mov ebx ,[esp]
mov ecx,[esp+20]
mov eax,ebx
call print_nl

dec ecx
mov eax,ecx
call print_nl

cmp ebx,ecx        ;ebx=j = low   ecx=high-1 =3
jbe moghayese
jmp biruneif

moghayese:
mov ebx,[esp]
neg ebx
mov ebx,[ebp+4*ebx]
mov edx,[esp+8]
mov eax,edx
call print_float
call print_nl
mov eax,ebx
call print_float
call print_nl
cmp ebx,edx
jb anjam
jmp ezafekardanej

anjam:
add dword [esp+4],1
call swap
jmp ezafekardanej


ezafekardanej:
add dword [esp],1
jmp l9




swap:
mov ebx,[esp+8] ;i raft toye ebx 
neg ebx

mov eax,[ebp+4*ebx]  ;temp=eax  a[i] raft toye eax
mov ecx,[esp+4]
neg ecx
mov ecx,[ebp+4*ecx]
mov [ebp+4*ebx],ecx
mov ecx,[esp+4]
neg ecx

mov [ebp+4*ecx],eax
mov eax,[esp+8]
call print_int
call print_nl
mov eax,[ebp]
call print_float
mov eax,[ebp-4]
call print_float

mov eax,[ebp-8]
call print_float

mov eax,[ebp-12]
call print_float

mov eax,[ebp-16]
call print_float
call print_nl


ret

biruneif:
mov eax,[esp]
call print_float
add dword [esp+4],1
mov edx,[esp+20]

mov dword [esp],edx
call swap
add esp,8

mov eax,[esp+4]

mov ebx,[esp+4]
dec eax
push ebx
push eax
call quicksort  
pop eax
pop ebx

call print_nl

call print_nl
mov ebx,[esp]
inc eax
push eax
push ebx

call quicksort   
pop eax
pop ebx



       
   
       
       
      




; FTGUPP :)