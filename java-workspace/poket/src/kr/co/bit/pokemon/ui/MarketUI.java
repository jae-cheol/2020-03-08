package kr.co.bit.pokemon.ui;

import java.util.List;
import java.util.Scanner;

import kr.co.bit.pokemon.vo.PokemonVO;
import kr.co.bit.pokemon.vo.UserInfoVO;
import kr.co.bit.pokemon.vo.UserPokemonVO;

public class MarketUI extends BaseUI {

	@Override
	public void execute() throws Exception {

		List<PokemonVO> list = service.selectAllPokemonList();

		System.out.println("���ϸ� ���� ��� : " + list.size() + "��");
		System.out.println("-------------------------------------------------------");
		System.out.println("�̸�\t���ݷ�\t����\t����\t��͵�\tü��");
		System.out.println("-------------------------------------------------------");
		for (PokemonVO p : list) {
			System.out.println(p.getName() + "\t" + p.getOffensive() + "\t" + p.getDefensive() + "\t" + p.getPrice()
					+ "\t" + p.getRarity() + "\t" + p.getLife());
		}
		if (list.isEmpty()) {
			System.out.println("��ȸ�� ���ϸ��� �����ϴ�.");
		}
		System.out.println("-------------------------------------------------------");

		UserInfoVO ui = service.money();
		System.out.println("���� �ڱ� :" + ui.getMoney());
		System.out.println("1.�����ϱ�\t2.�Ǹ��ϱ�\t3.������");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();

		switch (a) {
		case 1: {
			boolean buyOK = true;

			while (buyOK) {
				buyOK = false;

				String name = scanString("������ ���ϸ��� �Է��ϼ��� : ");

				UserPokemonVO userPokemon = new UserPokemonVO();
				List<PokemonVO> PokemonList = service.selectAllPokemonList();

				for (PokemonVO p : PokemonList) {
					buyOK ^= p.getName().equals(name);
					// ������ ���ϸ� �̸��� ����Ʈ�� �ִ°��� �˻�
					// false���� �ϳ��� true�� �ִٸ� ������ ����� true
				}
				if (buyOK == false) {
					System.out.println(name + " �ش�  ���ϸ� �� �����ϰ� ���� �ʽ��ϴ�.");
					buyOK = true;
					continue;
				}

				userPokemon.setId("��");
				userPokemon.setName(name);
				PokemonVO pm = service.pmoney(name);

				if (ui.getMoney() < pm.getPrice()) {
					System.out.println("�ڱ��� �����մϴ�.");
					break;
				} else if (service.insertPokemon(userPokemon) == 1) {
					service.UpdateMoney(pm.getPrice());
					System.out.println("���� �Ϸ�!");
					ui = service.money();
					System.out.println("���� �ڱ� :" + ui.getMoney());
				} else {
					 if (service.own1Pokemon(userPokemon) == 1) {
							System.out.println("���� �Ϸ�!");
							
						}else
					System.out.println("�̹� ������ �ִ� ���ϸ��Դϴ�.");
				}
				buyOK = false;
			}
		}

			break;

		case 2:
			UserPokemonUI x = new UserPokemonUI();
			boolean sellOK = true;

			while (sellOK) {
				sellOK = false;
				x.execute();
				String name = scanString("�Ǹ��� ���ϸ��� �Է����ּ��� : ");

				UserPokemonVO userPokemon = new UserPokemonVO();

				List<PokemonVO> userPokemonList = service.selectUserPokemonList();
				for (PokemonVO p : userPokemonList) {
					sellOK ^= p.getName().equals(name);
					// ���� ���ϸ� �߿��� �Ǹ��� ���ϸ��� �ִ��� �˻�
					// false���� �ϳ��� true�� �ִٸ� ������ ����� true
				}
				if (sellOK == false) {
					System.out.println(name + " �ش�  ���ϸ� �� �����ϰ� ���� �ʽ��ϴ�.");
					sellOK = true;
					continue;
				}

				userPokemon.setName(name);
				PokemonVO pm = service.pmoney(name);
				int price = -pm.getPrice();
				service.UpdateMoney(price);
				service.sellPokemon(userPokemon);
				System.out.println("�Ǹ� �Ϸ�!");
				ui = service.money();
				System.out.println("���� �ڱ� :" + ui.getMoney());

				sellOK = false;
				// �ǸŰ� �Ǿ����� ���� Ż��
			}

			break;
		case 3:
			break;
		default:
			System.out.println("�߸��� �Է��Դϴ�.");
		}

	}

}
