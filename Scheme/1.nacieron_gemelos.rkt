#lang racket

;;Nombre : igual
;;Parametros : (L1 L2 L1s L2s)
;;Descripcion : Funcion auxiliar que recorre los arboles para saber si son isomorfos
;;Retorno de la funcion : Retorna #t si son isomorfos, caso contrario retorna #f

(define igual
  (lambda (L1 L2 L1s L2s)
    (if (or(and(null? L1)(not(null? L2)))(and(null? L2)(not(null? L1))))
        (< 2 1)
        (if (and(not(null? L1))(not(null? L2)))
            (igual (car(cdr L1)) (car(cdr L2)) (append L1s (cdr(cdr L1))) (append L2s (cdr(cdr L2))))
            (if (and (not(null? L1s))(not(null? L2s)))
                (igual (car L1s) (car L2s) (cdr L1s) (cdr L2s))
                (if (and (null? L1s)(null? L2s))
                    (< 1 2)
                    (> 1 2)))))))
   
(define gemelos
  (lambda (L1 L2)
    (igual L1 L2 '() '())))



;(gemelos '(2 (12 '() '() ) (1 '() (8 '() '() ) ) ) '(3 (2 '() '() ) (18 '() (9'() '() ) ) ) )
;(gemelos '() '(4 (7 () (3 () (1 (4 () () ) () ) ) ) () ) )