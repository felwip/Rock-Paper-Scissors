import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Greeting } from '../../features/greeting/greeting';
import { greetingService } from '../../features/greeting/greeting.service';

interface Result {
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
  public greeting: Greeting | undefined;
  public choices: string[] = ['Rock', 'Paper', 'Scissors'];
  public computerChoice: string | undefined;
  public userChoice: string | undefined;
  public result!: Result | null;

  constructor(
    private route: ActivatedRoute,
    private greetingService: greetingService
  ) {}

  ngOnInit() {
    this.route.queryParams.subscribe((params) => {
      this.name = params['name'] || 'Player';
    });

    this.getGreeting(this.name);
  }

  public getGreeting(name: string) {
    this.greetingService.getGreeting(name).subscribe({
      next: (response) => {
        this.greeting = response;
      },
      error: (error) => {
        console.error(error.message);
      },
    });
  }

  public handleUserChoice(userChoiceIndex: number) {
    const computerChoiceIndex = Math.floor(Math.random() * 3);
    this.computerChoice = this.choices[computerChoiceIndex];
    this.userChoice = this.choices[userChoiceIndex];
    const result = userChoiceIndex - computerChoiceIndex;

    if (result == 0) {
      this.result = { value: 0, text: 'DRAW!' };
    } else if ([1, -2].includes(result)) {
      this.result = { value: 1, text: 'YOU WIN!' };
    } else this.result = { value: 2, text: 'YOU LOSE!' };
  }
}
