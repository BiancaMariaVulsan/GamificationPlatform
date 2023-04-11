import { Component, Input } from '@angular/core';
import { Badge } from 'src/app/models/badge.model';

@Component({
  selector: 'app-badges-box',
  templateUrl: './badges-box.component.html',
  styleUrls: ['./badges-box.component.css']
})
export class BadgesBoxComponent {
  @Input() badges: Badge[];
  @Input() groupName: string;
  @Input() viewUrl: string;

  private maxVisible = 4;

  public hasMoreAvailable(): boolean {
    return this.badges.length > this.maxVisible;
  }

  public notVisibleBadgesCount(): number {
    return this.badges.length - this.maxVisible;
  }
}
