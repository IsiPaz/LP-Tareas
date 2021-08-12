#lang racket

(define (serie funcion entero)
  (let repetir((contador 1) (suma 0))
    (if (= contador (+ entero 1))
        suma
        (repetir (+ contador 1) (+ (funcion contador) suma)))))

