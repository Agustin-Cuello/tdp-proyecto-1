package launcher;

import gui.SimplePresentationScreen;
import entities.Student;

public class Launcher {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	
            	Student EstudianteA = new Student(130678, "Cuello", "Agustín", "agcuello3@gmail.com", "https://github.com/Agustin-Cuello", "/images/ImagenEstudiante.jpg");
            	
            	SimplePresentationScreen VentanaPrincipal = new SimplePresentationScreen(EstudianteA);
            	
            	VentanaPrincipal.setVisible(true);
            	
            }
        });
    }
}	