package exam.code1Z0_808;

import java.util.Arrays;

public class No_136 {
	public static void main(String[] args) {
		int nums1[] = new int[3];
		int nums2[] = {1,2,3,4,5};
		nums1 = nums2;
		System.out.println(Arrays.toString(nums1));
		System.out.println(Arrays.toString(nums2));
		for(int x : nums1) {
			System.out.print(x + ":");
		}
	}
}