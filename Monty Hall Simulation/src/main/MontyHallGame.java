/*
 * Joseph Dimmick
 * Monty Hall Simulation game
 * I got expected win rates
 */
package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class MontyHallGame {
	
	private String[] strArray = {"","",""};
	private List<String> doors = new ArrayList<String>(Arrays.asList(strArray));
	private String prize;
	private int userInput, doorSwitch;

	public MontyHallGame() {

	}
	
	//clears the game and adds the elements to the field of play
	private void NewGame() {
		doors.clear();
		doors.add("car");
		doors.add("goat");
		doors.add("goat");
		
	}
	
	//shuffles the doors
	private void ShuffleDoors() {
		Collections.shuffle(doors);
	}
	
	//saves the prize behind the chosen door to a variable and removes it from the list
	private void PickDoor() {
		prize = doors.remove(userInput-1);	
	}
	
	//removes a goat from play
	private void RemoveGoat() {
		doors.remove("goat");
	}
	
	//enter a 1 if you want to switch doors
	//if doors are switched we return the value remaining in our list
	//if player keeps his door the value he picked when chose his door is returned
	private String SwitchDoor() {
		if(doorSwitch==1) return doors.get(0);
		else return prize;
	}
	
	//returns 1 if player wins, 0 if loss
	public int play(int doorChoice, int doorSwitch){
		userInput = doorChoice;
		this.doorSwitch = doorSwitch;
		
		NewGame();
		ShuffleDoors();
		PickDoor();
		RemoveGoat();
		if(SwitchDoor().compareTo("car")==0)return 1;
		else return 0;
	}
	
	public static void main(String[] args) {
		int win = 0, loss = 0 ;
		final int test = 10000;
		MontyHallGame mh = new MontyHallGame();
		
		//System.out.println(mh.play((int)(Math.random()*((3 - 1)+1))+1, 0));
		
		//1000 iterations of not switching the door when given the chance
		System.out.println("Not switching doors when given the chance");
		for(int i = 0; i<test; i++) {			
			int rand = (int)(Math.random()*((3 - 1)+1))+1;
			if(mh.play(rand, 0)==1) win++;
			else loss++;
		}
		System.out.printf("Wins: %d Loss: %d Win Rate: %.2f\n", win, loss, ((double)win/test)*100);
		System.out.println("=========================================");
		
		win = 0; 
		loss = 0;
		//1000 iterations of switching the door when give the chance
		System.out.println("Switching doors when given the chance");
		for(int i = 0; i<test; i++) {			
			int rand = (int)(Math.random()*((3 - 1)+1))+1;
			if(mh.play(rand, 1)==1) win++;
			else loss++;
		}
		System.out.printf("Wins: %d Loss: %d Win Rate: %.2f", win, loss, ((double)win/test)*100);
	}
}
