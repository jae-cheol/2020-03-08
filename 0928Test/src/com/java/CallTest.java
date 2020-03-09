package com.java;

import com.java.util.CommonUtil;

public class CallTest extends CommonUtil{
	int i = 1;
	CallTest() {
		this.i=2;
	}
	public static void main(String[] args) {
		CommonUtil o = new CommonUtil();
		CallTest ct = new CallTest();
//		ct.i += o.am();
//		ct.i += o.bm();
//		ct.cm();	//	calltest()에 있는 cm()은 가능.
//		ct.i += o.cm();
//		ct.i += o.dm();
		System.out.println(ct.i);
	}
}


// private : 아무도 못건듬
// default : 같은 패키지는 다 건들 수 있음
// protected : 다른 패키지에 있어도 상속 받은 놈은 가능
// public : 아무나 다건듬