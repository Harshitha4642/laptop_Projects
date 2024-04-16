import { LightningElement, api } from 'lwc';

export default class ParentOrderComponent extends LightningElement {
    @api msg;
    @api childmsg;
    constructor()
    {
        super();
        console.log('constructor ran');
    }
    connectedCallback(){
        console.log('connected callback run');

    }
    renderedCallback(){
        console.log('rendered callback run');
    }
    handlechange(e) {
       
        this.msg = e.target.value;
        console.log("iam event"+e.target.value);
        this.template.querySelector('c-child-List-Component').changeMessage(this.msg);     
    }
    handlevent(e)
    {
        this.childmsg = e.detail;
    }
}