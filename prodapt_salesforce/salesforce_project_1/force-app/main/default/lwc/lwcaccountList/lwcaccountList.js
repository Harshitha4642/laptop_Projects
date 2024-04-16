import { LightningElement, wire, api } from 'lwc';
import getaccounts from '@salesforce/apex/AccountController1.getaccounts';
import getaccounts2 from '@salesforce/apex/AccountController1.getaccounts2';

export default class LwcaccountList extends LightningElement {
    @api localresult;
    constructor(){
        super();
        console.log("constructor is running");
    }
    //@wire(getaccounts, { })
    connectedCallback(){
        console.log('connected callback run');

    }
    renderedCallback(){
        console.log('rendered callback run');
    }

    handleresult(result)
    {
        //this will handle the return value
        console.log(JSON.stringify(result.data));
        this.localresult = JSON.stringify(result.data);
    }

    handleClick(e){
        getaccounts2 ({}).
        then(result=>{
            console.log('non wired'+ JSON.stringify(result));
            this.localresult = result;
        }).
        catch(error=>{ console.log('non wired'+error); })
    }
}