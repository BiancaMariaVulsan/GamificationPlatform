import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-presentation-card',
  templateUrl: './presentation-card.component.html',
  styleUrls: ['./presentation-card.component.css']
})
export class PresentationCardComponent {
  @Input() title: string;
  @Input() subtitle: string;
  @Input() imageSrc: string;
  @Input() description: string;
}
