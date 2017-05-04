package fr.univavignon.pokedex.api;

/**
 * Pokemon POJO.
 * 
 * @author fv
 */
public final class Pokemon extends PokemonMetadata {

	/** Combat Point of the pokemon. **/
	private final int cp;

	/** HP of the pokemon. **/
	private final int hp;

	/** Required dust for upgrading this pokemon. **/
	private final int dust;

	/** Required candy for upgrading this pokemon. **/
	private final int candy;

	/** IV perfection percentage. **/
	private final double iv;
	
	/**
	 * Default constructor.
	 * 
	 * @param index Pokemon index.
	 * @param name Pokemon name.
	 * @param attack Attack level.
	 * @param defense Defense level.
	 * @param stamina Stamina level.
	 * @param cp Pokemon cp.
	 * @param hp Pokemon hp.
	 * @param dust Required dust for upgrading this pokemon.
	 * @param candy Required candy for upgrading this pokemon.
	 * @param iv IV perfection percentage.
	 */
	public Pokemon(//NOPMD
			final int index,//NOPMD
			final String name,//NOPMD
			final int attack,//NOPMD
			final int defense,//NOPMD
			final int stamina,//NOPMD
			final int cp,//NOPMD
			final int hp,//NOPMD
			final int dust,//NOPMD
			final int candy,//NOPMD
			final double iv) {//NOPMD
		super(index, name, attack, defense, stamina);//NOPMD
		this.cp = cp;//NOPMD
		this.hp = hp;//NOPMD
		this.dust = dust;//NOPMD
		this.candy = candy;//NOPMD
		this.iv = iv;//NOPMD
	}//NOPMD

	/** Combat Point getter getter. **/
	public int getCp() {
		return cp;
	}
	
	/** HP getter. **/
	public int getHp() {
		return hp;
	}

	/** Dust getter. **/
	public int getDust() {
		return dust;
	}

	/** Candy getter. **/
	public int getCandy() {
		return candy;
	}
	
	/** IV getter. **/
	public double getIv() {
		return iv;
	}
	
	/**
	 * 
	 */
	@Override
	public boolean equals(Object obj) {

		Pokemon pokemon = (Pokemon) obj;
		
		if (pokemon.getIndex() != this.getIndex()) {
			
			return false;
			
		}
		
		if (!pokemon.getName().equals(this.getName())) {
			
			return false;
			
		}
		
		if (pokemon.getAttack() != this.getAttack()) {
			
			return false;
			
		}
		
		if (pokemon.getDefense() != this.getDefense()) {
			
			return false;
			
		}
		
		if (pokemon.getStamina() != this.getStamina()) {
			
			return false;
			
		}
		
		if (pokemon.getCp() != this.getCp()) {
			
			return false;
			
		}
		
		if (pokemon.getHp() != this.getHp()) {
			
			return false;
			
		}
		
		if (pokemon.getDust() != this.getDust()) {
			
			return false;
			
		}

		if (pokemon.getCandy() != this.getCandy()) {
			
			return false;
			
		}

		if (pokemon.getIv() != this.getIv()) {
			
			return false;
			
		}
		
		return true;
		
	}
	
}
