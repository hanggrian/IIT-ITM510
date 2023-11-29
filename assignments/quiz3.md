<style type="text/css">ol { list-style-type: upper-alpha; }</style>

# Quiz 3: Inheritance

- What Is Inheritance?
- Calling the Superclass Constructor
- Overriding Superclass Methods
- Protected Members
- Chains of Inheritance
- The Object Class
- Polymorphism
- Abstract Classes and Abstract Methods
- Interfaces
- Anonymous Classes
- Functional Interfaces and Lambda Expressions

## Problem 1

> In an inheritance relationship ______.
>
> 1. The superclass constructor always executes before the subclass constructor

**A**. The superclass constructor always executes before the subclass constructor.

## Problem 2

> In a class hierarchy ______.
>
> 2. the more general classes are toward the top of the tree and the more
     specialized classes are toward the bottom

**B**. the more general classes are toward the top of the tree and the more
       specialized classes are toward the bottom

## Problem 3

> Which of the following is the operator used to determine whether an object is
  an instance of a particular class?
>
> 1. `instanceOf`

**A**. `instanceOf`

## Problem 4

> If you don't provide an access specifier for a class member, the class member
  is given ______ access by default.
>
> 3. package

**C**. package

## Problem 5

> Given the following code:
>
> ```java
> public class ClassA {
>   public ClassA() {}
>   public void method1(int a) {}
> }
> public class ClassB extends ClassA {
>   public ClassB() {}
>   public void method1() {}
> }
> public class ClassC extends ClassB {
>   public ClassC() {}
>   public void method1() {}
> }
>
> Which method1 will be executed when the following statements are executed?
>
> ```java
> ClassA item1 = new ClassB();
> item1.method1();
> ```
>
> 1. This is an error and will cause the program to crash.

**A**. This is an error and will cause the program to crash.

## Problem 6

> ______ is a special type of expression used to create an object that
  implements a functional interface.
>
> 2. lambda

**B**. lambda

## Problem 7

> A subclass can directly access ______.
>
> 3. only public and protected members of the superclass

**C**. only public and protected members of the superclass

## Problem 8

> Which key word indicates that a class inherits from another class?
>
> 3. `extends`

**C**. `extends`

## Problem 9

> In the following code, which line has an error?
>
> ```java
> public interface Interface1
> {
>   int FIELDA = 55;
>   public int methodA(double) {}
> }
> ```
>
> 1. Line 4

**A**. Line 4

## Problem 10

> Inheritance involves a subclass, which is the general class, and a superclass,
  which is the specialized class.
>
> 1. True
> 2. False

**B**. False

## Problem 11

> If two methods in the same class have the same name but different signatures,
  the second overrides the first.
>
> 1. True
> 2. False

**B**. False

## Problem 12

> A functional interface is simply an interface that has one abstract method.
>
> 1. True
> 2. False

**A**. True
