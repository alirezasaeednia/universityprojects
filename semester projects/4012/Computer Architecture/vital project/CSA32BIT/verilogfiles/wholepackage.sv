module testbench2;
 logic [31:0] x,y,sum;
 logic cout,cin;

 wholeoperation me(x,y,cin,cout,sum);

initial
begin
 x=32'd10;
 y=32'd11;
cin=1'b1;

#1x=32'd2**32-1;
 y=32'd2^31+1;
cin=1'b1;

#2 x=32'd4234234;
 y=32'd432;
cin=1'b0;

#3x=32'd2**32-1;
 y=32'd2^31+9;
cin=1'b1;

#4 x=32'd855;
 y=32'd100;
cin=1'b0;

#5 x=32'd423434524;
 y=32'd532523523;
cin=1'b1;

#6x=32'd2**32-1;
 y=32'd2^31+52;
cin=1'b0;

#7x=32'd1111;
 y=32'd112;
cin=1'b1;

#8x=32'd8901;
 y=32'd322;
cin=1'b0;


#9x=31'd2**31-1;
 y=32'b1;
cin=1'b0;

#10x=32'd22;
 y=32'd3;
cin=1'b1;

#11x=32'd2**14-1;
 y=32'd1;
cin=1'b0;



end

endmodule;
