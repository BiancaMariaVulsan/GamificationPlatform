import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { environment } from '../../environments/environment';
import { LoginRequest } from "../requests/login.request";
import { Observable } from "rxjs";
import { AuthResponse } from "../responses/auth.response";
import { SignUpRequest } from "../requests/signup.request";

@Injectable({
  providedIn: 'root'
})
export class AccountService {
  constructor(private http: HttpClient) {}

  private endpoint = 'account/';

  loginUser(loginInfo: LoginRequest): Observable<AuthResponse> {
    return this.http.post<AuthResponse>(environment.apiUrl + this.endpoint + 'login', loginInfo);
  }

  signupUser(signupInfo: SignUpRequest): Observable<boolean> {
    return this.http.post<boolean>(environment.apiUrl + this.endpoint + 'signup', signupInfo);
  }
}
