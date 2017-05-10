import {Currency} from "./Currency";
import {User} from "./User";
export class AccountSettingFA {
    id: number;
    user: User;
    defaultBidPerClick: number;    
    defaultBidPerClickUnit: Currency;
    dailyBudget:number;
    dailyBudgetUnit:Currency;
    campainActive:boolean;
}