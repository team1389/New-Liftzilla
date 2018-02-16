package com.team1389.autos.paths;

import com.team1389.auto.AutoModeBase;
import com.team1389.auto.AutoModeEndedException;
import com.team1389.autos.AutoConstants;
import com.team1389.autos.commands.NextCommand;
import com.team1389.autos.commands.RobotCommands;
import com.team1389.autos.commands.RobotCommands.DriveStraight;
import com.team1389.autos.commands.RobotCommands.TurnAngle;
import com.team1389.autos.commands.WaitCommand;
import com.team1389.robot.RobotSoftware;
import com.team1389.util.list.AddList;
import com.team1389.watch.Watchable;

public class SwitchPathTwo extends AutoModeBase
{
	RobotSoftware robot;
	DriveStraight drive;
	TurnAngle turn;
	RobotCommands commands;
	WaitCommand wait;
	NextCommand next, next2;
	
	public SwitchPathTwo(RobotSoftware robot)
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
		runCommand(commands.new DriveStraight(AutoConstants.getRotations(AutoConstants.SWITCH_TWO_DIS)));
		wait = new WaitCommand(AutoConstants.getRotations(AutoConstants.SCALE_TWO_DIS), 5, 
				commands.new TurnAngle(AutoConstants.SCALE_TWO_TURN_ANGLE, AutoConstants.SCALE_TWO_ABSOLUTE));
		next = new NextCommand(wait, new WaitCommand(AutoConstants.getRotations(AutoConstants.SWITCH_TWO_DIS_TWO), 5, 
				commands.new TurnAngle(AutoConstants.SCALE_TWO_TURN_ANGLE_TWO, AutoConstants.SCALE_TWO_ABSOLUTE_TWO)));
		next2 = new NextCommand(next, commands.new DriveStraight(AutoConstants.getRotations(AutoConstants.SWITCH_TWO_DIS_THREE)));
	}
}
