#lang racket

    
;;Nombre : row
;;Parametro : (N Lg Ls Lp1 c1 c2)
;;Breve descripcíon : función que chequea si una fila esta ordenada de menor a mayor
;;Retorno de la funcíon : booleano.

(define row
  (lambda (N Lg Ls Lp1 c1 c2)
    (if (< c1 N)
        (if (< c2 N )
            (if (< (car Lp1) (car(cdr Lp1)))
                (row N Lg Ls (cdr Lp1) (+ c1 1) c2)
                (if (null? Ls)
                    (column N Lg Lg (cdr(cdr Lg)) (car Lg) (car(cdr Lg)) 1 1)
                    (row N Lg (cdr Ls) (car Ls) 1 (+ c2 1))))
            (column N Lg Lg (cdr(cdr Lg)) (car Lg) (car(cdr Lg)) 1 1);N, lista de listas; last list save, lista de listas a modificar, L1, L2, cont hilera, cont col
            )
        (< 1 2))))


;;Nombre : BorrarCol
;;Parametro : (N Lg Lm Ls c1 c2)
;;Breve descripcíon : funcion auxiliar de column que borra columna de la matriz mandada
;;Retorno de la funcíon : Resto de la matriz

(define BorrarCol
  (lambda (N Lg Lm Ls c1 c2) 
    (if (null? Ls)
        (BorrarCol N Lg (append Lm (list (cdr(car Ls)))) (cdr Ls) c1 (+ c2 1))
        (if (null? Lm)
            (diagonal N (cdr Lg) (car(car Lg)) 1 2)
            (column N Lg Lm (cdr(cdr Lm)) (car Lm) (car(cdr Lm)) (+ c1 1) 1)))))


;;Nombre : column
;;Parametro : (N Lg Ls Lm L1 L2 c1 c2)
;;Breve descripcíon : función que chequea si una columna esta ordenada de menor a mayor
;;Retorno de la funcíon : booleano

(define column
  (lambda (N Lg Ls Lm L1 L2 c1 c2)      
    (if (< c2 N)
        (if (< c1 (+ N 1))
            (if (< (car L1) (car L2))
                (if (null? Lm)
                    (< 1 2)
                    (column N Lg Ls (cdr Lm) L2 (car Lm) c1 (+ c2 1)))
                (if (null? (cdr(car Ls)))
                    (diagonal N (cdr Lg) (car(car Lg)) 1 2)
                    (BorrarCol N Lg '() Ls c1 1)))
            (diagonal N (cdr Lg) (car(car Lg)) 1 2))
        (< 2 1))))


;;Nombre : auxDiag
;;Parametro : (N Lm Ls V1 c1 c2)
;;Breve descripcíon : Funcion auxiliar de diagonal, que elimina columna inecesaria
;;Retorno de la funcíon : retorna matriz con indicacion en coordenadas del valor que sera evaluado

(define auxDiag
  (lambda (N Lm Ls V1 c1 c2)
    (if (< c1 N)
        (auxDiag N (append Lm (list(cdr(car Ls)))) (cdr Ls) V1 (+ c1 1) c2)
        (diagonal N Lm V1 c2 c2))))


;;Nombre : digonal
;;Parametro : (N Ls V1 c1 c2)
;;Breve descripcíon : función que chequea si la diagonal esta ordenada de menor a mayor
;;Retorno de la funcíon : booleano

(define diagonal
  (lambda (N Ls V1 c1 c2)
    (if (< c2 (+ N 1))
        (if (not (= c1 c2))
            (auxDiag N '() Ls V1 c1 c2)
            (if (< V1 (car(car Ls)))
                (diagonal N (cdr Ls) (car(car Ls)) c1 (+ c2 1))
                (< 2 1)))
        (< 1 2))))



(define orden
  (lambda (N L)
    (row N L (cdr L) (car L) 1 0)))


;(orden 3 '( (1 4 3) (2 2 12) (1 5 15) ) )
;(orden 3 '( (3 9 8) (6 5 4) (2 1 7) ) )