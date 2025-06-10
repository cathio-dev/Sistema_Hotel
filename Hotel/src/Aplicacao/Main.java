package Aplicacao;

import java.time.LocalDate;
import java.util.*;

import Servicos.GerenciadorDeServicos;
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

        double valorTotalServicos = 0;
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

        exibirCabecalhoHotel();

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

        // resumo da reserva
        System.out.println("\n=== RESUMO DA RESERVA ===");
        System.out.println(" - Hóspede: " + hospede.getNome() + " (Cadastro: " + hospede.getCadastro() + ")");
        System.out.println(" - Quarto reservado: " + quartoEscolhido.getNumero() + " - "
                + quartoEscolhido.getClass().getSimpleName());
        System.out.println(
                " - Data de saída: " + saida.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println(
                " - Data de entrada: " + entrada.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println();

        System.out.println("///--- BOLETO DE GASTOS ---///");
        System.out.printf("-> Valor total a pagar: R$ %.2f\n", checkOut.calcularValorTotal());
        System.out.println("--------------------------");
        System.out.println("\n-> Serviços incluídos:");
        if (gerenciadorServicos.getServicos().isEmpty()) {
            System.out.println("Nenhum serviço adicional selecionado.");
        } else {
            for (Servico servico : gerenciadorServicos.getServicos()) {
                System.out.printf(" - %s - R$ %.2f\n", servico.getDescricao(), servico.getPreco());
                valorTotalServicos = valorTotalServicos + servico.getPreco();
            }

            System.out.println(" - TOTAL: R$ " + String.format("%.2f", valorTotalServicos));

            System.out.println("--------------------------");
        }

        System.out.println("-> Quarto incluído:");
        System.out.println(" - " + quartoEscolhido.toString());
        reserva.valorReservaDias(); // Printa quanto valor total (dias * diaria)

        if (tipoHospede == 1) {
            System.out.println("Desconto de Hospede Corporativo = 10%");
            System.out.println("(" + checkOut.calcularValorTotal() / 0.9 + " - "
                    + checkOut.calcularValorTotal() / 0.9 * 0.1 + " = " + checkOut.calcularValorTotal() + ")");
            System.out.println("--------------------------");
        } else if (tipoHospede == 2) {
            System.out.println("Desconto de Hospede Fidelidade = 15%");
            System.out.println("(" + checkOut.calcularValorTotal() / 0.85 + " - "
                    + checkOut.calcularValorTotal() / 0.85 * 0.15 + " = " + checkOut.calcularValorTotal() + ")");
            System.out.println("--------------------------");
        } else {
            System.out.println("Desconto de Hospede VIP = 20%");
            System.out.println("(" + checkOut.calcularValorTotal() / 0.8 + " - "
                    + checkOut.calcularValorTotal() / 0.8 * 0.2 + " = " + checkOut.calcularValorTotal() + ")");
            System.out.println("--------------------------");
        }
        exibirEncerramentoSistema();
        scanner.close();
    }

    public static void exibirCabecalhoHotel() {
        System.out.println("==============================================================");
        System.out.println("|                                                            |");
        System.out.println("|              BEM-VINDO AO SISTEMA DO HOTEL                 |");
        System.out.println("|                      \u001B[34m██████╗ ██╗  ██╗\u001B[0m                      |");
        System.out.println("|                      \u001B[34m██╔══██╗██║ ██╔╝\u001B[0m                      |");
        System.out.println("|                      \u001B[34m███████╔█████╔╝\u001B[0m                       |");
        System.out.println("|                      \u001B[34m██╔══██═██╔═██╗\u001B[0m                       |");
        System.out.println("|                      \u001B[34m██║  ██ ██║  ██╗\u001B[0m                      |");
        System.out.println("|                      \u001B[34m╚═╝     ╚═╝  ╚═╝\u001B[0m                      |");
        System.out.println("|                   HOTEL KRONBAUER SYSTEM                   |");
        System.out.println("|                                                            |");
        System.out.println("==============================================================\n");
    }

    public static void exibirServicosAdicionais() {
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║       SERVIÇOS ADICIONAIS          ║");
        System.out.println("╠═════════════════════════════════════╣");
        System.out.println("║ 1. Serviço de Quarto               ║");
        System.out.println("║ 2. Lavanderia                      ║");
        System.out.println("║ 3. SPA                             ║");
        System.out.println("║ 0. Finalizar seleção               ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.print("Escolha uma opção: ");
    }

    public static void exibirEncerramentoSistema() {
        System.out.println("\n\n█████████████████████████████████████████████████████████████████");
        System.out.println("█                                                           █");
        System.out.println("█       \u001B[32mCheckout finalizado com sucesso! Até logo!\u001B[0m       █");
        System.out.println("█                                                           █");
        System.out.println("█             \u001B[32m  🤙 HOTEL KRONBAUER AGRADECE 🤙 \u001B[0m           █");
        System.out.println("█                                                           █");
        System.out.println("█████████████████████████████████████████████████████████████████\n");
    }

    private static void adicionarServicos(Scanner scanner, GerenciadorDeServicos gerenciadorServicos,
            List<Item> itensDisponiveis) {
        while (true) {
            exibirServicosAdicionais();
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
                        System.out.println(
                                (tipo.ordinal() + 1) + ". " + tipo.getDescricao() + " - R$" + tipo.getPrecoPorPeca());
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
                        System.out
                                .println((tipo.ordinal() + 1) + ". " + tipo.getDescricao() + " - R$" + tipo.getPreco());
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