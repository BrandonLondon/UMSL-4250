#lang racket
;Brandon London
;4250 Programming languages
;Prof Galina
(define (my_area n r)
	(cond
		((= n 1) (* pi ( * r r)))
		((= n 2) (* (/ 4 3) pi (* r r r)))
		(else #f)))
(define (my_areab n r)
	(if (>= r 0)
		(if (exact-positive-integer? n)
			(if (= n 1)
				(* pi (* r r))
				(if (= n 2)
					(* (/ 4 3) pi ( * r r r))
					#f))
			
			#f)
		#f))

(define (rem-second list)
	(if (>= (length list) 2)
		(cons (car list) (cdr (cdr list)))
		'()))

(define (my_union a b)
	(cond ((null? b) a)
		((member (car b) a)
		 (my_union a (cdr b)))
		(else (my_union (cons (car b) a) (cdr b)))))

(define (my_delete V L)
	(cond ((null? L) L)
		((list? (car L))
			(cons (my_delete V (car L)) (my_delete V (cdr L))))
		((equal? V (car L)) (my_delete V (cdr L)))
		(else (cons (car L) (my_delete V (cdr L ))))))