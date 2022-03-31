package com.rps.rpsbackend.controller;

import com.rps.rpsbackend.model.RpsResult;
import com.rps.rpsbackend.service.RpsService;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping
@RestController
public class RpsController {
    private final RpsService rpsService;
    private static Logger logger = LogManager.getLogger();


    @Autowired
    public RpsController(RpsService rpsService) {
        this.rpsService = rpsService;
    }

    @PostMapping("/api")
    public RpsResult handleUserInput(@RequestBody int userInput) {
        logger.info("Incoming POST request");
        return this.rpsService.handleUserInput(userInput);
    }

    @GetMapping("/api")
    public RpsResult getGameStats() {
        logger.info("Incoming GET request");
        return this.rpsService.getGameStats();
    }

    /* ! To check whether the backend is running via browser */
    @GetMapping
    public String testApiRoute() {

        /* Logger examples to test log-level.
        To switch log-level, change setting in application.properties.
        Uncomment the following logs to check if the level applies. */
        /*
        logger.fatal("It is a fatal logger.");
        logger.error("It is an error logger.");
        logger.warn("It is a warn logger.");
        logger.info("It is a info logger.");
        logger.trace("It is a trace logger.");
        logger.debug("It is a debug logger.");
         */

        return "Backend is up and running. You can send requests to the available routes now.";
    }
}
