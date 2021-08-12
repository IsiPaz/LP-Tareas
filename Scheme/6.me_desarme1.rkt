#lang racket

;;Nombre :(remove lista)
;;Descripción : función que recibe una lista como parametro y elimina elementos repetidos en caso de que existan
;;Retorno : retorna la lista sin elementos repetidos

(define (remove lista)
  (cond
    ((null? lista) '())
    ((member (car lista) (cdr lista)) (remove (cdr lista)))
    (else (cons (car lista) (remove (cdr lista))))))



(define (armar k lista)
  (cond
  ((null? lista) #f)
  ((= (length lista) 1) #f)
  (else (let recorrer ((i (car (remove lista))) (j (car(cdr (remove lista)))) (iterador (- (length (remove lista)) 1)) (l1 (cdr (remove lista))) (l2 (cdr (remove lista))) (l3 '()))
    (if (= iterador 0)
        (if (null? l3)
            #f
            l3
         )
        (if (= iterador 1)
            (if (= (+ i j) k)
                (recorrer i j (- iterador 1) l1 (cdr l2) (append l3 (list(list i j)))); cuando quedan los ultimos dos elementos grandes de la lista
                (recorrer i j (- iterador 1) l1 (cdr l2) l3)
            )
            
            (if (= (length l2) 1);si acaba la primera iteracion
                (if (= (+ i j) k)
                  (recorrer (car l1) (car(cdr l1)) (- iterador 1) (cdr l1) (cdr l1) (append l3 (list(list i j))))
                  (recorrer (car l1) (car(cdr l1)) (- iterador 1) (cdr l1) (cdr l1) l3)
                )
                (if (=(+ i j) k)
                  (recorrer i (car(cdr l2)) iterador l1 (cdr l2) (append l3 (list(list i j))) )
                  (recorrer i (car(cdr l2)) iterador l1 (cdr l2) l3)))))))))

