import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder,FormControl, Validators} from '@angular/forms';
import { CreationService } from '../creation.service';

import { Customer } from '../Customer';
import { Employee } from '../Employee';
import { Medicine } from '../Medicine';
import { Prescription } from '../Presciption';
import { Prescribed_Drugs } from '../Prescribed_Drugs';
import { Orders } from '../Orders';
import { Ordered_Drugs } from '../Ordered_Drugs';
import { Bill } from '../Bill';
import { PrescriptionDTO } from '../PrescriptionDTO';
import { BillDTO } from '../BillDTO';

@Component({
  selector: 'app-outputpage',
  templateUrl: './outputpage.component.html',
  styleUrls: ['./outputpage.component.css']
})
export class OutputpageComponent implements OnInit {

  isLoginPage : boolean = false;
  loginsuccessful: boolean = false;

  isEmployeeLoginPage : boolean = false;
  Employeeloginsuccessful: boolean = false;

  isCustomerCreationPage: boolean = false;
  isEmployeeCreationPage: boolean = false;
  isMedicineCreationPage: boolean = false;
  isMedicineGetPage: boolean = false;
  isshowMainButtons: boolean = true;
  isBillOrderGetPage: boolean = false;
  isBillGetPage: boolean = false;
  isBillOrderedGetPage: boolean = false;
  isOrderGetPage: boolean = false;
  isPrescriptionGetPage: boolean = false;
  isPrescriptiondrugsGetPage: boolean = false;
  isAssignEmployeePage:boolean = false
  isBillEmployeePage:boolean = false;
  isPrescriptionCreatePage:boolean = false;
  isPrescriptionDrugsCreatePage: boolean = false;
  isExpiringMedicinePage:boolean = false;
  isOrderedDrugsCreatePage:boolean =false;

  orderList: Orders[] = [];
  medicinesList: Medicine[] = [];
  expiringMedicinesList: Medicine[] = [];
  billDTO: BillDTO = new BillDTO;
  prescriptionDTO: PrescriptionDTO = new PrescriptionDTO;

  loginForm!: FormGroup;
  addCustomerForm!: FormGroup;
  currentCustomer: Customer = new Customer();
  currentEmployee: Employee = new Employee();

  addEmployeeForm!: FormGroup;
  addMedicineForm!: FormGroup;
  addBillForm!: FormGroup;
  addOrderForm!: FormGroup
  addEmployeeAssignForm!: FormGroup;
  addPrescriptionForm!: FormGroup;
  addBillDTOForm!: FormGroup;
  addPrescriptionDrugsForm!: FormGroup;
  addOrderedDrugsForm!: FormGroup;

  constructor(private fb: FormBuilder, private creationService: CreationService) { }

  ngOnInit(): void {

  }

  login(){

    let body = new Customer();

    body.username= this.loginForm?.get("username")?.value;
    body.password = this.loginForm?.get("password")?.value;

    this.creationService.login(body).subscribe(
      result => {
        let res = result;
        if(res){
          this.currentCustomer = res;
          this.loginsuccessful = true;
          this.isshowMainButtons = false;
        }
      }
    )
  }

  login_Employee(){

    let body = new Employee();

    body.username= this.loginForm?.get("username")?.value;
    body.password = this.loginForm?.get("password")?.value;

    this.creationService.login_Employee(body).subscribe(
      result => {
        let res = result;
        if(res){
          this.currentEmployee = res;
          this.Employeeloginsuccessful = true;
          this.isshowMainButtons = false;
        }
      }
    )

  }

  getMedicines() {
    this.creationService.getAllMedicines().subscribe(
      result => {
        this.medicinesList = result;
      }
    );


  }

  getEmployeeIdNullValues(){
    this.creationService.getAllordersWithEmployeeID().subscribe(
      result => {
        this.orderList = result;
      }
    );

  }

  getBills() {
    this.creationService.getOrdersBySSN(this.currentCustomer.ssn).subscribe(
      result => {
        this.billDTO = result;
      }
    );


  }

