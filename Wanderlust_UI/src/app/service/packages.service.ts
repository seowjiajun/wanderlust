import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Details } from "src/app/models/Details";
import { Destination } from "src/app/models/Destination";
import { Itinerary } from "src/app/models/Itinerary";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";

@Injectable({
  providedIn: "root",
})
export class PackagesService {
  constructor(private http: HttpClient) {}

  getPackages(): Observable<Destination[]> {
    return this.http.get<Destination[]>(environment.getPackages);
  }

  getSearchPackages(search): Observable<Destination[]> {
    return this.http.get<Destination[]>(environment.getPackages + "/" + search);
  }

  getPackageDeals(): Observable<Destination[]> {
    return this.http.get<Destination[]>(environment.getPackageDeals);
  }

  getPackageById(id): Observable<Destination> {
    return this.http.get<Destination>(environment.getBookingbyId + id);
  }
}
