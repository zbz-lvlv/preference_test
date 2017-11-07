/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preference.test;

import java.awt.Color;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Zbz
 */

//Right is just the reverse
enum Combination{
    ITEM0GOOD,
    ITEM0BAD,
    ITEM1GOOD,
    ITEM1BAD;
}

public class Test {
    
    TestFrame testFrame;
    ResultFrame resultFrame;
    
    String item0;
    String item1;
    String[] words;
    String[] goodWords;
    String[] badWords;
    
    List<Integer> timesItem0Good = new ArrayList<>();
    List<Integer> timesItem0Bad = new ArrayList<>();
    List<Integer> timesItem1Good = new ArrayList<>();
    List<Integer> timesItem1Bad = new ArrayList<>();;
    
    long startTime;
    long endTime;
    
    String word;
    Combination combination = Combination.ITEM0GOOD;
    //Left:  1-Item0,Good 2-Item0,Bad  3-Item1,Good 4-Item1,Bad
    //Right: 1-Item1,Bad  2-Item1,Good 3-Item0,Bad  4-Item0,Good
    
    boolean isItemName;
    
    int correctAnsCount;
    int wrongAnsCount;
    
    final int NUMBER_OF_QUESTIONS = 30;
    
    public Test(String item0, String item1, String[] words, String[] goodWords, String[] badWords){
        
        this.item0 = item0;
        this.item1 = item1;
        this.words = words;
        this.goodWords = goodWords;
        this.badWords = badWords;
        
        testFrame = new TestFrame(this);
        testFrame.setVisible(true);
        
        //Init
        play();
        
    }
    
