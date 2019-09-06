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
  console.log(bubbleSort([2, 5, 6, 1, 3, 4]));

  console.log("isEven");
  console.log(isEven(0));
  console.log(isEven(9));
  console.log(isEven(8));

  console.log("isPalindrome");
  console.log(isPalindrome("Test"));
  console.log(isPalindrome("Madam"));
  console.log(isPalindrome("10101"));

  console.log("isLeapYear");
  let date1 = new Date("December 17, 2004 03:24:00");
  let date2 = new Date("December 17, 2048 03:24:00");
  let date3 = new Date("December 17, 1995 03:24:00");
  let date4 = new Date("December 17, 1900 03:24:00");
  console.log(isLeapYear(date1));
  console.log(isLeapYear(date2));
  console.log(isLeapYear(date3));
  console.log(isLeapYear(date4));

  console.log("Print Shape");
  printShape("Square", 3, "%");
  printShape("Triangle", 3, "$");
  printShape("Diamond", 3, "*");
  printShape("Diamond", 5, "*");

  console.log("Rotate");
  console.log(rotate([1, 2, 3, 4, 5], 1));
  console.log(rotate([1, 2, 3, 4, 5], 6));
  console.log(rotate([1, 2, 3, 4, 5], 3));

  console.log("Balanced");
  console.log(balanced("()"));
  console.log(balanced("()()"));
  console.log(balanced("(())"));
  console.log(balanced("({[]})"));
  console.log(balanced("("));
  console.log(balanced(")"));
  console.log(balanced("(()i"));
  console.log(balanced("([)]"));
};

//O(n)
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

//O(n)
function reverseArray(array) {
  return array.reverse();
}

//O(5n) = O(n)
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

//O(1)
function isValidEmail(email) {
  let re = /\S+@\S+\.\S+/;
  return re.test(email);
}

//O(n)
function removeChar(string, index) {
  return string.replace(string[index], "");
}

//O(n^2) worst case not close to being sorted
function bubbleSort(numArray) {
  let length = numArray.length - 1;
  let swapped = true;
  while (swapped) {
    swapped = false;
    for (let i = 0; i < length; i++) {
      if (numArray[i] > numArray[i + 1]) {
        let temp = numArray[i];
        numArray[i] = numArray[i + 1];
        numArray[i + 1] = temp;
        swapped = true;
      }
    }
  }
  return numArray;
}

//O(1)
function isEven(someNum) {
  if (Number.isInteger(someNum / 2)) {
    return true;
  } else {
    return false;
  }
}

//O(n)
function isPalindrome(someStr) {
  let newString = someStr
    .split("")
    .reverse()
    .join("");
  return newString.toUpperCase() == someStr.toUpperCase();
}

// Leap Years are any year that can be exactly divided by 4 (such as 2016, 2020, 2024, etc). not, except if it can be exactly divided by 100,
//O(1)
function isLeapYear(date) {
  let year = date.getYear();
  if (year % 4 == 0 && year % 100 != 0) {
    return true;
  } else {
    return false;
  }
}

//"Square", "Triangle", "Diamond".
//O((n/2)^2) -> O(n^2/4) -> O(n^2)
function printShape(shape, height, character) {
  switch (shape) {
    case "Square":
      for (let i = 0; i < height; i++) {
        console.log(character + character + character);
      }
      break;
    case "Triangle":
      for (let i = 0; i < height; i++) {
        let row = "";
        for (let j = 0; j < i + 1; j++) {
          row += character;
        }
        console.log(row);
      }
      break;
    case "Diamond":
      if (height % 2 == 0 || height <= 0) {
        console.log("invalid diamond");
      }
      let half = Math.floor(height / 2);
      for (let i = 0; i < half + 1; i++) {
        let row = new Array(height - 1);
        for (let j = 0; j < half + 1; j++) {
          if (j >= half - i) {
            row[j] = character;
            row[height - 1 - j] = character;
          } else {
            row[j] = " ";
            row[height - 1 - j] = " ";
          }
        }
        console.log(row.join(""));
      }
      for (let i = half - 1; i >= 0; i--) {
        let row = [];
        for (let j = 0; j < half + 1; j++) {
          if (j >= half - i) {
            row[j] = character;
            row[height - 1 - j] = character;
          } else {
            row[j] = " ";
            row[height - 1 - j] = " ";
          }
        }
        console.log(row.join(""));
      }
      break;
  }
}

//O(n)
function rotate(array, n) {
  let length = array.length;
  let rotations = n > length ? n - length : n;
  return [...array.slice(rotations), ...array.slice(0, rotations)];
}

//O(n^2)
function balanced(string) {
  let length = string.length;
  for (let i = 0; i < length; i++) {
    if (!(i = scan(i, string))) {
      return false;
    }
  }
  return true;
}

function scan(index, string) {
  let opening = ["(", "{", "[",")", "}", "]"];
  let closing = [")", "}", "]","(", "{", "["];
  for (let i = index + 1; i < string.length; i++) {
    let oIndex = opening.indexOf(string[index]);
    if (string[i] != closing[oIndex]) {
      i = scan(i, string);
    } else {
      return i;
    }
  }
}
