package com.nlp.resposebody.model;

import java.util.List;

public class body {
    public List<String> getTarget() {
        return target;
    }

    public void setTarget(List<String> target) {
        this.target = target;
    }

    public List<String> getAction() {
        return action;
    }

    public void setAction(List<String> action) {
        this.action = action;
    }

    private List<String> target;
    private List<String> action;
}
