package 코딩테스트.Part1.Ch04_배열;

public class 연습해보기2 {
	public static void main(String[] args) {
		String dataset[] = { "Braund, Mr. Owen Harris", "Cumings, Mrs. John Bradley (Florence Briggs Thayer)",
				"Heikkinen, Miss. Laina", "Futrelle, Mrs. Jacques Heath (Lily May Peel)", "Allen, Mr. William Henry",
				"Moran, Mr. James", "McCarthy, Mr. Timothy J", "Palsson, Master. Gosta Leonard",
				"Johnson, Mrs. Oscar W (Elisabeth Vilhelmina Berg)", "Nasser, Mrs. Nicholas (Adele Achem)",
				"Sandstrom, Miss. Marguerite Rut", "Bonnell, Miss. Elizabeth", "Saundercock, Mr. William Henry",
				"Andersson, Mr. Anders Johan", "Vestrom, Miss. Hulda Amanda Adolfina",
				"Hewlett, Mrs. (Mary D Kingcome) ", "Rice, Master. Eugene", "Williams, Mr. Charles Eugene",
				"Vander Planke, Mrs. Julius (Emelia Maria Vandemoortele)", "Masselmani, Mrs. Fatima",
				"Fynney, Mr. Joseph J", "Beesley, Mr. Lawrence", "McGowan, Miss. Anna", "Sloper, Mr. William Thompson",
				"Palsson, Miss. Torborg Danira", "Asplund, Mrs. Carl Oscar (Selma Augusta Emilia Johansson)",
				"Emir, Mr. Farred Chehab", "Fortune, Mr. Charles Alexander", "Dwyer, Miss. Ellen",
				"Todoroff, Mr. Lalio" };
		
		int res = 0;
		for(String d : dataset) {
			if(d.indexOf("M") > 0) {
				res++;
			}
		}
		System.out.println(res);
	}
}
