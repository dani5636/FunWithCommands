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
public class TextAction implements ICommand {

    private final WordModel model;
    private final String word;

    public TextAction(WordModel model, String word) {
        this.model = model;
        this.word = word;
    }

    @Override
    public void execute() //When executed will add word to model:
    {
        model.addWord(word);
    }

    @Override
    public void undo() //When undone will remove same word:
    {
        model.removeWord(word);
    }

}
