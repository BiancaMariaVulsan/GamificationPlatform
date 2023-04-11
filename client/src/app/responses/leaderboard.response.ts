export class LeaderboardResponse {
  constructor(public users: UserDto[], public rank: number) {}
}

export class UserDto {
  constructor(public id: number, public username: string, public points: number, public rank: number) {}
}
