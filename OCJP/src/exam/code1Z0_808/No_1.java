package exam.code1Z0_808;

public class No_1 {
	public static void main(String[] args) {
		String[] strs = new String[2];	// new�� ������ ��Ұ�, �ȿ��� null�� �������. �ʱ�ȭ�������.
		System.out.println("0 : " + strs[0]);
		System.out.println("1 : " + strs[1]);
		int idx = 0;
		for(String s : strs) {	// �����Ƚᵵ ������ �ƴ�.
			strs[idx].concat(" element " + idx);	// null�� access�ϴ°��� NPE(Null Pointer Exception)
			idx++;
		}
		for(idx = 0; idx<strs.length; idx++) {
			System.out.println(strs[idx]);
		}
	}
}
