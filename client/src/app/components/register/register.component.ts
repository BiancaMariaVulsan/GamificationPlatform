import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { SignUpRequest } from 'src/app/requests/signup.request';
import { AccountService } from 'src/app/services/account.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  constructor(private router: Router, private accountService: AccountService) {}

  public registerUser = new SignUpRequest('', '', '', '');

  onRegisterClicked(): void {
    if (this.registerUser.confirmPassword != this.registerUser.password) {
      alert('The passwords do not match!');
    }
    this.accountService.signupUser(this.registerUser).subscribe(result => {
      if (result !== undefined && result !== null && result === true) {
        alert('Created user!');

        this.router.navigate(['login']);
      } else {
        alert('Could not create user for provided credentials');
      }
    }, error => {
      alert('Could not create user for provided credentials');
      console.log(error);
    });
  }
}
