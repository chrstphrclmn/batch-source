//#1
//
function longestString(strArr){
  var longStrIndex;
  var longStrLength=0;
    for(let i = 0 ; i < strArr.length; i++){
      if (strArr[i].length > longStrLength){
         longStrIndex = i;
         longStrLength = strArr[i].length;
      }
    }
    return longStrIndex;
}

//#2
//
function reverseArray(arr){
  let reversedArr=[];
  for(let i = 0 ; i < arr.length ; i++){
    reversedArr[i]= arr[arr.length -1 -i];
  }
  return reversedArr;
}

//#3
//
function vowelCount(str){
  let count = 0;
  str = str.toLowerCase();
  for(let letter of str){
    if(letter == "a" ||letter == "e" || letter == "i"|| letter == "o"|| letter == "u"){
      count ++;
    }
  }
  return count;
}

//#4
//
function isValidEmail(string){
  //found regex on https://emailregex.com/
let regex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/

    return regex.test(string);
}

//#5
//
function removeCharacter(string, index){
    let arr = string.split("");
    arr[index] = "";
    console.log(arr);
    returnString = "";
    for (let letter of arr){
      returnString += letter;
    }
    return returnString;
}

//#6
//
function bubbleSort(numArray){
  let swaps;
  while(swaps != 0){
    swaps = 0;
    for(let i = 0; i < numArray.length ; i++){
      if(numArray[i]>numArray[i+1]){
        let placeHolder = numArray[i];
        numArray[i] = numArray[i+1];
        numArray[i+1] = placeHolder;
        swaps ++;
      }
    }
  }
  return numArray;
}

//#7
//
function isEven(num){
  if(Number.isInteger(num/2)){
    return true;
  }
  return false;
}

//#8
//
function isPalindrome(str){
		let j = 0;
		for (let i = (str.length - 1); i > str.length/2 ; i --) {
			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}
			else {
				j++;
			}
		}
	return true;
}

//#9
//
function isLeapYear(date){
  let year = date.getFullYear();
  if(year % 400 == 0){
    return true;
  }
  else if (year % 100 == 0) {
    return false
  }
  else if(year % 4 == 0){
    return true;
  }
  else{
    return false;
  }
}

//#10
//
function printShape(shape, height, character){
  var string = "";
  switch(shape){
    case "Square":
    for(let j = 0 ; j != height ; j++){
      for(let i = 0; i != height; i++){
        string += character;
      }
      console.log(string);
      string = "";
    }
      break;
    case "Triangle":
      for (let j = 0; j != height; j++){
        for(let i = 0; i != 1; i++){
          string += character;
        }
        console.log(string);
      }
      break;
    case "Diamond":

    spaces = (height - 1)/2;
    characters = 1;
    string = "";

    for (let col = 0; col < ((height-1)/2)+1 ; col ++){

        let space = spaces;

        while(space != 0){
          string += " ";
          space --;
        }

        let char = characters;

        while(char != 0){
          string += character;
          char --;
        }

        console.log(string);
        spaces --;
        characters += 2;
        string = "";
    }

  spaces = 1;
  characters = height -2;

  for (let col = 0; col < ((height-1)/2); col ++){

      let space = spaces;

      while(space != 0){
        string += " ";
        space --;
      }

      let char = characters;

      while(char != 0){
        string += character;
        char --;
      }

      console.log(string);
      spaces ++;
      characters -= 2;
      string = "";
  }
      break;
    default:
  }
}

//#11
//
function rotate(arr, num){
  let rotArr = [];
  let numLeft = num % arr.length;
  for(let i = 0; i < arr.length; i++){
    if (i-numLeft < 0){
      rotArr[i - numLeft + arr.length] = arr[i];
    }
    else {
      rotArr[i - numLeft] = arr[i];
    }
  }
  return rotArr;
}

//#12
//
function balanced(str){
  let stack = [];
  for(let char of str){
    if(char == "(" || char == "{" || char == "["){
      stack.push(char);
    }
    else if (char == ")" || char == "}" || char == "]") {
      let popped = stack.pop();
      if (char == ")" && popped == "("){}
      else if(char == "}" && popped == "{"){}
      else if(char == "]" && popped == "["){}
      else{
        return false;
      }
    }
    else{
      return false;
    }
  }
  if (stack.length == 0){
    return true;
  }
  else{
    return false;
  }
}
