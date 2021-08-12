#lang racket

;;Nombre : suumacola
;;Parametros : (n L1 L2 sum may men nmay nmen)
;;Breve descripcion : Funcion que suma los valores de L1 de forma recursiva de cola
;;Retorno: numero de la lista, su suma y el resto de listas por evaluar

(define sumacola
  (lambda (n L1 L2 sum may men nmay nmen)
    (if (null? L1)
        (presumacola n L2 sum may men nmay nmen)
        (sumacola n (cdr L1) L2 (+ sum (car L1)) may men nmay nmen))))

;;Nombre : presumacola
;;Parametros : (n L2 suma may men nmay nmen)
;;Breve descripcion : Función que recorre listas de listas y recuerda la suma de la lista mayor y menor
;;Retorno de la funcion : retorna una lista con el nombre de la lista mayor y menor
              
(define presumacola
  (lambda (n L2 suma may men nmay nmen)
    (if (null? n)
        (list nmay nmen)
        (if(> suma may)
           (if (< suma men)
               (if (null? L2)
                   (presumacola '() '() 0 suma suma n n)
                   (sumacola (caar L2) (cdar L2) (cdr L2) 0 suma suma n n)
                   )
               (if (null? L2)
                   (presumacola '() '() 0 suma men n nmen)
                   (sumacola (caar L2) (cdar L2) (cdr L2) 0 suma men n nmen)
                   )
               )
           (if (< suma men)
               (if (null? L2)
                   (presumacola '() '() 0 may suma nmay n)
                   (sumacola (caar L2) (cdar L2) (cdr L2) 0 may suma nmay n)
                   )
               (if (null? L2)
                   (presumacola '() '() 0 may men nmay nmen)
                   (sumacola (caar L2) (cdar L2) (cdr L2) 0 may men nmay nmen)))))))

(define maymecola
  (lambda (lista)
    (sumacola (caar lista) (cdar lista) (cdr lista)  0 -inf.0 +inf.0 0 0)))


;;Nombre : suma
;;Parametros : (lista)
;;Breve descripcion : Función que suma los elementos de una lista de forma recursion simple
;;Retorno de la funcion : retorna el valor final de la suma de los elementos de la lista

(define suma
  (lambda (lista)
    (if (null? lista)
        0
        (+ (car lista) (suma (cdr lista))))))

;;Nombre : presuma
;;Parametros : (L1 L2 may men nmay nmen)
;;Breve descripcion : Función que recorre listas de listas y recuerda la suma de la lista mayor y menor
;;Retorno de la funcion : retorn una lista con el nombre de la lista mayor y menor

(define presuma
  (lambda (L1 L2 may men nmay nmen)
    (if (null? L1)
        (list nmay nmen)
        (if(> (suma (cdr L1)) may)
           (if (< (suma (cdr L1)) men)
               (if (null? L2)
                   (presuma '() '() (suma (cdr L1)) (suma (cdr L1)) (car L1) (car L1))
                   (presuma (car L2) (cdr L2) (suma (cdr L1)) (suma (cdr L1)) (car L1) (car L1))
                   )
               (if (null? L2)
                   (presuma '() '() (suma (cdr L1)) men (car L1) nmen)
                   (presuma (car L2) (cdr L2) (suma (cdr L1)) men (car L1) nmen)
                   )
               )
           (if (< (suma (cdr L1)) men)
               (if (null? L2)
                   (presuma '() '() may (suma (cdr L1)) nmay (car L1))
                   (presuma (car L2) (cdr L2) may (suma (cdr L1)) nmay (car L1))
                   )
               (if (null? L2)
                   (presuma '() '() may men nmay nmen)
                   (presuma (car L2) (cdr L2) may men nmay nmen)
                   ))))))

(define maymecolasimple
  (lambda (lista)
    (presuma (car lista) (cdr lista)-inf.0 +inf.0 0 0)))

