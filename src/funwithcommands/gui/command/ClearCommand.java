/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithcommands.gui.command;

import funwithcommands.gui.model.WordModel;

/**
 *
 * @author Mecaa
 */
public class ClearCommand implements ICommand {

    private final WordModel model;

    public ClearCommand(WordModel model) {
        this.model = model;

    }

    @Override
    public void execute() {
        System.out.println("Is executed");
        model.clearWords();
    }

    @Override
    public void undo() {
        model.undoClear();

    }

}
