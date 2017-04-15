package com.aarestu.testMain;

import java.math.RoundingMode;

public class test2 {
public static void main(String[] args) {
	/*Double f=0.0;
	Double f1=1.23454645;
	System.out.println(Math.round (f1 * 100.0) / 100.0);*/
	
	int tot=22;
	int total =5;
	float ftot=tot;
	float ftotal=total;
	float f= ftot/ftotal;
	System.out.println(f);
System.out.println(ftot%ftotal==0);
if(ftot%ftotal!=0){
	f = f + 1;
}
int finalCount = (int) f;
System.out.println("final value: "+finalCount);
}
}
