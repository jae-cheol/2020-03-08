package HW11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Member implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5261727483109340L;
	private String name;
	private String id;
	private String phone;

	public static Member jsonParse(String filename) {
		String[] sub = new String[3];
		try (FileReader fr = new FileReader("iotest/" + filename); BufferedReader br = new BufferedReader(fr);) {

			String data = br.readLine();
			int[] arr = new int[6];
			int idx = data.indexOf("\"");
			int loc = 0;
			while (idx != -1) {
				arr[loc++] = idx;
				idx = data.indexOf("\"", idx + 1);
			}
			loc = 0;
			for (int i = 0; i < arr.length; i = i + 2) {
				sub[loc] = data.substring(arr[i] + 1, arr[i + 1]);
				System.out.println(sub[loc++]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Member(sub[0], sub[1], sub[2]);
	}

	public static ArrayList<Member> jsonParseArray(String filename) {
		String[] sub = new String[12];
		List<Member> list = new ArrayList<>();
		try (FileReader fr = new FileReader("iotest/" + filename); BufferedReader br = new BufferedReader(fr);) {

			
			String data = br.readLine();
			
			int[] arr = new int[24];
			int idx = data.indexOf("\"");
			int loc = 0;
			while (idx != -1) {
				arr[loc++] = idx;
				idx = data.indexOf("\"", idx + 1);
			}
			loc = 0;
			for (int i = 0; i < arr.length; i = i + 2) {
				sub[loc] = data.substring(arr[i] + 1, arr[i + 1]);
				System.out.println(loc);
				System.out.println(sub[loc++]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ArrayList<Member>();
	}

	public Member() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", id=" + id + ", phone=" + phone + "]";
	}

	public Member(String name, String id, String phone) {
		this.name = name;
		this.id = id;
		this.phone = phone;
	}

	public void jsonSave() {
	}
}
