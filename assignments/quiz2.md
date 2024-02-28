<style type="text/css">ol { list-style-type: upper-alpha; }</style>

# Quiz 2: Arrays and the ArrayList Class

- Introduction to Arrays
- Processing Array Contents
- Passing Arrays as Arguments to Methods
- Some Useful Array Algorithms and Operations
- Returning Arrays from Methods
- String Arrays
- Arrays of Objects
- The Sequential Search Algorithm
- Parallel Arrays
- Two-Dimensional Arrays
- Arrays with Three or More Dimensions
- The Selection Sort and the Binary Search
- Command-Line Arguments
- The ArrayList Class

## Problem 1

> To determine if two arrays are equal you must compare each of the elements of
  the two arrays.
>
> 1. True
> 2. False

**A.** True

## Problem 2

> Objects in an array are accessed with subscripts, just like any other data
  type in an array.
>
> 1. True
> 2. False

**A.** True

## Problem 3

> An array can hold multiple values of several different types of data
  simultaneously.
>
> 1. True
> 2. False

**B.** False

## Problem 4

> It is common practice to use a ______ variable as a size declarator.
>
> 1. `final`
> 2. reference
> 3. `static`
> 4. `boolean`

**A.** `final`

## Problem 5

> A partially filled array is normally used ______.
>
> 1. when you know how many elements will be in the array but not what the
     values are
> 2. with an accompanying integer value that holds the number of items stored in the array
> 3. with an accompanying parallel array
> 4. when only a very small number of values need to be stored

**B.** with an accompanying integer value that holds the number of items stored

## Problem 6

> If `numbers` is a two-dimensional `int` array that has been initialized and
  `total` is an `int` that has been set to `0`, which of the following will sum
  all the elements in the array?
>
> 1.
>
> ```java
> for (int row = 0; row < numbers.length; row++) {
>     for (int col = 0; col < numbers[row].length; col++) {
>        total += numbers[row][col];
>     }
> }
> ```
>
> 2.
>
> ```java
> for (int row = 1; row < numbers.length; row++) {
>     for (int col = 1; col < numbers.length; col++) {
>        total += numbers[row][col];
>     }
> }
> ```
>
> 3.
>
> ```java
> for (int row = 0; row < numbers.length; row++) {
>     for (int col = 0; col < numbers.length; col++) {
>        total += numbers[row][col];
>     }
> }
> ```
>
> 4.
>
> ```java
> for (int row = 0; row < numbers[row].length; row++) {
>     for (int col = 0; col < numbers.length; col++) {
>        total += numbers[row][col];
>     }
> }
> ```

**A.**

```java
for (int row = 0; row < numbers.length; row++) {
    for (int col = 0; col < numbers[row].length; col++) {
       total += numbers[row][col];
    }
}
```

## Problem 7

> What would be the result after the following code is executed?
>
> ```java
> int[] numbers = {40, 3, 5, 7, 8, 12, 10};
> int value = numbers[0];
> for (int i = 1; i < numbers.length; i++) {
>     if (numbers(i) < value)
>         value - numbers (i);
> }
> ```
>
> 1. The value variable will contain the highest value in the numbers array.
> 2. The value variable will contain the lowest value in the numbers array.
> 3. The value variable will contain the sum of all the values in the numbers
     array.
> 4. The value variable will contain the average of all the values in the
     numbers array.

**B.** The value variable will contain the lowest value in the numbers array.

## Problem 8

> By default, Java initializes array elements to ______.
>
> 1. `-1`
> 2. `0`
> 3. `1`
> 4. `100`

**B.** `0`

## Problem 9

> Subscripting always starts with ______.
>
> 1. `-1`
> 2. none of these
> 3. `1`
> 4. `0`

**D.** `0`

## Problem 10

> A(n) ______ is used as an index to pinpoint a specific element within an
  array.
>
> 1. `boolean` value
> 2. element
> 3. argument
> 4. subscript

**D.** subscript

## Problem 11

> What will be the value of `x[8]` after the following code is executed?
>
> ```java
> final int SUB = 12;
> int[] x = new int[SUB];
> int y = 100;
> for (int i = 0; 1 < SUB; i++) {
>     x[i] = y;
>     у += 10;
> }
> ```
>
> 1. 200
> 2. 180
> 3. 190
> 4. 170

**B.** 180

## Problem 12

> What will be the results after the following code is executed?
>
> ```java
> int[] x = { 55, 33, 88, 22, 99, 11, 44, 66, 77 };
> int a = 10;
> if (x[2] > x[5])
>     a = 5;
> else
>     a = 8;
> ```
>
> 1. `a = 5`
> 2. `a = 13`
> 3. `a = 8`
> 4. `a = 10`

**A.** `a = 5`
