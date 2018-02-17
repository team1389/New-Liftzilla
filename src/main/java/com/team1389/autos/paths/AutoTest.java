package com.team1389.autos.paths;

import com.team1389.auto.AutoModeBase;
import com.team1389.auto.AutoModeEndedException;
import com.team1389.autos.AutoConstants;
import com.team1389.autos.commands.RobotCommands;
import com.team1389.autos.commands.RobotCommands.DriveStraight;
import com.team1389.autos.commands.RobotCommands.TurnAngle;
import com.team1389.command_framework.command_base.Command;
import com.team1389.robot.RobotSoftware;
import com.team1389.util.list.AddList;
import com.team1389.watch.Watchable;

public class AutoTest extends AutoModeBase
{
	RobotSoftware robot;
	DriveStraight drive;
	TurnAngle turn;
	RobotCommands commands;
	
	public AutoTest(RobotSoftware robot) 
	{
		this.robot = robot;
	}
	@Override
	public AddList<Watchable> getSubWatchables(AddList<Watchable> arg0) 
	{
		return arg0;
	}

	@Override
	public String getIdentifier() 
	{
		return "Test Auto Running";
	}

	@Override
	protected void routine() throws AutoModeEndedException 
	{
		runCommand(commands.new DriveStraight(AutoConstants.getRotations(AutoConstants.AUTO_TEST_DIS), 2));
		runCommand(commands.new TurnAngle(AutoConstants.AUTO_TEST_TURN_ANGLE, AutoConstants.AUTO_TEST_ABSOLUTE));
	}
}
