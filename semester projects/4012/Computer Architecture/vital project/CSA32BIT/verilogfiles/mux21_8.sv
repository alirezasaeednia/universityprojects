module mult218bits(i0,i1,select,out);
input logic [7:0] i0, i1;
input logic select;
output logic[7:0] out;
assign out=(select)?i0:i1;
endmodule
