package org.guru.core;

import org.guru.command.Command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeneralAction implements ActionListener {

    private Command command;
    public GeneralAction(Command command) {
        this.command = command;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        command.execute();

    }
}
