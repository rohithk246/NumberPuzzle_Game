import java.awt.*;
import java.util.*;

class CustomNumberPuzzleControl extends NumberPuzzleControl {
	public int getWidth() {
		return 200;
	}
	public int getHeight() {
		return 250;
	}
	public int getXPosition() {
		return 200;
	}
	public int getYPosition() {
		return 200;
	}
	public String getTitle(){
		return "Number Puzzle";
	}
	public int getShuffleButtonFontSize() {
		return 12;
	}
	public int getNumbersFontSize() {
		return 12;
	}
	public Color getEmptyButtonColor() {
		return Color.WHITE;
	}
	public String getWinnerMessage() {
		return "Congrats, you have won!";
	}

	// The following three methods have to be written by the participants...

	public int handleButtonClicked(NumberPuzzleGame game){
		int emptyCellId = game.getEmptyCellId();
		Button buttonClicked = game.getButtonClicked();
		Button[] buttons = game.getButtons();
		
		// Index of clicked button
		int index = 0;
		for(int i=0;i<=15;i++) {
			if(buttons[i].getLabel().equals(buttonClicked.getLabel())) {
				index = i;
				break;
			}
		}
		
		// Checking if clicked button is adjacent to empty cell
		if(index+1 == emptyCellId || index-1 == emptyCellId || index+4 == emptyCellId || index-4 == emptyCellId) {
			swapButton(buttons[emptyCellId], buttonClicked);
			return index;
		}
		
		return emptyCellId;
	}
	public int[] getRandomNumbersForGrid() {
		int arr[] = new int[15];
		
		// Set to store non-duplicate values
		Set<Integer> generated = new LinkedHashSet<Integer>();
		
		while(generated.size()<15) {
			int a = getRandomNumber()%15 + 1;
			generated.add(a);
		}
		
		int n = 0;
		for(int i : generated) {
			arr[n++] = i;
		}
		
		return arr;
	}
	public boolean checkForWinner(Button[] buttons)
	{
		int arr[] = getIntegerArrayOfButtonIds(buttons);
		
		return Arrays.equals(arr, new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15});
	}
}