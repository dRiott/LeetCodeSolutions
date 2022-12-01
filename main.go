package Backend_Challenge

import (
	"encoding/csv"
	"fmt"
	"net/http"
	"strings"
)

// I'm working on an iPad as a primary device right now - to that end I used replit.com to come up with this result...
// Hope the http handling works as I'm imagining it to! 
// Forgive the http/file/error-handling copypasta. Thank you! */
func main() {
  /*
    1. Echo: Return the matrix as a string in matrix format.
    ```
    // Example output
    1,2,3
    4,5,6
    7,8,9
    ```
  */
	http.HandleFunc("/echo", func(w http.ResponseWriter, r *http.Request) {
		file, _, err := r.FormFile("file")
		if err != nil {
			w.Write([]byte(fmt.Sprintf("error %s", err.Error())))
			return
		}
		defer file.Close()
		records, err := csv.NewReader(file).ReadAll()
		if err != nil {
			w.Write([]byte(fmt.Sprintf("error %s", err.Error())))
			return
		}
    
		var response string
		for _, row := range records {
			response = fmt.Sprintf("%s%s\n", response, strings.Join(row, ","))
		}
		fmt.Fprint(w, response)
	})

  /*
    2. Invert: Return the matrix as a string in matrix format where the columns and rows are inverted
    ```
    // input          output
    1,2,3             1,4,7
    4,5,6     -->     2,5,8
    7,8,9             3,6,9
    ``` 
  */
  http.HandleFunc("/invert", func(w http.ResponseWriter, r *http.Request) {
		file, _, err := r.FormFile("file")
		if err != nil {
			w.Write([]byte(fmt.Sprintf("error %s", err.Error())))
			return
		}
		defer file.Close()
		records, err := csv.NewReader(file).ReadAll()
		if err != nil {
			w.Write([]byte(fmt.Sprintf("error %s", err.Error())))
			return
		}
    
		fmt.Fprint(w, invertMatrix(records))
	})
  
  /*
    3. Flatten: Return the matrix as a 1 line string, with values separated by commas.
  
    ```
    // Expected output
    1,2,3,4,5,6,7,8,9
    ``` 
    */
  http.HandleFunc("/flatten", func(w http.ResponseWriter, r *http.Request) {
		file, _, err := r.FormFile("file")
		if err != nil {
			w.Write([]byte(fmt.Sprintf("error %s", err.Error())))
			return
		}
		defer file.Close()
		records, err := csv.NewReader(file).ReadAll()
		if err != nil {
			w.Write([]byte(fmt.Sprintf("error %s", err.Error())))
			return
		}
    
		fmt.Fprint(w, matrixFlattened(records))
	})
  
  /*
    4. Sum: Return the sum of the integers in the matrix
    ```
    // Expected output
    45
    ``` 
  */
  http.HandleFunc("/sum", func(w http.ResponseWriter, r *http.Request) {
		file, _, err := r.FormFile("file")
		if err != nil {
			w.Write([]byte(fmt.Sprintf("error %s", err.Error())))
			return
		}
		defer file.Close()
		records, err := csv.NewReader(file).ReadAll()
		if err != nil {
			w.Write([]byte(fmt.Sprintf("error %s", err.Error())))
			return
		}
    [][]int digits = to2dIntArray(records)
		fmt.Fprint(w, digitsModify(digits, adder))
	})
  
  /*
    5. Multiply: Return the product of the integers in the matrix
    ```
    // Expected output
    362880
    ```
  */
  http.HandleFunc("/multiply", func(w http.ResponseWriter, r *http.Request) {
		file, _, err := r.FormFile("file")
		if err != nil {
			w.Write([]byte(fmt.Sprintf("error %s", err.Error())))
			return
		}
		defer file.Close()
		records, err := csv.NewReader(file).ReadAll()
		if err != nil {
			w.Write([]byte(fmt.Sprintf("error %s", err.Error())))
			return
		}
    
		[][]int digits = to2dIntArray(records)
		fmt.Fprint(w, digitsModify(digits, multiplier))
	})
  
	http.ListenAndServe(":8080", nil)
}

// Transposes a matrix; it is returned "inverted"
// Argument is not modified.
func invertMatrix(m [][]string) [][]string {
  rowLen, colLen := len(m), len(m[0])
  result := make([][]string, colLen)
  for i := range result {
    result[i] = make([]string, rowLen)
  }
  
  for r := 0; r < rowLen; r++ {
    for c := 0 ; c < colLen; c++ {
      result[c][r] = m[r][c]
    }
  }
  return result
}

// Transforms a matrix into a flattened string
func matrixFlattened(matrix [][]string) string {
    var response string
    for _, row := range matrix {
			response = fmt.Sprintf("%s%s,", response, strings.Join(row, ","))
		}
    return response[:len(response)-1] // trim final extra comma
}

// Converts a two-dimensional string array to int array
func to2dIntArray(strs [][]string) [][]int {
  res := make([][]int, len(strs))
  for i, row := range strs {
    res[i] = toIntArray(row)
  }
  return res
}

// Converts a string array into an int array.
// Panics if any of the string elements are not numbers.
func toIntArray(strs []string) []int {
  var res = []int{}
  for _, s := range strs {
      val, err := strconv.Atoi(s)
      if err != nil {
          panic(err) // todo, something more graceful?
      }
      res = append(res, val)
  }
  return res
}

// In the name of code reuse... extra complexity haha.
// Although this is a little ridiculous, I'm leaving it anyways because I had a good time playing with closures in Go.
// I started without closures, but the zero-value for int befuddled the multiplier.
// I'm not super familiar with overflow in Go, but I was concerned about that, esp. for multiply, hence int64
func digitsModify(digits [][]int, mod func() func([]int) int64) int64 {
    modFn := mod()
    var res int64
    for _, row := range digits {
      res = modFn(row)
		}
    return res
}

func adder() func([]int) int64 {
	var sum int64 = 0
	return func(x []int) int64 {
		for _, d := range x {
      sum+=int64(d)
    }
		return sum
	}
}

func multiplier() func([]int) int64 {
	var prod int64 = 1
	return func(x []int) int64 {
		for _, d := range x {
      prod*=int64(d)
		}
		return prod
	}
}
