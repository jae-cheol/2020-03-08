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
//		ct.cm();	//	calltest()�� �ִ� cm()�� ����.
//		ct.i += o.cm();
//		ct.i += o.dm();
		System.out.println(ct.i);
	}
}


// private : �ƹ��� ���ǵ�
// default : ���� ��Ű���� �� �ǵ� �� ����
// protected : �ٸ� ��Ű���� �־ ��� ���� ���� ����
// public : �ƹ��� �ٰǵ