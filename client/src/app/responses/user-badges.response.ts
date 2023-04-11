import { Badge } from "../models/badge.model";

export class UserBadgesResponse {
  constructor(public inProgressBadges: Badge[], public proposedBadges: Badge[], public ownedBadges: Badge[]) {}
}
