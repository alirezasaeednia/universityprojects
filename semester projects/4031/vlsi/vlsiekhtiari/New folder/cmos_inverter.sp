invertercmos_barayeemtiazi

M1 out A 1 1 cmosp w=5u l=0.8u
M2 out A 0 0 cmosn w=5u l=0.8u

c1 out 0 0.5p
vdd 1 0 3.3
Va A 0 pulse 0 3.3 0 1n 1n 10u 20u

.dc Va 0 3.3 0.01

.measure dc voh find v(out) when v(A)=0
.measure dc vol find v(out) when v(A)=3.3

.measure dc vm find v(A) when v(A)=v(out) cross=1

.measure dc vil find v(A) when deriv('v(out)')=-1 cross=1
.measure dc vih find v(A) when deriv('v(out)')=-1 cross=2

.measure dc nml param='vil - vol'
.measure dc nmh param='voh - vih'

.measure dc Vth_NMOS find v(A) when I(M2)=1u
.measure dc Vth_PMOS find v(A) when I(M1)=-1u GOAL=1



.print dc v(a) v(out)

.tran 1p 100u

.options post

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
+KETA    = -4.011887E-4   A1      = 0              A2      = 1
+RDSW    = 1.156967E3     PRWG    = -8.468558E-3   PRWB    = -7.678669E-3
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
+KETA    = -0.0169877     A1      = 0              A2      = 1
+RDSW    = 2.443009E3     PRWG    = 0.0260616      PRWB    = 0.141561
)

.end
