export class User {
    id:number;
    userName:string;
    password:string;
    firstName:string;
    lastName:string;
    email:string;
    img:string;
    document:string;
    cellNo:string;
    isVerified:boolean;
    //the following fields are different from server user dto
    confirmPassword:string;
}


