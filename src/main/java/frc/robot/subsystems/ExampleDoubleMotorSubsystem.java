package frc.robot.subsystems;

import frc.robot.Constants;
import frc.robot.motor.Motors;
import frc.robot.motor.Motor.encoderType;

/* TODO: add comment about extending from the superclass */

public class ExampleDoubleMotorSubsystem extends ExampleSingleMotorSubsytem {
    
    private final Motors pairedMotor;
    private final double pairedMotorSpeedRatio;

    public ExampleDoubleMotorSubsystem(double m_pairedMotorSpeedRatio) {

        /* TODO: add comment explaining how the super here calls the ExampleSingleMotorSubsytem's contructor method */

        super();

        pairedMotor = new Motors(Constants.EXAMPLE_PAIRED_INFO, encoderType.None);

        pairedMotorSpeedRatio = m_pairedMotorSpeedRatio;

    }

    /* TODO: add comment showing that you only need to add the methods that need changing */

    public void PositiveMove() {

        /* TODO: add comment about calling super.PositiveMove() and why it's necessarry */

        super.PositiveMove();

        /* TODO: add comment for the speed ratio */

        pairedMotor.Spin(motorSpeed * pairedMotorSpeedRatio);

    }

    public void NegativeMove() {

        super.NegativeMove();
        pairedMotor.Spin(-motorSpeed * pairedMotorSpeedRatio);

    }

    public void Stop() {

        super.Stop();
        pairedMotor.Spin(0);


    }

    /* TODO: add comment about adding new methods to the class */

    public String[] GetPairedDebuggingInfo() {

        return pairedMotor.GetDebuggingInformation();

    }

}