    private void play(){
        
        if((wrongAnsCount + correctAnsCount) == 0)
                JOptionPane.showMessageDialog(testFrame,
                    "You'll classify 30 words based on their category\nby pressing the left and right arrow keys.\nDo it as fast as you can.",
                    "How to use",
                    JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(testFrame,
                    "The classification categories have switched.",
                    "Note",
                    JOptionPane.INFORMATION_MESSAGE);
        
        switch(combination){
            
            case ITEM0GOOD:
                testFrame.displayLabels(item0, "Good", item1, "Bad");
                break;
            case ITEM0BAD:
                testFrame.displayLabels(item0, "Bad", item1, "Good");
                break;
            case ITEM1GOOD:
                testFrame.displayLabels(item1, "Good", item0, "Bad");
                break;
            case ITEM1BAD:
                testFrame.displayLabels(item1, "Bad", item0, "Good");
                break;   
            
        }
        
        newWord();
        
    }
    
    private void newWord(){
        
        word = getWord(words);    
        testFrame.displayWords(word);       
        startTime = System.currentTimeMillis();
        
    }
    
    private String getWord(String[] words){
        
        Random itemOrAdjR = new Random(System.nanoTime());
        int itemOrAdj = itemOrAdjR.nextInt(5); //0 - 3 Adjective, 4 Item
        
        if(itemOrAdj != 4){
            isItemName = false;
            
            Random wordRnd = new Random(System.nanoTime());
            int wordIndex = wordRnd.nextInt(words.length);
            return words[wordIndex];
        }
        else{
            isItemName = true;
            
            Random zeroOrOneR = new Random(System.nanoTime());
            int zeroOrOne = zeroOrOneR.nextInt(2);
            
            if(zeroOrOne == 0)
                return item0;
            else
                return item1;
        }
        
    }
    
    //Callback from TestFrame
    public void getAnswer(int keyCode){
        
        if(isAnswerCorrect(keyCode)){
            
            endTime = System.currentTimeMillis();
            
            if(!isItemName){
                if((endTime - startTime) < 3000){
                    if(keyCode == 37){
                        if(combination == Combination.ITEM0GOOD){
                            timesItem0Good.add((int)(endTime - startTime));
                        }
                        if(combination == Combination.ITEM0BAD){
                            timesItem0Bad.add((int)(endTime - startTime));
                        }
                        if(combination == Combination.ITEM1GOOD){
                            timesItem1Good.add((int)(endTime - startTime));
                        }
                        if(combination == Combination.ITEM1BAD){
                            timesItem1Bad.add((int)(endTime - startTime));
                        }
                    }

                    else if(keyCode == 39){
                        if(combination == Combination.ITEM0GOOD){
                            timesItem1Bad.add((int)(endTime - startTime));
                        }
                        if(combination == Combination.ITEM0BAD){
                            timesItem1Good.add((int)(endTime - startTime));
                        }
                        if(combination == Combination.ITEM1GOOD){
                            timesItem0Bad.add((int)(endTime - startTime));
                        }
                        if(combination == Combination.ITEM1BAD){
                            timesItem0Good.add((int)(endTime - startTime));
                        }
                    }
                }
            }
            
            testFrame.displayTickCross("Right", new Color(0, 204, 0));
            
            correctAnsCount++;
        }
        else{
            
            startTime = System.currentTimeMillis();
            testFrame.displayTickCross("Wrong", new Color(204, 0, 0));
            
            wrongAnsCount++;
        }
        
        //When total qns hit NUMBER_OF_QUESTIONS, go to results
        if((wrongAnsCount + correctAnsCount) % (4 * 30) == 0){
            getResult();
        }
        else if((wrongAnsCount + correctAnsCount) % 30 == 0){
            
            nextCombination();
            play();
        }
        else{
            newWord();
        }
        
    }
    
    private boolean isAnswerCorrect(int keyCode){
        
        if(!isItemName){
            if(combination == Combination.ITEM0GOOD || combination == Combination.ITEM1GOOD)
                return (keyCode == 37 && Arrays.asList(goodWords).contains(word)) || (keyCode == 39 && Arrays.asList(badWords).contains(word));
            if(combination == Combination.ITEM0BAD || combination == Combination.ITEM1BAD)
                return (keyCode == 37 && Arrays.asList(badWords).contains(word)) || (keyCode == 39 && Arrays.asList(goodWords).contains(word));
        }
        else{
            if(combination == Combination.ITEM0GOOD || combination == Combination.ITEM0BAD)
                return (keyCode == 37 && word.equals(item0)) || (keyCode == 39 && word.equals(item1));
            if(combination == Combination.ITEM1GOOD || combination == Combination.ITEM1BAD)
                return (keyCode == 37 && word.equals(item1)) || (keyCode == 39 && word.equals(item0));
        }
        
        return false;
        
    }
    
    private void nextCombination(){
        
        combination = getNextCombination(combination);
        
    }
    
    private Combination getNextCombination(Combination currentCombination){
        
        switch(currentCombination){
            case ITEM0GOOD:
                return Combination.ITEM0BAD;
            case ITEM0BAD:
                return Combination.ITEM1GOOD;
            case ITEM1GOOD:
                return Combination.ITEM1BAD;
        }
        
        return Combination.ITEM0GOOD;
        
    }
    
    public void getResult(){
        
        testFrame.close();
        testFrame.dispose();
        
        String preferredName;
        String notPreferredName;
        
        //time0 - Avg. time taken to associate preferred name positively
        //time1 - Avg. time taken to associate preferred name negatively
        //time2 - Avg. time taken to associate not preferred name positively       
        //time3 - Avg. time taken to associate not preferred name negatively
        int time0;
        int time1;
        int time2;
        int time3;
        
        //Logic
        //The longer the time it takes to associate the item negatively, the more positively the user perceives the item
        //The shorter the time it takes to associate the item positively, the more positively the user perceives the item
        if(mean(timesItem0Bad) / mean(timesItem0Good) > mean(timesItem1Bad) / mean(timesItem1Good)){
            preferredName = item0;
            notPreferredName = item1;
            
            time0 = (int)mean(timesItem0Good);
            time1 = (int)mean(timesItem0Bad);
            time2 = (int)mean(timesItem1Good);
            time3 = (int)mean(timesItem1Bad);
        }
        else{
            preferredName = item1;
            notPreferredName = item0;
            
            time0 = (int)mean(timesItem1Good);
            time1 = (int)mean(timesItem1Bad);
            time2 = (int)mean(timesItem0Good);
            time3 = (int)mean(timesItem0Bad);
        }
        
        resultFrame = new ResultFrame();
        resultFrame.setVisible(true);
        
        resultFrame.displayNames(preferredName, notPreferredName);
        resultFrame.displayTimings(preferredName, notPreferredName, time0, time1, time2, time3);
        
    }
    
    private double mean(List <Integer> marks) {
        Integer sum = 0;
        if(!marks.isEmpty()) {
            for (Integer mark : marks) {
                sum += mark;
            }
            return sum.doubleValue() / marks.size();
        }
        return sum;
    }
    
}
