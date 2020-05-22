package edu.cnm.deepdive.dicesolitaire.model;

import java.util.Arrays;
import java.util.Random;

public class Roll {

  public static final int NUM_DICE = 5;  //static final makes it a constant
  public static final int NUM_FACES = 6;  //self-documentation

  private final int[] dice;

  public Roll(Random rng) {   //constructor - same name as class
    dice = new int[NUM_DICE]; //allocated space on the heap, dice field points to array in heap
    for (int i = 0; i < NUM_DICE; i++) {  //says for, starting with new variable i that starts at a value of 0, before each iteration, check that it is less than 5, and then update - could also use dice.length
      dice[i] = 1 + rng.nextInt(NUM_FACES);  //generate random number from 0 to 5, add 1 to it and that becomes an array value
    }
    Arrays.sort(dice);  //java se 8 api utility for sorting
  }

  public int[] getDice() {
    return Arrays.copyOf(dice, NUM_DICE); //once we allocate space for an array it cannot be expanded or contracted
    //returning to the consumer a copy of the dice that are rolled, so they can't alter the dice on the heap
  }
}
