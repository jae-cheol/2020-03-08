package prob4;

public class MyStack implements Stack {
	private int size;	//	사이즈
	private int top;	//	높이
	private String[] stack;	// 스택안에 넣는값.
	
	// Stack 사이즈 생성자
	public MyStack(int size) {
		this.top = -1;
		this.size = size;
		this.stack = new String[size];
	}
	
	//	스택에 값을 넣음.
	public void push(String str){
		
		//	top보다 size가 높으면 더 못들어가니깐 size를 늘림.
		if(top+1 >= size){
			String[] temp = new String[size+12];
			System.arraycopy(stack, 0, temp, 0, stack.length);
			size += 12;
			stack = temp;
		}
		
		//	스택에 값을 넣기전에 top을 높임.
		stack[++top] = str;
	}
	
	//	스택에서 값을 뺌.
	public String pop(){
		
		//	만약 비었으면 null 리턴.
		if(this.isEmpty()) return null;
		
		// 안비었으면 스택에서 top을 낮춤.
		return stack[top--];
	}
	
	//	스택이 비었는지? 비었으면 true;
	public boolean isEmpty(){return top == -1;}
	
	//	현재 stack에 몇개가 들어있는지 설명해주는 함수.
	public int size(){return top + 1;}
}