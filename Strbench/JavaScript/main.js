// Concat two strings
let str = "abcdefgh" + "efghefgh";
let iteratorMax = 1024 / str.length * 1024 * 4;

let time = new Date();
console.log("exec.time.sec\tstr.size");

let newString = "";
let iterator = 0;
let length;

while (iterator++ < iteratorMax + 1000) {
    newString += str;
    newString = newString.replace(/efgh/g, "____");
    length = str.length * iterator;
    if ((length % (1024 * 256)) === 0) {
        let currentDate = new Date();
        console.log(parseInt(((currentDate.getTime() - time.getTime()) / 1000)) + " sec\t\t" + length / 1024 + "kb");
    }
}