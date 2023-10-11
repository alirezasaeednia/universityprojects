module fulladder(x,y,cin,cout,sum);
  input logic x,y,cin;
  output logic cout,sum;
  assign sum=x^y^cin;
  assign cout=(x&y)|cin&(x^y);


endmodule;

