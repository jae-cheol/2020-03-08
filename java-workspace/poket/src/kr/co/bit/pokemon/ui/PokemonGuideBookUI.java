package kr.co.bit.pokemon.ui;

import java.util.List;

import kr.co.bit.pokemon.vo.PokemonVO;
import kr.co.bit.pokemon.vo.UserInfoVO;

public class PokemonGuideBookUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		List<PokemonVO> list = service.selectPokemonBookList();

		System.out.println("도감 포켓몬 목록 : " + list.size() + " 마리");
		System.out.println("-------------------------------------------------------");
		System.out.println("이름\t공격력\t방어력\t가격\t희귀도\t체력");
		System.out.println("-------------------------------------------------------");
		for (PokemonVO p : list) {
			System.out.println(p.getName() + "\t" + p.getOffensive() + "\t" + p.getDefensive() + "\t" + p.getPrice()
					+ "\t" + p.getRarity() + "\t" + p.getLife());
		}
		UserInfoVO ui = service.money();
		if (list.isEmpty()) {
			System.out.println("포켓몬을 잡은 적이 없군요. 사냥을 떠나봐요!");
			System.out.println("-------------------------------------------------------");
		}

	}

}
