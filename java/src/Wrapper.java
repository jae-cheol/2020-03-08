

import java.util.ArrayList;
import java.util.List;

/*
 * Wrapper Class
 * 
 * boolean	---> Boolean
 * byte		---> Byte
 * char		---> Character
 * short	---> Short
 * int		---> Integer
 * long		---> Long
 * float	---> Float
 * double	---> Double
 */
public class Wrapper {
	public static void main(String[] args) {
		
		Integer i = null;	// 비어있다. 객체형이기때문에 null
		i = new Integer(10);	// i = 10 (X)
		System.out.println(i);
		int num = 10;
		i = num;	// 레퍼런스 타입에는 레퍼런스 타입만 들어와야 하지만, 래퍼클래스는 이게 가능!
					// 내부적으로 new Integer(num); ---> auto boxing
					// 기본자료형을 참조자료형으로 바꿔 주는 것
		
		num = 100;
		num = new Integer(100);	// 기본타입에는 기본타입만 들어가야 하지만,!!
								// = (new Integer(100).setInt()); 형태임.
								// auto unboxing : 래퍼클래스에서 인트값을 뽑아줌.
								// 참조자료형을 기본자료형으로 바꿔 주는것.
		
		List<Integer> list = new ArrayList<>();
		
		list.add(new Integer(1));	// 원래 이거.
		list.add(2);
		
		Integer data = list.get(0);
		int data2 = list.get(0);
	}
}
