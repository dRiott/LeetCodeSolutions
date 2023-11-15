/**
 * @param {Object|Array} obj
 * @return {Object|Array}
 */
function compactObject(obj) {
    if (!obj) return obj; 

    if (Array.isArray(obj)) {
        return obj.reduce((arr, item) => {
             // prevent another call deeper if item is primitive
            const value = typeof item === 'object' ? compactObject(item) : item;
            if (value) {
                arr.push(value);
            }
            return arr;
        }, []);
    }

    // handle objects
    const newObj = {};
    for (let key of Object.keys(obj)) {
        // prevent another call deeper if item is primitive
        let value = typeof obj[key] === 'object' ? compactObject(obj[key]) : obj[key];
        if (value) {
            newObj[key] = value
        }
    }

    return newObj
};
