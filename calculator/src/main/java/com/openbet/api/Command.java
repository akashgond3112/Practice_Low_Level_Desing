package com.openbet.api;

public interface Command {
    public void execute();
    public void unexecute();
}