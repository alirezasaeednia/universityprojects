%include "asm_io.inc"
extern _scanf

segment .data
; Write Code data here
    integer1: dd -33.4,-4.0,14.1,12.3,0.3333,5.1,-11.2345
        garbage: db "sss dddd eeeeeee dd aaa dsds ee dddd?"
        spacex: db " "


    len: equ ($-integer1)/4



segment .text
        global  _asm_main
_asm_main:

mov eax,len
mov edx,0
mov ebx,10

div ebx
mov eax,edx
inc eax

mov ecx,eax  ; dar surate taghiir eslah shavad

mov ebx,0
mov ebp,esp
mov edx,0
l2:
mov eax,[integer1+4*edx]
mov [esp+4*ebx],eax             
mov eax, [esp+4*ebx]

inc ebx
inc edx

loop l2
mov eax,[ebp]



mov eax,len
mov edx,0
mov ebx,10

div ebx
mov eax,edx
mov ebx,4
mul ebx
add ebp,eax                          ;BASTE BE TEDAD ANASOR TAFAVOT SHAVAD

push 0
push 0
mov eax,len
mov edx,0
mov ebx,10
div ebx
mov eax,edx
mov ecx,eax
push ecx
call quicksort
add esp,12

call printarray

ret


quicksort:
mov ebx,[esp+4]  ;ebx=4
mov ecx,[esp+8]  ;ecx=0

cmp ecx,ebx
Jl l8
ret

;oke

   


l8:  
call partition

add dword [esp+12],-1
push 0
push dword [esp+12]
push dword [esp+20]

call quicksort
add esp,12

add dword [esp+12],1
push 0
push dword [esp+16]
push dword [esp+12]


call quicksort

add esp,12
ret





partition:

mov ebx,[esp+8] ;ebx=4  ; high raft toye ebx

neg ebx
mov eax,[ebp+4*ebx]              

push eax  ; pivot push shod
mov ebx,[esp+16]
mov ecx,ebx
dec ebx

push ebx   ;i push shod
push ecx ; j push shod


l9:

mov ebx ,[esp]
mov ecx,[esp+20]


dec ecx


cmp ebx,ecx        ;ebx=j = low   ecx=high-1 =3
JlE moghayese

jmp biruneif


moghayese:
mov ebx,[esp]
neg ebx
mov ebx,[ebp+4*ebx]
mov eax,ebx
mov edx,[esp+8]


cmp ebx,0
jl checkdovomi
jmp dovomimanfieyanna

checkdovomi:
cmp edx,0
jl joftmanfi
jmp yekimanfi

dovomimanfieyanna:
cmp edx,0
jl yekimanfi
jmp yekimanfi

yekimanfi:
cmp ebx,edx
jle anjam
jmp ezafekardanej

joftmanfi:
neg ebx
neg edx
cmp ebx,edx
jbe anjam
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
mov ecx,[esp+4]   ; j raft toye ecx
neg ecx
mov ecx,[ebp+4*ecx]  ; ecx=a[j]
mov [ebp+4*ebx],ecx
mov ecx,[esp+4]  ; j raft toye ecx
neg ecx

mov [ebp+4*ecx],eax  ; temp raft toye a[j]


ret

biruneif:

add dword [esp+4],1

mov edx,[esp+20]

mov dword [esp],edx

call swap
mov eax,[esp+4]
add esp,12

mov dword [esp+16],eax


ret

printarray:
mov eax,len
mov edx,0
mov ebx,10
div ebx
mov eax,edx

mov ecx,eax 
mov ebx,1

okok:
dec ebx
mov eax,[ebp+4*ebx]
call print_float
mov eax,spacex
call print_string
dec ecx
cmp ecx,-1

jnz okok
ret


       





