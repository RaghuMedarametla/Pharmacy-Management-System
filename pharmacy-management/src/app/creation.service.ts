import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

import { Customer } from './Customer';
import { Employee } from './Employee';
import { Medicine } from './Medicine';
import { Prescription } from './Presciption';
import { Prescribed_Drugs } from './Prescribed_Drugs';
import { Orders } from './Orders';
import { Ordered_Drugs } from './Ordered_Drugs';
import { Bill } from './Bill';
import { PrescriptionDTO } from './PrescriptionDTO';
import { BillDTO } from './BillDTO';

@Injectable({
  providedIn: 'root'
})

export class CreationService {

  customerApiUrl = 'http://localhost:8083/customers';
  employeeApiUrl = 'http://localhost:8083/employees';
  medicineApiUrl = 'http://localhost:8083/medicines';
  prescriptionApiUrl = 'http://localhost:8083/prescriptions';
  prescribeddrugsApiUrl = 'http://localhost:8083/prescribed_drugs';
  orderApiUrl = 'http://localhost:8083/orders';
  ordereddrugApiUrl = 'http://localhost:8083/ordereddrugs';
  billApiUrl = 'http://localhost:8083/bills';

  
  constructor(private httpClient: HttpClient) { }

  getAllCustomers(): Observable<any> {

    // const httpOptions = {
    //   headers: new HttpHeaders({
    //     'Content-Type': 'application/json',
    //   })
    // }
    return this.httpClient.get(this.customerApiUrl + '/all');
  }

  getAllordersWithEmployeeID(): Observable<any> {

    // const httpOptions = {
    //   headers: new HttpHeaders({
    //     'Content-Type': 'application/json',
    //   })
    // }
    return this.httpClient.get(this.orderApiUrl + '/sunny');
  }

  createCustomer(body: Customer): Observable<any>{
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      })
    }
    return this.httpClient.post(this.customerApiUrl + '/create', body, httpOptions);
  }

  login(body: Customer): Observable<any> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      })
    }
    return this.httpClient.post(this.customerApiUrl + '/login', body, httpOptions);
  }

  getBillByUsername(username: string): Observable<any>{
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      })
    }
    return this.httpClient.get(this.customerApiUrl + '/all/'+ username, httpOptions);
  }


  getAllEmployees(): Observable<any> {

    // const httpOptions = {
    //   headers: new HttpHeaders({
    //     'Content-Type': 'application/json',
    //   })
    // }
    return this.httpClient.get(this.employeeApiUrl + '/all');
  }

  createEmployee(body: Employee): Observable<any>{
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      })
    }
    return this.httpClient.post(this.employeeApiUrl + '/create', body, httpOptions);
  }

  login_Employee(body: Employee): Observable<any> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      })
    }
    return this.httpClient.post(this.employeeApiUrl + '/login', body, httpOptions);
  }


  getAllMedicines(): Observable<any> {

    // const httpOptions = {
    //   headers: new HttpHeaders({
    //     'Content-Type': 'application/json',
    //   })
    // }
    return this.httpClient.get(this.medicineApiUrl + '/all');
  }

  getExpiringMedicines(): Observable<any> {

    // const httpOptions = {
    //   headers: new HttpHeaders({
    //     'Content-Type': 'application/json',
    //   })
    // }
    return this.httpClient.get(this.medicineApiUrl + '/Expiring');
  }


  createMedicine(body: Medicine): Observable<any>{
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      })
    }
    return this.httpClient.post(this.medicineApiUrl + '/create', body, httpOptions);
  }


  getAllPrescriptions(): Observable<any> {

    // const httpOptions = {
    //   headers: new HttpHeaders({
    //     'Content-Type': 'application/json',
    //   })
    // }
    return this.httpClient.get(this.prescriptionApiUrl + '/all');
  }

  createPrescriptions(body: Prescription): Observable<any>{
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      })
    }
    return this.httpClient.post(this.prescriptionApiUrl + '/create', body, httpOptions);
  }

  createPrescribed_Drugs(body: Prescribed_Drugs): Observable<any>{
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      })
    }
    return this.httpClient.post(this.prescribeddrugsApiUrl + '/create', body, httpOptions);
  }

  createOrdered_Drugs(body: Ordered_Drugs): Observable<any>{
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      })
    }
    return this.httpClient.post(this.ordereddrugApiUrl + '/create', body, httpOptions);
  }

  getPrescriptionBySSN(SSN: string): Observable<any>{
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      })
    }
    return this.httpClient.get(this.prescriptionApiUrl + '/all/'+ SSN, httpOptions);
  }

  getAllPrescribed_drugs(): Observable<any> {

    // const httpOptions = {
    //   headers: new HttpHeaders({
    //     'Content-Type': 'application/json',
    //   })
    // }
    return this.httpClient.get(this.prescribeddrugsApiUrl + '/all');
  }

  getAllOrders(): Observable<any> {

    // const httpOptions = {
    //   headers: new HttpHeaders({
    //     'Content-Type': 'application/json',
    //   })
    // }
    return this.httpClient.get(this.orderApiUrl + '/all');
  }

  createOrders(body: Orders): Observable<any>{
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      })
    }
    return this.httpClient.post(this.orderApiUrl + '/create', body, httpOptions);
  }

  getAllordereddrugs(): Observable<any> {

    // const httpOptions = {
    //   headers: new HttpHeaders({
    //     'Content-Type': 'application/json',
    //   })
    // }
    return this.httpClient.get(this.ordereddrugApiUrl + '/all');
  }


  getAllBills(): Observable<any> {

    // const httpOptions = {
    //   headers: new HttpHeaders({
    //     'Content-Type': 'application/json',
    //   })
    // }
    return this.httpClient.get(this.billApiUrl + '/all');
  }

  createBill(body: Bill): Observable<any>{
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      })
    }
    return this.httpClient.post(this.billApiUrl + '/create', body, httpOptions);
  }

  getOrdersBySSN(SSN: string): Observable<any> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      })
    }
    return this.httpClient.get(this.billApiUrl + '/all/'+ SSN, httpOptions);
  }


  getResult(prescriptionId: number, employeeId:number): Observable<any> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      })
    }
    return this.httpClient.put(this.orderApiUrl + '/update/'+ prescriptionId + "/" + employeeId, httpOptions);
  }


}