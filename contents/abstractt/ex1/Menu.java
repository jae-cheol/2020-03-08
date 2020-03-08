package contents.abstractt.ex1;

public class Menu {

	public void print(int no) {

		Printer p = null;
		switch(no) {
		case 1 : 
			p = new LGPrinter();
			break;
		case 2 : 
			p = new SamsungPrinter();
			break;
		}
		
		if(p != null) {
			p.print();
		} else {
			System.out.println("잘못 선택하였습니다.");
		}
//		
//		switch(no) {
//		case 1 : 
//			LGPrinter lg = new LGPrinter();
//			lg.print();
//			break;
//		case 2 : 
//			SamsungPrinter sam = new SamsungPrinter();
//			sam.print();
//			break;
//		}
//		
//		switch(no) {
//		case 1 : 
//			LGPrinter lg = new LGPrinter();
//			lg.lgPrint();
//			break;
//		case 2 : 
//			SamsungPrinter sam = new SamsungPrinter();
//			sam.samPrint();
//			break;
//		}
	}

}
