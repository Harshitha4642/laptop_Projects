import { Brand } from "./brand";

export interface Cycle {
    id : number,
    brand : Brand,
    isAvailable : boolean,
    cost: number,
    quantity: number,
    selected: boolean,
    status: boolean;
}