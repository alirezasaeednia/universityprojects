.decoder3be8

.subckt NOT in out
M1 out in vdd vdd CMOSP w=2u L=0.5u
M2 out in gnd gnd CMOSN w=1u L=0.5u
c1 out gnd 0.5p
.ends NOT


.subckt NAND3 in1 in2 in3 outp
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


XAND0 Abar Bbar Cbar D0 NAND3
XAND1 Abar Bbar C D1 NAND3
XAND2 Abar B Cbar D2 NAND3
XAND3 Abar B C D3 NAND3
XAND4 A Bbar Cbar D4 NAND3
XAND5 A Bbar C D5 NAND3
XAND6 A B Cbar D6 NAND3
XAND7 A B C D7 NAND3


Va A 0 3.3
Vb B 0 3.3
Vc C 0 3.3

.MODEL CMOSN NMOS (
+LEVEL   = 49             acm     = 3              hdif    = 0.5e-6
+VERSION = 3.1            TNOM    = 27             TOX     = 7.7E-9
+XJ      = 1E-7           NCH     = 2.3579E17      VTH0    = 0.5048265
+K1      = 0.5542796      K2      = 0.0155863      K3      = 2.3475646
+K3B     = -3.3142916     W0      = 4.145888E-5    NLX     = 1.430868E-7
+DVT0W   = 0              DVT1W   = 0              DVT2W   = 0
+DVT0    = -0.0150839     DVT1    = 1.51022E-3     DVT2    = 0.170688
+U0      = 415.8570638    UA      = 5.057324E-11   UB      = 1.496793E-18
+UC      = 2.986268E-11   VSAT    = 1.237033E5     A0      = 0.9098788
+AGS     = 0.2120181      B0      = 1.683612E-6    B1      = 5E-6
+CAPMOD  = 2              XPART   = 0.4            CGDO    = 1.96E-10
+CGSO    = 1.96E-10       CGBO    = 0              CJ      = 8.829973E-4
+PBSW    = 0.9890846      MJSW    = 0.1871372
)


.MODEL CMOSP PMOS (
+LEVEL   = 49             acm     = 3              hdif    = 0.5e-6
+VERSION = 3.1            TNOM    = 27             TOX     = 7.7E-9
+XJ      = 1E-7           NCH     = 8.52E16        VTH0    = -0.6897992
+K1      = 0.4134289      K2      = -5.342989E-3   K3      = 24.8361788
+K3B     = -1.4390847     W0      = 2.467689E-6    NLX     = 3.096223E-7
+DVT0W   = 0              DVT1W   = 0              DVT2W   = 0
+DVT0    = 1.3209807      DVT1    = 0.4695965      DVT2    = -8.790762E-4
+U0      = 150.6275733    UA      = 2.016943E-10   UB      = 1.714919E-18
+UC      = -1.36948E-11   VSAT    = 9.559222E4     A0      = 0.9871247
+AGS     = 0.3541967      B0      = 3.188091E-6    B1      = 5E-6
+CAPMOD  = 2              XPART   = 0.4            CGDO    = 2.307E-10
+CGSO    = 2.307E-10      CGBO    = 0              CJ      = 1.397645E-3
+PBSW    = 0.99           MJSW    = 0.3399328
)


.options post
.tran 1p 1000u
.end
