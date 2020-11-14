import { Details } from './Details';

export class Destination {
    destinationId:string;
    continent:string;
    destinationName:string;
    imageUrl:string;
    noOfNights:number;
    flightCharge:number;
    chargePerPerson:number;
    discount:number;
    availability:number;
    details:Details;
}