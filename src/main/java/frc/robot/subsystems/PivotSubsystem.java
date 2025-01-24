package frc.robot.subsystems;

import com.studica.frc.AHRS;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.swervemodule.SwerveModule;
import frc.robot.swervemodule.SwerveModules;



public class PivotSubsystem extends SubsystemBase {
    private final Pivot pivot; // Reference to the Pivot subsystem
    private final XboxController controller; // Reference to the Xbox controller
    private final int axis; // The axis on the controller used for pivot control

    public PivotSubsystem(Pivot pivot, XboxController controller, int axis) {
        this.pivot = pivot;
        this.controller = controller;
        this.axis = axis;

        addRequirements(pivot); // Declare subsystem dependencies
    }

    // Periodically called to update pivot position based on controller input
    @Override
    public void startPivot(speed) {
        // Get the speed from the controller axis
        // Move the pivot at the speed determined by the controller input
        pivot.move(speed);
    }

    // Stop the pivot (you could add a method to stop manually if needed)
    public void stopPivot() {
        pivot.stop();
    }
}