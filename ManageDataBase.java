package FilmGame;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ManageDataBase {
    
	
	public static int getCoins()
	{
		try(Connection Con=DataBaseConnection.Connect();PreparedStatement P=Con.prepareStatement("SELECT thecoins FROM coins"))
		{
			P.execute();
			ResultSet R1=P.executeQuery();
			R1.next();
			return R1.getInt("thecoins");
		}
		catch(Exception E)
		{
			System.out.println(E.getMessage());
			return 0;
		}
		
	}
	
	public static int getLevel()
	{
		try(Connection Con=DataBaseConnection.Connect();PreparedStatement P=Con.prepareStatement("SELECT thelevel FROM level1"))
		{
			P.execute();
			ResultSet R1=P.executeQuery();
			R1.next();
			return R1.getInt("thelevel");
		}
		catch(Exception E)
		{
			System.out.println(E.getMessage());
			return 0;
		}
	}
    
	public static filmdata getfilmAndhero(int level)
	{
		
		try(Connection Con=DataBaseConnection.Connect();PreparedStatement P=Con.prepareStatement("SELECT * FROM filmname WHERE filmid=?"))
		{
			P.setInt(1, level);
			P.execute();
			ResultSet R1=P.executeQuery();
			R1.next();
			return new filmdata(R1.getString("thename"),R1.getString("thehero"));
		}
		catch(Exception E)
		{
			System.out.println(E.getMessage());
			return null;
		}
	}
	
	public static void UpdateLevel()
	{
		try(Connection Con=DataBaseConnection.Connect();PreparedStatement P=Con.prepareStatement("UPDATE level1 SET thelevel = ?"))
		{
			P.setInt(1, ManageDataBase.getLevel()+1);
			P.execute();
		}
		catch(Exception E)
		{
			System.out.println(E.getMessage());
		}
		
	}
	
	public static void UpdateLevelTo(int level)
	{
		try(Connection Con=DataBaseConnection.Connect();PreparedStatement P=Con.prepareStatement("UPDATE level1 SET thelevel = ?"))
		{
			P.setInt(1, level);
			P.execute();
		}
		catch(Exception E)
		{
			System.out.println(E.getMessage());
		}
		
	}
	
	public static void AddCoins()
	{
		try(Connection Con=DataBaseConnection.Connect();PreparedStatement P=Con.prepareStatement("UPDATE coins SET thecoins = ?"))
		{
			P.setInt(1, ManageDataBase.getCoins()+10);
			P.execute();
		}
		catch(Exception E)
		{
			System.out.println(E.getMessage());
		}
	}
	
	public static void RemoveCoins()
	{
		try(Connection Con=DataBaseConnection.Connect();PreparedStatement P=Con.prepareStatement("UPDATE coins SET thecoins = ?"))
		{
			P.setInt(1, ManageDataBase.getCoins()-10);
			P.execute();
		}
		catch(Exception E)
		{
			System.out.println(E.getMessage());
		}
	}
	
	public static boolean IsSolved(int level)
	{
		boolean IsSolved=false;
		try(Connection Con=DataBaseConnection.Connect();PreparedStatement P=Con.prepareStatement("SELECT filmstate FROM filmname WHERE filmid = ?"))
		{
			P.setInt(1, level);
			P.execute();
			ResultSet R1=P.executeQuery();
			R1.next();
			if(R1.getString("filmstate").equals("solved"))
				IsSolved=true;
			return IsSolved;
		}
		catch(Exception E)
		{
			System.out.println(E.getMessage());
			return false;
		}
	}
	public static void setSolved(int level)
	{
		try(Connection Con=DataBaseConnection.Connect();PreparedStatement P=Con.prepareStatement("UPDATE filmname SET filmstate = ? WHERE filmid = ?"))
		{
			P.setString(1, "solved");
			P.setInt(2, level);
			P.execute();
		}
		catch(Exception E)
		{
			System.out.println(E.getMessage());
		}
	}
	public static int getsolvedlevels()
	{
		int solved=0;
		try(Connection Con=DataBaseConnection.Connect();PreparedStatement P=Con.prepareStatement("SELECT filmstate FROM filmname WHERE filmstate = ?"))
		{
			P.setString(1, "solved");
			P.execute();
			ResultSet R1=P.executeQuery();
			while(R1.next())
			{
				solved++;
			}
			return solved;
		}
		catch(Exception E)
		{
			System.out.println(E.getMessage());
			return 0;
		}
	}
	
	
}
