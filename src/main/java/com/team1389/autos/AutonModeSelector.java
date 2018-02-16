package com.team1389.autos;

import com.team1389.auto.AutoModeBase;
import com.team1389.robot.RobotSoftware;

public class AutonModeSelector
{
	
	public static AutoModeBase createAutoMode(AutonOption autonOption)
	{
			return autonOption.setupAutoModeBase(RobotSoftware.getInstance());
	}
}
