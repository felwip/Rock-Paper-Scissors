import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Greeting } from '../../features/greeting/greeting';
import { greetingService } from '../../features/greeting/greeting.service';

@Component({
  selector: 'app-hello',
  templateUrl: './hello.component.html',
  styleUrls: ['./hello.component.css'],
})
export class HelloComponent implements OnInit {
  public name: string = '';
  public greeting: Greeting | undefined;

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
