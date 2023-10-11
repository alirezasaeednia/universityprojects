        module calculatePG(p,g,P,G);
input logic [3:0] p,g;
output logic P,G;
assign P=p[0]&&p[1]&&p[2]&&p[3];
assign G=(g[0]&&p[1]&&p[2]&&p[3])|(g[1]&&p[3]&&p[2])|(g[2]&&p[3])|g[3];
endmodule;

