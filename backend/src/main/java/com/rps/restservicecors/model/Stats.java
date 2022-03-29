package com.rps.restservicecors.model;

public class Stats {
    private final int streak;
    private final int rockPlayed;
    private final int paperPlayed;
    private final int scissorsPlayed;
    private final int rockWins;
    private final int paperWins;
    private final int scissorsWins;

    public Stats(int streak, int rockPlayed, int paperPlayed, int scissorsPlayed, int rockWins, int paperWins, int scissorsWins) {
        this.streak = streak;
        this.rockPlayed = rockPlayed;
        this.paperPlayed = paperPlayed;
        this.scissorsPlayed = scissorsPlayed;
        this.rockWins = rockWins;
        this.paperWins = paperWins;
        this.scissorsWins = scissorsWins;
    }


    public int getStreak() {
        return streak;
    }

    public int getRock() {
        return rockPlayed;
    }

    public int getPaper() {
        return paperPlayed;
    }

    public int getScissors() {
        return scissorsPlayed;
    }

    public int getRockWins() {
        return rockWins;
    }

    public int getPaperWins() {
        return paperWins;
    }

    public int getScissorsWins() {
        return scissorsWins;
    }
}
