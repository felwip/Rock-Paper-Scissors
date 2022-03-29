import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { RpsResult } from 'src/app/features/rps/rpsResult';
import { rpsService } from '../../features/rps/rps.service';

interface DisplayResult {
  value: number;
  text: string;
}
@Component({
  selector: 'app-game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.css'],
})
export class GameComponent implements OnInit {
  public name: string = '';
  public randomRobot: string =
    'https://robohash.org/' + Math.floor(Math.random() * 10);
  public choices: string[] = ['Rock', 'Paper', 'Scissors'];
  public computerChoice: string | undefined;
  public userChoice: string | undefined;
  public result!: DisplayResult | null;
  public stats: Partial<RpsResult> = {
    gamesPlayed: 0,
    userWins: 0,
    userLosses: 0,
    draws: 0,
    streak: 0,
  };

  constructor(private route: ActivatedRoute, private rpsService: rpsService) {}

  ngOnInit() {
    //* Display player name when navigating to `${appUrl} + '?=name'`
    this.route.queryParams.subscribe((params) => {
      this.name = params['name'] || 'Challenger';
    });

    this.rpsService.getGameStatistics().subscribe({
      next: (response) => {
        this.stats = { ...this.stats, ...response };
      },
      error: (error) => {
        console.error('Caught error while getting game stats: ', error);
      },
    });
  }

  public handleUserChoice(userChoiceIndex: number) {
    this.userChoice = this.choices[userChoiceIndex];

    this.rpsService.handleUserChoice(userChoiceIndex).subscribe({
      next: (response: RpsResult) => {
        //* Hydrating result with text to display to the user
        const text =
          response.result == 0
            ? 'DRAW!'
            : response.result == 1
            ? 'YOU WIN!'
            : 'YOU LOSE!';

        this.computerChoice = this.choices[response.computerChoice];
        this.result = { value: response.result, text };
        this.stats = { ...this.stats, ...response };
      },
      error: (error) =>
        console.error('Caught error while handling user choice: ', error),
    });
  }

  //* pure frontend game logic
  // public handleUserChoice(userChoiceIndex: number) {
  //   const computerChoiceIndex = Math.floor(Math.random() * 3);
  //   this.computerChoice = this.choices[computerChoiceIndex];
  //   this.userChoice = this.choices[userChoiceIndex];
  //   const result = userChoiceIndex - computerChoiceIndex;

  //   if (result == 0) {
  //     this.result = { value: 0, text: 'DRAW!' };
  //   } else if ([1, -2].includes(result)) {
  //     this.result = { value: 1, text: 'YOU WIN!' };
  //   } else this.result = { value: 2, text: 'YOU LOSE!' };
  // }
}
