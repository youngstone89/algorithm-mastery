let y = 9
let result = y & 1
console.log("result:" + result)
console.log(result.toString(2))
if (result) {
    // evaluates to true/1 because the least significant bit of y is 1 and 
    // the AND operation with 1 preserves that bit
    console.log(y + " is odd")
} else {
    // evalutes to false/0 because the least significant bit of y is 0 and
    // the AND operation with 0 sets all other bits to 0
    console.log(y + " is even")
}