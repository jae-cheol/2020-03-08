package kr.co.bit.pokemon.vo;

public class PokemonVO extends PlayVO {
	private String	name;
	private int		price;
	private int		rarity;
	
	public PokemonVO() {
	}

	public PokemonVO(String name, int offensive, int defensive, int price, int rarity, int life) {
		this.name = name;
		this.offensive = offensive;
		this.defensive = defensive;
		this.price = price;
		this.rarity = rarity;
		this.life = life;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getRarity() {
		return rarity;
	}

	public void setRarity(int rarity) {
		this.rarity = rarity;
	}

	@Override
	public String toString() {
		return "���ϸ� ���� [���ϸ� �̸� =" + name + ", ���ݷ� =" + offensive + ", ���� = " + defensive + ", ���� =" + price
				+ ", ��͵�=" + rarity + "]";
	}
	
	@Override
	public void PrintHp(String user_name)
	{
		System.out.println(user_name + "�� ������ ����. " + this.name+" ���� ü�� : " + this.life);
	}
	
	public void setStat(String name, int offensive, int defensive, int price, int rarity, int life)
	{
		this.name = name;
		this.offensive = offensive;
		this.defensive = defensive;
		this.price = price;
		this.rarity = rarity;
		this.life = life;
	}
	
}
