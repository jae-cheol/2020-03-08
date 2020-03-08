package ¹è¿­;

import java.util.Arrays;

public class Deep_Shallow {

	public static void main(String[] args) {
		
		int[] nums = {10, 20, 30, 40, 50};
		int[] nums2;
		
		// Deep copy(±íÀºº¹»ç)
		nums2 = new int[nums.length];
//		for(int i = 0 ; i < nums.length; i++) {
//			nums2[i] = nums[i];
//		}	
//		System.arraycopy(nums, 0, nums2, 0, nums.length);
		
//		System.arraycopy(nums, 2, nums2, 0, 2);
		for(int i = 0; i < 2; i++) {
			nums2[i] = nums[i+2];
		}
		
		/*
		// Shallow copy(¾èÀºº¹»ç)
		nums2 = nums;
		*/
				
		System.out.println("nums  : " + Arrays.toString(nums));
		System.out.println("nums2 : " + Arrays.toString(nums2));
	}
}
