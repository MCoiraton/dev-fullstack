import { Center } from "./Center";

export interface Appointment{
    id: number ;
    mail: string;
    tel: number;
    firstName: string;
    lastName: string;
    appointmentDate: Date;
    centre : Center;
}