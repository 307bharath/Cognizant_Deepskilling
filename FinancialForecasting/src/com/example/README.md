# Financial Forecasting Tool

This project is a simple financial forecasting tool that predicts future values based on past data using recursive algorithms in Java.

## Exercise Overview

**Scenario:**  
You are developing a financial forecasting tool that predicts future values based on past data.

---
## 1.Understanding Recursive Algorithms
**Recursion** is a programming technique where a method calls itself to solve a problem by breaking it down into smaller, similar subproblems. It can simplify problems like traversing trees, calculating factorials, or solving mathematical sequences.

---
## 2. Setup: Recursive Future Value Method
Suppose you want to predict the future value of an investment given an initial amount, a constant growth rate, and a number of periods.

---
## 3.Analysis
**Time Complexity:**
The recursive algorithm has O(n) time complexity, where n is the number of periods, because it makes one recursive call per period.

**Optimization**:
For this problem, recursion is straightforward and not computationally expensive. However, for more complex recursive problems (like Fibonacci), you can use memoization or convert to an iterative approach to avoid redundant calculations and stack overflow.

**Iterative Alternative:**  
For large `periods`, use a loop to avoid deep recursion:
```java
public static double futureValueIterative(double presentValue, double growthRate, int periods) {
    double result = presentValue;
    for (int i = 0; i < periods; i++) {
        result *= (1 + growthRate);
    }
    return result;
}
```
---

