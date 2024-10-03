package FilmGame;

public class filmdata {

	private String film_name,film_hero;
	
	
	public filmdata(String film_name,String film_hero)
	{
		this.film_name=film_name;
		this.film_hero=film_hero;
	}
	
	public void setName(String film_name)
	{
		this.film_name=film_name;
	}
	public void setHero(String film_hero)
	{
		this.film_hero=film_hero;
	}
	public String getName()
	{
		return this.film_name;
	}
	public String getHero()
	{
		return this.film_hero;
	}
}
