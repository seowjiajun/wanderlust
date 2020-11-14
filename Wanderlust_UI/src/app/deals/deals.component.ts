import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { PackagesService } from "../service/packages.service";
import { Destination } from "../models/Destination";

@Component({
  selector: "app-deals",
  templateUrl: "./deals.component.html",
  styleUrls: ["./deals.component.css"],
})
export class DealsComponent implements OnInit {
  destinationList: Destination[];
  errorMsg: String;
  destinationTemp: Destination;
  errorMessage: string;

  constructor(private router: Router, private packagesService: PackagesService) {}

  ngOnInit() {
    this.getAllDeals();
  }

  getAllDeals() {
    this.packagesService.getPackageDeals().subscribe(
      (response) => {
        this.destinationList = response;
      },
      (error) => {
        this.errorMsg = error.error.message;
      }
    );
  }

  getPackageById(destinationId) {
    this.packagesService.getPackageById(destinationId).subscribe(
      (response) => {
        this.destinationTemp = response;
      },
      (error) => {
        this.errorMessage = error.error.message;
      }
    );
  }
}
