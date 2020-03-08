

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
		
		Integer i = null;	// ����ִ�. ��ü���̱⶧���� null
		i = new Integer(10);	// i = 10 (X)
		System.out.println(i);
		int num = 10;
		i = num;	// ���۷��� Ÿ�Կ��� ���۷��� Ÿ�Ը� ���;� ������, ����Ŭ������ �̰� ����!
					// ���������� new Integer(num); ---> auto boxing
					// �⺻�ڷ����� �����ڷ������� �ٲ� �ִ� ��
		
		num = 100;
		num = new Integer(100);	// �⺻Ÿ�Կ��� �⺻Ÿ�Ը� ���� ������,!!
								// = (new Integer(100).setInt()); ������.
								// auto unboxing : ����Ŭ�������� ��Ʈ���� �̾���.
								// �����ڷ����� �⺻�ڷ������� �ٲ� �ִ°�.
		
		List<Integer> list = new ArrayList<>();
		
		list.add(new Integer(1));	// ���� �̰�.
		list.add(2);
		
		Integer data = list.get(0);
		int data2 = list.get(0);
	}
}
