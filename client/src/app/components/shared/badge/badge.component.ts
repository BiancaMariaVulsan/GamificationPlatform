import { Component, Input } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Badge } from 'src/app/models/badge.model';
import { BadgesService } from 'src/app/services/badges.service';
import { AssignDialogComponent } from '../assign-dialog/assign-dialog.component';
import { UserService } from 'src/app/services/users.service';
import { User } from 'src/app/models/user.model';

@Component({
  selector: 'app-badge',
  templateUrl: './badge.component.html',
  styleUrls: ['./badge.component.css']
})
export class BadgeComponent {
  @Input() badge: Badge;

  constructor(public dialog: MatDialog, private badgesService: BadgesService, private userService: UserService) {}

  public isAssignableByUser() {
    const userId = Number(localStorage.getItem('gmf-userId'));
    return userId === this.badge.requesterId && this.badge.solverId === null;
  }

  public isAssignableToUser() {
    const userId = Number(localStorage.getItem('gmf-userId'));
    return userId !== this.badge.requesterId && this.badge.solverId === null;
  }

  public assignBadge() {
    var users: User[] = [];
    this.userService.getUsers().subscribe(users => {
      const dialogRef = this.dialog.open(AssignDialogComponent, {
        data: {users: users, assignedUsername: null},
      });

      dialogRef.afterClosed().subscribe(result => {
        debugger;
        var assignedUser = users.find(u => u.username === result);
        if(assignedUser) {
          this.badge.solverId = assignedUser.id;
          this.badgesService.assignBadge(this.badge).subscribe(assigned => alert(this.badge.solverId));
        }
      });
    });
  }

  public takeOnBadge() {
    alert('taken');
  }
}
