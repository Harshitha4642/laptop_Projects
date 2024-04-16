import { LightningElement, track } from 'lwc';
import createCountryRecord from '@salesforce/apex/CountryController.createCountryRecord';

export default class CreateCountry extends LightningElement {
    @track visaStatusOptions = [
        { label: 'Visa-free', value: 'Visa-free' },
        { label: 'Visa-Restricted', value: 'Visa-Restricted' },
        { label: 'Regular Visa', value: 'Regular Visa' },
        { label: 'Visa-on-Arrival', value:'Visa-on-Arrival'}
    ];
    @track countryName;
    @track countryCapital;
    @track visaStatus;
    @track fieldName;
    @track fieldValue;

    handleInputChange(event) {
        const fieldName = event.target.name;
        const fieldValue = event.target.value;
        this[fieldName] = fieldValue;
        console.log(fieldName+" "+fieldValue);
    }

    handleSave(event){
        console.log(this.countryCapital);
        console.log(this.countryName);
        console.log(this.visaStatus);
        console.log("change");
        createCountryRecord({countryName: this.countryName,
        countryCapital: this.countryCapital,
        visaStatus: this.visaStatus
        })
        .then(result => {
            console.log('Record saved successfully: ', result);
            this.resetFields();
        })
        .catch(error => {
            console.error('Error saving record: ', error);
        });

    }
}