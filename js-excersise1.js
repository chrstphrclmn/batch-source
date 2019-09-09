/*Upload a file named “js-exercise1.js” to your branch by Monday with the following function declarations:
	
/////////////////// required 
1.      Longest String 
Define function: maxLength(array)
Write a JavaScript to find the longest string from a given array 
of strings and returns the string’s array index.
 */

function maxLength(array){
    var index=0;
    var maxLength=0;
    var maxLength1=0;
    var x;
    var respuesta=[];
    for(x in array){
        if(x>0){
            maxLength1=array[x-1].length
        }
        maxLength=array[x].length
        index=x;
        if(maxLength<=maxLength1){
            maxLength=maxLength1;
            index=x-1;
        }
    }
    respuesta[0]=maxLength;
    respuesta[1]=index;
    return respuesta;

}
var a = ["","","adsadasdasdasdas","ajsdasasd"];

/*
2.      Reverse Array
Define function: reverseArray(array)
Write a JavaScript function to reverse the elements 
of a given array.
*/

function reverseArray(array){
    var newArray=[];
    var i;
    for (i in array ){
        newArray[i]=array[array.length-i-1];
    }

    return newArray;
}
b=[1,2,3,4];

/* 
3.     Count Vowels 
	Define function: vowelCount(string)
     Write a JavaScript function to count the number 
     of vowels in a given string.
*/
function vowelCount(string){
    var i;
    var l=string.length;
    var counter=0;
    var vowel;
    
    for(i=0; i<l;i++){
        vowel=string.charAt(i);
        
        if(vowel=="a"||vowel=="e"||vowel=="i"||vowel=="o"||
            vowel=="u"||vowel=="A"||vowel=="E"||vowel=="I"||
            vowel=="O"||vowel=="U"){
            
            counter++;                        
        }

        

    }
    return counter;
}

c="andres";

/*
 
4.      Email Validation 	
Define function: isValidEmail(string)
Create a function that checks for a valid email format.
*/
function isValidEmail(string){
    var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if(string.match(mailformat)){
    return true;
    }
    else{
    console.log("You have entered an invalid email address!");
    return false;
    }
}

/* 
5.     Remove Character
	Define function: removeChar(string, index)
Write a JavaScript function to remove a character at 
the specified position of a given string and return
 the new string.
*/

function removeChar(string, index){
    var i=0;
    var l=string.length;
    var s="";
    for(i=0;i<l;i++){
        if(i==index){
            i++;
        }

        s=s+string.charAt(i);


    }
    return s;
}



/*
6.       Bubble Sort
Define function: bubbleSort(numArray)
Use the bubble sort algorithm to sort the array. You may need to look up the algorithm if you’re not familiar with it
Return the sorted array.
*/
function swap(arr, first_Index, second_Index){
    var temp = arr[first_Index];
    arr[first_Index] = arr[second_Index];
    arr[second_Index] = temp;
}

function bubbleSort(arr){

    var len = arr.length,
        i, j, stop;

    for (i=0; i < len; i++){
        for (j=0, stop=len-i; j < stop; j++){
            if (arr[j] > arr[j+1]){
                swap(arr, j, j+1);
            }
        }
    }

    return arr;
}
console.log(bubbleSort([3, 0, 2, 5, -1, 4, 1]));

var array=[6,3,2,7,5];
console.log(array);
/*
function bubbleSort(numArray){
    var newNumArray=[];
    var l = numArray.length;
    var i=0;

    for(i=1;i<l;i++){
        
        if(numArray[i]>numAray[i-1]){
            break a;
            newNumArray[i]=numArray[i-1];
            i++;

        }

    }
    return newNumArray;

}
*/

 
/*
7.    Even Number
Define function: isEven(someNum)
Return true if even, false if odd.
Challenge: Do not use % operator.
 */
