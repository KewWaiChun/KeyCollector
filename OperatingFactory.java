//Coded by KEW WAI CHUN 1141128080

//Operating factory as factory design pattern. 
public class OperatingFactory
{
	//Used to return a particular key object with the given string. Factory design pattern applied here.
	public Key getKeyInstance(String str)
	{
		if(str.equals("icon/a.gif")){	
			return new Key("icon/a.gif");

		} else if(str.equals("icon/b.gif")){	
			return new Key("icon/b.gif");

		} else if(str.equals("icon/c.gif")){	
			return new Key("icon/c.gif");

		} else if(str.equals("icon/d.gif")){	
			return new Key("icon/d.gif");

		} else {
			return new Key("icon/e.gif");
		}
	}

	//Used to return a particular index number with the given string. 
	public int getPlayerIndex(Player player)
	{
		if(player.getName() == "icon/1.gif"){	
			return 0;
		} else if(player.getName() == "icon/2.gif"){	
			return 1;
		} else if(player.getName() == "icon/3.gif"){	
			return 2;
		} else {	
			return 3;
		}
	}

	
}