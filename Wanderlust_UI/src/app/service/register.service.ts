import { Injectable } from "@angular/core";
import { HttpClient, HttpErrorResponse } from "@angular/common/http";
import { Observable, throwError } from "rxjs";
import { Users } from "../models/User";
import { environment } from "src/environments/environment";
import { catchError } from "rxjs/operators";

@Injectable({
  providedIn: "root",
})

export class RegisterService {

  constructor(private http: HttpClient) { }

  register(registerdata: Users): Observable<Users> {
    return this.http.post<Users>(environment.registerUser, registerdata);
  }
}