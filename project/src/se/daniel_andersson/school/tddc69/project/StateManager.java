package se.daniel_andersson.school.tddc69.project;


import java.awt.*;
import java.util.ArrayList;

public class StateManager {

    private ArrayList<State> states;

    private int currentState;

    public StateManager() {
        states = new ArrayList<State>();
        initAllStates();
    }

    private void initAllStates() {
        //TODO Add states
        states.add(new MenuState());
    }
    public void addState(State s){
        states.add(s);
    }

    public void startCurrentState() {
        states.get(currentState).start();
    }
    public void stopCurrentState() {
        states.get(currentState).stop();
    }

    public void setCurrentState(String s) {
        for(State state : states){
            if (s.equals(state.name)) {
                currentState = states.indexOf(state);
            }
        }
    }

    public void updateState(){
        states.get(currentState).update();
    }

    public void renderCurrentState(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(states.get(currentState).screen, 0, 0, GraphicalViewer.WIDTH, GraphicalViewer.HEIGHT, null);
    }

}
