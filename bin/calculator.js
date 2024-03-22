// Function to calculate wealth by year
function calc_wealth_by_year(currWealth, monthlySavings, rateOfReturn, years) {
    let totalSavings = currWealth;
    for (let i = 0; i < years; i++) {
        const interestEarned = totalSavings * (rateOfReturn / 100);
        totalSavings += interestEarned + (monthlySavings * 12);
    }
    return totalSavings;
}

// Function to calculate years to financial freedom
function calcYearsToFinFreedom(currWealth, monthlySavings, rateOfReturn, targetWealth) {
    let totalSavings = currWealth;
    let years = 0;

    while (totalSavings < targetWealth) {
        const interestEarned = totalSavings * (rateOfReturn / 100);
        totalSavings += interestEarned + (monthlySavings * 12);
        years++;
    }

    return years;
}

// Function to validate user input
function validateInput(value) {
    if (isNaN(value) || value <= 0) {
        return false;
    }
    return true;
}

// Function to calculate wealth by year
function calculateWealth() {
    const currWealth = parseFloat(document.getElementById('current-wealth').value);
    const monthlySavings = parseFloat(document.getElementById('monthly-savings').value);
    const rateOfReturn = parseFloat(document.getElementById('rate-of-return').value);
    const years = parseFloat(document.getElementById('years').value);

    if (!validateInput(currWealth) || !validateInput(monthlySavings) || !validateInput(rateOfReturn) || !validateInput(years)) {
        document.getElementById('wealth-result').innerHTML = 'Invalid input. Please enter positive numbers.';
        return;
    }

    const totalWealth = calc_wealth_by_year(currWealth, monthlySavings, rateOfReturn, years);
    document.getElementById('wealth-result').innerHTML = `Your total wealth after ${years} years will be: $${totalWealth.toFixed(2)}`;
}

// Function to calculate years to financial freedom
function calculateYearsToFreedom() {
    const currWealth = parseFloat(document.getElementById('current-wealth-2').value);
    const monthlySavings = parseFloat(document.getElementById('monthly-savings-2').value);
    const rateOfReturn = parseFloat(document.getElementById('rate-of-return-2').value);
    const targetWealth = parseFloat(document.getElementById('target-wealth').value);

    if (!validateInput(currWealth) || !validateInput(monthlySavings) || !validateInput(rateOfReturn) || !validateInput(targetWealth)) {
        document.getElementById('freedom-result').innerHTML = 'Invalid input. Please enter positive numbers.';
        return;
    }

    const yearsToFreedom = calcYearsToFinFreedom(currWealth, monthlySavings, rateOfReturn, targetWealth);
    document.getElementById('freedom-result').innerHTML = `It will take you ${yearsToFreedom} years to reach financial freedom of: $${targetWealth.toFixed(2)}`;
}