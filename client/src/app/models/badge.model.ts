export class Badge {
  public constructor(public id: number, public title: string, public description: string,
                     public requesterId: number, public requesterUsername: string,
                     public solverId: number | null, public solverUsername: string | null,
                     public points: number, public image: string) {}
}
