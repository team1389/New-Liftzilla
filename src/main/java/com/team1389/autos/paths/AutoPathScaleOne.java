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

public class AutoPathScaleOne extends AutoModeBase
{
	RobotSoftware robot;
	DriveStraight drive;
	TurnAngle turn;
	RobotCommands commands;
	
	public AutoPathScaleOne(RobotSoftware robot) 
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
		runCommand(commands.new DriveStraight(AutoConstants.getRotations(AutoConstants.SCALE_ONE_DIS)));
		runCommand(commands.new TurnAngle(AutoConstants.SCALE_ONE_TURN_ANGLE, AutoConstants.SCALE_ONE_ABSOLUTE));
		runCommand(commands.new DriveStraight(AutoConstants.getRotations(AutoConstants.SCALE_ONE_DIS_TWO)));
	}
}