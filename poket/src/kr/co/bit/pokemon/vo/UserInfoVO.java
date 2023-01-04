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
		return "플레이어 정보 [이름 =" + id + ", 공격력 =" + offensive + ", 방어력 =" + defensive + ", 체력 =" + life + ", 현재 자금=" + money
				+ "]";
	}
	
	@Override
	public void PrintHp(String mon_name)
	{
		System.out.println(mon_name + "의 공격을 받음. " + "내 체력 : " + this.life);
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
