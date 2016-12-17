package com.gumeniuk.Puzzle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public abstract class AbstractFrame extends JFrame {
    private class WindowEventListener implements WindowAdapter {


    }
    public AbstractFrame() throws HeadlessException {
        addWindowListener();
    }
}
