import { LightningElement, wire } from 'lwc';
import getApplicationStatistics from '@salesforce/apex/ApplicationDashboardController2.getApplicationStatistics';
export default class VisaDashboard extends LightningElement {

    totalApplications = 0;
    approvedApplications = 0;
    deniedApplications = 0;
    constructor(){
        console.log('inside constructor');
        super();
    }
 
    @wire(getApplicationStatistics)
    wiredApplicationStatistics({ error, data }) {
        if (data) {
            console.log('inside the statistics function');
            this.totalApplications = data.totalApplications;
            this.approvedApplications = data.approvedApplications;
            this.deniedApplications = data.deniedApplications;
            console.log(this.deniedApplications);
            console.log(this.totalApplications);
            console.log(this.approvedApplications);
 
        } else if (error) {
            console.error('Error fetching application statistics:', error);
        }
    }
}