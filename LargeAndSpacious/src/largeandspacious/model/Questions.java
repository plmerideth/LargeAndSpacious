/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largeandspacious.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author julzlee
 */
public class Questions implements Serializable {
    // class instance variables
    private int questionsID;
    private String question;
    private String answer;
    private int fruitValue;

    public Questions(){
    }
    
    
    public int getQuestionsID() {
        return questionsID;
    }

    public void setQuestionsID(int questionsID) {
        this.questionsID = questionsID;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setFruitValue(int value)
    {
        this.fruitValue = value;
    }
    
    public int getFruitValue()
    {
        return this.fruitValue;
    }
    
    @Override
    public String toString() {
        return "Questions{" + "questionsID=" + questionsID + ", question=" + question + ", answer=" + answer + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + this.questionsID;
        hash = 19 * hash + Objects.hashCode(this.question);
        hash = 19 * hash + Objects.hashCode(this.answer);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Questions other = (Questions) obj;
        if (this.questionsID != other.questionsID) {
            return false;
        }
        if (!Objects.equals(this.question, other.question)) {
            return false;
        }
        if (!Objects.equals(this.answer, other.answer)) {
            return false;
        }
        return true;
    }

    

    
    
    
}
