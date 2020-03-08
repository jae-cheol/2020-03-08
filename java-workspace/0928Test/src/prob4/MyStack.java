package prob4;

public class MyStack implements Stack {
	private int size;	//	������
	private int top;	//	����
	private String[] stack;	// ���þȿ� �ִ°�.
	
	// Stack ������ ������
	public MyStack(int size) {
		this.top = -1;
		this.size = size;
		this.stack = new String[size];
	}
	
	//	���ÿ� ���� ����.
	public void push(String str){
		
		//	top���� size�� ������ �� �����ϱ� size�� �ø�.
		if(top+1 >= size){
			String[] temp = new String[size+12];
			System.arraycopy(stack, 0, temp, 0, stack.length);
			size += 12;
			stack = temp;
		}
		
		//	���ÿ� ���� �ֱ����� top�� ����.
		stack[++top] = str;
	}
	
	//	���ÿ��� ���� ��.
	public String pop(){
		
		//	���� ������� null ����.
		if(this.isEmpty()) return null;
		
		// �Ⱥ������ ���ÿ��� top�� ����.
		return stack[top--];
	}
	
	//	������ �������? ������� true;
	public boolean isEmpty(){return top == -1;}
	
	//	���� stack�� ��� ����ִ��� �������ִ� �Լ�.
	public int size(){return top + 1;}
}