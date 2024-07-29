# Polynomial Calculator

This Java project implements a Polynomial class using a linked list to store polynomial terms. Each term consists of a coefficient and the power of x. The project provides methods to add, multiply, and print polynomials, as well as calculate the y-intercept.

## Classes

### Term

The `Term` class represents a single term in a polynomial.

#### Fields

- `int coefficient`: The coefficient of the term.
- `int power`: The power of the term.
- `Term next`: A reference to the next term in the linked list.

#### Constructor

- `Term(int coefficient, int power)`: Initializes the term with the given coefficient and power.

### Polynomial

The `Polynomial` class represents a polynomial as a linked list of terms.

#### Fields

- `Term head`: The head of the linked list.

#### Constructor

- `Polynomial(Term term)`: Initializes the polynomial with a single term.

#### Methods

- `void add(Polynomial p)`: Adds the given polynomial to the current polynomial.
- `Polynomial multiply(Polynomial p)`: Multiplies the current polynomial with the given polynomial and returns the result.
- `void print()`: Prints the polynomial and its y-intercept.

## Usage

### Creating a Polynomial

You can create a polynomial from a single term and add more terms to it. For example:

```java
Polynomial p = new Polynomial(new Term(-10, 0));
p.add(new Polynomial(new Term(-1, 1)));
p.add(new Polynomial(new Term(9, 7)));
p.add(new Polynomial(new Term(5, 10)));
