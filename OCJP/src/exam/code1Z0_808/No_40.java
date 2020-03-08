package exam.code1Z0_808;
/*
 * Lambda expression's signature
 * (T) -> boolean
 * 
 * Predicate<T>
 * (T) -> boolean
 * boolean test(T t);

 */
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

class Person {
	String name;
	int age;
	
	public Person(String n, int a) {
		name = n;
		age = a;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
public class No_40 {

	public static void checkAge(List<Person> list, Predicate<Person> predicate) {
		for(Person p : list) {
			if(predicate.test(p)) {
				System.out.println(p.name + " ");
			}
		}
	}
	public static void main(String[] args) {
		List<Person> iList = Arrays.asList(
				new Person("Hank", 45),
				new Person("c", 40),
				new Person("S", 38)
				);
		//checkAge(iList, ()->p.getAge()>40);
		//checkAge(iList, Person p->p.getAge()>40);
		checkAge(iList, p->p.getAge()>40);
		//checkAge(iList, (Person p)->{p.getAge()>40;});
	}

}
