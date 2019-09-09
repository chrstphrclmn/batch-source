function maxLength(array){
    let max = array[0];
    for(let i=0; i<array.length; i++){
        if(array[i].length > max.length){
            max = array[i];
        }
    }
    return max;
}

function reverseArray(array){
    let new_arr = arr.reverse();
}

function vowelCount(string){
    let vowel = "aeiouAEIOU";
    let count = 0;
    for(let i = 0; i<string.length; i++){
        if(vowel.indexOf(string[i]) != -1){
            count++;
        }
    }
    return count;
}

function isValidEmail(string){
    let rex = /\S+@\S+\.\S+/;
    return rex.test(string);
}

function removeChar(string, index){
    let start = string.substring(0, index);
    let end = string.substring(index + 1, string.length);
    let remove = start + end;
    return remove;
}

function bubbleSort(numArray){
    let l = numArray.length;
    for (let i = 0; i<l; i++){
        for(let j = 0; j<l-i-1; j++){
            if(numArray[j] > numArray[j+1]){
                let temp = numArray[j];
                numArray[j] = numArray[j+1];
                numArray[j+1] = temp;
            }
        }
    }
    return numArray;
}

function isEven(someNum){
    return !( someNum & 1 ); 
}

function isPalindrome(someStr){
    let l = someStr.length;
    for(let i=0; i< l/2; i++){
        if(someStr[i] != someStr[l-i-1]){
            return false;
        }
    }
    return true;
}

function isLeapYear(date){
    if(date % 4 == 0){
        if(date % 100 == 0){
            if(date % 400 ==0){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return true;
        }
    }
    return false;
}

function printShape(shape, height, character){
    switch(shape){
        case 'Square':
            for(let i =0; i<height; i++){
                let ch = "";
                for(let j = 0; j<height; j++){
                    ch += character;
                }
                console.log(ch);
            }
            
        case 'Triangle':
            for(let i =0; i<height; i++){
                let ch = "";
                for(let j = 0; j<=i; j++){
                    ch += character;
                }
                console.log(ch);
            }
        
        case 'Diamond':
            let str = '';
            for(let i=1; i<=height; i++){
                for(let k=1; k<=height-i; k++){
                    str += " ";
                }
                for(let j=1; j<=i; j++){
                    str += "*" + " ";
                }
                console.log(str);
                str = "";
            }
            for(let i=1; i<=height; i++){
                let j=1; j<=i; j++
                for(let j=1; j<=i; j++){
                    str +=" ";
                }
                for(let k=1; k<=height-i; k++){
                    str += "*" + " ";
                }
                console.log(str);
                str = "";
            }

                
    }
}

function rotate(array, n){
    for(let i = 0; i<n; i++){
        let temp = array[0];
        for(let j=0; j<array.length-1; j++){
            array[j] = array[j+1];
        }
        array[array.length-1] = temp;
        }
    return array;
    }

function balanced(string){
    let matching;
    let ch;
    let stack = []
    let openBrackets = ['[', '{', '(']
    let closBrackets = [']', '}', ')']
    for (let i = 0; i < string.length; i++) {
        ch = string[i]
        if (closBrackets.indexOf(ch) > -1) {
          matching = openBrackets[closBrackets.indexOf(ch)]
          if (stack.length == 0 || (stack.pop() != matching)) {
            return false
          }
        } else {
          stack.push(ch)
        }
      }
    
      return (stack.length == 0)
    }
