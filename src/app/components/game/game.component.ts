import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Greeting } from '../../features/greeting/greeting';
import { greetingService } from '../../features/greeting/greeting.service';

@Component({
  selector: 'app-game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.css'],
})
export class GameComponent implements OnInit {
  public name: string = '';
  public greeting: Greeting | undefined;
  public choices: string[] = ['Rock', 'Paper', 'Scissors'];
  public computerChoice: string | undefined;
  public result: string | undefined;

  constructor(
    private route: ActivatedRoute,
    private greetingService: greetingService
  ) {}

  ngOnInit() {
    this.route.queryParams.subscribe((params) => {
      this.name = params['name'];
    });

    this.getGreeting(this.name);
  }

  public getGreeting(name = 'Player') {
    this.greetingService.getGreeting(name).subscribe({
      next: (response) => {
        this.greeting = response;
      },
      error: (error) => {
        console.error(error.message);
      },
    });
  }

  public handleUserChoice(userChoice: number) {
    const computerChoiceIndex = Math.floor(Math.random() * 3);
    this.computerChoice = this.choices[computerChoiceIndex];
    const result = userChoice - computerChoiceIndex;

    console.log('activated Route: ', this.route);

    if (result == 0) {
      this.result = 'Draw! Go one more time...';
    } else if ([1, -2].includes(result)) {
      this.result = 'You WIN! Comgratulations!';
    } else this.result = 'You lose. Give it another try!';
  }
}
