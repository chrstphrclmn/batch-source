window.onload = function() {
  let array = ["Hello World", "hi", "hello"];
  console.log("maxLength");
  console.log(maxLength(array));
  console.log("reverseArray");
  console.log(reverseArray(array));
  console.log("vowelCount");
  console.log(vowelCount("Hello World?"));

  console.log("Email Validation Start");
  console.log(isValidEmail("s@s.com"));
  console.log(isValidEmail("@s.com"));
  console.log(isValidEmail("s@s."));
  console.log(isValidEmail("s@scom"));
  console.log(isValidEmail("s.com"));

  console.log("RemoveChar");
  console.log(removeChar("Read", 2));

  console.log("BubbleSort");
  console.log(bubbleSort([2,5,6,1,3,4]));

  console.log("isEven");
  console.log(isEven(0));
  console.log(isEven(9));
  console.log(isEven(8));

  console.log("isPalindrome");
  console.log(isPalindrome("Test"));
  console.log(isPalindrome("Madam"));
  console.log(isPalindrome("10101"));

  console.log("isLeapYear");
  let date1 = new Date('December 17, 2004 03:24:00');
  let date2 = new Date('December 17, 2048 03:24:00');
  let date3 = new Date('December 17, 1995 03:24:00');
  let date4 = new Date('December 17, 1900 03:24:00');
  console.log(isLeapYear(date1));
  console.log(isLeapYear(date2));
  console.log(isLeapYear(date3));
  console.log(isLeapYear(date4));
};

function maxLength(array) {
  let length = 0;
  let index = -1;
  for (let i = 0; i < array.length; i++) {
    let checked = array[i].length > length;
    length = checked ? array[i].length : length;
    index = checked ? i : index;
  }
  return index;
}

function reverseArray(array) {
  return array.reverse();
}

function vowelCount(string) {
  let count = 0;
  let vowels = ["a", "e", "i", "o", "u"];
  for (let i = 0; i < string.length; i++) {
    for (let j = 0; j < vowels.length; j++) {
      if (string[i] == vowels[j]) {
        count++;
        break;
      }
    }
  }
  return count;
}

function isValidEmail(email) {
  let re = /\S+@\S+\.\S+/;
  return re.test(email);
}

function removeChar(string, index) {
    return string.replace(string[index],"");
}

function bubbleSort(numArray){
    let length = numArray.length -1;
    let swapped = true;
    while(swapped){
        swapped = false;
        for (let i=0; i < length; i++) {
            if (numArray[i] > numArray[i+1]) {
                let temp = numArray[i];
                numArray[i] = numArray[i+1];
                numArray[i+1] = temp;
                swapped = true;
            }
        }
    } 
    return numArray;
}

function isEven(someNum){
    if(Number.isInteger(someNum/2)){return true;}else{return false;}
}

function isPalindrome(someStr){
    let newString = someStr.split("").reverse().join("");
    return newString.toUpperCase() == someStr.toUpperCase();
}
// Leap Years are any year that can be exactly divided by 4 (such as 2016, 2020, 2024, etc). not, except if it can be exactly divided by 100,
function isLeapYear(date){
    let year = date.getYear();
    if ((year % 4 == 0 && year % 100 != 0)) {
       return true;
    } else {
        return false;
    }
}

function printShape(shape, height, character){
    
}