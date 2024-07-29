// Define the Term class
class Term {
    int coefficient;
    int power;
    Term next;

    Term(int coefficient, int power) {
        this.coefficient = coefficient;
        this.power = power;
        this.next = null;
    }
}

// Define the Polynomial class
class Polynomial {
    private Term head;

    // Constructor for creating a polynomial from a single term
    Polynomial(Term term) {
        head = term;
    }

    // Method to add a polynomial
    public void add(Polynomial p) {
        Term current = p.head;
        while (current != null) {
            addTerm(current.coefficient, current.power);
            current = current.next;
        }
    }

    // Helper method to add a term to the polynomial
    private void addTerm(int coefficient, int power) {
        Term newTerm = new Term(coefficient, power);
        if (head == null) {
            head = newTerm;
            return;
        }

        Term current = head;
        Term prev = null;
        while (current != null && current.power > power) {
            prev = current;
            current = current.next;
        }

        if (current != null && current.power == power) {
            current.coefficient += coefficient;
        } else {
            newTerm.next = current;
            if (prev == null) {
                head = newTerm;
            } else {
                prev.next = newTerm;
            }
        }
    }

    // Method to multiply two polynomials
    public Polynomial multiply(Polynomial p) {
        Polynomial result = new Polynomial(new Term(0, 0));
        for (Term term1 = head; term1 != null; term1 = term1.next) {
            Polynomial temp = new Polynomial(new Term(0, 0));
            for (Term term2 = p.head; term2 != null; term2 = term2.next) {
                int newCoeff = term1.coefficient * term2.coefficient;
                int newPower = term1.power + term2.power;
                temp.addTerm(newCoeff, newPower);
            }
            result.add(temp);
        }
        return result;
    }

    // Method to print the polynomial and y-intercept
    public void print() {
        Term current = head;
        boolean isFirst = true;
        int yIntercept = 0;
        while (current != null) {
            if (current.coefficient != 0) {
                if (!isFirst && current.coefficient > 0) {
                    System.out.print(" + ");
                } else if (current.coefficient < 0) {
                    System.out.print(" - ");
                }
                if (Math.abs(current.coefficient) != 1 || current.power == 0) {
                    System.out.print(Math.abs(current.coefficient));
                }
                if (current.power != 0) {
                    System.out.print("x");
                    if (current.power != 1) {
                        System.out.print("^" + current.power);
                    }
                }
                if (current.power == 0) {
                    yIntercept = current.coefficient;
                }
                isFirst = false;
            }
            current = current.next;
        }
        System.out.println();
        System.out.println("y-intercept: " + yIntercept);
    }

    // Main method to test the Polynomial class
    public static void main(String[] args) {
        Polynomial p = new Polynomial(new Term(-10, 0));
        p.add(new Polynomial(new Term(-1, 1)));
        p.add(new Polynomial(new Term(9, 7)));
        p.add(new Polynomial(new Term(5, 10)));

        System.out.print("p(x) = ");
        p.print();

        Polynomial q = p.multiply(p);
        System.out.print("p(x) * p(x) = ");
        q.print();
    }
}
