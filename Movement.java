//Concept discussed by CHAN HOH YUE 1141128352, KEW WAI CHUN 1141128080, PUA JUN MING 1141128767 and NICHOLAS HOA WAI KEN. 
//Coded by CHAN HOH YUE 1141128352.

import java.awt.*;
import java.util.LinkedList;

//Movement class for determining the available steps for the players.
public class Movement {
	private LinkedList<Integer> possibleX = new LinkedList<Integer>();
	private LinkedList<Integer> possibleY = new LinkedList<Integer>(); 

	//Calculate upward movements of the player in their position.
	public void calculateUpMoves(int[] position,int[] boxes){
		int axisX = position[0];
		int axisY = position[1];
		int tempX = axisX;
		for(int i = 0; i < boxes.length; i++)
		{
			axisX = tempX - boxes[i];
			setPossiblePosition(axisX, axisY);
		}
	}
	
	//Calculate upper-right diagonal movements of the player in their position.
	public void calculateUpRightMoves(int[] position,int[] boxes){
		int axisX = position[0];
		int axisY = position[1];
		int tempX = axisX;
		int tempY = axisY;

		for(int i = 0; i < boxes.length; i++)
		{
			axisX = tempX - boxes[i];
			axisY = tempY + boxes[i];
			setPossiblePosition(axisX, axisY);
		}
	}
	
	//Calculate right movements of the player in their position.
	public void calculateRightMoves(int[] position,int[] boxes){
		int axisX = position[0];
		int axisY = position[1];
		int tempX = axisX;
		int tempY = axisY;

		for(int i = 0; i < boxes.length; i++)
		{
			axisY = tempY + boxes[i];
			setPossiblePosition(axisX, axisY);
		}
	}
	
	//Calculate lower-right diagonal movements of the player in their position.
	public void calculateDownRightMoves(int[] position,int[] boxes){
		int axisX = position[0];
		int axisY = position[1];
		int tempX = axisX;
		int tempY = axisY;

		for(int i = 0; i < boxes.length; i++)
		{
			axisX = tempX + boxes[i];
			axisY = tempY + boxes[i];
			setPossiblePosition(axisX, axisY);
		}
	}
	
	//Calculate down movements of the player in their position.
	public void calculateDownMoves(int[] position,int[] boxes){
		int axisX = position[0];
		int axisY = position[1];
		int tempX = axisX;
		int tempY = axisY;

		for(int i = 0; i < boxes.length; i++)
		{
			axisX = tempX + boxes[i];
			setPossiblePosition(axisX, axisY);
		}
		
	}
	
	//Calculate lower-left diagonal movements of the player in their position.
	public void calculateDownLeftMoves(int[] position,int[] boxes){
		int axisX = position[0];
		int axisY = position[1];
		int tempX = axisX;
		int tempY = axisY;

		for(int i = 0; i < boxes.length; i++)
		{
			axisX = tempX + boxes[i];
			axisY = tempY - boxes[i];
			setPossiblePosition(axisX, axisY);
		}
	}
	
	//Calculate left movements of the player in their position.
	public void calculateLeftMoves(int[] position,int[] boxes){
		int axisX = position[0];
		int axisY = position[1];
		int tempX = axisX;
		int tempY = axisY;

		for(int i = 0; i < boxes.length; i++)
		{
			axisY = tempY - boxes[i];
			setPossiblePosition(axisX, axisY);
		}
		
	}
	
	//Calculate upper-left diagonal movements of the player in their position.
	public void calculateUpLeftMoves(int[] position,int[] boxes){
		int axisX = position[0];
		int axisY = position[1];
		int tempX = axisX;
		int tempY = axisY;

		for(int i = 0; i < boxes.length; i++)
		{
			axisX = tempX - boxes[i];
			axisY = tempY - boxes[i];
			setPossiblePosition(axisX, axisY);
		}
	}
	
	//Add possible position for players to move to linked list.
	public void setPossiblePosition(int axisX, int axisY){
		possibleX.add(axisX);
		possibleY.add(axisY);
	}
	
	//Clear linked list.
	public void clear(){
		possibleX.clear();
		possibleY.clear();
	}
	
	//Set of movements for player with no key.
	public boolean playerDefaultMove(int[] position, int destinationX, int destinationY){
		clear();
		int[] movableBoxes = { 1 , 2 };
		boolean status = false;
		calculateUpMoves(position,movableBoxes);
		calculateUpRightMoves(position,movableBoxes);
		calculateRightMoves(position,movableBoxes);
		calculateDownRightMoves(position,movableBoxes);
		calculateDownMoves(position,movableBoxes);
		calculateDownLeftMoves(position,movableBoxes);
		calculateLeftMoves(position,movableBoxes);
		calculateUpLeftMoves(position,movableBoxes);

		for(int i = 0 ; i < possibleX.size() ; i++){
			if (possibleX.get(i)==destinationX){
				if(possibleY.get(i)==destinationY){
					//System.out.println("Player move to "+destinationX+" , "+destinationY);
					status = true;
				}
			}
		}

		return status;
	}

