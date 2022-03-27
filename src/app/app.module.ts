import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StatsComponent } from './components/stats/stats.component';
import { Mode2Component } from './components/mode2/mode2.component';
import { greetingService } from './features/greeting/greeting.service';
import { HelloComponent } from './components/hello/hello.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';

@NgModule({
  declarations: [
    AppComponent,
    StatsComponent,
    Mode2Component,
    HelloComponent,
    PageNotFoundComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, HttpClientModule],
  providers: [greetingService],
  bootstrap: [AppComponent],
})
export class AppModule {}
