import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoginRequest } from 'src/app/requests/login.request';
import { AccountService } from 'src/app/services/account.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  constructor(private router: Router, private accountService: AccountService) {}

  public loginUser = new LoginRequest('', '');

  onLoginClicked(): void {
    this.accountService.loginUser(this.loginUser).subscribe(result => {
      if (result !== undefined && result !== null) {
        const userId = result.id;
        const userName = result.username;
        const points = result.points;

        localStorage.setItem('gmf-userId', userId.toString());
        localStorage.setItem('gmf-userName', userName);
        localStorage.setItem('gmf-points', points.toString());

        this.router.navigate(['home']);
      } else {
        alert('Could not find user for provided credentials');
      }
    }, error => {
      alert('Could not find user for provided credentials');
      console.log(error);
    });
  }
}
