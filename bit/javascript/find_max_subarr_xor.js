function findMaxSubArrayXOR(arr) {
    let result = Number.MIN_VALUE
    for (let i = 0; i < arr.length; i++){
        let curr_xor = 0;
        for (let j = i; j < arr.length; j++){
            curr_xor = curr_xor ^ arr[j]
            result = Math.max(result,curr_xor)
        }
    }
    return result
}

let arr = [8, 1, 2, 12]
let n = arr.length

console.log(findMaxSubArrayXOR(arr))