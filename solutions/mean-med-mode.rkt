#lang racket

; mean implementation with sumlist
(define (meanlist lis)
  (/ (sumlist lis) (length lis)))

; median implementation with recursion
(define (medianlist lis)
  (define sorted-list (sort lis <))
  (if (equal? (length sorted-list) 2)
      (/ (sumlist sorted-list) 2)
      (if (equal? (length sorted-list) 1)
          (sumlist sorted-list)
          (trimlist sorted-list))))

; helper function to take off first and last number in list
(define (trimlist lis)
  (medianlist (cdr (sort (cdr lis) >))))

; mode implementation with recursion
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
        (let* ([head (car lis)] ; temporary assignments
              [tail (cdr lis)]
              [count (countelement head tail)])
         (cond
           [(> count currfreq)
            (findmode tail head count)]
           [else
            (findmode tail currmode currfreq)]))))
  ; base case
  (if (null? lis)
      #f
      (let* ([head (car lis)]
            [tail (cdr lis)]
            [count (countelement head tail)])
       (findmode tail head count))))
      
      
       
       
  

; classic head-tail recursion
(define (sumlist lis)
  (if (= (length lis) 0)
      0
      (+ (car lis) (sumlist (cdr lis)))))