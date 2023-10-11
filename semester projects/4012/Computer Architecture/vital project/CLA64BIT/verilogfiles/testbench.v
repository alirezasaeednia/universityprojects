module testbenchforcarrylookahead;
logic [63:0] x,y,firstcin;
logic [63:0] sum;
logic  [3:0]PF,GF;
logic  sixfbitP,sixfbitG;
logic [2:0] finalcarry;
logic cout;




 wholepackage me9(x[15:0],y[15:0],firstcin[15:0],sum[15:0],PF[0],GF[0]);

assign  finalcarry[0]=(firstcin[0]&&PF[0])|GF[0];

 wholepackage me4(x[31:16],y[31:16],finalcarry[0],sum[31:16],PF[1],GF[1]);

assign  finalcarry[1]=(finalcarry[0]&&PF[0]&&PF[1])|(GF[0]&&PF[1])|GF[1];

 wholepackage me5(x[47:32],y[47:32],finalcarry[1],sum[47:32],PF[2],GF[2]);

assign  finalcarry[2]=(finalcarry[1]&&PF[0]&&PF[1]&&PF[2])|(GF[0]&&PF[1]&&PF[2])|(GF[1]&&PF[2])|GF[3];

 wholepackage me6(x[63:48],y[63:48],finalcarry[2],sum[63:48],PF[3],GF[3]);

calculatePG finally(PF,GF,sixfbitP,sixfbitG);

assign cout=(firstcin[0]&&sixfbitP)|sixfbitG;
initial
begin



 x=16'd57;
 y=16'd24342;
 firstcin=16'b1;


//#30 x=64'd5345345357;
//#30 y=64'd54521454342;
//#30 firstcin=64'b1;

 #1 x=16'd23211;
  y=16'd24382;
  firstcin=16'd1;

#2 x=64'd24211;
#2 y=64'd212;
#2 firstcin=64'd1;

#3 x=64'd3;
 y=64'd22;
 firstcin=64'd1;

#3 x=64'd522222222222227;
 y=64'd2413252353342;
 firstcin=64'b1;

#3.5 x=64'd2**63+1;
 y=64'd2**63-1;
 firstcin=64'b0;

#4 x=64'd634636363457;
 y=64'd2234254342;
 firstcin=64'b0;

#5 x=64'd6346326363457;
 y=64'd2234254342;
 firstcin=64'b1;

#6 x=64'd113123213326363457;
 y=64'd22543525254342;
 firstcin=64'b1;

#6.5 x=64'd2**63+5;
 y=64'd2**63-1;
 firstcin=64'b0;

#7
x=64'd17;
 y=64'd2;
firstcin=64'b1;

#8
x=64'd2**63-1;
 y=64'd1;
firstcin=64'b0;




end


endmodule;

