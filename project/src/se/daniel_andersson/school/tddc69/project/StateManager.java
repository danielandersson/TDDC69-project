package se.daniel_andersson.school.tddc69.project;


import javax.swing.*;
import java.util.ArrayList;

public class StateManager implements StateChangeListener{

    private final ArrayList<State> states;
    private int currentState;
    private final JFrame stateFrame;

    private StateChangeListener listener = null;
    private State previousState = null;

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
        states.get(currentState).setListener(this);
        stateFrame.pack();
        stateFrame.setVisible(true);
        states.get(currentState).requestFocus();
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

    @Override
    public void stateChanged(String nextState) {
        System.out.println("Byte State");
        stopCurrentState();
        setCurrentState(nextState);
        states.get(currentState).updateInputMap();
        startCurrentState();
    }
}