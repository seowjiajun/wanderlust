import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { PackagesService } from "../service/packages.service";
import { Destination } from "../models/Destination";

@Component({
  selector: "app-packages",
  templateUrl: "./packages.component.html",
  styleUrls: ["./packages.component.css"],
})
export class PackagesComponent implements OnInit {
  private search: string;
  private destinationList: Destination[];
  private errorMsg: string;
  private destinationTemp: Destination;
  private errorMessage: string;
  private price: number = 5000;
  private night: number = 10;

  constructor(private router: Router, private packagesService: PackagesService) {
  }

  ngOnInit() {
    this.search = this.router.url.split('/')[this.router.url.split('/').length - 1];
    this.packagesService.getSearchPackages(this.search).subscribe(
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

  filterPackage() {
    this.packagesService.getSearchPackages(this.search).subscribe(
      (response) => {
        this.destinationList = [];
        for (let _i = 0; _i < response.length; _i++) {
          if (response[_i].chargePerPerson <= this.price && response[_i].noOfNights <= this.night) {
            this.destinationList.push(response[_i]);
          }
        }
      },
      (error) => {
        this.errorMsg = error.error.message;
      }
    );
  }
}
