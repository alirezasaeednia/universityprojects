module adder(x,y,p,g,cin);
input x,y,cin;
output p,g;
assign p=(~x&&y)|(~y&&x);
and (g,x,y);


endmodule;

