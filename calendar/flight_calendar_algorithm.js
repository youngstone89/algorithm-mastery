
// compare if choice is before, middle, after the range
function findLocationFromRange(num, flights, range) {
    // if choise is before range
    if (num < range[0]) {
        return "before"
    } else if (num > range[0] && num < range[1]) {
        return "middle"
    } else if (num > range[1]) {
        return "after"
    }
}
function findLocationFromFirstChoice(choice, numberToCompare) {
    if (choice < numberToCompare) {
        return "before"
    } else if (choice === numberToCompare) {
        return "on"
    } else if (choice > numberToCompare) {
        return "after"
    }
}
function updateRangeWithStartOnly(choice, range) {
    range[0] = choice
}
function handleUpdateByLocation(choice, range, location) {
    if (location === "before") {
        let originalEnd = range[1] //keep
        let newStart = choice // keep
        range[0] = newStart
        range[1] = originalEnd
        startIdx = 1
        console.log(`${location}:extend:choice:${choice}:keep:${originalEnd}:range:${range}:startIdx:${startIdx}`)

    } else if (location === "middle") {
        console.log(`${location}:reduce:choice:${choice}:range:${range}:startIdx:${startIdx}`)
        range[startIdx] // keep
        range[startIdx ^ 1] = choice
    } else if (location === "after") {
        updateRangeWithStartOnly(choice, range)
        console.log(`${location}:reset:choice:${choice}:range:${range}`)
    }
}
function handleUpdateByLocationForDoubleChoice(choice, range, locationFromFirstChoice) {
    if (locationFromFirstChoice === "before") {
        const temp = range[0]
        range[0] = choice
        range[1] = temp
    } else if (locationFromFirstChoice === "on") {
        range[1] = choice
    } else if (locationFromFirstChoice === "after") {
        range[1] = choice
    }
}
function handleUpdateForSecondChoice(range) {
    // check if second choice is needeed
    choice = 4
    console.log('T3:choice:', choice)
    const locationFromFirstChoice = findLocationFromFirstChoice(choice, range[0])
    handleUpdateByLocationForDoubleChoice(choice, range, locationFromFirstChoice)
}


const flights = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
const range = [1, 2]
let startIdx = 0
console.log('=================')
console.log('C1 cycle starts')
console.log(`T1:range:${range}:startIdx:${startIdx}`,)
let choice = 3
console.log('T2:choice:', 3)
let location = findLocationFromRange(choice, flights, range)
console.log(`T2:choice:${choice}:location:${location}`)
handleUpdateByLocation(choice, range, location)
handleUpdateForSecondChoice(range)
console.log(range)
console.log('C1 cycle ends')
console.log('=================')
console.log('=================')
console.log(`T4:range:${range}:startIdx:${startIdx}`)
console.log('C2 cycle starts')
choice = 1
console.log(`T4:choice:${choice}:range:${range}:startIdx:${startIdx}`)
location = findLocationFromRange(choice, flights, range)
console.log(`T4:choice:${choice}:location:${location}`)
handleUpdateByLocation(choice, range, location)
console.log(`T4:choice:${choice}:location:${location}:range:${range}`)
console.log('C2 cycle ends')
console.log('=================')
console.log('=================')
console.log(`T5:range:${range}:startIdx:${startIdx}`)
console.log('C3 cycle starts')
console.log('T5:choice:2:want:[2,4]')
choice = 2
location = findLocationFromRange(choice, flights, range)
handleUpdateByLocation(choice, range, location)
console.log(`T5:choice:${choice}:location:${location}:range:${range}`)
console.log('C3 cycle ends')
console.log('=================')
console.log('=================')