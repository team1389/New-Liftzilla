package com.team1389.autos.paths;

import com.team1389.auto.AutoModeBase;
import com.team1389.auto.AutoModeEndedException;
import com.team1389.autos.AutoConstants;
import com.team1389.autos.commands.RobotCommands;
import com.team1389.autos.commands.RobotCommands.DriveStraight;
import com.team1389.autos.commands.RobotCommands.TurnAngle;
import com.team1389.robot.RobotSoftware;
import com.team1389.util.list.AddList;
import com.team1389.watch.Watchable;

public class SwitchPathOne extends AutoModeBase{
	
	RobotSoftware robot;
	DriveStraight drive;
	TurnAngle turn;
	RobotCommands commands;
	
	public SwitchPathOne(RobotSoftware robot)
	{
		this.robot = robot;
	}

	@Override
	public AddList<Watchable> getSubWatchables(AddList<Watchable> arg0) 
	{
		return null;
	}

	@Override
	public String getIdentifier() 
	{
		return null;
	}

	@Override
	protected void routine() throws AutoModeEndedException 
	{
		runCommand(commands.new DriveStraight(AutoConstants.getRotations(AutoConstants.SWITCH_ONE_DIST)));
		runCommand(commands.new TurnAngle(AutoConstants.SWITCH_ONE_TURN_ANGLE, AutoConstants.SWITCH_ONE_ABSOLUTE));
		runCommand(commands.new DriveStraight(AutoConstants.getRotations(AutoConstants.SWITCH_ONE_DIST_TWO)));
	}
}