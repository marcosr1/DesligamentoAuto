package gui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.util.Duration;


public class SampleDesController{
	@FXML
	private Button bt30m;
	@FXML
	private Button bt1hr;
	@FXML
	private Button bt2hr;
	@FXML
	private Button btCancelar;
	
	@FXML
	private Circle c;
	@FXML
	private Circle c1;
	@FXML
	private Circle c2;
	@FXML
	private Circle c3;
	@FXML
	private Circle c4;
	@FXML
	private Circle c5;
	@FXML
	private Circle c6;
	@FXML
	private Circle c7;
	
	private Random rand = new Random();
	
	@FXML
	public void onBt30m() { 
		try {

            ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "shutdown /s /t 1800");


            builder.redirectErrorStream(true);


            Process processo = builder.start();


            BufferedReader leitor = new BufferedReader(new InputStreamReader(processo.getInputStream()));
            String linha;
            while ((linha = leitor.readLine()) != null) {
                System.out.println(linha);
            }

            leitor.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	@FXML
	public void onBt1h() { 
		try {

            ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "shutdown /s /t 3600");


            builder.redirectErrorStream(true);


            Process processo = builder.start();


            BufferedReader leitor = new BufferedReader(new InputStreamReader(processo.getInputStream()));
            String linha;
            while ((linha = leitor.readLine()) != null) {
                System.out.println(linha);
            }

            leitor.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	@FXML
	public void onBt2h() { 
		try {

            ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "shutdown /s /t 7200");


            builder.redirectErrorStream(true);


            Process processo = builder.start();


            BufferedReader leitor = new BufferedReader(new InputStreamReader(processo.getInputStream()));
            String linha;
            while ((linha = leitor.readLine()) != null) {
                System.out.println(linha);
            }

            leitor.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	@FXML
	public void onBtCancelar() { 
		try {

            ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "shutdown /a");


            builder.redirectErrorStream(true);


            Process processo = builder.start();


            BufferedReader leitor = new BufferedReader(new InputStreamReader(processo.getInputStream()));
            String linha;
            while ((linha = leitor.readLine()) != null) {
                System.out.println(linha);
            }

            leitor.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public void initialize() {
		
		List<javafx.scene.Node> elementos = List.of(c, c1, c2, c3,c4,c5,c6,c7);
		

		Platform.runLater(() -> {
			
			for (javafx.scene.Node elemento : elementos) {
			
				Scene scene = c.getScene();
				
				double larguraCena = scene.getWidth();
	            double alturaCena = scene.getHeight();

	            TranslateTransition animaEstrelas = new TranslateTransition();
	            animaEstrelas.setNode(elemento);  
	            animaEstrelas.setOnFinished(event -> {
	              
	            	double maxX = larguraCena - elemento.getLayoutBounds().getWidth() + 50;
                    double maxY = alturaCena - elemento.getLayoutBounds().getHeight() + 50;
                    
                    double novoX = rand.nextDouble() * maxX;
                    double novoY = rand.nextDouble() * maxY;
                    
                    animaEstrelas.setDuration(Duration.seconds(2.5));  
                    
                    animaEstrelas.setToX(novoX - elemento.getLayoutX()); 
                    animaEstrelas.setToY(novoY - elemento.getLayoutY());  
	
	                
                    animaEstrelas.play();
	            });
	
	            
	            animaEstrelas.play();
			}
        });
    }

}
