import { LightningElement, api, track } from 'lwc';

export default class RevisionLWC extends LightningElement {
    @api name;
    @api email;

    @api showname;
    @api showemail;
    @api isClicked;

    @track fieldName;
    @track fieldvalue;

    constructor(){
        super();
        console.log('Constructor executed');
        this.isClicked = false;
    }

    showDetails() {
        this.showname = this.name;
        this.showemail = this.email;
        this.isClicked = !this.isClicked;
        console.log(this.isClicked);
    }

    handleChange(event) {
        this[event.target.name] = event.target.value;
    }
}
