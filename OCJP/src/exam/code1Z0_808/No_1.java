package exam.code1Z0_808;

public class No_1 {
	public static void main(String[] args) {
		String[] strs = new String[2];	// new로 공간만 잡았고, 안에는 null이 들어있음. 초기화해줘야함.
		System.out.println("0 : " + strs[0]);
		System.out.println("1 : " + strs[1]);
		int idx = 0;
		for(String s : strs) {	// 변수안써도 에러는 아님.
			strs[idx].concat(" element " + idx);	// null에 access하는것은 NPE(Null Pointer Exception)
			idx++;
		}
		for(idx = 0; idx<strs.length; idx++) {
			System.out.println(strs[idx]);
		}
	}
}
