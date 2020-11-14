import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { MessageService } from "primeng/components/common/messageservice";
import { Message } from "@angular/compiler/src/i18n/i18n_ast";
import { PackagesService } from "../service/packages.service";
import { Destination } from "../models/Destination";

@Component({
  selector: "app-home",
  templateUrl: "./home.component.html",
  styleUrls: ["./home.component.css"],
})

export class HomeComponent implements OnInit {
  successMessage: string = null;
  email: string;
  data: any;
  destinationList: Destination[];
  responseMsg: object;
  errorMsg: string;
  destinationTemp: Destination = null;
  errorMessage: string;

  constructor(private router: Router, private messageService: MessageService, private packageService: PackagesService) { }

  ngOnInit() {
    this.getAllPackages();
  }

  getAllPackages() {
    this.packageService.getPackages().subscribe(
      (response) => {
        this.responseMsg = response;
        this.destinationList = response;
      },
      (error) => {
        this.errorMsg = error.error.message;
      }
    );
  }

  showInfo() {
    this.successMessage = 'Thank you for subscribing. Updates will be sent to ' + this.email;
    this.messageService.add({severity: 'success', summary: this.successMessage, detail: ''});
  }

  getPackages(search: string) {
    this.router.navigate(['/packages', search]);
  }

  getPackageById(destinationId) {
    this.packageService.getPackageById(destinationId).subscribe(
      (response) => {
        this.destinationTemp = response;
      },
      (error) => {
        this.errorMessage = error.error.message;
      }
    );
  }
}