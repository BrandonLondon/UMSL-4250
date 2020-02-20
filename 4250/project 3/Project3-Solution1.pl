male(pete).
male(mark).
male(tom).
male(john).
male(frank).
male(matt).
male(henry).
male(todd).
female(anne).
female(lilly).
female(kate).
female(alice).
female(jenny).
/*  parent ( child, parent).  */
parent(mark, pete).
parent(tom, pete).
parent(anne, pete).
parent(lilly, mark).
parent(john, mark).
parent(frank, mark).
parent(kate, tom).
parent(alice, anne).
parent(matt, anne).
parent(henry, alice).
parent(jenny, matt).
parent(todd, matt).
father(Child, Dad) :- male(Dad), parent(Child, Dad).
mother(Child, Mom) :- female(Mom), parent(Child, Mom).
brother(Sibling, Bro) :- male(Bro), parent(Sibling, Parent), parent(Bro, Parent), Bro \= Sibling.
sibling(Siblingone, Siblingtwo) :- parent(Siblingone, Parent), parent(Siblingtwo, Parent), Siblingone \= Siblingtwo.
sister(Sibling, Sis) :- female(Sis), parent(Sibling, Parent), parent(Sis, Parent), Sis \= Sibling.
grandparent(Grandchild, Grandparent) :- parent(Grandchild, Parent), parent(Parent, Grandparent).