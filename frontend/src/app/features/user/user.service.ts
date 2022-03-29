import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { environment } from 'src/environments/environment';
import { User } from './user';

@Injectable()
export class userService {
  private apiServerUrl = environment.apiBaseUrl;
  constructor(private http: HttpClient) {}

  public getUser(name: string): Observable<User> {
    return this.http.get<any>(`${this.apiServerUrl}/${name}`);
  }
}
