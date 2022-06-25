import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-loginform',
  templateUrl: './loginform.component.html',
  styleUrls: ['./loginform.component.css']
})
export class LoginformComponent implements OnInit {

  credentials = {
    userName: '',
    password: ''
  }

  onSubmit() {
    if ((this.credentials.userName != '' && this.credentials.password != '') && (this.credentials.userName != null && this.credentials.password != null)) {
  
      // generate the token
        this.loginservice.generateToken(this.credentials).subscribe(response=>{
          console.log(response);         
        },error=>{
          console.log(error);
          
        })
    }
    else {
      console.log('fields are empty');

    }
  }
  constructor(private loginservice:LoginService) { }

  ngOnInit(): void {
  }

}
