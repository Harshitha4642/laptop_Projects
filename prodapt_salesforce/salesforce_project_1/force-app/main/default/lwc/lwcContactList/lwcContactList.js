import { LightningElement,api,wire } from 'lwc';
import getcontacts from '@salesforce/apex/LWCcontactcontroller.getcontacts'
export default class lwcContactList extends LightningElement {
    @api contactlist;
 
    constructor(){
    super();
    console.log('constructor ran from contact list');
}
 

@wire(getcontacts, { })
 handleresult(result){ //this will handle the return value
    console.log('wire call ran');
   //console.log(JSON.stringify(result.data));
  this.contactlist = JSON.stringify(result.data);
 
}
}