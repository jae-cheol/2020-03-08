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
			// 루프를 돌면서 input을 증가시키는데 MAX*MAX_VALUE+1(2001번) 돌면 break;

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
			// 얼만나 많이 걸리는지 확인하기 위한 용도(1).
			// (input == (MAX_VALUE * MAX_MULTIPLY) + 1) 부분을 주석해제하면 해당 수많큼 반복하고
			// 통계를 볼 수 있음.

			int tmp = 4;
			tmp *= result;
			Random rand1 = new Random();
			int tmp2 = rand1.nextInt(5);
			// 44마리의 포켓몬중 0~11단위로 나누어 해당 단위에서 4를 곱하고,
			// 다시 0~4의 난수를 구해서 랜덤 포켓몬을 선택함.
			// (ex. result(0)*4+(0~4): 0번부터 4번의 포켓몬(제일 높은 등급)
			// (ex. result(10)*4+(0~4): 40번부터 44번의 포켓몬(제일 낮은 등급)

			monster_select = tmp + tmp2;
			if (monster_select == 44)
				monster_select -= 1;
			// 0~43이므로 4*10+(0~4)의 값이 나왔을 때 조정.
		}
		return monster_select;
	}

	public int weightedRand(int weight_size, int weight[], int max_size) {
		int rand = 0, i = 0;

		Random num = new Random();

		rand = num.nextInt(max_size);
		// 0~total까지의 난수를 구함

		for (i = 0; i < weight_size; i++) {
			if (weight[i] > rand)
				break;
			// 배열의 값보다 난수가 크면 중단하고 난수값을 리턴.
		}
		return i;
	}
}
