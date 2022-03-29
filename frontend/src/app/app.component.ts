import { Component, OnInit } from '@angular/core';
import { Greeting } from './features/greeting/greeting';
import { greetingService } from './features/greeting/greeting.service';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {
  public greeting: Greeting | undefined;

  constructor(private greetingService: greetingService) {}

  ngOnInit(): void {
    this.getGreeting();
  }

  public getGreeting(name = 'world') {
    this.greetingService.getGreeting(name).subscribe({
      next: (response) => {
        this.greeting = response;
      },
      error: (error) => {
        alert(error.message);
      },
    });
  }
}
