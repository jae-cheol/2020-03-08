package kr.co.bit.pokemon.ui;

import java.util.List;

import kr.co.bit.pokemon.vo.PokemonVO;
import kr.co.bit.pokemon.vo.UserInfoVO;

public class UserPokemonUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		List<PokemonVO> list = service.selectUserPokemonList();
		
		System.out.println("���� ���ϸ� ��� : " + list.size() + " ����");
		System.out.println("-------------------------------------------------------");
		System.out.println("�̸�\t���ݷ�\t����\t����\t��͵�\tü��");
		System.out.println("-------------------------------------------------------");
		for(PokemonVO p : list) {
			System.out.println(p.getName() + "\t" + p.getOffensive() + "\t"
					+ p.getDefensive() + "\t" + p.getPrice()+ "\t" + p.getRarity()+ "\t" + p.getLife());
		}
		UserInfoVO ui = service.money();
		if(list.isEmpty()) {
			System.out.println("��ȸ�� ���ϸ��� �����ϴ�.");
		}
		System.out.println("-------------------------------------------------------");
		System.out.println("���� �ڱ� : "+ui.getMoney());
		System.out.println("-------------------------------------------------------");

	}

}