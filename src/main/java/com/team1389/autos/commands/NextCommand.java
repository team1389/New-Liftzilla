package com.team1389.autos.commands;

import com.team1389.auto.AutoModeEndedException;
import com.team1389.command_framework.command_base.Command;

/*
 * Ignore this class
 * I'm just doing stupid stuff 
 */
public class NextCommand extends Command
{
	private boolean m_active = false;
	double startTurnInches, mainCommand, turn;
	Command fallowCommand, currentCommand, nextCommand;
	
	public NextCommand(Command currentCommand, Command nextCommand) throws AutoModeEndedException
	{
		this.currentCommand = currentCommand;
		this.nextCommand = nextCommand;
		
		if (currentCommand.isFinished())
		{
			runCommand(nextCommand);
		}
	}
	
	public NextCommand(Command currentCommand, Command fallowCommand, Command nextCommand) throws AutoModeEndedException
	{
		this.currentCommand = currentCommand;
		this.fallowCommand = fallowCommand;
		this.nextCommand = nextCommand;
		
		if (currentCommand.isFinished() && fallowCommand.isFinished())
		{
			runCommand(nextCommand);
		}
	}
	
	public boolean isActive() {
		return m_active;
	}
	
	protected boolean isActiveWithThrow() throws AutoModeEndedException {
		if (!isActive()) {
			throw new AutoModeEndedException();
		}
		return isActive();
	}
	
	public void runCommand(Command action) throws AutoModeEndedException {
		isActiveWithThrow();
		while (!Thread.interrupted() && isActiveWithThrow() && !action.isFinished()) {
			try {
				action.exec();
				Thread.sleep((long) (20));
			} catch (InterruptedException e) {
				throw new AutoModeEndedException();
			}
		}
		action.cancel();
		System.out.println("ending command tick thread");
	}

	@Override
	protected boolean execute() 
	{
		return false;
	}
}
