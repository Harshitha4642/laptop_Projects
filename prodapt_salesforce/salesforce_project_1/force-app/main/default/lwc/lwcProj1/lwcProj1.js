import { LightningElement, api, track } from 'lwc';

export default class LwcProj1 extends LightningElement {
    @api name;
    @api email;
    @api phone;
    constructor(){
        super();
        console.log("this is salesforce session by Harshitha");
        this.name = 'Harshitha';
        this.email = 'harshithamodali13@gmail.com';
        this.phone = '8718927111';
    }
    changeName(e)
    {
        this.name = e.target.value;
        console.log(this.name);
    }
    changePhone(e)
    {
        this.phone = e.target.value;
    }
}