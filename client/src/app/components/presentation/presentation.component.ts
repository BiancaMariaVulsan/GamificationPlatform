import { Component } from '@angular/core';

@Component({
  selector: 'app-presentation',
  templateUrl: './presentation.component.html',
  styleUrls: ['./presentation.component.css']
})

export class PresentationComponent {
  public cards: PresentationCard[] = [];

  constructor() {
    var card1 = new PresentationCard();
    card1.title = "Earn Tokens for Your Achievements";
    card1.subtitle = "Get Rewarded for Your Efforts";
    card1.description = "Our platform rewards users with tokens for their achievements, whether it's completing a task, hitting a milestone, or winning a competition. The more achievements you earn, the higher your ranking and the more tokens you can accumulate."
    card1.imageSrc = "./../../../assets/medal.png";

    var card2 = new PresentationCard();
    card2.title = "Socialize and Get Rewarded";
    card2.subtitle = "Climb the Leaderboard and Earn More";
    card2.description = "Our platform offers social tokens that you can earn by connecting with friends, sharing content, and engaging with the community. The more you socialize, the more tokens you can accumulate."
    card2.imageSrc = "./../../../assets/ranking.png";

    var card3 = new PresentationCard();
    card3.title = "Share Your Progress";
    card3.subtitle = "Get Tokens for Sharing Your Progress";
    card3.description = "It's your time to show how cool you are to your friends. Get them involved, challenge them and earn new badges & tokens. The more people in, the more fun for everybody!"
    card3.imageSrc = "./../../../assets/socialize.png";

    this.cards.push(card1);
    this.cards.push(card2);
    this.cards.push(card3);
  }
}

export class PresentationCard {
  public title: string;
  public subtitle: string;
  public description: string;
  public imageSrc: string;
}
