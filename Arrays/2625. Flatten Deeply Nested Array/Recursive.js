/**
 * @param {Array} arr
 * @param {number} depth
 * @return {Array}
 */
var flat = function (arr, n) {
    if (n === 0) return arr;

    const flatten = (res, elem, n) => {
        for (const key of elem) {
            if (Array.isArray(key) && n > 0) {
                    flatten(res, key, n-1)
            } else {
                res.push(key);
            }
        }
    }

    let res = [];
    flatten(res, arr, n);
    return res;
};
