// --- Directions
// Given a string, return true if the string is a palindrome
// or false if it is not.  Palindromes are strings that
// form the same word if it is reversed. *Do* include spaces
// and punctuation in determining if the string is a palindrome.
// --- Examples:
//   palindrome("abba") === true
//   palindrome("abcdefg") === false

function palindrome(str) {
    const halfLength = str.length/2
    for (let i=0; i < (halfLength%2 === 0 ? halfLength : Math.floor(halfLength)); i++) {
        if (str[i] !== str[str.length - i - 1]) return false
    }
    return true
}

console.log(palindrome('12321'))

module.exports = palindrome;

// function palindrome(str) {
//     const reversedStr = str
//      .split('')
//      .reduce((partialRev, char) => (char + partialRev), '')
//     return (reversedStr === str)
// }

// function palindrome(str) {
//     return str
//      .split('')
//      .every((char, index) => (char === str[str.length - index -1]))
// }
