import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { LeaderboardResponse } from '../responses/leaderboard.response';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LeaderboardService {
  constructor(private http: HttpClient) {}

  private endpoint = 'leaderboard/';

  public getLeaderboard(topCount: number, userId: number): Observable<LeaderboardResponse> {
    var request = { topCount: topCount, userId: userId};
    return this.http.post<LeaderboardResponse>(environment.apiUrl + this.endpoint, request);
  }
}
