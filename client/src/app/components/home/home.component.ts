import { Component } from '@angular/core';
import { Badge } from 'src/app/models/badge.model';
import { BadgesService } from 'src/app/services/badges.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  constructor(private badgesService: BadgesService) {}

  public inProgressBadges: Badge[] = [];
  public proposedBadges: Badge[] = [];
  public ownedBadges: Badge[] = [];

  ngOnInit() {
    const userId = Number(localStorage.getItem('gmf-userId'));
    this.badgesService.getUserBadges(userId).subscribe(result => {
      this.inProgressBadges = result.inProgressBadges;
      this.proposedBadges = result.proposedBadges;
      this.ownedBadges = result.ownedBadges;
    });
  }
}
