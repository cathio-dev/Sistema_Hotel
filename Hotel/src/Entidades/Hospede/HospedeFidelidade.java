package Hospede;



public class HospedeFidelidade extends Hospede{
    private Integer numeroEstadias;

    public HospedeFidelidade(String nome, Integer CPF, Reserva reserva, Integer numeroEstadias){
        super(nome, CPF, reserva);
        this.numeroEstadias = numeroEstadias;
    }

    public void setNumeroEstadias(Integer numeroEstadias){
        this.numeroEstadias = numeroEstadias;
    }

    public Integer getNumeroEstadias(){
        return numeroEstadias;
    }


    @Override
    public Double calcularDesconto() {
        Double desconto;
        if (numeroEstadias >= 10){
            desconto = reserva.getValorTotal() * 0.15;
        } else if (numeroEstadias >= 5){
            desconto = reserva.getValorTotal() * 0.10;
        } else {
            desconto = reserva.getValorTotal() * 0.05;
        }

        return desconto;
    }
    
}