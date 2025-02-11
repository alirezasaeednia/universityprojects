.lookuptable
.subckt Decoder3be8 A B C D0 D1 D2 D3 D4 D5 D6 D7
.subckt NOT in out
M1 out in vdd vdd CMOSP w=2u L=0.5u
M2 out in gnd gnd CMOSN w=1u L=0.5u
c1 out gnd 0.5p
.ends NOT

.subckt NAND3 in1 in2 in3 outp vdd gnd
M7 out in1 vdd vdd CMOSP w=2u L=0.5u
M8 out in2 vdd vdd CMOSP w=2u L=0.5u
M3 out in3 vdd vdd CMOSP w=2u L=0.5u
M4 out in1 1 gnd CMOSN w=1u L=0.5u
M5 1 in2 2 gnd CMOSN w=1u L=0.5u
M6 2 in3 gnd gnd CMOSN w=1u L=0.5u
xnot out outp NOT
c2 out gnd 0.5p
.ends NAND3

vdd vdd gnd 3.3
.global vdd

XNOTA A Abar NOT
XNOTB B Bbar NOT
XNOTC C Cbar NOT

XAND0 Abar Bbar Cbar D0 vdd gnd NAND3
XAND3 Abar B C D3 vdd gnd NAND3
XAND4 A Bbar Cbar D4 vdd gnd NAND3
XAND5 A Bbar C D5 vdd gnd NAND3
XAND6 A B Cbar D6 vdd gnd NAND3

XAND1 Abar Bbar C D1 gnd gnd NAND3
XAND2 Abar B Cbar D2 0 0 NAND3
XAND7 A B C D7 0 0 NAND3
c3 out gnd 0.5p
.ends Decoder3be8

XDEC A B C D0 D1 D2 D3 D4 D5 D6 D7 Decoder3be8

.subckt SRAM datas1 writeq1 wordq1 phi2 2
.subckt NOT in out
m1 out in vdd vdd CMOSP w=2u L=0.5u
m2 out in gnd gnd CMOSN w=1u L=0.5u
c1 out gnd 0.5p
.ends NOT
.subckt AND in1 in2 out
M9 out in1 12 vdd CMOSP W=4u L=0.5u
M10 12 in2 vdd vdd CMOSP W=4u L=0.5u
M11 out in1 gnd gnd CMOSN W=1u L=0.5u
M12 out in2 gnd gnd CMOSN W=1u L=0.5u
.ends AND
M21 2 phi2bar vdd vdd CMOSP W=1u L=0.5u
M22 1 phi2bar vdd vdd CMOSP w=1u L=0.5u
M32 2 wordq1 4 gnd CMOSN w=1u L=0.5u
M42 1 wordq1 5 gnd CMOSN w=1u L=0.5u
M52 2 writeq1 6 gnd CMOSN w=1u L=0.5u
M62 1 writeq1 7 gnd CMOSN w=1u L=0.5u
M72 6 datas1 gnd gnd CMOSN w=1u L=0.5u
M82 7 datas1not gnd gnd CMOSN w=1u L=0.5u

XNOT1 datas1 datas1not NOT
XNOT2 4 5 NOT
XNOT3 5 4 NOT
XNOT4 2 10 NOT
XNOT5 10 11 NOT
XNOT7 phi2bar phi2barnot NOT
XAND1 phi2barnot 4 and_out AND
c1 out gnd 0.5p
.ends SRAM

.subckt NOT in out
m1 out in vdd vdd CMOSP w=2u L=0.5u
m2 out in gnd gnd CMOSN w=1u L=0.5u
c1 out gnd 0.5p
.ends NOT

XSRAM0 D0 D0 D0 phi2 datas1 SRAM
XSRAM1 D1 D1 D1 phi2  datas2 SRAM
XSRAM2 D2 D2 D2 phi2  datas3 SRAM
XSRAM3 D3 D3 D3 phi2  datas4 SRAM
XSRAM4 D4 D4 D4 phi2  datas5 SRAM
XSRAM5 D5 D5 D5 phi2  datas6 SRAM
XSRAM6 D6 D6 D6 phi2  datas7 SRAM
XSRAM7 D7 D7 D7 phi2  datas8 SRAM

Va A 0 PULSE(0 3.3 0n 1n 1n 10u 20u)
Vb B 0 PULSE(0 3.3 0n 1n 1n 20u 40u)
Vc C 0 PULSE(0 3.3 0n 1n 1n 40u 80u)

Vword wordq1 gnd 3.3
Vwrite writeq1 gnd PULSE(0 3.3 0n 1n 1n 80u 300u)
Vphi2 phi2 gnd PULSE(0 3.3 85u 1n 1n 120u 200u)

c1 out gnd 0.5p


.MODEL CMOSN NMOS (
+LEVEL   = 49             acm     = 3              hdif    = 0.5e-6
+VERSION = 3.1            TNOM    = 27             TOX     = 7.7E-9
+XJ      = 1E-7           NCH     = 2.3579E17      VTH0    = 0.5048265
+K1      = 0.5542796      K2      = 0.0155863      K3      = 2.3475646
+K3B     = -3.3142916     W0      = 4.145888E-5    NLX     = 1.430868E-7
)
.MODEL CMOSP PMOS (
+LEVEL   = 49             acm     = 3              hdif    = 0.5e-6
+VERSION = 3.1            TNOM    = 27             TOX     = 7.7E-9
+XJ      = 1E-7           NCH     = 8.52E16        VTH0    = -0.6897992
+K1      = 0.4134289      K2      = -5.342989E-3   K3      = 24.8361788
+K3B     = -1.4390847     W0      = 2.467689E-6    NLX     = 3.096223E-7
)

.options post
.tran 1p 500u
.end
