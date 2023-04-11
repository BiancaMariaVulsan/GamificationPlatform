import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { BadgesService } from 'src/app/services/badges.service';
import { CreateBadgeRequest } from 'src/app/requests/create-badge.request';
import { BadgeDialogComponent } from '../badge-dialog/badge-dialog.component';
import { UserService } from 'src/app/services/users.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
  constructor(public dialog: MatDialog, private badgesService: BadgesService, private userService: UserService) {}

  ngOnInit() {
    const userId = Number(localStorage.getItem('gmf-userId'));
    this.username = localStorage.getItem('gmf-userName') ?? 'User';
    this.userService.getUserPoints(userId).subscribe(result => {
      this.points = result;
    });
  }

  private badge = new CreateBadgeRequest();
  public points: number;
  public username: string;

  public createBadge(): void {
    const dialogRef = this.dialog.open(BadgeDialogComponent, {
      data: this.badge,
    });

    dialogRef.afterClosed().subscribe(result => {
      debugger;
      const userId = Number(localStorage.getItem('gmf-userId'));
      result.requesterId = userId;
      this.badgesService.createBadge(result).subscribe(res => {
        if (res === false) {
          alert('Insufficient funds to create the badge!');
        } else {
          location.reload();
        }
      });
    });
  }
}
