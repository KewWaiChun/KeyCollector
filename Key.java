//Coded by LEE AIK PHENG 1141128168

public class Key {
	private String keyName;
	private int[] keyPosition = new int[2];

	//Constructor to set key name.
	public Key(String name){
		keyName = name;
	}
	
	//Return key name.
	public String getKeyName(){
		return keyName;
	}

	//Return current key position.
	public int[] getKeyPosition(){
		return keyPosition;
	}

	//Set current key position.
	public void setKeyPosition(int x, int y){

		keyPosition[0] = x;
		keyPosition[1] = y;
	}
}