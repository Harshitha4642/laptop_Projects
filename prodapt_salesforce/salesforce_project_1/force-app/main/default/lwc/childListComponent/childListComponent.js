import { LightningElement, api } from 'lwc';

export default class ChildListComponent extends LightningElement {
    @api msgfromparent;
    @api msg;
    constructor()
    {
        super();
    }

    @api
    changeMessage(Stringmsg)
    {
        console.log(Stringmsg+"gfuffx");
        this.msgfromparent = Stringmsg;
    }

    
    handlechange(e){
        e.preventDefault();
        let selectEvent = new CustomEvent("prodaptevent", {detail: e.target.value});
        this.dispatchEvent(selectEvent);
    }
}