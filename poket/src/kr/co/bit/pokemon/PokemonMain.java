package kr.co.bit.pokemon;

import kr.co.bit.pokemon.ui.PokemonUI;

public class PokemonMain {

	public static void main(String[] args) {
		
		try {
			PokemonUI ui = new PokemonUI();
			ui.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
