import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Greeting } from './greeting';

@Injectable()
export class greetingService {
  private apiServerUrl = environment.apiBaseUrl;
  constructor(private http: HttpClient) {}

  public getGreeting(name: string): Observable<Greeting> {
    return this.http.get<any>(`${this.apiServerUrl}/greeting?name=${name}`);
  }
}
