export class CreateBadgeRequest {
  constructor(public creatorId: number = 0, public title: string = '', public description: string = '',
              public points: number = 0, solverId: number = 0) {}
}