  getPrescriptions() {
    this.creationService.getPrescriptionBySSN(this.currentCustomer.ssn).subscribe(
      result => {
        this.prescriptionDTO = result;
      }
    );


  }



  userLoginClick(){
    this.loginsuccessful = false;
    this.isLoginPage = true;
    this.isCustomerCreationPage = false;
    this.isEmployeeCreationPage = false;
    this.isEmployeeLoginPage=false;

    this.loginForm = this.fb.group({
      username: [],
      password: []
    });
  }

  EmployeeuserLoginClick(){
    this.Employeeloginsuccessful = false;
    this.isEmployeeLoginPage = true;
    this.isLoginPage =false;
    this.isCustomerCreationPage = false;
    this.isEmployeeCreationPage = false;
    this.loginForm = this.fb.group({
      username: [],
      password: []
    });
  }

  AssignEmployeeClick(){
    this.isCustomerCreationPage = false;
    this.isEmployeeLoginPage =true;
    this.Employeeloginsuccessful = true;
    this.isEmployeeCreationPage = false;
    this.isMedicineCreationPage = false;
    this.isMedicineGetPage=false;
    this.isOrderGetPage=false;
    this.isAssignEmployeePage =true;
    this.isPrescriptionCreatePage = false;
    this.isBillEmployeePage = false;
    this.isExpiringMedicinePage = false;
    this.isOrderedDrugsCreatePage = false;
    
    this.getEmployeeIdNullValues();
    this.addEmployeeAssignForm =  this.createEmployeeAssignForm();
  }

  createCustomerClick(){
    this.isCustomerCreationPage = true;
    this.isLoginPage = false;
    this.isEmployeeCreationPage =false;
    this.isEmployeeLoginPage=false;

    this.addCustomerForm = this.createCustomerFormGroup();
  }

  createMedicineClick(){
    this.isCustomerCreationPage = false;
    this.isEmployeeLoginPage =true;
    this.Employeeloginsuccessful = true;
    this.isEmployeeCreationPage = false;
    this.isMedicineCreationPage = true;
    this.isMedicineGetPage=false;
    this.isOrderGetPage=false;
    this.isAssignEmployeePage =false;
    this.isPrescriptionCreatePage = false;
    this.isBillEmployeePage = false;
    this.isPrescriptionDrugsCreatePage = false;
    this.isExpiringMedicinePage = false;
    this.isOrderedDrugsCreatePage = false;
    this.addMedicineForm = this.createMedicineFormGroup();

  }

  createBillClick(){
    this.isCustomerCreationPage = false;
    this.isEmployeeLoginPage =true;
    this.Employeeloginsuccessful = true;
    this.isEmployeeCreationPage = false;
    this.isMedicineCreationPage = false;
    this.isMedicineGetPage=false;
    this.isOrderGetPage=false;
    this.isAssignEmployeePage =false;
    this.isPrescriptionCreatePage = false;
    this.isBillEmployeePage = true;
    this.isPrescriptionDrugsCreatePage = false;
    this.isExpiringMedicinePage = false;
    this.isOrderedDrugsCreatePage = false;
    this.addBillForm = this.createBillFormGroup();


  }


  createPrescriptionClick(){
    this.isCustomerCreationPage = false;
    this.isEmployeeLoginPage =true;
    this.Employeeloginsuccessful = true;
    this.isEmployeeCreationPage = false;
    this.isMedicineCreationPage = false;
    this.isMedicineGetPage=false;
    this.isOrderGetPage=false;
    this.isAssignEmployeePage =false;
    this.isPrescriptionCreatePage = true;
    this.isBillEmployeePage = false;
    this.isPrescriptionDrugsCreatePage = false;
    this.isExpiringMedicinePage = false;
    this.isOrderedDrugsCreatePage = false;
    this.addPrescriptionForm = this.createPrescrptionFormGroup();

  }

