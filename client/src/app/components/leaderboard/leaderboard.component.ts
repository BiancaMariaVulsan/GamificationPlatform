import { Component, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { UserDto } from 'src/app/responses/leaderboard.response';
import { LeaderboardService } from 'src/app/services/leaderboard.service';

@Component({
  selector: 'app-leaderboard',
  templateUrl: './leaderboard.component.html',
  styleUrls: ['./leaderboard.component.css']
})
export class LeaderboardComponent {
  displayedColumns: string[] = ['rank', 'username', 'points'];
  dataSource = new MatTableDataSource<UserDto>();
  dataLength: number;
  userRank: number;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private leaderboardService: LeaderboardService) {}

  ngOnInit(): void {
    const userId = Number(localStorage.getItem('gmf-userId'));
    var rank = 1;
    this.leaderboardService.getLeaderboard(100, userId).subscribe(result => {
      for (var user of result.users) {
        user.rank = rank++;
      }

      this.dataSource = new MatTableDataSource(result.users);
      this.userRank = result.rank;
      this.dataLength = result.users.length;
      this.dataSource.paginator = this.paginator;
    });
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
}
