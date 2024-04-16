import { LightningElement,api, wire, track } from 'lwc';
import FirstName from '@salesforce/schema/Contact.FirstName'
import LastName from '@salesforce/schema/Contact.LastName';
import Email from '@salesforce/schema/Contact.Email';
import Id from '@salesforce/schema/Contact.Id';
import ContactObject from '@salesforce/schema/Contact';
import { createRecord } from 'lightning/uiRecordApi';
import { updateRecord } from 'lightning/uiRecordApi';
import { getRecord } from 'lightning/uiRecordApi';
import { getFieldValue } from 'lightning/uiRecordApi';
import {NavigationMixin} from 'lightning/navigation';
import { deleteRecord } from 'lightning/uiRecordApi';
import { ShowToastEvent } from "lightning/platformShowToastEvent";

export default class lwcContactForm extends NavigationMixin(LightningElement) {
    @api firstName;
    @api lastName;
    @api email;
    @api fields;
    @api recordId
    constructor(){
        super();
        this.fields ={};
    }

    connectedCallback(){
        console.log(this.recordId);
    }
 
    @wire(getRecord, { recordId: '$recordId', fields: [FirstName,LastName, Email] })
    handle(result){
    console.log('this is get record');
   console.log(JSON.stringify(result.data)+ "hey hello");
   
    this.lastName = getFieldValue(result.data,LastName);
    this.firstName = getFieldValue(result.data,FirstName);
    this.email = getFieldValue(result.data,Email);

    console.log(this.lastName+ " :last name");
    console.log(this.firstName+ ": first name");
    console.log(this.email+ ": email");
  //  console.log(this.name +'name');
    
}
    handleChange(event){
        event.preventDefault();
        let {name , value} = event.target;
        console.log("hey");
        if(name == 'firstname'){
            //console.log("first" + value);
            this.fields[FirstName.fieldApiName] = value;
        }
        else if(name == 'lastname'){
            //console.log("last" + value);
            this.fields[LastName.fieldApiName] = value;
        }
        else if(name == 'email'){
            //console.log("email" + value);
            this.fields[Email.fieldApiName] = value;
        }
    }
 
    @api
    handleClick(e){
        e.preventDefault();
      const recordInput = {
        apiName: ContactObject.objectApiName,
        fields: this.fields
    };
       
        createRecord(recordInput).then((record) => {
            console.log(record);
          });
        }
    
    
    handleClick2(e){
        e.preventDefault();
        console.log('updateing '+ this.recordId);
        this.fields[Id.fieldApiName] =this.recordId;
     
       console.log('value of fields' +this.fields);
    const recordInput2 = {
            fields: this.fields
            };
          updateRecord(recordInput2).then((record) => {
                console.log(record);
              });
    }

    navigateToObjectHome() {
        // Navigate to the Account home page
        console.log("nene adi nene");
        this[NavigationMixin.Navigate]({
            type: 'standard__objectPage',
            attributes: {
                objectApiName: 'Contact',
                actionName: 'home',
            },
        });
    }

    @track error;
  deleteTheContact(event) {
    console.log("nene adi nene.. ah cheera utikindi nene");
    deleteRecord(this.recordId)
      .then(() => {
        this.dispatchEvent(
          new ShowToastEvent({
            title: "Success",
            message: "Record deleted",
            variant: "success",
          }),
        );
        // Navigate to a record home page after
        // the record is deleted, such as to the
        // contact home page
        this[NavigationMixin.Navigate]({
          type: "standard__objectPage",
          attributes: {
            objectApiName: "Contact",
            actionName: "home",
          },
        });
      })
      .catch((error) => {
        this.dispatchEvent(
          new ShowToastEvent({
            title: "Error deleting record",
            message: error.body.message,
            variant: "error",
          }),
        );
      });
  }
}