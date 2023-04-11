import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { CreateBadgeRequest } from 'src/app/requests/create-badge.request';

@Component({
  selector: 'app-badge-dialog',
  templateUrl: './badge-dialog.component.html',
  styleUrls: ['./badge-dialog.component.css']
})
export class BadgeDialogComponent {
  constructor(
    public dialogRef: MatDialogRef<BadgeDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: CreateBadgeRequest,
  ) {}

  onNoClick(): void {
    this.dialogRef.close();
  }
}
