
let y = 10
console.log(y.toString(2))
y = y >> 1
console.log(y)
console.log(y.toString(2).padStart(4,'0'))