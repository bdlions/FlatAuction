import {Role} from "./Role";
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
    roleList: Array<Role>;
    //the following fields are different from server user dto
    confirmPassword:string;
}


