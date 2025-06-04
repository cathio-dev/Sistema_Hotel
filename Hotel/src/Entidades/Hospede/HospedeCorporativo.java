package Hospede

public class HospedeCorporativo extends Hospede{
    
    @Override
    public Double calcularDesconto(){
        return reserva.getValorTotal() * 0.10;
    }

}