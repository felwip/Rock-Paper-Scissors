package com.rps.rpsbackend.service;

import com.rps.rpsbackend.model.RpsResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RpsService {
    private static Logger logger = LogManager.getLogger();

    int result;
    int computerChoice;
    int gamesPlayed = 0;
    int userWins = 0;
    int userLosses = 0;
    int draws = 0;
    int streak = 0;
    /* TODO: implement additional stats for chart.js
    int rockPlayed = 0;
    int paperPlayed = 0;
    int scissorPlayed = 0;
    int rockWins = 0;
    int paperWins = 0;
    int scissorWins = 0;
    */

    @Autowired
    public RpsService() {}

    /* ! public methods */
    public RpsResult handleUserInput(int userInput) {
        this.gamesPlayed += 1;
        this.computerChoice = this.generateRandomInteger(3);
        return this.computeResult(userInput, this.computerChoice);
    }

    public RpsResult getGameStats() {
       RpsResult rpsResult = new RpsResult(
                this.result,
                this.computerChoice,
                this.gamesPlayed,
                this.userWins,
                this.userLosses,
                this.draws,
                this.streak);

        logger.debug("getGameStats: Returning RpsResult: {}", result);
        return rpsResult;

    }

    /* ! private helper methods */
    int generateRandomInteger(int maxNumber) {
        return (int)Math.floor(Math.random() * maxNumber);
    }


    RpsResult computeResult(int userChoice, int computerChoice) {
        int result = userChoice - computerChoice;
        ArrayList<Integer> winningScenario = new ArrayList<Integer>(2);
        winningScenario.add(1);
        winningScenario.add(-2);
        logger.debug("computeResult: userChoice - computerChoice: {}", result);


        /* Draw scenarios */
        if(result == 0) {
            this.result = 0;
            this.draws += 1;
        }
        /* Winning scenarios */
        else if (winningScenario.contains(result)) {
            this.result = 1;
            this.userWins += 1;
            this.streak += 1;
        }
        /* Losing scenarios */
        else {
            this.result = 2;
            this.userLosses += 1;
            this.streak = 0;
        }

        RpsResult rpsResult = new RpsResult(
                this.result,
                this.computerChoice,
                this.gamesPlayed,
                this.userWins,
                this.userLosses,
                this.draws,
                this.streak
        );
        logger.debug("computeResult: Returning RpsResult: {}", result);
        return rpsResult;
    }
}