  createPrescriptionDrugsClick(){
    this.isCustomerCreationPage = false;
    this.isEmployeeLoginPage =true;
    this.Employeeloginsuccessful = true;
    this.isEmployeeCreationPage = false;
    this.isMedicineCreationPage = false;
    this.isMedicineGetPage=false;
    this.isOrderGetPage=false;
    this.isAssignEmployeePage =false;
    this.isPrescriptionCreatePage = false;
    this.isBillEmployeePage = false;
    this.isPrescriptionDrugsCreatePage = true;
    this.isExpiringMedicinePage = false;
    this.isOrderedDrugsCreatePage = false;
    this.addPrescriptionDrugsForm = this.createPrescrptionDrugsFormGroup();


  }

  createOrderedDrugsClick(){
    this.isCustomerCreationPage = false;
    this.isEmployeeLoginPage =true;
    this.Employeeloginsuccessful = true;
    this.isEmployeeCreationPage = false;
    this.isMedicineCreationPage = false;
    this.isMedicineGetPage=false;
    this.isOrderGetPage=false;
    this.isAssignEmployeePage =false;
    this.isPrescriptionCreatePage = false;
    this.isBillEmployeePage = false;
    this.isPrescriptionDrugsCreatePage = false;
    this.isExpiringMedicinePage = false;
    this.isOrderedDrugsCreatePage = true;
    this.addOrderedDrugsForm = this.createOrderedDrugsFormGroup();


  }


  createOrderClick(){
    this.isCustomerCreationPage = false;
    this.isEmployeeLoginPage =true;
    this.Employeeloginsuccessful = true;
    this.isEmployeeCreationPage = false;
    this.isMedicineCreationPage = false;
    this.isMedicineGetPage=false;
    this.isOrderGetPage=true;
    this.isAssignEmployeePage =false;
    this.isPrescriptionCreatePage = false;
    this.isBillEmployeePage = false;
    this.isPrescriptionDrugsCreatePage = false;
    this.isExpiringMedicinePage = false;
    this.isOrderedDrugsCreatePage = false;
    this.addOrderForm = this.createOrderFormGroup();

  }

  getMedicineClick(){
    this.isCustomerCreationPage = false;
    this.isEmployeeLoginPage =true;
    this.Employeeloginsuccessful = true;
    this.isEmployeeCreationPage = false;
    this.isMedicineCreationPage = false;
    this.isMedicineGetPage=true;
    this.isOrderGetPage=false;
    this.isAssignEmployeePage =false;
    this.isPrescriptionCreatePage = false;
    this.isBillEmployeePage = false;
    this.isPrescriptionDrugsCreatePage = false;
    this.isExpiringMedicinePage = false;
    this.isOrderedDrugsCreatePage = false;
    this.getMedicines();
  }

  getExpiringMedicineClick(){
    this.isCustomerCreationPage = false;
    this.isEmployeeLoginPage =true;
    this.Employeeloginsuccessful = true;
    this.isEmployeeCreationPage = false;
    this.isMedicineCreationPage = false;
    this.isMedicineGetPage=false;
    this.isOrderGetPage=false;
    this.isAssignEmployeePage =false;
    this.isPrescriptionCreatePage = false;
    this.isBillEmployeePage = false;
    this.isPrescriptionDrugsCreatePage = false;
    this.isExpiringMedicinePage = true;
    this.isOrderedDrugsCreatePage = false;
    this.getExpiringMedicines();
  }

  getExpiringMedicines() {
    this.creationService.getExpiringMedicines().subscribe(
      result => {
        this.expiringMedicinesList = result;
      }
    );
  }

  getPrescriptionClick(){
    this.isCustomerCreationPage = false;
    this.isLoginPage =true;
    this.loginsuccessful = true;
    this.isEmployeeCreationPage = false;
    this.isMedicineCreationPage = false;
    this.isMedicineGetPage=true;
    this.isBillOrderGetPage=false;
    this.isBillGetPage = false;
    this.isBillOrderedGetPage=false;
    this.isPrescriptionGetPage = true;
    this.isPrescriptiondrugsGetPage = false;
    this.getPrescriptions();
  }

