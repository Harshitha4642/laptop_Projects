import { Component } from '@angular/core';
import { OdometerServiceService } from '../odometer-service.service';

@Component({
  selector: 'app-odometer',
  templateUrl: './odometer.component.html',
  styleUrls: ['./odometer.component.css']
})
export class OdometerComponent {
  odo: OdometerServiceService = new OdometerServiceService();
  odoReading: number = 1234;
  message: String = "";
  private max = 123456789;
  private min = 0;
  increment(): any{
    if(this.validate()){
      this.odoReading = this.odo.incrementReading(this.odoReading);
      this.message = "";
    }
    return(this.odoReading);
  }

  decrement(): any{
    if(this.validate()){
      this.odoReading = this.odo.decrementReading(this.odoReading);
      this.message = "";
    }
    return(this.odoReading);
  }
  
  reset(): number{
    this.odoReading = 1234;
    this.message = "";
    return(this.odoReading);
  }

  validate(): boolean {
    if(this.odoReading == null)
    {
      this.message = "Enter some number";
      return false;
    }
    else if(this.odoReading > this.max || this.odoReading < this.min){
        this.message = "Reading not in specified range, Enter a number between 0 to 12345678";
        return false;
    }

    else if(!this.isAscending(this.odoReading)){
        this.message = "Enter the number in ascending order";
        return false;
    }

    else{
      return true;
    }
  }

  isAscending(num: number): boolean {
    const numStr = num.toString();
    for (let i = 0; i < numStr.length - 1; i++) {
      if (parseInt(numStr[i], 10) > parseInt(numStr[i + 1], 10)) {
        return false;
      }
    }
    return true;
  }
  

}


