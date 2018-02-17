package com.team1389.autos;

import java.util.Optional;
import java.util.function.Function;

import com.team1389.auto.AutoModeBase;
import com.team1389.autos.paths.AutoPathScaleOne;
import com.team1389.autos.paths.AutoPathScaleTwo;
import com.team1389.autos.paths.CrossBaseline;
import com.team1389.autos.paths.SwitchPathOne;
import com.team1389.autos.paths.SwitchPathTwo;
import com.team1389.robot.RobotSoftware;

public enum AutonOption
{
	CROSS_BASELINE(CrossBaseline :: new), SWITCH_PATH_ONE(SwitchPathOne :: new), SWITCH_PATH_TWO(SwitchPathTwo :: new), 
	SCALE_PATH_ONE(AutoPathScaleOne :: new), SCALE_PATH_TWO(AutoPathScaleTwo :: new);
	public final Optional<Function<RobotSoftware, AutoModeBase>> autoConstructor;

	AutonOption(Function<RobotSoftware, AutoModeBase> autoConstructor)
	{
		this.autoConstructor = Optional.of(autoConstructor);
	}

	AutonOption()
	{
		this.autoConstructor = Optional.empty();
	}

	public AutoModeBase setupAutoModeBase(RobotSoftware robot)
	{
		if (autoConstructor.isPresent())
		{
			return autoConstructor.get().apply(robot);
		} else
		{
			throw new RuntimeException("cannot auto insantiate a complex style auto option!");
		}
	}
}
