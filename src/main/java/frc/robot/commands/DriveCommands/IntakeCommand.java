package.frc.robot.commands.ButtonCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.subsystems.ExampleSingleMotorSubsystem;
import frc.robot.subsystems.ExampleDoubleMotorSubsystem;
import.frc.robot.subsystems.IntakeSubsystem;



public class IntakeCommand extends SequentialCommandGroup {
    private final IntakeSubsystem intakeSubsystem;
    private final boolean intakeOn;

    public IntakeCommand(IntakeSubsystem intakeSubsystem, boolean intakeOn) {
        this.intakeSubsystem = intakeSubsystem;
        this.intakeOn = intakeOn;
        addRequirements(intakeSubsystem);
    }

    @Override
  public void initialize() {
        if (intakeOn) {
            intakeSubsystem.setIntakeSpeed(0.5); // Set speed when intake is on
            intakeSubsystem.startIntake(); // Engage intake
        } else {
            intakeSubsystem.setIntakeSpeed(0); // Set speed to 0 when intake is off
            intakeSubsystem.stopIntake(); // Disengage intake
        }
    }


    @Override
    public boolean isFinished() {
        return true; // Instant command
    }
}
