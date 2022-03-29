package com.rps.rpsbackend.controller;

import com.rps.rpsbackend.model.RpsResult;
import com.rps.rpsbackend.service.RpsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping
@RestController
public class RpsController {
    private final RpsService rpsService;

    @Autowired
    public RpsController(RpsService rpsService) {
        this.rpsService = rpsService;
    }

    @PostMapping("/api")
    public RpsResult handleUserInput(@RequestBody int userInput) {
        System.out.println("==== received POST request ====");
        return this.rpsService.handleUserInput(userInput);
    }

    @GetMapping("/api")
    public RpsResult getGameStats() {
        System.out.println("==== received GET request ====");
        return this.rpsService.getGameStats();
    }

    /* ! For checking if backend is running via browser */
    @GetMapping
    public String testApiRoute() {
        return "Backend is up and running. You can send requests to the available routes now.";
    }
}
