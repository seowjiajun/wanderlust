import { Component, OnInit } from '@angular/core';
import { AuthService } from '../core/auth.service';
import { Router } from '@angular/router';
import { Users } from '../models/User';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  userName: String;
  loggedIn: Boolean = false;

  constructor(public auth: AuthService, private router: Router) { }

  ngOnInit() {
    this.auth.sessionUser.subscribe(data => {
      this.userName = data.userName; 
      if (this.userName != null) {
        this.loggedIn = true;
      }
    });
  }

  logout() {
    this.auth.sessionUser.next(new Users());
    this.loggedIn = false;
    this.router.navigate(['/home']);
  }
}
