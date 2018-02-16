package com.team1389.autos.paths;

import com.team1389.auto.AutoModeBase;
import com.team1389.auto.AutoModeEndedException;
import com.team1389.autos.commands.RobotCommands;
import com.team1389.autos.commands.RobotCommands.DriveStraight;
import com.team1389.autos.commands.RobotCommands.TurnAngle;
import com.team1389.util.list.AddList;
import com.team1389.watch.Watchable;

public class AutoPathScaleTwo extends AutoModeBase
{

	DriveStraight drive;
	TurnAngle turn;
	RobotCommands x;

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
		
	}
}
