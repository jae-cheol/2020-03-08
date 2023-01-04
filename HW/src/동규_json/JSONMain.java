package 동규_json;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

class Field{
	private String fieldName;
	private String value;
	public Field(String fieldName, String value) {
		super();
		this.fieldName = fieldName;
		this.value = value;
	}
	@Override
	public String toString() {
		return "Field [fieldName=" + fieldName + ", value=" + value + "]";
	}
	public String getFieldName() {return fieldName;}
	public void setFieldName(String fieldName) {this.fieldName = fieldName;}
	public String getValue() {return value;}
	public void setValue(String value) {this.value = value;}
}

class Member{
	private String name;
	private String id;
	private String phone;
	public Member(String name, String id, String phone) {
		super();
		this.name = name;
		this.id = id;
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Member [name=" + name + ", id=" + id + ", phone=" + phone + "]";
	}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getId() {return id;}
	public void setId(String id) {this.id = id;}
	public String getPhone() {return phone;}
	public void setPhone(String phone) {this.phone = phone;}
	
	private static Field[] parseField(String data){
		StringBuilder sb = new StringBuilder(data);
		if(sb.charAt(sb.length()-1) == ',') sb.deleteCharAt(sb.length()-1);
		sb = new StringBuilder(sb.subSequence(1, sb.length()-1));
		String[] token = sb.toString().split(",");
		Field[] fields = new Field[token.length];
		for(int i=0;i<token.length;i++){
			String[] ts = token[i].split(":");
			ts[1] = ts[1].trim();
			fields[i] = new Field(ts[0].trim(), ts[1].substring(1,ts[1].length()-1));
		}
		return fields;
	}
	
	public static Member jsonParse(String fileName){
		Member m = null;
		String name=null, id=null, phone=null;
		try(
			FileReader rd = new FileReader(fileName);
			BufferedReader bf = new BufferedReader(rd);
		){
			Field[] fields = parseField(bf.readLine());
			for(Field f : fields){
				switch(f.getFieldName()){
				case "name" :
					name = f.getValue();
					break;
				case "id" :
					id = f.getValue();
					break;
				case "phone" :
					phone = f.getValue();
					break;
				}
			}
			m = new Member(name, id, phone);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return m;
	}
	
	public static ArrayList<Member> jsonParseArray(String fileName){
		ArrayList<Member> list = new ArrayList<Member>();
		try(
				FileReader rd = new FileReader(fileName);
				BufferedReader bf = new BufferedReader(rd);
			){
				while(true){
					String name = null, id = null, phone = null;
					StringBuilder sb = new StringBuilder(bf.readLine());
					if(sb.charAt(0) == '[') sb.deleteCharAt(0);
					if(sb.charAt(sb.length()-1) == ']') sb.deleteCharAt(sb.length()-1);
					Field[] fields = parseField(sb.toString());
					for(Field f : fields){
						switch(f.getFieldName()){
						case "name" :
							name = f.getValue();
							break;
						case "id" :
							id = f.getValue();
							break;
						case "phone" :
							phone = f.getValue();
							break;
						}
					}
					list.add(new Member(name, id, phone));
				}
				
			} catch (Exception e) {
				System.out.println("JSON array parsing 완료!");
			}
		return list;
	}
}

public class JSONMain {
	public static void main(String[] args){
		Member m = Member.jsonParse("iotest/json.txt");
		System.out.println("파일 데이터 객체 출력");
		System.out.println(m);
		
		ArrayList<Member> list = Member.jsonParseArray("iotest/json2.txt");
	    for(Member mem : list)  System.out.println(mem);
	}
}
