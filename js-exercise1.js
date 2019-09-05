// Michael Zhang JSExercise 1

// Q1: Longest String

function maxLength(arr){

    if(!arr) return NaN;

    let maxLength = -1;
    let idx = -1;

    for(let i = 0; i < arr.length ; i++){

        if(arr[i].length > maxLength){

            maxLength = arr[i].length;
            idx = i;
        }
    }

    return idx;
}

// Q2: Array Reversal

function reverseArray(arr){

    let returnArray = [];

    while(arr.length){

        returnArray.push(arr.pop());
    }

    return returnArray;
}

// Q3: Counting Vowels

function vowelCount(str){

    let ret = 0;

    for(let i = 0 ; i < str.length ; i++){

        let c = str.toLowerCase().charAt(i)

        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){

            ret ++;
        }
    }

    return ret;
}

// Q4: Email Validation

function isValidEmail(str){

    const EMAIL_REGEX = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

    return (EMAIL_REGEX.test(str.toUpperCase()));
}

// Q5: Remove Char

function removeChar(str, idx){

    let ret = "";

    for(let i = 0 ; i < str.length ; i++){

        if(i != idx) ret += str[i];
    }

    return ret;
}

// Q6: BubbleSort

function bubbleSort(arr){

    let temp;
    let sorted = true;

    do{

        sorted = true;

        for(let i = 1 ; i < arr.length ; i++){

            if(arr[i] < arr[i - 1]){

                temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
                sorted = false;
            }
        }

    } while(!sorted);

    return arr;
}

// Q7: Even number

function isEven(num){

    return String(num / 2).indexOf(".") == -1;
}

// Q8: Palindrome

function isPalindrome(str){

    let x = "";

    for(let i = str.length - 1 ; i >= 0 ; i--){

        x += str.charAt(i);
    }

    return x.toLowerCase() === str.toLowerCase();
}

// Q9: Leap Year

function isLeapYear(date){

    let year = date.getFullYear();

    if(year % 4) return false;
    else if(year % 100) return true;
    else if(year % 400) return false;
    else return true;
}

// Q10: Shapes

function printShape(shape, height, char){

    let line = "";

    if(shape.toLowerCase() == "square"){

        for(let i = 1 ; i <= height ; i++){

            line = "";

            for(let j = 1 ; j <= height ; j ++){

                line += char;
            }

            console.log(line);
        }
    }

    if(shape.toLowerCase() == "triangle"){

        for(let i = 1 ; i <= height ; i++){

            line = "";

            for(let j = 1 ; j <= i ; j ++){

                line += char;
            }

            console.log(line);
        }
    }

    if(shape.toLowerCase() == "diamond"){

        if(height % 2){

            for(let i = 1 ; i <= height ; i += 2){

                line = "";

                for(let j = 1 ; j <= (height - i) / 2 ; j++){

                    line += " ";
                }

                for(let j = 1 ; j <= i ; j ++){

                    line += char;
                }

                for(let j = 1 ; j <= (height - i) / 2 ; j++){

                    line += " ";
                }

            console.log(line);

            }

            for(let i = height - 2; i >= 1 ; i -= 2){

                line = "";

                for(let j = 1 ; j <= (height - i) / 2 ; j++){

                    line += " ";
                }

                for(let j = 1 ; j <= i ; j ++){

                    line += char;
                }

                for(let j = 1 ; j <= (height - i) / 2 ; j++){

                    line += " ";
                }

            console.log(line);

            }
        }

        else{

            for(let i = 2 ; i <= height ; i += 2){

                line = "";

                for(let j = 1 ; j <= (height - i) / 2 ; j++){

                    line += " ";
                }

                for(let j = 1 ; j <= i ; j ++){

                    line += char;
                }

                for(let j = 1 ; j <= (height - i) / 2 ; j++){

                    line += " ";
                }

            console.log(line);

            }

            for(let i = height - 2; i >= 2 ; i -= 2){

                line = "";

                for(let j = 1 ; j <= (height - i) / 2 ; j++){

                    line += " ";
                }

                for(let j = 1 ; j <= i ; j ++){

                    line += char;
                }

                for(let j = 1 ; j <= (height - i) / 2 ; j++){

                    line += " ";
                }

            console.log(line);

            }
        }
    }
}

// Q11 : Rotate left

function rotate(arr, n){

    let offset = n % arr.length;
    let temp;
    
    for(let i = 0 ; i < offset ; i++){

        temp = arr[0];

        for(let j = 0 ; j < arr.length - 1 ; j++){

            arr[j] = arr[j + 1];
        }

        arr[arr.length - 1] = temp;
    }

    return arr;
}

// Q12: Bracket Balance

function balance(str){

    let stack = [];

    for(let char of str){

        if(char == '(') stack.push(')');
        else if (char == '[') stack.push(']');
        else if (char == '{') stack.push('}');

        else if (char == ')'){

            if(char != stack.pop()) return false;
        }

        else if (char == ']'){

            if(char != stack.pop()) return false;
        }

        else if (char == '}'){

            if(char != stack.pop()) return false;
        }
    }

    return(!stack.length);

}