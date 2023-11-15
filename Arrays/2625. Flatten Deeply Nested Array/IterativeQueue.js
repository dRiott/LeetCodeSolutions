/**
 * @param {Array} arr
 * @param {number} depth
 * @return {Array}
 */
var flat = function (arr, n) {
    if (n === 0) return arr;

    let nestedArrayElement = true;
    let queue;
    let depth = 0;

    while (nestedArrayElement && depth < n) {
        nestedArrayElement = false;
        queue = [];

        for(let i = 0; i < arr.length; i++) {
            if (Array.isArray(arr[i])) {
                queue.push(...arr[i]);
                nestedArrayElement = true; // skips cases where n is high, but no nested arrays exist
            } else {
                queue.push(arr[i]);
            }
        }
        arr = [...queue]; // expand queue into arr, as a copy essentially
        depth++;
    }
    
    return arr;

};
