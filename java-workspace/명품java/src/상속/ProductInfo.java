package ���;

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
			num = Util.inputInt("\n��ǰ �߰�<1>, ��� ��ǰ ��ȸ<2>, ������<3> >> ");
			switch(num){
			case 1 : // ��ǰ �߰�<1>
				while(b){
					if(cnt == 10){  
						System.out.println("�� �̻� �߰��� �� �����ϴ�.");  
						break;
					}
					num = Util.inputInt("��ǰ ���� å<1>, ����CD<2>, ȸȭå<3> >> ");			
					switch(num){
					case 1 : // å<1>
						insertProduct(new Book(), cnt, p);
						break;
					case 2 : // ����CD<2>
						insertProduct(new CompactDisc(), cnt, p);
						break;
					case 3 : // ȸȭå<3>
						insertProduct(new ConversationBook(), cnt, p);
						break;
					default :
						cnt--;
						b = true;
						System.out.println("�ٽ� �Է��ϼ���.");
						break;
					}
					b = false;
					cnt++;
				}
				break;
			case 2 : // ��� ��ǰ ��ȸ<2>
				for(int i=0; i<cnt; i++){  p[i].info();  }
				break;
			case 3 : // ������<3>
				System.exit(0);
				break;
			default :
				System.out.println("�ٽ� �Է��ϼ���.");
				break;
			}
		}
	}
}