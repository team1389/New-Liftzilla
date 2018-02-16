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

public class CrossBaseline extends AutoModeBase
{
	RobotSoftware robot;
	DriveStraight drive;
	TurnAngle turn;
	RobotCommands commands;
	
	public CrossBaseline(RobotSoftware robot)
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
		return "Cross Baseline";
	}

	@Override
	protected void routine() throws AutoModeEndedException 
	{
		drive = commands.new DriveStraight(AutoConstants.getRotations(AutoConstants.BASELINE_DIST), AutoConstants.BASELINE_SPEED);
		runCommand(drive);
	}
}