  getPrescriptiondrugsClick(){
    this.isCustomerCreationPage = false;
    this.isLoginPage =true;
    this.loginsuccessful = true;
    this.isEmployeeCreationPage = false;
    this.isMedicineCreationPage = false;
    this.isMedicineGetPage=true;
    this.isBillOrderGetPage=false;
    this.isBillGetPage = false;
    this.isBillOrderedGetPage=false;
    this.isPrescriptionGetPage = false;
    this.isPrescriptiondrugsGetPage = true;
    this.getPrescriptions();
  }

  getBillOrderClick(){
    this.isCustomerCreationPage = false;
    this.isLoginPage =true;
    this.loginsuccessful = true;
    this.isEmployeeCreationPage = false;
    this.isMedicineCreationPage = false;
    this.isMedicineGetPage=true;
    this.isBillOrderGetPage=true;
    this.isBillGetPage = false;
    this.isBillOrderedGetPage=false;
    this.isPrescriptionGetPage = false;
    this.isPrescriptiondrugsGetPage = false;
    this.getBills();
  }



  getBillOrderedClick(){
    this.isCustomerCreationPage = false;
    this.isLoginPage =true;
    this.loginsuccessful = true;
    this.isEmployeeCreationPage = false;
    this.isMedicineCreationPage = false;
    this.isMedicineGetPage=true;
    this.isBillOrderGetPage=false;
    this.isBillGetPage = false;
    this.isBillOrderedGetPage =true;
    this.isPrescriptionGetPage = false;
    this.isPrescriptiondrugsGetPage = false;
    this.getBills();
  }

  getBillClick(){
    this.isCustomerCreationPage = false;
    this.isLoginPage =true;
    this.loginsuccessful = true;
    this.isEmployeeCreationPage = false;
    this.isMedicineCreationPage = false;
    this.isMedicineGetPage=true;
    this.isBillOrderGetPage=false;
    this,this.isBillOrderedGetPage=false;
    this.isBillGetPage = true
    this.isPrescriptionGetPage = false;
    this.isPrescriptiondrugsGetPage = false;
    this.getBills();
  }


  createCustomerFormGroup(){
    return new FormGroup({
      ssn: new FormControl("",[Validators.required]),
      username: new FormControl("",[Validators.required]),
      password: new FormControl("",[Validators.required]),
      first_name: new FormControl("",[Validators.required]),
      last_name: new FormControl("",[Validators.required]),
      phone: new FormControl("",[Validators.required]),
      gender: new FormControl("",[Validators.required]),
      address: new FormControl("",[Validators.required]),
      dateOfBirth: new FormControl("",[Validators.required])
    });
  }

  createPrescrptionDrugsFormGroup(){
    return new FormGroup({
      prescriptionId: new FormControl("",[Validators.required]),
      drugName: new FormControl("",[Validators.required]),
      prescribedQuantity: new FormControl("",[Validators.required]),

    });

  }

  createOrderedDrugsFormGroup(){
    return new FormGroup({
      orderId: new FormControl("",[Validators.required]),
      drugName: new FormControl("",[Validators.required]),
      batchNumber: new FormControl("",[Validators.required]),
      orderedQuantity: new FormControl("",[Validators.required]),
      price: new FormControl("",[Validators.required]),
    });

  }

  createEmployeeClick(){
    this.isEmployeeCreationPage = true;
    this.isEmployeeLoginPage = false;
    this.isLoginPage=false;
    this.isEmployeeLoginPage=false;
    this.isCustomerCreationPage=false;
    this.addEmployeeForm = this.createEmployeeFormGroup();
  }

