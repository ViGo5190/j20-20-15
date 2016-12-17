package com.gumeniuk.Puzzle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static javax.swing.UIManager.setLookAndFeel;
import static javax.swing.UIManager.getSystemLookAndFeelClassName;

public abstract class AbstractFrame extends JFrame {

    private final ActionListenerImpl actionListenerImpl;

    public AbstractFrame() throws HeadlessException {

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);
        actionListenerImpl = new ActionListenerImpl();

        WindowEventListener windowEventListener = new WindowEventListener();
        addWindowListener(windowEventListener);
        addWindowStateListener(windowEventListener);
        addWindowFocusListener(windowEventListener);
    }

    private class WindowEventListener extends WindowAdapter {

        @Override
        public void windowOpened(WindowEvent e) {
            onInit();
        }

        @Override
        public void windowClosed(WindowEvent e) {
            onClose();
        }

    }

    private class ActionListenerImpl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();

            if (source instanceof JButton) {
                onButtonClick((JButton) source);
            } else {
                onAction(source, e.getActionCommand());
            }
        }

    }

    public ActionListenerImpl getActionListenerImpl() {
        return actionListenerImpl;
    }

    protected void onInit() {
    }

    protected void onClose() {
    }

    protected void onAction(Object src, String cmd) {

    }

    protected void onButtonClick(JButton btn) {

    }

    protected static void initLookAndFeel() {
        try {
            setLookAndFeel(getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | ReflectiveOperationException ignore) {

        }
    }
}
