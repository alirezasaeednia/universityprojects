section .data
    format db "Cache L2 Line size: %d B, Assoc. type: %d, Cache size: %d KB.", 10, 0

section .text
    global main
    extern printf, __cpuid

_asm_main:
    push ebp
    mov ebp, esp

    push ebx
    push ecx
    push edx

    mov eax, 0x80000006
    cpuid

    mov ecx, ebx
    and ecx, 0xFF

    mov edx, ebx
    shr edx, 12
    and edx, 0x15

    mov ebx, ebx
    shr ebx, 16
    and ebx, 0xFFFF

    push ebx
    push edx
    push ecx
    push format
    call printf
    add esp, 16

    xor eax, eax
    leave
    ret