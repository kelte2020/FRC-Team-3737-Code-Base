package frc.robot.commands.CompositeCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

//insert subsystems being used
imprt robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.PivotSubsystem;
import frc.robot.subsystems.BeltSubsystem;
import frc.robot.subsystems.IntakeSubsystem;



public class EmergencyStopIntermediateCommand extends SequentialCommandGroup {
        
     public EmergencyStopIntermediateCommand(ShooterSubsystem, PivotSubsystem, BeltSubsystem, IntakeSubsystem) {  
        
        addCommands(
           new stopBelt();,      // Stop the belt
            new stopPivot();,    // Stop the pivot
            new stopShooter();// stop the shooter
            new stopIntake(); // stop the intake
        );
    }
}