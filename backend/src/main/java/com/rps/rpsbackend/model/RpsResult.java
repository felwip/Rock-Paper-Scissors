package com.rps.rpsbackend.model;

import java.util.UUID;

public class RpsResult {
    /*private final UUID id;*/
    private final int result;
    private final int computerChoice;
    private final int gamesPlayed;
    private final int userWins;
    private final int draws;
    private final int userLosses;
    private final int streak;

    public int getResult() {
        return result;
    }

    public int getComputerChoice() {
        return computerChoice;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public int getUserWins() {
        return userWins;
    }

    public int getDraws() {
        return draws;
    }

    public int getUserLosses() {
        return userLosses;
    }

    public int getStreak() {
        return streak;
    }

    public RpsResult(/*UUID id,*/
                     int result,
                     int computerChoice,
                     int gamesPlayed,
                     int userWins,
                     int userLosses,
                     int draws,
                     int streak) {
                        /*this.id = id;*/
                        this.result = result;
                        this.computerChoice = computerChoice;
                        this.gamesPlayed = gamesPlayed;
                        this.userWins = userWins;
                        this.draws = draws;
                        this.userLosses = userLosses;
                        this.streak = streak;
                    }


}
