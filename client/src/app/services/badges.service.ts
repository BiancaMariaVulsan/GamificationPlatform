import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { environment } from '../../environments/environment';
import { UserBadgesResponse } from "../responses/user-badges.response";
import { Observable, of } from "rxjs";
import { Badge } from "../models/badge.model";
import { CreateBadgeRequest } from "../requests/create-badge.request";

@Injectable({
  providedIn: 'root'
})
export class BadgesService {
  constructor(private http: HttpClient) {}

  private endpoint = 'badges/';

  getUserBadges(userId: number): Observable<UserBadgesResponse> {
    return this.http.get<UserBadgesResponse>(environment.apiUrl + this.endpoint + userId.toString());
  }

  getChallengesForUser(userId: number): Observable<Badge[]> {
    return this.http.get<Badge[]>(environment.apiUrl + this.endpoint + 'challenges/' + userId.toString());
  }

  createBadge(createBadge: CreateBadgeRequest): Observable<boolean> {
    return this.http.post<boolean>(environment.apiUrl + this.endpoint + 'create', createBadge);
  }

  assignBadge(badge: Badge): Observable<boolean>{
    return this.http.post<boolean>(environment.apiUrl + this.endpoint + 'assign', badge);
  }

  getInProgressBadges(userId: number): Observable<Badge[]> {
    return this.http.get<Badge[]>(environment.apiUrl + this.endpoint + 'in-progress/' +  userId.toString());
  }

  getProposedBadges(userId: number): Observable<Badge[]> {
    return this.http.get<Badge[]>(environment.apiUrl + this.endpoint + 'proposed/' +  userId.toString());
  }

  getOwnedBadges(userId: number): Observable<Badge[]> {
    return this.http.get<Badge[]>(environment.apiUrl + this.endpoint + 'owned/' +  userId.toString());
  }
}
