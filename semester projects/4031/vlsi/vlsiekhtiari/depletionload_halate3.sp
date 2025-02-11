takhlie iii

m2 vdd out out out dmosn w=1.6u l=1.6u
m1 out A 0 0 cmosn w=6.4u l=0.8u

c1 out 0 1f
vdd vdd 0 3.3
va A 0 pulse 0 3.3 0 1n 1n 10u 20u

.dc va 0 3.3 0.01

.measure dc voh find v(out) when v(A)=0
.measure dc vol find v(out) when v(A)=3.3

.measure dc vm find v(A) when v(A)=v(out) cross=1

.measure dc vil find v(A) when deriv('v(out)')=-1 cross=1
.measure dc vih find v(A) when deriv('v(out)')=-1 cross=2

.measure dc nml param='vil - vol'
.measure dc nmh param='voh - vih'

.measure dc Vth_NMOS find v(A) when I(M1)=1u
.tran 1p 100u

.options post

.MODEL DMOSN NMOS (
+LEVEL = 49             acm     = 3              hdif    = 0.5e-6
+VERSION = 3.1          TNOM    = 27             TOX     = 7.7E-9
+XJ      = 1E-7         NCH     = 2.3579E17      VTH0    = -2.5
+K1      = 0.5542796    K2      = 0.0155863      K3      = 2.3475646
+K3B     = -3.3142916   W0      = 4.145888E-5    NLX     = 1.430868E-7
+DVT0W   = 0            DVT1W   = 0              DVT2W   = 0
+DVT0    = -0.0150839   DVT1    = 1.51022E-3     DVT2    = 0.170688
+U0      = 415.8570638  UA      = 5.057324E-11   UB      = 1.496793E-18
+UC      = 2.986268E-11 VSAT    = 1.237033E5     A0      = 0.9098788
+AGS     = 0.2120181    B0      = 1.683612E-6    B1      = 5E-6
+KETA    = -4.011887E-4 A1      = 0              A2      = 1
+RDSW    = 1.156967E3   PRWG    = -8.468558E-3   PRWB    = -7.678669E-3
+WR      = 1            WINT    = 5.621821E-8    LINT    = 1.606205E-8
+XL      = -2E-8        XW      = 0              DWG     = -6.450939E-9
+DWB     = 6.530228E-9  VOFF    = -0.1259348     NFACTOR = 0.3344887
)

.MODEL CMOSN NMOS (
+LEVEL   = 49           acm     = 3              hdif    = 0.5e-6
+VERSION = 3.1          TNOM    = 27             TOX     = 7.7E-9
+XJ      = 1E-7         NCH     = 2.3579E17      VTH0    = 0.5048265
+K1      = 0.5542796    K2      = 0.0155863      K3      = 2.3475646
+K3B     = -3.3142916   W0      = 4.145888E-5    NLX     = 1.430868E-7
+DVT0W   = 0            DVT1W   = 0              DVT2W   = 0
+DVT0    = -0.0150839   DVT1    = 1.51022E-3     DVT2    = 0.170688
+U0      = 415.8570638  UA      = 5.057324E-11   UB      = 1.496793E-18
+UC      = 2.986268E-11 VSAT    = 1.237033E5     A0      = 0.9098788
+AGS     = 0.2120181    B0      = 1.683612E-6    B1      = 5E-6
+KETA    = -4.011887E-4 A1      = 0              A2      = 1
+RDSW    = 1.156967E3   PRWG    = -8.468558E-3   PRWB    = -7.678669E-3
)

.end
