#lang racket

(define (cima lista)
  (cond
    ((= 1 (length lista)) (list (car lista)))
    ((null? lista) #false)
    (else (let subir((i (car lista)) (j (car(cdr lista))) (l1 (cdr lista)) (l2 '()) (l3 lista)(contador (length lista)))
            (if (= 1 contador)
                l2
                (if (= 1 (length l1))
                    (cond
                      ((= 2 (length l3))(subir i j l1 (append l2 (list(+ i j))) l3(- contador 1)))
                      ((= (- contador 1) (length l2))(subir (car l2) (car(cdr l2)) (cdr l2) '() l2 (- contador 1)))
                      (else (subir i j l1 (append l2 (list(+ i j))) l3 contador)))

                    (subir (car l1)(car(cdr l1))(cdr l1)(append l2 (list(+ i j))) l3 contador)))))))