function isEvenNumber(someNum){

    var num=Math.floor(someNum/2);
    var r=someNum-num*2;
    if(r>0){
        return false;

    }

    return true;
}

 /*
8.   Palindrome
Define function: isPalindrome(someStr)
Return true if someStr is a palindrome, otherwise return false.
*/

function isPalindrome(someStr){
    var l = someStr.length;
    var num=Math.floor(l/2);

    for(i=0;i<num;i++){

        c1=someStr.charAt(i);
        c2=someStr.charAt(l-i-1);

        if(c1!=c2){
            
            return false;
        }

        return true;
    }

}

/*
////////////// challenge questions

9. Find Leap Year
Define function: isLeapYear(date)
Create a JavaScript function that takes a date parameter 
and returns true if the year is a leap year in the Gregorian calendar.
 
10.   Shapes
Define function: printShape(shape, height, character)
shape is a String and is either "Square", "Triangle", "Diamond".
height is a Number and is the height of the shape. Assume the number is odd.
character is a String that represents the contents of the shape.
Assume this String contains just one character.
Use a switch statement to determine which shape was passed in.
Use the console.log function to print the desired shape.
Example for printShape("Square", 3, "%");
%%%
%%%
%%%
Example for printShape("Triangle", 3, "$");
$
$$
$$$

Example for printShape("Diamond", 5, "*");
  *
 ***
*****
 ***
  *		
  
*/

function square(num,character){
    var array=[];
    
    for(i=0;i<num;i++){
        s="";
        for(j=0;j<num;j++){
        s=s+character;    
            
        }
        console.log(s+"\n");
        
    }
    console.log(s);
    
}

function triangle(num,character){
    s="";
    for(i=0;i<num;i++){
        s=s+character;
        console.log(s);
    }

}

function Diamond(num,character){

    var s="";
    var asterisc=character;
    var zero=(num+1)/2;
    var n=-num;
    
    var contador=0;
    var cont=0;
    do{
        for(i=-zero;i<zero;i++){
            if(i<=cont && i>=-cont){
                s=s+character;
            }else{
                s=s+" ";
            }
        }
        s=s+"\n"
        contador++;
        if(contador>=zero){
            cont--;
        }else{
            cont++;
        }
            
    }while(cont>=0)
    
    console.log(s);
    
}


function printShape(shape,height,character){

    switch(shape){
        case "Triangle":
            triangle(height,character);
            break;
        case "Square":
            square(height,character);
            break;
        case "Diamond":
            Diamond(height,character);
            break;
        default:
            console.log("invalid arguments");
    }
}


/*  
11.   Rotate Left
Define function: rotate(array, n)
Given array, rotate left n times and return array
Examples
f([1,2,3,4,5], 1) = [2,3,4,5,1]
f([1,2,3,4,5], 6) = [2,3,4,5,1]
f([1,2,3,4,5], 3) = [4,5,1,2,3]

*/
function rotate(array,n){
    
    var newArray=[(7)];
    r=n%array.length;
    for(i=0;i<array.length;i++){

        if(i<r-1){

            newArray[i]=array[i+r];

        }else{
            newArray[i]=array[-array.length+n+i];
        }

    }
    return newArray;
    

}

/*

12.   Balanced Brackets
 	Define function: balanced(string)

A bracket is any one of the following: (, ), {, }, [, or ]
 
The following are balanced brackets:
()
()()
(())
({[]})
 
The following are NOT balanced brackets
(
)
(()i
([)]
 
Create a function which takes a string of brackets and returns 
true if balanced and false if not balanced
 
*/

function balanced(string){
    
    let stack = [];
    let map = {
        '(': ')',
        '[': ']',
        '{': '}'
    }

    for (let i = 0; i < string.length; i++) {

        if (string[i] === '(' || string[i] === '{' || string[i] === '[' ) {
            stack.push(string[i]);
        }
        else {
            let last = stack.pop();

            
            if (string[i] !== map[last]) {return false};
        }
    }
    
        if (stack.length !== 0) {return false};

    return true;
    
}





