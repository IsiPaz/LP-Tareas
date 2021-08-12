#lang racket

;;retorna #f si la lista es vacia

(define (segm funcion lista)
  (if (null? lista)
    #f
    (let evaluar ((i (car lista)) (v '()) (f '()) (largo (length lista)) (l1 lista))
     (if (= largo 0)
         (append v f)
         (if (= largo 1)
             (if (equal? (funcion i) #true)
                 (evaluar  i (append v (list i)) f (- largo 1) (cdr l1))
                 (evaluar  i v (append f (list i)) (- largo 1)(cdr l1))
             )                
             (if (equal? (funcion i) #true)
                 (evaluar (car (cdr l1)) (append v (list i)) f (- largo 1) (cdr l1) )
                 (evaluar (car (cdr l1)) v (append f (list i)) (- largo 1)(cdr l1))))))))


