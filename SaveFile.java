//Coded by KEW WAI CHUN 1141128080

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

//SaveFile class for saving functionality.
public class SaveFile{
	FileWriter fw;
	BufferedWriter bw;
	
	//Open or create file.
	public void openFile() throws IOException {
		fw = new FileWriter("temp.txt");
		bw = new BufferedWriter(fw);
	}

	//Close file.
	public void closeFile() throws IOException{
		bw.close();
	}

	//Write player position into file.
	public void savePlayerPosition(Player player) throws IOException{
		int[] tempCurPosition = player.getCurPosition();
		String tempName=player.getName();
		bw.write(tempName);
		bw.newLine();
		for(int i=0;i<2;i++){
			bw.write(new Integer(tempCurPosition[i]).toString());
			bw.newLine();
		}
	}

	//Write current player turn into file.
	public void savePlayerTurn(int Turn) throws IOException{
		bw.write(new Integer(Turn).toString());
		bw.newLine();
	}

	//Write all keys held by player into file.
	public void savePlayerKeyInventory(Player player) throws IOException{
		bw.write(player.getName() + "Inventory");
		bw.newLine();
		bw.write(new Integer(player.getInventorySize()).toString());
		bw.newLine();
		LinkedList<Key> tempInventory = player.getInventory();
		for(int i=0; i<tempInventory.size();i++){
			String tempString = (tempInventory.get(i)).getKeyName();
			bw.write(tempString);
			bw.newLine();
		}
	}

	//Write all key position on board into file.
	public void saveKeyPosition(Key key) throws IOException{
		int[] tempCurPosition = key.getKeyPosition();
		bw.write(key.getKeyName());
		bw.newLine();
		for(int i=0;i<2;i++){
			bw.write(new Integer(tempCurPosition[i]).toString());
			bw.newLine();
		}
	}
}