import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { environment } from '../../environments/environment';
import { Observable, of } from "rxjs";
import { UserDto } from "../responses/leaderboard.response";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  constructor(private http: HttpClient) {}

  private endpoint = 'users/';

  public getUsers(): Observable<UserDto[]> {
    return this.http.get<UserDto[]>(environment.apiUrl + this.endpoint);
  }

  public getUserPoints(userId: number): Observable<number> {
    return this.http.get<number>(environment.apiUrl + this.endpoint + userId.toString());
  }
}
