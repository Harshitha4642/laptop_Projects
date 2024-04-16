import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class OdometerServiceService {

  constructor() { }
  private max = [9, 8, 7, 6, 5, 4, 3, 2, 1];
  

  incrementReading(odoReading: number): number{
      console.log("entered function");
      const readArray = this.makeArray(odoReading);
      const size = readArray.length;
      let i = size - 1;
  
      while (i >= 0) {
        if (readArray[i] < this.max[size - 1 - i]) {
          const number = this.makeNumber(readArray);
          if (this.isAscending(number) && i === size - 1) {
            readArray[i] = readArray[i] + 1;
            const numb = this.makeNumber(readArray);
            odoReading = numb;
            return(odoReading);
          } 
          
          else {
            let temp = readArray[i] + 1;
            for (let varIndex = i; varIndex <= size - 1; varIndex++) {
              readArray[varIndex] = temp++;
            }
            const result = this.makeNumber(readArray);
            odoReading = result;
            return(odoReading);
          }
        }
        else if (readArray[i] === this.max[size - 1 - i]) {
          i--;
        }
      }
    
    return 1;
  }

  decrementReading(odoReading: number) : number{
      const readArray = this.makeArray(odoReading);
      const max = [9, 8, 7, 6, 5, 4, 3, 2, 1];
      const size = readArray.length;
      let i = size - 1;
  
      while (i >= 0) {
        if (i !== 0 && readArray[i] !== readArray[i - 1] + 1) {
          readArray[i] = readArray[i] - 1;
          const numb = this.makeNumber(readArray);
          odoReading = numb;
          return(odoReading);
        } else {
          if (i !== 0) {
            readArray[i] = max[size - 1 - i];
            i--;
          } else {
            readArray[i] = readArray[i] - 1;
            const numb = this.makeNumber(readArray);
           odoReading = numb;
           return(odoReading);
          }
        }
      }
    return 0;
  }
  
  makeArray(num: number): number[] {
    const numStr = num.toString();
    return numStr.split('').map((char) => parseInt(char, 10));
  }
  
  makeNumber(array: number[]): number {
    return parseInt(array.join(''), 10);
  }

  isAscending(num: number): boolean {
    const numStr = num.toString();
    for (let i = 0; i < numStr.length - 1; i++) {
      if (numStr[i] > numStr[i + 1]) {
        return false;
      }
    }
    return true;
  }


}

