package com.empapp.exception;

import java.util.InputMismatchException;

public class InputException extends InputMismatchException
{
     public InputException()
     {
         System.out.println("Input Entered is incorrect");
     }
}
