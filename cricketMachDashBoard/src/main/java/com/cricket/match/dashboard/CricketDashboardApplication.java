package com.cricket.match.dashboard;


import com.cricket.match.dashboard.models.Match;
import com.cricket.match.dashboard.models.Team;

public class CricketDashboardApplication {
	public static void main(String[] args) {
		Team india = new Team("India");
		Team australia = new Team("Australia");
		Match match1 = new Match("Test Match", india, australia, 5, 2);
		match1.addPlayersToTeam(india, new String[] { "P1", "P2", "P3", "P4", "P5" });
		match1.addPlayersToTeam(australia, new String[] { "P1", "P2", "P3", "P4", "P5" });
		match1.startMatch(india);
	}
}
