import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Badge } from 'src/app/models/badge.model';
import { BadgesService } from 'src/app/services/badges.service';

@Component({
  selector: 'app-badges-page',
  templateUrl: './badges-page.component.html',
  styleUrls: ['./badges-page.component.css']
})
export class BadgesPageComponent {
  constructor(private route: ActivatedRoute, private badgesService : BadgesService) {}

  ngOnInit() {
    const userId = Number(localStorage.getItem('gmf-userId'));
    this.route.queryParams
      .subscribe(params => {
        var category = params['category'];
        switch (category) {
          case 'challenges':
            this.badgesService.getChallengesForUser(userId).subscribe(result => {
              this.badges = result;
              this.pageTitle = 'Challenge Badges';
            });
            break;
          case 'in-progress':
            this.badgesService.getInProgressBadges(userId).subscribe(result => {
              this.badges = result;
              this.pageTitle = 'In Progress Badges';
            });
            break;
          case 'proposed':
            this.badgesService.getProposedBadges(userId).subscribe(result => {
              this.badges = result;
              this.pageTitle = 'Proposed Badges';
            });
            break;
          default:
              this.badgesService.getOwnedBadges(userId).subscribe(result => {
                this.badges = result;
                this.pageTitle = 'Owned Badges';
              });
              break;
        }
      }
    );
  }

  public badges: Badge[] = [];
  public pageTitle = '';
}
