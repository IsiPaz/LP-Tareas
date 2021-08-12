#lang racket

;;Nombre : LastNode
;;Parametro : (N Lo Cc Lc Lct CML Cont Lmax)
;;Breve descripcíon : busca el ultimo nodo de un camino
;;Retorno de la funcíon : nodo actual con el camino recorrido

(define LastNode
  (lambda (N Lo Cc Lc Lct CML Cont Lmax)
    (if (not(null? (cdr Lct)))
        (LastNode N Lo Cc Lc (cdr Lct) CML (+ Cont 1) Lmax)
        (NodoAct (car Lct) Lo Lo Cc Lc CML Cont Lmax))))
    
;;Nombre : setlistaresto
;;Parametro : (Sn Lo Dest Lc Cc Cont Lmax CML)
;;Breve descripcíon : Guarda en lista de listas posibles caminos
;;Retorno de la funcíon : nodo actual con lista de su camino recorrido y lista de posibles de nodo anterior

(define setlistaresto
  (lambda (Sn Lo Dest Lc Cc Cont Lmax CML)
    (if (not(null? Dest))
        (setlistaresto Sn Lo (cdr Dest) Lc (append Cc (list (append Lc (list (car Dest))))) Cont Lmax CML)
        (NodoAct Sn Lo Lo Cc Lc CML Cont Lmax))))

;;Nombre : Encontrar Camino
;;Parametro : (N Lo Pc Cc Lc CML Cont Lmax)
;;Breve descripcíon : Si recive siguiente nodo (Pc) vacio y lista de caminos restantes vacio retorna mejor camino, si
;;Retorno de la funcíon : Lista mas larga

(define EncontrarCamino
  (lambda (N Lo Pc Cc Lc CML Cont Lmax)
    (if (not(null? Pc))
        (if (not(null? (cdr Pc)))
            (setlistaresto (car Pc) Lo (cdr Pc) Lc Cc Cont Lmax CML)
            (NodoAct (car Pc) Lo Lo Cc Lc CML Cont Lmax)
            )
        (if (< Lmax Cont)
            (if (null? Cc)
                Lc
                (LastNode 0 Lo (cdr Cc) (car Cc) (car Cc) Lc 1 Cont)
                )
            (if (null? Cc)
                CML
                (LastNode 0 Lo (cdr Cc) (car Cc) (car Cc) CML 0 Lmax))))))
            
;;Nombre : NodoAct
;;Parametro : (N Lo Lm Cc Lc CML Cont Lmax)
;;Breve descripcion : función que busca el nodo actual
;;Retorno de la funcíon : retorna el nodo actual

(define NodoAct
  (lambda (N Lo Lm Cc Lc CML Cont Lmax)
    (if (= (car(car Lm)) N)
        (EncontrarCamino N Lo (car(cdr(car Lm))) Cc (append Lc (list N)) CML (+ Cont 1) Lmax)
        (NodoAct N Lo (cdr Lm) Cc Lc CML Cont Lmax))))

(define voy
  (lambda (N L)
    (NodoAct N L L '() '() '() 0 0)))


;(voy 1 '( (1 (2 3) ) (2 (3 4) ) ( 3 (4) ) (4 () ) ) )
