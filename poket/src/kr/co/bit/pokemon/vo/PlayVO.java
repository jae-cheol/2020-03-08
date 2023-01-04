package kr.co.bit.pokemon.vo;

public abstract class PlayVO {
	
	 protected String id;				// 케릭터 아이디
	 protected int offensive = 0;		// 공격력
	 protected int defensive = 0; 		// 방어력
	 protected int life = 0;			// 체력
	 
	 public abstract void PrintHp(String name);
	 public abstract String toString();
	
	public void Attack(int offensive)
	{
		if( this.life <= 0 || this.life <= offensive )
			this.life = 0;
		else if( defensive >= offensive )
			this.life -= 5;
		else
			this.life -= (offensive-defensive);
	}
	
	public int getPower()
	{
		return this.offensive;
	}
	
	public void setLife(int life)
	{
		this.life = life;
	}
	
	public int getLife()
	{
		return this.life;
	}
	
	public int getOffensive() {
		return offensive;
	}

	public void setOffensive(int offensive) {
		this.offensive = offensive;
	}

	public int getDefensive() {
		return defensive;
	}

	public void setDefensive(int defensive) {
		this.defensive = defensive;
	}
	
	

}
