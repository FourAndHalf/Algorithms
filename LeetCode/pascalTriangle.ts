export {};

function generate(rows: number): number[][] {
    let solution: number[][] = [[]];
    solution[0][0] = 1;

    for(let i = 1;i < rows;i++) {                           //! Time Complexity = O(n)
        let temp: number[] = solution[i-1].slice();
        temp.unshift(0);
        temp.push(0);
        let row: number[] = [];

        for(let j = 1;j < temp.length;j++) {                //! Time Complexity = O(n)
            row.push(temp[j-1] + temp[j]);
        }
        solution.push(row); 
    }                                               
    return solution;
}                                                           //! Total Time Complexity = O(n^2)

let rows: number = 6;

console.log(generate(rows));