import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { RegisterService } from "../service/register.service";

@Component({
  selector: "app-register",
  templateUrl: "./register.component.html",
  styleUrls: ["./register.component.css"]
})

export class RegisterComponent implements OnInit {

  registerform: FormGroup;
  errorMessage: String;
  userName: String;

  constructor(private fb: FormBuilder, private registerService: RegisterService) { }

  ngOnInit() {
    this.registerform = this.fb.group({
      userName: [ "", [ Validators.required, Validators.pattern("^[a-zA-Z]+( [a-zA-Z]+)*") ]], 
      emailId: [ "", [ Validators.required, Validators.pattern("[a-zA-Z0-9]{1,}@[a-zA-Z0-9]{1,}.com") ]], 
      contactNumber: ["", [ Validators.required, Validators.pattern("^[0-9]{10}$")]], 
      password: [ "", [ Validators.required, Validators.pattern("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{7,20}$") ]]
    });
  }

  register() {
    this.errorMessage = null;
    this.userName = null;
    this.registerService.register(this.registerform.value).subscribe(
      (response) => {
        this.userName = response.userName;
      },
      (error) => {
        this.errorMessage = error.error.message;
      }
    );
  }
}