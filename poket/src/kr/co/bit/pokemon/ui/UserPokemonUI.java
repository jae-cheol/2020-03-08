package kr.co.bit.pokemon.ui;

import java.util.List;

import kr.co.bit.pokemon.vo.PokemonVO;
import kr.co.bit.pokemon.vo.UserInfoVO;

public class UserPokemonUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		List<PokemonVO> list = service.selectUserPokemonList();
		
		System.out.println("소유 포켓몬 목록 : " + list.size() + " 마리");
		System.out.println("-------------------------------------------------------");
		System.out.println("이름\t공격력\t방어력\t가격\t희귀도\t체력");
		System.out.println("-------------------------------------------------------");
		for(PokemonVO p : list) {
			System.out.println(p.getName() + "\t" + p.getOffensive() + "\t"
					+ p.getDefensive() + "\t" + p.getPrice()+ "\t" + p.getRarity()+ "\t" + p.getLife());
		}
		UserInfoVO ui = service.money();
		if(list.isEmpty()) {
			System.out.println("조회할 포켓몬이 없습니다.");
		}
		System.out.println("-------------------------------------------------------");
		System.out.println("현재 자금 : "+ui.getMoney());
		System.out.println("-------------------------------------------------------");

	}

}
