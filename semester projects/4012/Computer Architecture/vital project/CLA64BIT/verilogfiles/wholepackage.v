module wholepackage(x,y,firstcin,sum,PF,GF);
input logic [15:0] x,y,firstcin;
output logic [15:0] sum;
output logic PF,GF;
genvar j;
 logic [2:0] cother;
 logic [15:0] p,g;
 logic [3:0] P,G;
 logic [15:0] cin;



for(j=0;j<16;j=j+1)
begin
adder f1(x[j],y[j],p[j],g[j],firstcin[0]);  
end



calculatePG k1(p[3:0],g[3:0],P[0],G[0]);  
calculatePG k2(p[7:4],g[7:4],P[1],G[1]); 
calculatePG k3(p[11:8],g[11:8],P[2],G[2]); 
calculatePG k4(p[15:12],g[15:12],P[3],G[3]); 


thirdfloor hi(P[3:0],G[3:0],firstcin[0],cother[2:0]);  


   assign cin[0]=firstcin[0];
   assign cin[4]=cother[0];
   assign cin[8]=cother[1];
   assign cin[12]=cother[2];
   assign PF=P[0]&&P[1]&&P[2]&&P[3];
   assign GF=(G[0]&&P[1]&&P[2]&&P[3])|(G[1]&&P[2]&&P[3])|(G[2]&&P[3])|G[3];
  


 



secondcarry w1(p[3:0],g[3:0],cin[0],cin[3:1]);
secondcarry w2(p[7:4],g[7:4],cin[4],cin[7:5]);
secondcarry w3(p[11:8],g[11:8],cin[8],cin[11:9]);
secondcarry w4(p[15:12],g[15:12],cin[12],cin[15:13]);


for(j=0;j<16;j=j+1)
begin
adder2 hh(p[j],cin[j],sum[j]);
end

endmodule;

