function spiralOrder(matrix: number[][]): number[] {
    let solution: number[] = [];

    const visitedCells = new Map<String, Boolean>();

    let direction: 'up'|'down'|'left'|'right' = 'right';
    let row: number = 0;
    let column: number = 0;

    function shouldChangeDirection(row: number, column: number): boolean {
        const outOfBounds = !(row in matrix && column in matrix[row]);
        const hasVisited = visitedCells.has(`${row}x${column}`);

        return outOfBounds || hasVisited;
    }

    while(!visitedCells.has(`${row}x${column}`)) {
        if(row in matrix && column in matrix[row]) {
            visitedCells.set(`${row}x${column}`, true);

            solution.push(matrix[row][column]);
        }
        
        if(direction === 'right') {
            if(shouldChangeDirection(row, column+1)) {
                direction = 'down';
                row++;
            } else {
                column++;
            }
        } else if(direction === 'down') {
            if(shouldChangeDirection(row+1, column)) {
                direction = 'left';
                column--;
            } else {
                row++;
            }
        } else if(direction === 'left') {
            if(shouldChangeDirection(row, column-1)) {
                direction = 'up';
                row--;
            } else {
                column--;
            }
        } else if(direction === 'up') {
            if(shouldChangeDirection(row-1, column)) {
                direction = 'right';
                column++;
            } else {
                row--;
            }
        } else {
            break;
        }
    }


    return solution;
};

let testCase: number[][] = [[1,2,3],[4,5,6],[7,8,9]];

console.log(spiralOrder(testCase));