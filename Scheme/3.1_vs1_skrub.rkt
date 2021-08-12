#lang racket

;;Nombre : CompAImp
;;Parametro : (L1 L2 izq der)
;;Descripción : compara las listas con el operador A en posiciones impares
;;Retorno : retorna lista ganadora

(define CompAImp
  (lambda (lista1 lista2 izq der);parte en impar = sumarle a der (2)
    (if (or(null? lista1) (null? lista2))
        (ganador izq der)
         (if (and (= (car lista1) (car lista2)) (= (car lista1) 1)) ;ambos iguales e igual a 1
            (CompAPar (cdr lista1) (cdr lista2) izq (+ der 1))
            (CompAPar (cdr lista1) (cdr lista2) izq der)))))


;;Nombre : CompAPar
;;Parametro : (L1 L2 izq der)
;;Descripción : comapara las listas con el operador A en posiciones pares
;;Retorno : retorna lista ganadora

(define CompAPar
  (lambda (lista1 lista2 izq der);par = sumarle a izq (1)
    (if (or (null? lista1)(null? lista2))
        (ganador izq der)   
         (if (and (= (car lista1) (car lista2)) (= (car lista1) 1)) ;ambos iguales e igual a 1
            (CompAImp (cdr lista1) (cdr lista2) (+ izq 1) der)
            (CompAImp (cdr lista1) (cdr lista2) izq der)))))


;;Nombre : CompOImp
;;Parametro : (L1 L2 izq der)
;;Descripción : Compara las listas con operador O en posiciones impares
;;Retorno : retorna lista ganadora

(define CompOImp
  (lambda (L1 L2 izq der)
    (if (or (null? L1)(null? L2))
        (ganador izq der)
        (if (or (= (car L1) 1) (= (car L2) 1))
            (CompOPar (cdr L1) (cdr L2) izq (+ der 1))
            (CompOPar (cdr L1) (cdr L2) izq der)))))


;;Nombre : CompOPar
;;Parametro : (L1 L2 izq der)
;;Descripción : Compara con el operador O en posiciones pares
;;Retorno : retorna lista ganadora

(define CompOPar
  (lambda (L1 L2 izq der)
    (if (or (null? L1)(null? L2))
        (ganador izq der)
        (if (or (= (car L1) 1) (= (car L2) 1))
            (CompOImp (cdr L1) (cdr L2) (+ izq 1) der)
            (CompOImp (cdr L1) (cdr L2) izq der)))))


;;Nombre : CompXImp
;;Parametro : (L1 L2 izq der)
;;Descripción : Compara con el operador X en posiciones impares
;;Retorno : retorna lista ganadora

(define CompXImp
  (lambda (L1 L2 izq der)
    (if (or (null? L1)(null? L2))
        (ganador izq der)
        (if (or (and (= (car L1) 1) (= (car L2) 0)) (and (= (car L2) 1) (= (car L1) 0)))
            (CompXPar (cdr L1) (cdr L2) izq (+ der 1))
            (CompXPar (cdr L1) (cdr L2) izq der)))))


;;Nombre : CompXPar
;;Parametro : (L1 L2 izq der)
;;Descripción : Comapara con el operador X en posiciones pares
;;Retorno : retorna la lista ganadora

(define CompXPar
  (lambda (L1 L2 izq der)
    (if (or (null? L1)(null? L2))
        (ganador izq der)
        (if (or (and (= (car L1) 1) (= (car L2) 0)) (and (= (car L2) 1) (= (car L1) 0)))
            (CompXImp (cdr L1) (cdr L2) (+ izq 1) der)
            (CompXImp (cdr L1) (cdr L2) izq der)))))


(define vs
  (lambda (lista)
    (define izq 0)
    (define der 0)
    (cond
      ((eq? (car lista) 'A) (CompAImp (car(cdr lista)) (car(cdr(cdr lista))) izq der))
      ((eq? (car lista) 'O) (CompOImp (car(cdr lista)) (car(cdr(cdr lista))) izq der))
      ((eq? (car lista) 'X) (CompXImp (car(cdr lista)) (car(cdr(cdr lista))) izq der))
      (else "comando no aceptado"))))


;;Nombre : ganador
;;Parametro : (izq der)
;;Descripción : funcion que chequea al ganador entre izq y der 
;;Retorno : retorna la lista ganadora del combate

(define ganador
  (lambda (izq der)
    '(izq)
    '(der)
    (cond
          ((< izq der) '2)
          ((> izq der) '1)
          (else #f))))

;(vs '(A (0 1 1 0 1 1) (1 0 1 1 0 1)))
;(vs '(O (1 0 0 0 0 0 1 0) (1 0 0 0 0 1 1 0)))