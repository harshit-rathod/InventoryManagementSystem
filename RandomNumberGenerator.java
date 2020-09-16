import java.io.*;
public class RandomNumberGenerator 
{

 private int minNumber, maxNumber;

 public RandomNumberGenerator() 
 {

 }

 public RandomNumberGenerator(int minNumber, int maxNumber) 
 {

 }

 //Generates a randomvalue/number between the provided minimum and maximum value.
 public int generateRandomNumber(int minNumber, int maxNumber) 
 {
  int rn = (minNumber + (int)(Math.random() * maxNumber));
  return rn;
 }
}