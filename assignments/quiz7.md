<style type="text/css">ol { list-style-type: upper-alpha; }</style>

# Quiz 7: Generics

- Introduction to Generics
- Writing a Generic Class
- Passing Objects of a Generic Class to a Method
- Writing Generic Methods
- Constraining a Type Parameter in a Generic Class
- Inheritance and Generic Classes
- Defining Multiple Parameter Types
- Generics and Interfaces
- Erasure
- Restrictions of the Use of Generic Types

## Problem 1

> A generic class
>
> 1. may create instances of any of its type parameters
> 2. may not create instances of any of its type parameters
> 3. may not implement interfaces that are generic
> 4. None of the above

**B.** may not create instances of any of its type parameters

## Problem 2

> Let `Point<T>` be a generic type. We want to write a method that takes as
  parameter `Point` objects whose type parameter is the `Number` class, or any
  subclass of `Number`. We can do this by declaring the type of the method
  parameter as
>
> 1. `Point<Number>`
> 2. `Point<? super Number>`
> 3. `Point<? extends Number>`
> 4. `Point<? sub Number>`

**C.** `Point<? extends Number>`

## Problem 3

> Which of the following statements are true?
>
> 1. You cannot instantiate an object of a generic type
> 2. You cannot create arrays whose elements are instances of a generic type
> 3. You can declare references to arrays whose elements are of a generic type
> 4. All of the above

**C.** You can declare references to arrays whose elements are of a generic type

## Problem 4

> Erasure is the process of
>
> 1. removing references to generic interfaces during execution
> 2. returning the null value when the compiler cannot determine the value of a
    generic reference
> 3. replacing generic types with their upper bound, or with Object, during
    compilation
> 4. deleting generic types that cannot be correctly resolved during compilation

**C.** replacing generic types with their upper bound, or with Object, during
    compilation

## Problem 5

> Let `Point<T>` be a generic type. We want to write a method that takes as
  parameter `Point` objects whose type parameter is the `Number` class, or any
  superclass of `Number`. We can do this by writing
>
> 1. `Point<Number>`
> 2. `Point<? super Number>`
> 3. `Point<? extends Number>`
> 4. `Point<? sub Number>`

**B.** `Point<? super Number>`

## Problem 6

> The automatic conversion of a primitive type to the corresponding wrapper type
  when being passed as parameter to a generic class is called
>
> 1. type promotion
> 2. type wrapping
> 3. autoconversion
> 4. autoboxing

**D.** autoboxing

## Problem 7

> The code fragment
>
> ```java
> class MySArrayList extends ArrayList<String> {
> }
> ```
>
> 1. is a correct way to extend a class
> 2. is incorrect because there is no type variable
> 3. is incorrect because it is missing the wildcard symbol
> 4. None of the above

**A.** is a correct way to extend a class

## Problem 8

> An advantage of using generic types is
>
> 1. lower compile-time overhead
> 2. increased portability of Java programs
> 3. increased type-safety without the need to do typecasts at run time
> 4. faster execution of programs that use generics

**C.** increased type-safety without the need to do typecasts at run time

## Problem 9

> Consider the class
>
> ```java
> class Value<T extends Number> {
>   private T v;
>   public Value(T v1) {
>     v = v1;
>   }
>   public void output() {
>     System.out.println(v);
>   }
> }
> ```
>
> The code
>
> ```java
> Value<Number> nV1 = new Value<Double>(34.5);
> ```
>
> 1. will cause a compiler error
> 2. will compile correctly, but cause an exception at run time
> 3. will compile and run correctly
> 4. None of the above

**A.** will cause a compiler error

## Problem 10

> The process used by the Java compiler to remove generic notation and
  substitute actual type arguments for formal type parameters is called
>
> 1. erasure
> 2. removal
> 3. substitution
> 4. masking

**A.** erasure
