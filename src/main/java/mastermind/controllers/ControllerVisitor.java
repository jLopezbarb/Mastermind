package mastermind.controllers;

public interface ControllerVisitor {

    void visit(StartController startController);

    void visit(ProposeController proposeController);

    void visit(ResumeController resumeController);
}
