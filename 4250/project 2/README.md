**CS 4250 Programming Languages Fall 2019**

**----------------------------------------------------------------------------------------------------**

**Project #2 [55 points].**

**Due date is Monday, October 14 (11:59 pm).**

**Please, note that the original due date (10/09) is changed.**

This is a programming project. Write your programs using DrRacket functional language.

Run each of the programs as many times as necessary to show that different situations are handled properly.

1. In the beginning of each part of this problem, introduce a named value pi, which is 3.1416. You will have to write a function my\_area that takes two numerical parameters. If the first parameter is 1, calculate the area of a circle, whose radius equals the second parameter of the function. If the first parameter is 2, calculate the volume of the sphere, whose radius equals the second parameter of the function. For other values of the first parameter and for a non-positive second parameter return a false Boolean value.

A) [7 points] Implement a function my\_area using a multiple-way selection structure when checking the value of the first parameter.

B) [7 points] Implement a function my\_area using a two-way selection structure when checking the value of the first parameter.

2. [12 points] Write a Racket function rem\_second that takes a list as a parameter and returns a list identical to the parameter except with the second top-level element removed. If the given list does not have two elements, the function should return an empty list.

3. [13 points] Write a Racket function my\_union that returns a union of two simple list parameters that represent sets. Remember that duplicate elements are not allowed in a set. You may use a program &#39;membership.rkt&#39; from the folder &#39;DrRacket&#39; under &#39;Modules&#39;.

4. [16 points] Write a function my\_delete that takes two parameters: an atom and a list (which may be a nested list). This function will produce a list, identical to its parameter list, except with all occurrences of an atom parameter removed, no matter how deep they were. The produced list should not have anything in place of the deleted atoms.

For each part of the project submit screenshots that show the code of your program and results of its execution.
