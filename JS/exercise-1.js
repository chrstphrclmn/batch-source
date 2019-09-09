console.log('connected');

// 1;
function maxLength(arr) {
    let longestLength = 'a';
    arr.map(e => {
        if (e.length > longestLength.length) {
            longestLength = e;
        }
    });
    return longestLength;
}

function maxLength2(arr) {
    let longestStringIndex;
    let longestLength = 'a';
    for (i in arr) {
        if (arr[i].length > longestLength.length) {
            longestStringIndex = i;
            longestLength = arr[i];
        }
    }
    return longestStringIndex;
}

// 2;

function reverseArray(arr) {
    return arr.reverse();
}

// 3. doesn't account for duplicates though. Yet!
function countVowels(word) {
    let count = 0;
    let splittedString = word.toLowerCase().split('');
    splittedString.map(e => {
        if (e === 'a' || e === 'e' || e === 'i' || e === 'o' || e === 'u') {
            count++;
        }
    });
    return count;
}

// 4.
function validEmail(email) {
    let re = /\S+@\S+\.\S+/;
    return re.test(email);
}

// 5.
function removeChar(string, index) {
    return (
        string.substring(0, index) + string.substring(index + 1, string.length)
    );
}

// 6.

function swap(array, i, j) {
    var temp = array[i];
    array[i] = array[j];
    array[j] = temp;
}
function bubbleSort(array) {
    for (var i = 0; i < array.length; i++) {
        for (var j = 1; j < array.length; j++) {
            if (array[j - 1] > array[j]) {
                swap(array, j - 1, j);
            }
        }
    }
    return array;
}

// 7.
function isEven(num) {
    let number = num / 2;
    return Number.isInteger(number);
}

// 8.
function palindrome(str) {
    var re = /[^A-Za-z0-9]/g;
    str = str.toLowerCase().replace(re, '');
    var len = str.length;
    for (var i = 0; i < len / 2; i++) {
        if (str[i] !== str[len - 1 - i]) {
            return false;
        }
    }
    return true;
}

// 9.
function isLeapYear(year) {
    return year % 400 === 0
        ? true
        : year % 100 === 0
        ? false
        : year % 4 === 0
        ? true
        : false;
}

// Rotate Array

function rotLeft(a, d) {
    // simply "cut" the array where how many times to rotate = where we cut it.
    // then concatenate it with the rest
    a = a.concat(a.splice(0, d));
    return a;
}

// balanced brackets:

function isValid(str) {
    if (str.length <= 1) return false;

    let matchingOpeningBracket, ch;
    let stack = [];

    let openingBrackets = ['[', '{', '('];
    let closingBrackets = [']', '}', ')'];

    for (let i = 0; i < str.length; i++) {
        ch = str[i];

        if (closingBrackets.indexOf(ch) > -1) {
            matchingOpeningBracket =
                openingBrackets[closingBrackets.indexOf(ch)];
            if (stack.length == 0 || stack.pop() != matchingOpeningBracket) {
                return false;
            }
        } else {
            stack.push(ch);
        }
    }

    return stack.length == 0;
}
