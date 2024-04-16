import { LightningElement, track } from 'lwc';
import createPlanRecord from '@salesforce/apex/PlanController.createPlanRecord';

export default class PlanComponent extends LightningElement {
 
    @track planName;
    @track planDuration;
    @track messageRate;
    @track price;
    @track internetRate;
    @track freeSms;
    @track freeInternet;
    @track freeCalls;
    @track callRate;
 
    handleInputChange(event) {
        const fieldName = event.target.name;
        const fieldValue = event.target.value;
        this[fieldName] = fieldValue;
    }
 
    handleSave() {
               
        createPlanRecord({
            planName: this.planName, planDuration: this.planDuration, messageRate: this.messageRate, price: this.price,
            internetRate: this.internetRate, freeSms: this.freeSms, freeInternet: this.freeInternet, freeCalls: this.freeCalls, callRate: this.callRate 
        })
        .then(result => {
            console.log('Record saved successfully: ', result);
            this.resetFields();
        })
        .catch(error => {
            console.error('Error saving record: ', error);
        });
    }
 
    resetFields() {
        this.planName = ''; this.planDuration = ''; this.messageRate = ''; this.price = ''; this.internetRate = '';
        this.freeSms = ''; this.freeInternet = ''; this.freeCalls = ''; this.callRate = '';
    }
}