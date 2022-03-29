import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
// import { Observable } from 'rxjs/internal/Observable';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { RpsResult } from './rpsResult';

@Injectable()
export class rpsService {
  private apiServerUrl = environment.apiBaseUrl;
  constructor(private http: HttpClient) {}

  public handleUserChoice(input: number): Observable<RpsResult> {
    return this.http
      .post<RpsResult>(environment.apiBaseUrl, input)
      .pipe(retry(3), catchError(this.handleError));
  }

  public getGameStatistics(): Observable<RpsResult> {
    return this.http
      .get<RpsResult>(environment.apiBaseUrl)
      .pipe(retry(3), catchError(this.handleError));
  }

  private handleError(error: HttpErrorResponse) {
    if (error.status === 0) {
      // A client-side or network error occurred.
      console.error('A client-side error occurred:', error);
    } else {
      // The backend returned an unsuccessful response code.
      console.error(
        `Backend returned error-code ${error.status}, body was: `,
        error.error
      );
    }
    // Return an observable with a user-facing error message.
    return throwError(
      () => new Error('An error occurred; please try again later.')
    );
  }
}
