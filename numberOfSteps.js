var numberOfSteps = function (num) {
    let steps = 0;
    let reduceNumbers = (n) => {
        if (n === 0) return;
        if (n % 2 === 0) {
            steps = steps + 1;
            reduceNumbers(n / 2);
        }
        else {
            steps = steps + 1;
            reduceNumbers(n - 1);
        }
    }
    reduceNumbers(num);
    console.log(steps);
    return steps;
};

numberOfSteps(123);