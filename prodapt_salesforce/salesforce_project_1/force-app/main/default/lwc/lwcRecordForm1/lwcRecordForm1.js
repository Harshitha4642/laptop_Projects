import { LightningElement, api } from 'lwc';


export default class LwcRecordForm1 extends LightningElement {
    @api recordId;
    @api objectApiName;
    @api fields = ['AccountId', 'Name', 'Title', 'Phone', 'Email'];
    constructor(){
        super();
            this.objectApiName ="Account";
    }
}