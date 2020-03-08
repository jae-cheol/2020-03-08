package kr.co.bit.pokemon.vo;

public class UserPokemonVO extends PlayVO {
	private String  id;
	private String	name;
	private int		own; // 1이면 소유 중, 0이면 가지고 있지는 않지만 가졌던 적 있음
	
	public UserPokemonVO() {}

	public UserPokemonVO(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOwn() {
		return own;
	}

	public void setOwn(int own) {
		this.own = own;
	}

	public void PrintHp(String str)
	{
	}
	
	@Override
	public String toString() {
		return "UserPokemonVO [id=" + id + " name=" + name + "]";
	}
	
}
