package kr.co.bit.util;

import java.util.Random;

public class Rand {

	int input = 0;
	int result = 0, count = 0;
	int sss = 0, ss = 0, s = 0;
	int aaa = 0, aa = 0, a = 0;
	int bbb = 0, bb = 0, b = 0;
	int ccc = 0, cc = 0;

	int MAX_MULTIPLY = 2;
	int MAX_COUNT = 11;
	int MAX_VALUE = 1000;
	int weightArr[] = { 5, 15, 30, 60, 120, 240, 350, 500, 650, 800, 1000 };

	public int rarity_Rand() {
		int monster_select = 0;

		while (count < 1) {

			input++;
			count++;

			// if (input == (MAX_VALUE * MAX_MULTIPLY) + 1)
			// break;
			// ������ ���鼭 input�� ������Ű�µ� MAX*MAX_VALUE+1(2001��) ���� break;

			result = this.weightedRand(MAX_COUNT, weightArr, MAX_VALUE);

			// if (result == 0)
			// sss++;
			// else if (result == 1)
			// ss++;
			// else if (result == 2)
			// s++;
			// else if (result == 3)
			// aaa++;
			// else if (result == 4)
			// aa++;
			// else if (result == 5)
			// a++;
			// else if (result == 6)
			// bbb++;
			// else if (result == 7)
			// bb++;
			// else if (result == 8)
			// b++;
			// else if (result == 9)
			// ccc++;
			// else if (result == 10)
			// cc++;
			// �󸸳� ���� �ɸ����� Ȯ���ϱ� ���� �뵵(1).
			// (input == (MAX_VALUE * MAX_MULTIPLY) + 1) �κ��� �ּ������ϸ� �ش� ����ŭ �ݺ��ϰ�
			// ��踦 �� �� ����.

			int tmp = 4;
			tmp *= result;
			Random rand1 = new Random();
			int tmp2 = rand1.nextInt(5);
			// 44������ ���ϸ��� 0~11������ ������ �ش� �������� 4�� ���ϰ�,
			// �ٽ� 0~4�� ������ ���ؼ� ���� ���ϸ��� ������.
			// (ex. result(0)*4+(0~4): 0������ 4���� ���ϸ�(���� ���� ���)
			// (ex. result(10)*4+(0~4): 40������ 44���� ���ϸ�(���� ���� ���)

			monster_select = tmp + tmp2;
			if (monster_select == 44)
				monster_select -= 1;
			// 0~43�̹Ƿ� 4*10+(0~4)�� ���� ������ �� ����.
		}
		return monster_select;
	}

	public int weightedRand(int weight_size, int weight[], int max_size) {
		int rand = 0, i = 0;

		Random num = new Random();

		rand = num.nextInt(max_size);
		// 0~total������ ������ ����

		for (i = 0; i < weight_size; i++) {
			if (weight[i] > rand)
				break;
			// �迭�� ������ ������ ũ�� �ߴ��ϰ� �������� ����.
		}
		return i;
	}
}
