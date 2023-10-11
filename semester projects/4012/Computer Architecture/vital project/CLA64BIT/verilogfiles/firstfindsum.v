        module adder2(p,cin,sum);
input cin,p;
output sum;
 assign sum=(~p&&cin)|(~cin&&p);
endmodule;



