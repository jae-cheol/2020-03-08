package 알고리즘;

/**
 * 사용처
 *  보물섬_2589
 *  말이되고픈원숭이
 *  미로탐색_2178
 */
class Point {
	int x;
	int y;
	int cnt;
	int ability;
	String bg;

	Point(int x, int y){
		this.x = x;
		this.y = y;
	}

	Point(int x, String bg){
		this.x = x;
		this.bg = bg;
	}

	Point(int x, int y, int cnt){
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
	
	Point(int x, int y, int cnt, int ability){
		this.x = x;
		this.y = y;
		this.cnt = cnt;
		this.ability = ability;
	}
}
