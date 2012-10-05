package se.daniel_andersson.school.tddc69.project;


import javax.swing.*;
import java.util.ArrayList;

public class StateManager {

    private final ArrayList<State> states;

    private int currentState;

    private final JFrame stateFrame;

    public StateManager(JFrame j){
        stateFrame = j;
        states = new ArrayList<State>();
        initAllStates();
    }

    private void initAllStates(){
        //TODO Add states
        states.add(new MenuState());
        states.add(new GameState());
    }

    public void startCurrentState(){
        stateFrame.add(states.get(currentState));
        states.get(currentState).start();
        stateFrame.setVisible(true);
    }

    public void stopCurrentState(){
        stateFrame.remove(states.get(currentState));
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