/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithcommands.gui.command;

/**
 *
 * @author Stegger
 */
public interface ICommand
{

    /**
     * Executes the command.
     */
    public void execute();

    /**
     * Undoes the executed command.
     */
    public void undo();
}
