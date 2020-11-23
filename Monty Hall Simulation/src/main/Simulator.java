package main;

public class Simulator {

	public static void main(String[] args) {
		
		//MontyHallGame newGame = new MontyHallGame();
		
		for(int i = 0; i<10; i++) {
			System.out.println((int)(Math.random()*((3 - 1)+1))+1);
		}
	}

}
