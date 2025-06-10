package Aplicacao;

import java.time.LocalDate;
import java.util.*;

import Servicos.GerenciadorDeServicos;
import Entidades.GerenciadorDeQuartos;
import Servicos.Servico;
import Servicos.ServicoDeQuarto;
import Servicos.ServicoLavanderia;
import Servicos.ServicoSPA;
import Servicos.TipoServicoLavanderia;
import Servicos.TipoServicoSPA;
import Entidades.*;
import Servicos.*;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        GerenciadorDeQuartos gerenciadorQuartos = new GerenciadorDeQuartos();
        GerenciadorDeServicos gerenciadorServicos = new GerenciadorDeServicos();

        List<Item> itensDisponiveis = new ArrayList<>();
        itensDisponiveis.add(new Item("Água", 5.0));
        itensDisponiveis.add(new Item("Refrigerante", 8.0));
        itensDisponiveis.add(new Item("Chocolate", 10.0));
        itensDisponiveis.add(new Item("Vinho", 100.0));

        gerenciadorQuartos.adicionarQuarto(new QuartoSimples(101, 1, false, 100.0));
        gerenciadorQuartos.adicionarQuarto(new QuartoExecutivo(201, 2, false, 180.0, true));
        gerenciadorQuartos.adicionarQuarto(new QuartoFamilia(301, 3, false, 250.0, 4, true));
        gerenciadorQuartos.adicionarQuarto(new SuitePresidencial(401, 4, false, 400.0, 2, true));

        System.out.println("=== BEM-VINDO AO SISTEMA DO HOTEL KRONBAUER ===");

        System.out.print("\nDigite o nome do hóspede: ");
        String nome = scanner.nextLine();

        System.out.print("\nDigite o número de cadastro do hóspede: ");
        int cadastro = Integer.parseInt(scanner.nextLine());

        System.out.println("\nSelecione o tipo de hóspede:");
        System.out.println("1. Corporativo");
        System.out.println("2. Fidelidade");
        System.out.println("3. VIP");
        int tipoHospede = Integer.parseInt(scanner.nextLine());
        Hospede hospede;
        switch (tipoHospede) {
            case 1 -> hospede = new HospedeCorporativo();
            case 2 -> hospede = new HospedeFidelidade();
            case 3 -> hospede = new HospedeVIP();
            default -> {
                System.out.println("Tipo inválido. Usando VIP como padrão.");
                hospede = new HospedeVIP();
            }
        }

        hospede.setNome(nome);
        hospede.setCadastro(cadastro);

        // Exibir quartos disponíveis
        gerenciadorQuartos.listarQuartos();

        System.out.print("\nDigite o número do quarto que deseja reservar: ");
        int numQuarto = Integer.parseInt(scanner.nextLine());

        Quarto quartoEscolhido = gerenciadorQuartos.obterQuarto(numQuarto);

        if (quartoEscolhido == null) {
            System.out.println("Quarto inválido. Encerrando...");
            return;
        }

        if (quartoEscolhido.isStatus()) {
            System.out.println("Este quarto já está reservado. Encerrando...");
            return;
        }

        // Datas da reserva
        System.out.print("Digite a data de entrada (dd/MM/yyyy): ");
        LocalDate entrada = LocalDate.parse(scanner.nextLine(), fmt);

        System.out.print("Digite a data de saída (dd/MM/yyyy): ");
        LocalDate saida = LocalDate.parse(scanner.nextLine(), fmt);

        adicionarServicos(scanner, gerenciadorServicos, itensDisponiveis);

        Reserva reserva = new Reserva(entrada, saida, hospede, gerenciadorServicos, quartoEscolhido);

        CheckOut checkOut = new CheckOut(reserva);
        checkOut.processarCheckout();
        
       //resumo da reserva
        System.out.println("\n=== RESUMO DA RESERVA ===");
        System.out.println("Hóspede: " + hospede.getNome() + " (Cadastro: " + hospede.getCadastro() + ")");
        System.out.println("Quarto reservado: " + quartoEscolhido.getNumero() + " - " + quartoEscolhido.getClass().getSimpleName());
        System.out.println("Data de entrada: " + entrada.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("Data de saída: " + saida.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        System.out.println("\n Serviços incluídos:");
        if (gerenciadorServicos.getServicos().isEmpty()) {
            System.out.println("Nenhum serviço adicional selecionado.");
        } else {
            for (Servico servico : gerenciadorServicos.getServicos()) {
                System.out.println("- " + servico.getDescricao());
            }
        }


        System.out.println("=== APLICAÇÃO ENCERRADA ===");
        scanner.close();
    }

    private static void adicionarServicos(Scanner scanner, GerenciadorDeServicos gerenciadorServicos, List<Item> itensDisponiveis) {
        while (true) {
            System.out.println("\n=== SERVIÇOS ADICIONAIS ===");
            System.out.println("1. Serviço de Quarto");
            System.out.println("2. Lavanderia");
            System.out.println("3. SPA");
            System.out.println("0. Finalizar seleção de serviços");

            System.out.print("Escolha uma opção: ");
            int escolha = Integer.parseInt(scanner.nextLine());

            switch (escolha) {
                case 1 -> {
                    List<Item> itensEscolhidos = new ArrayList<>();
                    System.out.println("\nItens disponíveis:");
                    for (int i = 0; i < itensDisponiveis.size(); i++) {
                        System.out.println((i + 1) + ". " + itensDisponiveis.get(i));
                    }

                    String input;
                    do {
                        System.out.print("Escolha um item (ou 0 para encerrar): ");
                        input = scanner.nextLine();
                        if (!input.equals("0")) {
                            int index = Integer.parseInt(input) - 1;
                            if (index >= 0 && index < itensDisponiveis.size()) {
                                itensEscolhidos.add(itensDisponiveis.get(index));
                            } else {
                                System.out.println("Item inválido.");
                            }
                        }
                    } while (!input.equals("0"));

                    if (!itensEscolhidos.isEmpty()) {
                        gerenciadorServicos.adicionarServico(new ServicoDeQuarto(itensEscolhidos));
                    }
                }

                case 2 -> {
                    System.out.println("\nTipos de Lavanderia:");
                    for (TipoServicoLavanderia tipo : TipoServicoLavanderia.values()) {
                        System.out.println((tipo.ordinal() + 1) + ". " + tipo.getDescricao() + " - R$" + tipo.getPrecoPorPeca());
                    }

                    System.out.print("Escolha o tipo: ");
                    int tipoEscolhido = Integer.parseInt(scanner.nextLine());
                    TipoServicoLavanderia tipo = TipoServicoLavanderia.values()[tipoEscolhido - 1];

                    System.out.print("Quantidade de peças: ");
                    int qtd = Integer.parseInt(scanner.nextLine());

                    gerenciadorServicos.adicionarServico(new ServicoLavanderia(qtd, tipo));
                }

                case 3 -> {
                    System.out.println("\nTipos de SPA:");
                    for (TipoServicoSPA tipo : TipoServicoSPA.values()) {
                        System.out.println((tipo.ordinal() + 1) + ". " + tipo.getDescricao() + " - R$" + tipo.getPreco());
                    }

                    System.out.print("Escolha o tipo de serviço SPA: ");
                    int tipoSpa = Integer.parseInt(scanner.nextLine());
                    TipoServicoSPA tipo = TipoServicoSPA.values()[tipoSpa - 1];

                    gerenciadorServicos.adicionarServico(new ServicoSPA(tipo));
                }

                case 0 -> {
                    return;
                }

                default -> System.out.println("Opção inválida.");
            }
        }
    }

}