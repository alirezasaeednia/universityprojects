module wholeoperation(x,y,cin,finalcout,sum);
input logic [31:0]x,y;
output logic [31:0] sum;
input logic cin;
output logic finalcout;


logic cout1;
logic cout2;
logic cout3;
logic coutforlower16bit;


logic cout21,cout22;
logic cout31,cout32;

logic [39:0] sum2;
logic [39:0] sum3;

eightbitadder me(x[7:0],y[7:0],cin,cout,sum[7:0]); //first adder

eightbitadder me1(x[15:8],y[15:8],1'b1,cout2,sum2[15:8]); //laye payini 
eightbitadder me2(x[15:8],y[15:8],1'b0,cout3,sum3[15:8]); //laye balayi


mult218bits hey2(sum2[15:8],sum3[15:8],cout,sum[15:8]); //making sum[15:0]


mult21forcarry hey3(cout2,cout3,cout,coutforlower16bit);

eightbitadder me12(x[23:16],y[23:16],1'b1,cout21,sum2[23:16]); //laye payini 8 bit seri dovom

eightbitadder me13(x[23:16],y[23:16],1'b0,cout31,sum3[23:16]); //laye balayi 8 bit seri dovom


mult218bits hey4 (sum2[23:16],sum3[23:16],coutforlower16bit,sum[23:16]);


eightbitadder me14(x[31:24],y[31:24],1'b1,cout22,sum2[31:24]); //laye payini 8 bit seri dovom

eightbitadder me15(x[31:24],y[31:24],1'b0,cout32,sum3[31:24]); //laye balayi 8 bit seri dovom

mult218bits muxpayin (sum2[31:24],sum3[31:24],cout21,sum2[39:32]);

mult218bits muxbala (sum2[31:24],sum3[31:24],cout31,sum3[39:32]);


mult218bits finalmuxforsum (sum2[39:32],sum3[39:32],coutforlower16bit,sum[31:24]);

mult21forcarry muxbalayi(cout22,cout32,cout21,coutuppermux);

mult21forcarry muxpayini(cout22,cout32,cout31,coutdownermux);

mult218bits finalmuxforcarry (coutuppermux,coutdownermux,coutforlower16bit,finalcout);


endmodule;