	//Set of movements for player with latest key as pinkey.
	public boolean playerPinkeyMove(int[] position, int destinationX, int destinationY){
		clear();
		int[] movableBoxes = {1};
		boolean status = false;
		calculateUpMoves(position,movableBoxes);
		calculateUpRightMoves(position,movableBoxes);
		calculateRightMoves(position,movableBoxes);
		calculateDownRightMoves(position,movableBoxes);
		calculateDownMoves(position,movableBoxes);
		calculateDownLeftMoves(position,movableBoxes);
		calculateLeftMoves(position,movableBoxes);
		calculateUpLeftMoves(position,movableBoxes);

		for(int i = 0 ; i < possibleX.size() ; i++){
			if (possibleX.get(i)==destinationX){
				if(possibleY.get(i)==destinationY){
					//System.out.println("Player move to "+destinationX+" , "+destinationY);
					status = true;
				}
			}
		}

		return status;
	}

	//Set of movements for player with latest key as donkey.
	public boolean playerDonkeyMove(int[] position, int destinationX, int destinationY){
		clear();
		int[] movableBoxes = {1, 2, 3};
		boolean status = false;
		calculateUpRightMoves(position,movableBoxes);
		calculateDownRightMoves(position,movableBoxes);
		calculateDownLeftMoves(position,movableBoxes);
		calculateUpLeftMoves(position,movableBoxes);

		for(int i = 0 ; i < possibleX.size() ; i++){
			if (possibleX.get(i)==destinationX){
				if(possibleY.get(i)==destinationY){
					//System.out.println("Player move to "+destinationX+" , "+destinationY);
					status = true;
				}
			}
		}

		return status;
	}
	
	//Set of movements for player with latest key as keydisk.
	public boolean playerKeydiskMove(int[] position, int destinationX, int destinationY){
		clear();
		int[] movableBoxes = {1 ,2, 3};
		boolean status = false;
		calculateUpMoves(position,movableBoxes);
		calculateRightMoves(position,movableBoxes);
		calculateDownMoves(position,movableBoxes);
		calculateLeftMoves(position,movableBoxes);

		for(int i = 0 ; i < possibleX.size() ; i++){
			if (possibleX.get(i)==destinationX){
				if(possibleY.get(i)==destinationY){
					//System.out.println("Player move to "+destinationX+" , "+destinationY);
					status = true;
				}
			}
		}

		return status;
	}

	//Set of movements for player with latest key as keynote.
	public boolean playerKeynoteMove(int[] position, int destinationX, int destinationY){
		clear();
		int[] movableBoxes = {2};
		boolean status = false;
		calculateUpMoves(position,movableBoxes);
		calculateUpRightMoves(position,movableBoxes);
		calculateRightMoves(position,movableBoxes);
		calculateDownRightMoves(position,movableBoxes);
		calculateDownMoves(position,movableBoxes);
		calculateDownLeftMoves(position,movableBoxes);
		calculateLeftMoves(position,movableBoxes);
		calculateUpLeftMoves(position,movableBoxes);

		for(int i = 0 ; i < possibleX.size() ; i++){
			if (possibleX.get(i)==destinationX){
				if(possibleY.get(i)==destinationY){
					//System.out.println("Player move to "+destinationX+" , "+destinationY);
					status = true;
				}
			}
		}

		return status;
	}

	//Set of movements for player with latest key as monkey.
	public boolean playerMonkeyMove(int[] position, int destinationX, int destinationY){
		clear();
		int[] movableBoxes = {1, 2, 3};
		boolean status = false;
		calculateUpMoves(position,movableBoxes);
		calculateUpRightMoves(position,movableBoxes);
		calculateRightMoves(position,movableBoxes);
		calculateDownRightMoves(position,movableBoxes);
		calculateDownMoves(position,movableBoxes);
		calculateDownLeftMoves(position,movableBoxes);
		calculateLeftMoves(position,movableBoxes);
		calculateUpLeftMoves(position,movableBoxes);

		for(int i = 0 ; i < possibleX.size() ; i++){
			if (possibleX.get(i)==destinationX){
				if(possibleY.get(i)==destinationY){
					//System.out.println("Player move to "+destinationX+" , "+destinationY);
					status = true;
				}
			}
		}

		return status;
	}

}