  createEmployeeFormGroup() {
    return new FormGroup({
      id: new FormControl("",[Validators.required]),
      ssn: new FormControl("",[Validators.required]),
      username: new FormControl("",[Validators.required]),
      password: new FormControl("",[Validators.required]),
      first_name: new FormControl("",[Validators.required]),
      last_name: new FormControl("",[Validators.required]),
      role: new FormControl("",[Validators.required]),
      salary: new FormControl("",[Validators.required]),
      phoneNumber: new FormControl("",[Validators.required]),

    });

  }



  createBillDTOFormGroup() {
    return new FormGroup({
      orderId: new FormControl("",[Validators.required]),
      customerssn: new FormControl("",[Validators.required]),
      totalAmount: new FormControl("",[Validators.required]),
      customerAmount: new FormControl("",[Validators.required]),
      order: new FormControl("",[Validators.required]),
      ordereddrugs: new FormControl("",[Validators.required]),

    });

  }

  createBillFormGroup(){
    return new FormGroup({
      orderId: new FormControl("",[Validators.required]),
      customerssn: new FormControl("",[Validators.required]),
      totalAmount: new FormControl("",[Validators.required]),
      customerAmount: new FormControl("",[Validators.required]),

    });

  }

  createPrescrptionFormGroup(){
    return new FormGroup({
      prescriptionId: new FormControl("",[Validators.required]),
      ssn: new FormControl("",[Validators.required]),
      doctorId: new FormControl("",[Validators.required]),

    });

  }


  CreateCustomer(){
    let body = new Customer();

    body.ssn = this.addCustomerForm?.get("ssn")?.value;
    body.username = this.addCustomerForm?.get("username")?.value;
    body.password = this.addCustomerForm?.get("password")?.value;
    body.first_name = this.addCustomerForm?.get("first_name")?.value;
    body.last_name = this.addCustomerForm?.get("last_name")?.value;
    body.phone = this.addCustomerForm?.get("phone")?.value;
    body.gender = this.addCustomerForm?.get("gender")?.value;
    body.address = this.addCustomerForm?.get("address")?.value;
    body.dateOfBirth = this.addCustomerForm?.get("dateOfBirth")?.value;

    this.creationService.createCustomer(body).subscribe(
      result => {
        console.log(result);
      }
    );
  }

  CreateEmployee(){

    let body = new Employee();

    body.ssn = this.addEmployeeForm?.get("ssn")?.value;
    body.username = this.addEmployeeForm?.get("username")?.value;
    body.password = this.addEmployeeForm?.get("password")?.value;
    body.first_name = this.addEmployeeForm?.get("first_name")?.value;
    body.last_name = this.addEmployeeForm?.get("last_name")?.value;
    body.role = this.addEmployeeForm?.get("role")?.value;
    body.salary = this.addEmployeeForm?.get("salary")?.value;
    body.phoneNumber = this.addEmployeeForm?.get("phoneNumber")?.value;

    this.creationService.createEmployee(body).subscribe(
      result => {
        console.log(result);
      }
    );

  }


  createMedicineFormGroup() {
    return new FormGroup({
      drugName: new FormControl("",[Validators.required]),
      batchNumber: new FormControl("",[Validators.required]),
      manufacturer: new FormControl("",[Validators.required]),
      stockQuantity: new FormControl("",[Validators.required]),
      phoneNumber: new FormControl("",[Validators.required]),
      expiryDate: new FormControl("",[Validators.required]),
      price: new FormControl("",[Validators.required]),

    });

  }

  createOrderFormGroup() {
    return new FormGroup({
      orderId: new FormControl("",[Validators.required]),
      prescriptionId: new FormControl("",[Validators.required]),
      employeeId: new FormControl("",[Validators.required]),
      orderDate: new FormControl("",[Validators.required]),
    });

  }


