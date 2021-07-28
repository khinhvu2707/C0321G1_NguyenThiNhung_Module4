package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Aspect
@Component
public class BookAspect {
    public static int count = 0;

    @Pointcut("execution(* com.example.controller.BookController.borrow(..))")
    public void borrow() {
    }

    @Pointcut("execution(* com.example.controller.BookController.pay(..))")
    public void pay() {
    }

    @After("borrow()")
    public void resultBorrow(JoinPoint joinPoint) {
        System.err.println("Hành động : " + joinPoint.getSignature().getName());
        System.err.println("Thời gian :" + LocalDate.now());
    }

    @After("pay()")
    public void resultPay(JoinPoint joinPoint) {
        System.err.println("Hành động : " + joinPoint.getSignature().getName());
        System.err.println("Thời gian :" + LocalDate.now());
    }

    @After("execution(* com.example.controller.BookController.*(..))")
    public void result(JoinPoint joinPoint) {
        System.err.println("Số lượt truy cập vào trang :" + ++count);
    }
}
