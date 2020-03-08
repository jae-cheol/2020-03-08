package 스태틱;

/*
 * 꼭 공유해야 하는것만 static을 써야함.
 * 이름같은 경우는 공유하는 것이 아니기 때문에 static을 쓰면 안됨.
 */
class Employee {
	String name;	// 사원명
	static int empCount;	// 총사원수
	// 생성자
	Employee(String name) {
		this.name = name;
		Employee.empCount++;	// this.empCount++; 도 가능은 하지만, static이라는것을 보여주기 위해 이렇게 해야됨.
	}
	void info() {
		System.out.println("사원명 : " + name);
//		System.out.println("지금까지 입사한 사원수 : " + Employee.empCount + "명");
		Employee.empCountInfo();
	}
	// static 메소드 안에서 non_static변수는 사용 불가
	static void empCountInfo() {
		System.out.println("총사원수 : " + Employee.empCount + "명");
	}
}

public class EmployeeMain {
	public static void main(String[] args) {
		Employee e = new Employee("홍길동");
		e.info();
		Employee e2 = new Employee("고길동");
		e2.info();
		Employee e3 = new Employee("박길동");
		e3.info();
		Employee e4 = new Employee("최길동");		
		e4.info();
		
	}
}
