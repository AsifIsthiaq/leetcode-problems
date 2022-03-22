var maximumWealth = function (accounts) {
    console.log(accounts);
    let totalWealth = [];
    accounts.forEach(account => {
        console.log(account);
        let initialValue = 0;
        totalWealth.push(account.reduce((previousValue, currentValue) => previousValue + currentValue,
            initialValue))
    });
    console.log(totalWealth);
    console.log(Math.max(...totalWealth));
    return Math.max(...totalWealth);
};

maximumWealth([[1, 2, 3], [3, 2, 1]]);