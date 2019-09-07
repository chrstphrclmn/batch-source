//1. Write a JavaScript to find the longest string from a given array of strings and returns
//   the string’s array index.
function maxLength(){
    let longestString = "";
    let strings = [arguments.length];
        for(let i =0;i<arguments.length;i++){
            strings[i] = arguments[i];
        if (arguments[i].length>longestString.length){
                longestString = arguments[i];
        } 
        var num = strings.indexOf(longestString);
    }
    console.log(num);
}

//2. Write a JavaScript function to reverse the elements of a given array.
function reverseArray(){
    let num = arguments.length;
    let strings = [];
    let reverseStrings = [];
    let num2 =0;
    for (let i = 0; i<num ;i++){
        strings[i] = arguments[i];
    }
    for (let i =(num);i>0;i--){
        reverseStrings[num2] = strings[i-1];
        num2++;
    }
    console.log(reverseStrings);
}

//3. Write a JavaScript function to count the number of vowels in a given string.
function vowelCount(){
    let count = 0;
    for (let i =0;i<arguments[0].length;i++)
        if(arguments[0].charAt(i)==="a"||arguments[0].charAt(i)==="e"||arguments[0].charAt(i)==="i"||arguments[0].charAt(i)==="o"||arguments[0].charAt(i)==="u"){
            count++;
        }
        console.log(count);
}

//4. Create a function that checks for a valid email format.
function isValidEmail(email){
    let isValid = false;
    let regex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if(email.match(regex)){
        isValid = true;
    }
    console.log(isValid);
}

//5. Write a JavaScript function to remove a character at the specified position of 
//a given string and return the new string.
function removeChar(string, num){
    letter = string.charAt(num);
    console.log(string.replace(letter,""));
}

//6. Use the bubble sort algorithm to sort the array. 
//You may need to look up the algorithm if you’re not familiar with it.
function bubbleSort(){

    for (let i=0;i<arguments.length;i++){

    }
}

//7. Return true if even, false if odd.
function isEven(num){
    if((num%2)==1){
        console.log(false);
    } else {
        console.log(true);
    }
}

//8. Return true if someStr is a palindrome, otherwise return false.
function isPalindrome(string){
    let string2="";
    for(let i = (string.length)-1;i>=0;i--){
        string2 = string2 + string.charAt(i);
    }
    if(string===string2){
        console.log(true);
    } else{
        console.log(false)
    }
}

