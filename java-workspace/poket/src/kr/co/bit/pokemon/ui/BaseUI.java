package kr.co.bit.pokemon.ui;

import java.util.Scanner;

import kr.co.bit.pokemon.service.PokemonService;

public abstract class BaseUI implements IPokemonUI {
	private Scanner sc;
	protected PokemonService service;
	
	public BaseUI() {
		sc = new Scanner(System.in);
		service = new PokemonService();
	}
	
	String scanString(String msg) {
		System.out.print(msg);
		return sc.nextLine();
	}
	int scanInt(String msg) {
		System.out.print(msg);
		int n;
		while(true){
			try{
				n = Integer.parseInt(sc.nextLine());
				break;
			}catch(NumberFormatException e){
				System.out.println("숫자만 입력해 ㅈㅎ");
			}
		}
		return n;
	}
}
