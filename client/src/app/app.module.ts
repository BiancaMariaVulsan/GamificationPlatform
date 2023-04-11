import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { NavbarComponent } from './components/shared/navbar/navbar.component';

import {MatPaginatorModule} from '@angular/material/paginator';
import {MatDialogModule} from '@angular/material/dialog';
import {MatTableModule} from '@angular/material/table';
import {MatCardModule} from '@angular/material/card';
import {MatIconModule} from '@angular/material/icon'
import {MatFormFieldModule } from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatListModule} from '@angular/material/list';
import {MatAutocompleteModule} from '@angular/material/autocomplete';

import { BannerComponent } from './components/dashboard/banner/banner.component';
import { PresentationComponent } from './components/presentation/presentation.component';
import { RegisterComponent } from './components/register/register.component';
import { PresentationCardComponent } from './components/shared/presentation-card/presentation-card.component';
import { DashboardNavbarComponent } from './components/dashboard/dashboard-navbar/dashboard-navbar.component';
import { HomeComponent } from './components/home/home.component';
import { BadgesBoxComponent } from './components/shared/badges-box/badges-box.component';
import { BadgeComponent } from './components/shared/badge/badge.component';
import { BadgeDialogComponent } from './components/shared/badge-dialog/badge-dialog.component';
import { MatButtonModule } from '@angular/material/button';
import { LeaderboardComponent } from './components/leaderboard/leaderboard.component';
import { BadgesPageComponent } from './components/badges-page/badges-page.component';
import { AssignDialogComponent } from './components/shared/assign-dialog/assign-dialog.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    DashboardComponent,
    NavbarComponent,
    BannerComponent,
    PresentationComponent,
    RegisterComponent,
    PresentationCardComponent,
    DashboardNavbarComponent,
    HomeComponent,
    BadgesBoxComponent,
    BadgeComponent,
    BadgeDialogComponent,
    LeaderboardComponent,
    BadgesPageComponent,
    AssignDialogComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatPaginatorModule,
    MatDialogModule,
    MatTableModule,
    MatCardModule,
    MatIconModule,
    MatFormFieldModule,
    MatInputModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatListModule,
    MatAutocompleteModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
