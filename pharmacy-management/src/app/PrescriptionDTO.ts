import { Prescribed_Drugs } from "./Prescribed_Drugs";

export class PrescriptionDTO{
    prescriptionId: number = 0;
    ssn: string = "";   
    doctorId: number = 0;
    prescribeddrugs: Prescribed_Drugs[] = [];

    constructor(){
        
    }
}
