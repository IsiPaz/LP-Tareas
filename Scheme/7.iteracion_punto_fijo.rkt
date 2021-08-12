#lang racket


(define (fpi funcion umbral i)
  (let rep( (x i)(contador 0))
    (if (<= (abs (-(funcion x) x))umbral)
        contador
        (rep (funcion x) (+ contador 1) ))))