package Hospede;

public class HospedeVIP extends Hospede{
    
    @Override
    public Double calcularDesconto(){
        return reserva.getValorTotal() * 0.15;
    }
}