  CreateMedicine(){

    let body = new Medicine();

    body.drugName = this.addMedicineForm?.get("drugName")?.value;
    body.batchNumber = this.addMedicineForm?.get("batchNumber")?.value;
    body.manufacturer = this.addMedicineForm?.get("manufacturer")?.value;
    body.stockQuantity = this.addMedicineForm?.get("stockQuantity")?.value;
    body.expiryDate = this.addMedicineForm?.get("expiryDate")?.value;
    body.price = this.addMedicineForm?.get("price")?.value;

    this.creationService.createMedicine(body).subscribe(
      result => {
        console.log(result);
      }
    );

  }

  CreateOrder(){
    let body = new Orders();

    body.orderId = this.addOrderForm?.get("orderId")?.value;
    body.prescriptionId = this.addOrderForm?.get("prescriptionId")?.value;
    body.employeeId = this.addOrderForm?.get("employeeId")?.value;
    body.orderDate = this.addOrderForm?.get("orderDate")?.value;

    this.creationService.createOrders(body).subscribe(
      result => {
        console.log(result);
      }
    );


  }

  CreateBill(){
    let body = new Bill();

    body.orderId = this.addBillForm?.get("orderId")?.value;
    body.customerssn = this.addBillForm?.get("customerssn")?.value;
    body.totalAmount = this.addBillForm?.get("totalAmount")?.value;
    body.customerAmount = this.addBillForm?.get("customerAmount")?.value;

    this.creationService.createBill(body).subscribe(
      result => {
        console.log(result);
      }
    );


  }

  CreatePrescription(){
    let body = new Prescription();

    body.prescriptionId = this.addPrescriptionForm?.get("prescriptionId")?.value;
    body.ssn = this.addPrescriptionForm?.get("ssn")?.value;
    body.doctorId = this.addPrescriptionForm?.get("doctorId")?.value;

    this.creationService.createPrescriptions(body).subscribe(
      result => {
        console.log(result);
      }
    );


  }

  CreatePrescriptionDrugs(){
    let body = new Prescribed_Drugs();

    body.prescriptionId = this.addPrescriptionDrugsForm?.get("prescriptionId")?.value;
    body.drugName = this.addPrescriptionDrugsForm?.get("drugName")?.value;
    body.prescribedQuantity = this.addPrescriptionDrugsForm?.get("prescribedQuantity")?.value;

    this.creationService.createPrescribed_Drugs(body).subscribe(
      result => {
        console.log(result);
      }
    );


  }

  CreateOrderedDrugs(){
    let body = new Ordered_Drugs();

    body.orderId = this.addOrderedDrugsForm?.get("orderId")?.value;
    body.drugName = this.addOrderedDrugsForm?.get("drugName")?.value;
    body.batchNumber = this.addOrderedDrugsForm?.get("batchNumber")?.value;
    body.orderedQuantity = this.addOrderedDrugsForm?.get("orderedQuantity")?.value;
    body.price = this.addOrderedDrugsForm?.get("price")?.value;

    this.creationService.createOrdered_Drugs(body).subscribe(
      result => {
        console.log(result);
      }
    );


  }

  createBillDTO() {

    let body = new BillDTO();

    body.orderId = this.addBillDTOForm?.get("orderId")?.value;
    body.customerssn = this.addBillDTOForm?.get("customerssn")?.value;
    body.totalAmount = this.addBillDTOForm?.get("totalAmount")?.value;
    body.customerAmount = this.addBillDTOForm?.get("customerAmount")?.value;
    body.order = this.addBillDTOForm?.get("order")?.value;
    body.ordereddrugs= this.addBillDTOForm?.get("ordereddrugs")?.value;

    this.creationService.createBill(body).subscribe(
      result => {
        console.log(result);
      }
    );


  }

  createEmployeeAssign(){

    let prescriptionId = this.addEmployeeAssignForm?.get("prescriptionId")?.value;

    this.creationService.getResult(prescriptionId, this.currentEmployee.id).subscribe(
      result => {
        console.log(result);
      }
    );

  }

  createEmployeeAssignForm(){
    return new FormGroup({
      prescriptionId: new FormControl("",[Validators.required]),

    });

  }






}


