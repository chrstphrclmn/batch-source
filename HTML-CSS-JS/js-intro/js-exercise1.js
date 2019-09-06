function maxLength(array){
    let retValue = "";
    for(let strg of array){
        if(strg.length > retValue.length){
            retValue = strg;
        }
    }
    return retValue;
}

function reverseArray(array){

    let retValue = [];
    let count = 0;

    for(i = array.length-1; i>=0; i--){
        retValue[count]=array[i];
        count++;
    }

    return retValue;
}

function vowelCount(strg){

    let vowels = ["a", "e", "i", "o", "u", "A", "E", "I", "O", "U"];
    let count = 0;
    for(i=0; i<strg.length;i++){
        let test = strg[i];
        for(j=0; j<vowels.length; j++){
            if(test == vowels[j]){
                count++;
            }
        }
    }

    return count;
}

function isValidEmail(email){

    if(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email)){
        return true;
    }
    return false;

}

function removeChar(string, index){

    if(index == 0){
        return string.substring(1, string.length);
    }

    if(index == string.length){
        return string.substring(0, string.length-1);
    }

    return string.substring(0, index).concat(string.substring(index+1, string.length));

}

function bubbleSort(numArray){

    let numReturn = numArray;

    for(let j = 0; j < numArray.length-1; j++){
        for(let i = 0; i < numArray.length-1; i++){
            if(numReturn[i]>numReturn[i+1]){
                let hold = numReturn[i+1];
                numReturn[i+1] = numReturn[i];
                numReturn[i] = hold;
            }
        }
    }

    return numReturn;

}

function isEven(someNum){
    let test = someNum/2;
    if(test*2==someNum){
        return true;
    }
    return false;
}