package tourneyGen;

import java.util.Scanner;
import java.util.Random;
import java.io.PrintWriter;
import java.io.File;

public class GenerateTournament {

	static boolean byFlag = false;
	static int numBys;
	static String nextRound;
	static int currMatch = 0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the number of teams in the tournament: ");
		int numTeams = in.nextInt();
		in.nextLine();
		System.out.println();
		String[] tourney = new String[numTeams];
		tourney[0] = Integer.toString(numTeams);
		String[] teams = new String[numTeams];
		for (int i = 0; i < numTeams; i++) {
			System.out.print("Enter the name of team #" + (i+1) + ": ");
			String team = in.nextLine();
			tourney[1] =  team + ";";
			teams[i] = team;
		}

	}

	public static String[] setupFirstRound(String[] teams) {

		if (teams.length % 2 == 0) {
			String[] roundOne = new String[teams.length / 2];
			for (int i = 0; i < roundOne.length; i++) {
				for (int j = i * 2; j < j + 2; j++) {
					if (j % 2 == 0) {
						roundOne[i] += teams[j] + ",";
					} else {
						roundOne[i] += teams[j] + ";";
					}
				}
			}
			return roundOne;
		} else {
			numBys = numBys(teams.length);
			String[] roundOne = new String[(teams.length - numBys) / 2];
			for (int i = 0; i < roundOne.length; i++) {
				for (int j = i * 2; j < j + 2; j++) {
					if (j % 2 == 0) {
						roundOne[i] += teams[j] + ",";
					} else {
						roundOne[i] += teams[j] + ";";
					}
				}
			}
			byFlag = true;
			return roundOne;
		}
	}
	
	public static String[] setupSecondRound(String[] teams, String nextRound, int numBys){
		String[] roundTwo = new String[numBys + nextRound.length()]; 
		String[] winners = nextRound.split("");
		for (int i = 0; i < roundTwo.length; i++){
			for (int j = teams.length - numBys + 1; j < teams.length; j++){
				for (int x = j * 2; x < x + 2; x++) {
					if (x % 2 == 0) {
						roundTwo[j] += teams[x] + ",";
					} else {
						roundTwo[j] += teams[x] + ";";
					}
				}
			}
			for (int n = 0; n < winners.length; n++){
				for (int m = n * 2; m < m + 2; m++){
					if (m % 2 == 0) {
						roundTwo[n] += winners[m] + ",";
					} else {
						roundTwo[n] += winners[m] + ";";
					}
				}
			}
		}
		return roundTwo;
	} 
	
	public static int numBys(int numTeams){
		int closestPower = 32 - Integer.numberOfLeadingZeros(numTeams - 1);
		return closestPower - numTeams;
	}
	
	public static void outFile(String[] out){
		
	}
}
