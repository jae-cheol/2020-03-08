package contents.casting;

public class CastMain02 {

	public static void main(String[] args) {
		
		// ����������ȯ(�ڵ�ĳ����) : �������� ū�Ϳ� ������
			// ������ - ��Ӱ����� ����Ŭ����
			// ū�� - ��Ӱ����� ����Ŭ����
		// ����������ȯ(����ĳ�����������) : ū���� �����Ϳ� ������ - ����������ȯ
		// �̷��������� �����Ͽ����� �߻���.
		
		// ū�Ϳ� �������� ����.
		Parent p = new Child01();	// ����������ȯ
		p.info();	// *�������̵�� �޼ҵ��� �ڽĲ� ȣ����.
		System.out.println(p.name);	// �θ� �ʵ带 ȣ����.
		System.out.println(p.age);	// �θ� �ʵ带 ȣ����.
		
		// �����Ϳ� ū���� �������� ������ ����ȯ
		Child01 c = (Child01)p;		// ����������ȯ
				
		c.info();
		c.sleep();
		c.study();
		
	}
}