@echo off
CD /d "%~dp0"
nasm -f elf code.asm
gcc -o code driver.c code.o asm_io.o
code.exe
echo:
PAUSE
:: danial