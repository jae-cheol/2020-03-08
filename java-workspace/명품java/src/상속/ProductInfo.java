package 상속;

import java.util.Scanner;

public class ProductInfo {
	public static void insertProduct(Product pro, int cnt, Product[] p){
		p[cnt] = new Book();
		p[cnt].write();
		p[cnt].setId(cnt);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Product[] p = new Product[10];
		int cnt = 0;
		int num;
		while(true){
			boolean b = true;
			num = Util.inputInt("\n상품 추가<1>, 모든 상품 조회<2>, 끝내기<3> >> ");
			switch(num){
			case 1 : // 상품 추가<1>
				while(b){
					if(cnt == 10){  
						System.out.println("더 이상 추가할 수 없습니다.");  
						break;
					}
					num = Util.inputInt("상품 종류 책<1>, 음악CD<2>, 회화책<3> >> ");			
					switch(num){
					case 1 : // 책<1>
						insertProduct(new Book(), cnt, p);
						break;
					case 2 : // 음악CD<2>
						insertProduct(new CompactDisc(), cnt, p);
						break;
					case 3 : // 회화책<3>
						insertProduct(new ConversationBook(), cnt, p);
						break;
					default :
						cnt--;
						b = true;
						System.out.println("다시 입력하세요.");
						break;
					}
					b = false;
					cnt++;
				}
				break;
			case 2 : // 모든 상품 조회<2>
				for(int i=0; i<cnt; i++){  p[i].info();  }
				break;
			case 3 : // 끝내기<3>
				System.exit(0);
				break;
			default :
				System.out.println("다시 입력하세요.");
				break;
			}
		}
	}
}