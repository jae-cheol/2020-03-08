import java.time.LocalDate;

public class ForEach {
	public static void main(String[] args) {
		LocalDate date = LocalDate.of(2012, 01, 31);
		String s = "";
		date.plusDays(10);
		System.out.println( date.plusDays(10) );
		System.out.println(date);
	}
}
