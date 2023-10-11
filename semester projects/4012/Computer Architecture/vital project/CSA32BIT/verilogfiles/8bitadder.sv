module eightbitadder(x,y,cin,cout,sum);
genvar j;
input logic [7:0]x,y;
output logic [7:0] sum;
input logic cin;
logic [6:0] c;
output logic cout;
fulladder me (x[0],y[0],cin,c[0],sum[0]);
for(j=1;j<7;j=j+1)
begin
fulladder me2 (x[j],y[j],c[j-1],c[j],sum[j]);
end

fulladder me3 (x[7],y[7],c[6],cout,sum[7]);

endmodule;

