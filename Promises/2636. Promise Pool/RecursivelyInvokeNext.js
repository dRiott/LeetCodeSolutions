/**
 * @param {Function[]} functions
 * @param {number} n
 * @return {Promise<any>}
 */
var promisePool = async function(functions, n) {
	  // execute functions in order, max n concurrently
    // return promise that resolves (any value) when all functions resolve
    return new Promise((res, rej) => {
        let inProgress = 0;
        let curr = 0;
        const invokeNextPromise = () => {
            if (inProgress == 0 && curr >= functions.length) {
                res();
            }

            // fill up the pool while we can
            while (inProgress < n && curr < functions.length) {
                const p = functions[curr++]();
                inProgress++;
                p.then((res, rej) => {
                    inProgress--;
                    invokeNextPromise();
                });
            }
        }
        invokeNextPromise();
    });
};

/**
 * const sleep = (t) => new Promise(res => setTimeout(res, t));
 * promisePool([() => sleep(500), () => sleep(400)], 1)
 *   .then(console.log) // After 900ms
 */
