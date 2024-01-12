#lang racket

; mean implementation with sumlist
(define (meanlist lis)
  (/ (sumlist lis) (length lis)))

; median implementation
(define (medianlist lis)
  (if (even? (length lis))
      (/ (+ (list-ref lis (/ (length lis) 2)) (list-ref lis (- (/ (length lis) 2) 1))) 2)
      (list-ref lis (+ (quotient (length lis) 2)))))

; mode implementation
(define (modelist lis)
  ; function to count times an element appears
  (define (countelement elem lis)
    (cond
      [(null? lis) 0]
      [(equal? elem (car lis))
       (add1 (countelement elem (cdr lis)))]
      [else
       (countelement elem (cdr lis))]))
  ; function to find mode
  (define (findmode lis currmode currfreq)
    (if (null? lis)
        currmode
        
      
      
       
       
  

; classic head-tail recursion
(define (sumlist lis)
  (if (= (length lis) 0)
      0
      (+ (car lis) (sumlist (cdr lis)))))