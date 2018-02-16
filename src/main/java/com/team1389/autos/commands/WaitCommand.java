package com.team1389.autos.commands;

import com.team1389.auto.AutoModeEndedException;
import com.team1389.command_framework.command_base.Command;
import com.team1389.robot.RobotConstants;

/*
 * Ignore this class
 * I'm just doing stupid stuff
 */
public class WaitCommand extends Command
{
	private boolean m_active = false;
	double startTurnInches, mainCommand, turn;
	Command fallowCommand;
	
	boolean done;
	
	public WaitCommand(double mainCommand, double startTurnInches, Command fallowCommand) throws AutoModeEndedException
	{
		this.mainCommand = mainCommand;
		this.startTurnInches = startTurnInches;
		this.fallowCommand = fallowCommand;
		
		turn = mainCommand + (startTurnInches / (RobotConstants.WheelDiameter * Math.PI));
		
		if (startTurnInches == turn)
		{
			runCommand(fallowCommand);
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
