module mult21forcarry(i0,i1,select,out);
input logic i0, i1;
input logic select;
output logic out;
assign out=(select)?i0:i1;
endmodule
