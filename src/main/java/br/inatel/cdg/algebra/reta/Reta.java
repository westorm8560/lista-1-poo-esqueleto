package br.inatel.cdg.algebra.reta;

public class Reta {

    private Ponto ponto1, ponto2;

    //Construtor
    public Reta(Ponto ponto1, Ponto ponto2){

        this.ponto1 = ponto1;
        this.ponto2 = ponto2;
    }

    //Método que calcula o coeficiente angular
    public double coeficiente_angular(){

        double coeficiente_angular = 0.0;

        coeficiente_angular = ((ponto2.getY() - ponto1.getY()) / (ponto2.getX()) - ponto1.getX());

        return coeficiente_angular;
    }

    //Método que calcula o coeficiente linear
    public  double coeficiente_linear(){

        double coeficiente_linear = 0.0;

        coeficiente_linear = ponto1.getY() - coeficiente_angular()* ponto1.getX();

        return coeficiente_linear;
    }

}
