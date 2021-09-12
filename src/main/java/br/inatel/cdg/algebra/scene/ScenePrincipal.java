package br.inatel.cdg.algebra.scene;

//import br.inatel.cdg.algebra.reta.Ponto;
//import br.inatel.cdg.algebra.reta.Reta;
import br.inatel.cdg.algebra.reta.Ponto;
import br.inatel.cdg.algebra.reta.Reta;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ScenePrincipal {

    private Button btnCalcCoefAngular, btnCalcCoefLinear; //Button representa botoes
    private Label labelPX1, labelPY1, labelPX2, labelPY2; //Label representam rótulos
    private TextField tfPX1, tfPY1, tfPX2, tfPY2, tfCalcCoefAngular, getTfCalcCoefLinear; //TextField Representam áreas de texto

    public void criaScenePrincipal(Stage stage){

        //Criando os labels para os pontos e os campos de texto para os dados
        labelPX1 = new Label("Ponto P1.X");
        tfPX1 = new TextField();

        labelPY1 = new Label("Ponto P1.Y");
        tfPY1 = new TextField();

        labelPX2 = new Label("Ponto P2.X");
        tfPX2 = new TextField();

        labelPY2 = new Label("Ponto P2.Y");
        tfPY2 = new TextField();


        //HBox é usado para agrupar elementos horizontalmente
        HBox grupoHorizontal = new HBox(labelPX1, tfPX1); //Passamos no construtor todos os elementos. Você poderá criar vários grupos horizontais
        HBox grupoHorizontal_2 = new HBox(labelPY1, tfPY1);
        HBox grupoHorizontal_3 = new HBox(labelPX2, tfPX2);
        HBox grupoHorizontal_4 = new HBox(labelPY2, tfPY2);

        //Agrupando elementos verticalmente
        VBox vbox1 = new VBox(grupoHorizontal, grupoHorizontal_2, grupoHorizontal_3, grupoHorizontal_4);

        //Agora vamos criar a area que mostrará o que foi digitado
        tfCalcCoefAngular = new TextField();
        tfCalcCoefAngular.setEditable(false);//vamos deixar false para apenas mostrar texto
        tfCalcCoefAngular.setText("Coeficiente Angular: ");

        getTfCalcCoefLinear = new TextField();
        getTfCalcCoefLinear.setEditable(false);//vamos deixar false para apenas mostrar texto
        getTfCalcCoefLinear.setText("Coeficiente Linear: ");

        HBox resp = new HBox(tfCalcCoefAngular, getTfCalcCoefLinear);

        //Criamos o botão
        btnCalcCoefAngular = new Button("Calcular o Coeficiente Angular.");
        //Criamos a ação que o botão responderá as ser pressionado
        btnCalcCoefAngular.setOnAction(evento -> {
            //Aqui dentro é a ação que será executado ao pressionar o botão
            Reta reta = construirReta();
            tfCalcCoefAngular.setText("Coeficiente Angular: " + reta.coeficiente_angular());
        });

        btnCalcCoefLinear = new Button("Calcular o Coeficiente Linear.");
        //Criamos a ação que o botão responderá as ser pressionado
        btnCalcCoefLinear.setOnAction(evento -> {
            //Aqui dentro é a ação que será executado ao pressionar o botão
            Reta reta = construirReta();
            btnCalcCoefLinear.setText("Coeficiente Linear: " + reta.coeficiente_linear());
        });

        HBox hboxbotoes = new HBox(btnCalcCoefAngular, btnCalcCoefLinear);

        //VBox é usada para agrupar elementos verticalmente
        //No construtor passamos todos os elementos que serão agrupados, que podem ser outros grupos
        VBox layoutFinal = new VBox(vbox1, resp,hboxbotoes);//Aqui vamos agrupar verticalmente o grupo (Label + Texto) o Botao e A area que aparecer o texto digitado
        //Criamos a Scene
        Scene scene = new Scene(layoutFinal, 300 , 200);

        stage.setTitle("Software Para Calculos de Álgebra Linear");
        stage.setScene(scene);
        stage.show();
    }

    //Função auxiliar que construirá a reta
    private Reta construirReta(){

        Ponto ponto1 = new Ponto(Double.parseDouble(tfPX1.getText()),
                Double.parseDouble(tfPY1.getText()));

        Ponto ponto2 = new Ponto(Double.parseDouble(tfPX1.getText()),
                Double.parseDouble(tfPY1.getText()));

        Reta reta = new Reta(ponto1, ponto2);

        return reta;

    }

}
