# Java Recursive Assignment – Ex13 (20454)

## Author
- **Name**: Shimon Esterkin ([SemionVlad](https://github.com/SemionVlad))
- **ID**: *****2258  
- **Semester**: 2025B

---

## Overview

This repository contains my solution to **Assignment 13** for the course *20454 - Introduction to Computer Science in Java*.  
The focus of this assignment was on recursive thinking and implementation without the use of loops or helper classes.

The repository includes solutions to **two main questions**, each focusing on recursive strategies.

---

## Files

| File Name                           | Description |
|------------------------------------|-------------|
| `Ex13_20454.java`                  | Main Java class with full recursive implementation for both questions. |
| `Ex13_20454.class`                 | Compiled bytecode version of the main Java class. |
| `Ex13_20454StudentTester.java`     | Provided tester used to validate the correctness of the solution. |
| `Results.txt`                      | Output log from running the tester. |
| `Maman13-20454-java-score85.xlsx`  | Excel file showing the official evaluation and final grade (85). |
| `LICENSE`                          | Repository license information. |

---

## Question 1: `countEqualDiff(int[] arr, int diff)`

**Objective**:  
Find and print all valid disjoint complementary partitions of the input array such that both:

- `|sum(A) - sum(B)| == diff`
- `|size(A) - size(B)| == diff`

**Constraints**:

- Must be implemented recursively.
- No use of loops or collections.
- Duplicate elements are not allowed in the input.

**Output format**:

{a1 a2 ...} sum = X count = N {b1 b2 ...} sum = Y count = M

---

## Question 2: `minPoints(int[][] mat)`

**Objective**:  
Determine the minimum initial energy required to travel from the top-left to the bottom-right cell of a 2D matrix, moving only right or down, without the energy level dropping below 1 at any point.

**Key Details**:

- Recursive strategy with memoization.
- The matrix contains both positive and negative values.
- Energy must always remain ≥ 1.

---

## Grade

The file `Maman13-20454-java-score85.xlsx` includes the official feedback and final score for the assignment:

**✅ Final Score: 85**

---

## 📄 License
![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)

Created by [SemionVlad](https://github.com/SemionVlad) for academic and portfolio purposes. This repository is intended for **non-commercial**, **educational** sharing only.
