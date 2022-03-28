import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { StatsComponent } from './components/stats/stats.component';
import { Mode2Component } from './components/mode2/mode2.component';
import { GameComponent } from './components/game/game.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';

import { AppRoutingModule } from './app-routing.module';
import { greetingService } from './features/greeting/greeting.service';

@NgModule({
  declarations: [
    AppComponent,
    StatsComponent,
    Mode2Component,
    GameComponent,
    PageNotFoundComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, HttpClientModule],
  providers: [greetingService],
  bootstrap: [AppComponent],
})
export class AppModule {}
