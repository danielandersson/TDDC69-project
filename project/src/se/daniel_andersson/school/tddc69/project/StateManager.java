package se.daniel_andersson.school.tddc69.project;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StateManager {

    private ArrayList<State> states;

    private int currentState;

    private JFrame gameFrame;

    public StateManager(JFrame j){
        gameFrame = j;
        states = new ArrayList<State>();
        initAllStates();
    }

    private void initAllStates(){
        //TODO Add states
        states.add(new MenuState());
        states.add(new GameState());
    }

    public void startCurrentState(){
        gameFrame.add(states.get(currentState));
        states.get(currentState).start();
    }

    public void stopCurrentState(){
        gameFrame.remove(states.get(currentState));
        states.get(currentState).stop();
    }

    public void setCurrentState(String s){
        for(int i = 0; i < states.size(); i++){
            if(s.equals(states.get(i).name)){
                currentState = i;
            }
        }
    }

}