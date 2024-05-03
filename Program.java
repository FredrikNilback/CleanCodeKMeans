import Controller.MainController;
import View.Frame;
import View.Panel;

public class Program {

    public Program() {

        Panel panel = new Panel();
        new Frame(panel);
        new MainController(panel); 
    }
}