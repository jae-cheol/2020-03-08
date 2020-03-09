package kr.co.bit.pokemon.vo;

public class UserInfoVO extends PlayVO {
	
	private String	id;
	private int money;
	
	public UserInfoVO() {
	}

	public UserInfoVO(String id, int offensive, int defensive, int life, int money) {
		this.id = id;
		this.offensive = offensive+10;
		this.defensive = defensive;
		this.life = life;
		this.money = money;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public void setMoney(int money)
	{
		this.money = money;
	}
	
	public int getMoney()
	{
		return this.money;
	}

	@Override
	public String toString() {
		return "�÷��̾� ���� [�̸� =" + id + ", ���ݷ� =" + offensive + ", ���� =" + defensive + ", ü�� =" + life + ", ���� �ڱ�=" + money
				+ "]";
	}
	
	@Override
	public void PrintHp(String mon_name)
	{
		System.out.println(mon_name + "�� ������ ����. " + "�� ü�� : " + this.life);
	}
	
	public void setStat(String id, int power, int defen, int hp, int money)
	{
		this.id = id;
		this.offensive = power;
		this.defensive = defen;
		this.life = hp;
		this.money = money;
	}
	
}
