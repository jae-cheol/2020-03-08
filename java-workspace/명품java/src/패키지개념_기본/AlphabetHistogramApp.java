package ��Ű������_�⺻;

import java.io.IOException;
import java.io.InputStreamReader;
/*
 * ���� ���ĺ� 26�ڿ� ���� �迭�� �����.( �� ���� ���ĺ��� ������ŭ �����Ű�� ���� )
 * ��Ʈ�����۸� ����Ѵ�.(
 */
public class AlphabetHistogramApp {
	int histoData [] = new int [26]; // ���� ���ĺ� 26�ڸ� ī�����ϴ� ������ �迭
	StringBuffer sb = new StringBuffer(); // Ű �Է��� ���� ��Ʈ�� ����
	
	public AlphabetHistogramApp() {
		for(int i=0; i<histoData.length; i++)
			histoData[i] = 0; // �ʱ⿡ ī���� ���� ��� 0���� ����
	}
	
	// Ű����κ��� ���ĺ� ���ڸ� �а� ������׷��� �׸��� �ٽ� �޼ҵ�
	public void run() {
		readString();
		makeHistogram();
		drawHistogram();
	}
	
	// �Է¹��� ���ڵ�κ��� ������׷��� ����Ÿ�� �����.
	public void makeHistogram() {
		String s = sb.toString(); // ��Ʈ�� ������ ���ڿ��� ��Ʈ������ ����
		s = s.toUpperCase(); // ��Ʈ���� ��� �ҹ��ڷ� ����

		// �Էµ� ��� ���ڸ� ���Ͽ� ������ ����Ÿ�� �����.
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(c >= 'A' && c <= 'Z') { // ���ĺ� ���ڸ� ī����
				int index = c - 'A';
				histoData[index]++; // �ش��ϴ� ������ ������ ���� ��Ŵ.
			}
		}		
	}

	// ������׷��� �׸���.
	public void drawHistogram() {
		System.out.println("\n������׷��� �׸��ϴ�.");
		for(int i =0; i<histoData.length; i++) {
			System.out.print((char)('A'+ i)); //�빮�ڸ� ����Ѵ�.

			for(int j=0; j<histoData[i]; j++)
				System.out.print('-'); // �����䵥��Ÿ ������ŭ -�� ����Ѵ�.
			System.out.println();			
		}
	}
	
	// Ű����κ��� ���ڿ��� �о� ��Ʈ�� ���ۿ� �����Ѵ�.
	public void readString() {
		InputStreamReader rd = new InputStreamReader(System.in);
		try {
			while (true) {
				int c = rd.read(); //Ctrl-z�� �ԷµǸ� -1�� �����Ѵ�.
				if (c == -1) 	
					break;
				sb.append((char)c); // ���� ���ڸ� ��Ʈ�� ���ۿ� �߰��Ѵ�.
			} 
		}
		catch (IOException e) {
			System.out.println("�Է� ���� �߻�");
		}
	}
	
	public static void main(String[] args) {
		AlphabetHistogramApp app = new AlphabetHistogramApp();
		app.run();
	}

}
