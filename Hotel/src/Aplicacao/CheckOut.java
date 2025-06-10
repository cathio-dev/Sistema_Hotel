package Aplicacao;

import Entidades.*;

public class CheckOut {
    private Reserva reserva;

    public CheckOut(Reserva reserva) {
        this.reserva = reserva;
    }

    public Double calcularValorTotal(){
        return reserva.calcularTotalReserva();
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void processarCheckout(){
        reserva.getQuarto().liberarQuarto();
        System.out.println("\nCheckout realizado com sucesso.");
        System.out.println("Valor total: R$ " + String.format("%.2f", calcularValorTotal()));
    }
}
