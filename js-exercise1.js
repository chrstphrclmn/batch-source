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