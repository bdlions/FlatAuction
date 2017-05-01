/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import {ServerResponse} from "./ServerResponse"

export class SignInResponse extends ServerResponse{
    userName:string ;
    fullName:string;
    address:string;
    sessionId:string;
}