       module secondcarry(p,g,cin,cout);
input logic [3:0] p,g;
input logic cin;
output logic [2:0] cout;

assign cout[0]=(cin&&p[0])|g[0];
assign cout[1]=(cin&&p[0]&&p[1])|(g[0]&&p[1])|g[1];
assign cout[2]=(cin&&p[0]&&p[1]&&p[2])|(g[0]&&p[1]&&p[2])|(g[1]&&p[2])|g[2];
endmodule;


