/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package upx2hortafacil;

/*import java.sql.ResultSet;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UPX2HortaFacil {

    private static Scanner scanner;
    private static MySQL bd;

    private static void consultarHorta() {
        CadastroHorta horta = new CadastroHorta();
        System.out.print("Estado que fica a Horta: ");
        horta.setEstado(scanner.next());
        scanner.nextLine();

        String query = "SELECT * FROM horta WHERE estado = '" + horta.getEstado() + "'";
        ResultSet set = bd.select(query);

        if (set == null) {
            System.out.println("horta nao encontrad.");
        } else {
            try {
                boolean encontrado = false;
                while (set.next()) {
                    horta = new CadastroHorta(
                            set.getString("estado"),
                            set.getString("cidade"),
                            set.getString("nome_horta"),
                            set.getString("nome_responsavel"),
                            set.getInt("capacidade_max_membros"),
                            set.getInt("tamanho"),
                            set.getString("resumo_horta")
                    );
                    System.out.println(horta.toString());
                    encontrado = true;
                }
            } catch (Exception e) {
                System.out.printf(
                        "Erro ao ler lista: %s\n",
                        e.getMessage());
            }
        }
    }

    private static void cadastrarUsuario() {
        Usuario usu = new Usuario();

        System.out.print("Nome: ");
        usu.setNome(scanner.nextLine());
        System.out.print("CPF: ");
        usu.setCpf(scanner.nextLine());
        System.out.print("Data de Nascimento (no formato dd/MM/yyyy): ");
        String dataNascimentoInput = scanner.nextLine();

        try {
            // Convertendo a data de nascimento para o formato do banco de dados (YYYY-MM-DD)
            Date dataNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimentoInput);
            String dataNascimentoSQL = new SimpleDateFormat("yyyy-MM-dd").format(dataNascimento);

            System.out.print("Telefone: ");
            usu.setTelefone(scanner.nextLine());
            System.out.print("Email: ");
            usu.setEmail(scanner.nextLine());
            System.out.print("Cidade: ");
            usu.setCidade(scanner.nextLine());
            System.out.print("Estado: ");
            usu.setEstado(scanner.nextLine());

            String query = "INSERT INTO USUARIO (nome, cpf, dataNascimento, telefone, email, cidade, estado)"
                    + " VALUES ("
                    + "'" + usu.getNome() + "', "
                    + "'" + usu.getCpf() + "', "
                    + "'" + dataNascimentoSQL + "', " // Data de nascimento formatada para o SQL
                    + "'" + usu.getTelefone() + "', "
                    + "'" + usu.getEmail() + "', "
                    + "'" + usu.getCidade() + "', "
                    + "'" + usu.getEstado() + "'"
                    + ")";

            if (bd.insert(query)) {
                System.out.println("-----------------");

                System.out.println("1. Gostaria de me voluntariar");
                System.out.println("2. Gostaria de cadastrar uma horta");
                int opcao2 = scanner.nextInt();
                scanner.nextLine(); // Adiciona esta linha para consumir a nova linha

                if (opcao2 == 1) {
                    cadastrarVoluntario();
                } else if (opcao2 == 2) {
                    cadastrarHorta();
                } else {
                    System.out.println("Opcao invalida.");
                }

            } else {
                System.out.println("Erro ao cadastrar.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao processar a data de nascimento.");
        }

    }

    private static void cadastrarHorta() {
        CadastroHorta cadastro = new CadastroHorta();
        System.out.print("Nome da Horta: ");
        cadastro.setNome(scanner.nextLine());
        System.out.print("Responsavel: ");
        cadastro.setProp(scanner.nextLine());
        System.out.print("Estado: ");
        cadastro.setEstado(scanner.nextLine());
        System.out.print("Cidade: ");
        cadastro.setCidade(scanner.nextLine());
        System.out.print("Membros: ");
        cadastro.setMembros(scanner.nextInt());
        scanner.nextLine(); // Consumir a nova linha restante após a leitura de um inteiro
        System.out.print("Tamanho Horta: ");
        cadastro.setTamanho(scanner.nextInt());
        scanner.nextLine(); // Consumir a nova linha restante após a leitura de um inteiro
        System.out.print("Descricao da Horta: ");
        cadastro.setDescri(scanner.nextLine());

        String query = "INSERT INTO HORTA (estado, cidade, nome_horta, nome_responsavel, capacidade_max_membros, tamanho, resumo_horta)"
                + " VALUES ("
                + "'" + cadastro.getEstado() + "', "
                + "'" + cadastro.getCidade() + "', "
                + "'" + cadastro.getNome() + "', "
                + "'" + cadastro.getProp() + "', "
                + "'" + cadastro.getMembros() + "', "
                + "'" + cadastro.getTamanho() + "', "
                + "'" + cadastro.getDescri() + "'"
                + ")";

        if (bd.insert(query)) {
            System.out.println("----------------------------");
             
        } else {
            System.out.print(query);
            System.out.println("Erro ao cadastrar.");
        }
    }

    private static void cadastrarVoluntario() {
        Voluntario voluntario = new Voluntario();
        System.out.println("Por que voce gostaria de ser voluntario(a)?");
        String motivo = scanner.nextLine();
        voluntario.setMotivo(motivo);

        scanner.nextLine();

        String query = "INSERT INTO VOLUNTARIO (Pergunta_Por_que_quer_ser_um_voluntario)"
                + " VALUES ("
                + "'" + voluntario.getMotivo() + "'"
                + ")";
        if (bd.insert(query)) {
            
            System.out.println("Onde voce gostaria de ser voluntario(a)?\nDigite o estado para pesquisar as hortas proximas a voce");
            consultarHorta();
            System.out.println("---------------------------");
            System.out.println("Qual horta voce gostaria de fazer parte?");
            String escolha=(scanner.nextLine());
            System.out.println("Cadastrado realizado com sucesso!\nEm alguns dias voce recebera um e-mail com as informacoes necessarias para seu voluntariado\nObrigado por ajudar!");
            scanner.nextLine();
            
        } else {
            System.out.print(query);
            System.out.println("Erro ao cadastrar.");
        }
    }

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        bd = new MySQL(
                "ProjetoUPX2HortaFacil",
                "root",
                "190997");
        if (!bd.conectaBanco()) {
            System.exit(1);
        }
        int opcao;

        do {
            System.out.println();
            System.out.println("Bem-Vindo(a) ao Horta Facil");
            System.out.println("---------------------");
            System.out.println("Aqui voce pode cadastrar sua horta comunitaria!");
            System.out.println("Digite 1 para saber mais!");
            System.out.println("Voce pode se tornar um voluntario ");
            System.out.println("Digite 2 para saber mais!");
            System.out.println("Digite 3 para criar seu usuario!");
            System.out.println("Digite 4 para pesquisar as Hortas existentes!");
            System.out.println("Digite 5 para sair do sistema");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:

                    System.out.println("Hortas comunitarias sao espacos de uso coletivo reservados para o plantio,cultivo\ne colheita de vegetais de todos os tipos por membros de uma comunidade.");

                    break;
                case 2:
                    System.out.println("-------------------------------------");
                    System.out.println("Na horta comunitaria, os voluntarios sao como abelhas em meio as flores:");
                    System.out.println("Maos que semeiam, coracoes que cuidam e sorrisos que colhem.");
                    System.out.println("Trabalho na horta: Plantam, regam, capinam, colhem... Tudo com carinho e dedicacao.");
                    System.out.println("Compartilhando conhecimento: Ensinam e aprendem sobre o cultivo de hortalicas e a importancia da agricultura urbana.");
                    System.out.println("Eventos e oficinas: Organizam atividades para a comunidade, como feiras de mudas e momentos de confraternizacao.");
                    System.out.println("");
                    System.out.println("Se voce quer fazer a diferenca, junte-se a nos! A horta de bracos abertos te espera!");
                    break;
                case 3:

                    cadastrarUsuario();

                case 4:
                   consultarHorta();
                   
                    break;
                case 5:

                    System.out.println("Obrigado por usar o Horta Facil. Ate logo!");
                    break;
                default:

                    System.out.println("Opcao invalida. Por favor, escolha uma opcao valida.");
                    break;
            }
        } while (opcao != 5);

        scanner.close();
    }

}*/
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UPX2HortaFacil {
    private static MySQL bd;

    public static void main(String[] args) {
        bd = new MySQL("ProjetoUPX2HortaFacil", "root", "190997");
        if (!bd.conectaBanco()) {
            System.exit(1);
        }

        // Estilo da Interface
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("Horta Facil");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(320, 400);
        frame.setLocationRelativeTo(null); // Centraliza a janela na tela

        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        JLabel welcomeLabel = new JLabel("Bem-Vindo(a) ao Horta Facil", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));

        JButton infoButton = new JButton("Saber mais sobre Hortas Comunitárias");
        JButton volunteerInfoButton = new JButton("Saber mais sobre Voluntariado");
        JButton registerUserButton = new JButton("Criar usuário");
        JButton searchHortaButton = new JButton("Pesquisar Hortas existentes");
        JButton exitButton = new JButton("Sair do sistema");

        // Configurações de estilo dos botões
        Font buttonFont = new Font("Arial", Font.PLAIN, 14);
        infoButton.setFont(buttonFont);
        volunteerInfoButton.setFont(buttonFont);
        registerUserButton.setFont(buttonFont);
        searchHortaButton.setFont(buttonFont);
        exitButton.setFont(buttonFont);

        // Layout
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(welcomeLabel)
                .addComponent(infoButton)
                .addComponent(volunteerInfoButton)
                .addComponent(registerUserButton)
                .addComponent(searchHortaButton)
                .addComponent(exitButton)
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(welcomeLabel)
                .addComponent(infoButton)
                .addComponent(volunteerInfoButton)
                .addComponent(registerUserButton)
                .addComponent(searchHortaButton)
                .addComponent(exitButton)
        );

        frame.add(panel);
        frame.setVisible(true);

        infoButton.addActionListener(e -> JOptionPane.showMessageDialog(frame,
            "Hortas comunitarias sao espacos de uso coletivo reservados para o plantio, cultivo\n" +
            "e colheita de vegetais de todos os tipos por membros de uma comunidade."));

        volunteerInfoButton.addActionListener(e -> JOptionPane.showMessageDialog(frame,
            "Na horta comunitaria, os voluntarios sao como abelhas em meio as flores:\n" +
            "Maos que semeiam, coracoes que cuidam e sorrisos que colhem.\n" +
            "Trabalho na horta: Plantam, regam, capinam, colhem... Tudo com carinho e dedicacao.\n" +
            "Compartilhando conhecimento: Ensinam e aprendem sobre o cultivo de hortalicas e a importancia da agricultura urbana.\n" +
            "Eventos e oficinas: Organizam atividades para a comunidade, como feiras de mudas e momentos de confraternizacao.\n" +
            "\nSe voce quer fazer a diferenca, junte-se a nos! A horta de bracos abertos te espera!"));

        registerUserButton.addActionListener(e -> {
            JPanel registerPanel = new JPanel(new GridLayout(0, 1));
            JTextField nameField = new JTextField();
            JTextField cpfField = new JTextField();
            JTextField birthDateField = new JTextField();
            JTextField phoneField = new JTextField();
            JTextField emailField = new JTextField();
            JTextField cityField = new JTextField();
            JTextField stateField = new JTextField();

            registerPanel.add(new JLabel("Nome:"));
            registerPanel.add(nameField);
            registerPanel.add(new JLabel("CPF:"));
            registerPanel.add(cpfField);
            registerPanel.add(new JLabel("Data de Nascimento (dd/MM/yyyy):"));
            registerPanel.add(birthDateField);
            registerPanel.add(new JLabel("Telefone:"));
            registerPanel.add(phoneField);
            registerPanel.add(new JLabel("Email:"));
            registerPanel.add(emailField);
            registerPanel.add(new JLabel("Cidade:"));
            registerPanel.add(cityField);
            registerPanel.add(new JLabel("Estado:"));
            registerPanel.add(stateField);

            int result = JOptionPane.showConfirmDialog(frame, registerPanel,
                "Cadastro de Usuário", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                try {
                    String nome = nameField.getText();
                    String cpf = cpfField.getText();
                    String dataNascimentoInput = birthDateField.getText();
                    Date dataNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimentoInput);
                    String dataNascimentoSQL = new SimpleDateFormat("yyyy-MM-dd").format(dataNascimento);
                    String telefone = phoneField.getText();
                    String email = emailField.getText();
                    String cidade = cityField.getText();
                    String estado = stateField.getText();

                    String query = "INSERT INTO USUARIO (nome, cpf, dataNascimento, telefone, email, cidade, estado) VALUES ("
                            + "'" + nome + "', "
                            + "'" + cpf + "', "
                            + "'" + dataNascimentoSQL + "', "
                            + "'" + telefone + "', "
                            + "'" + email + "', "
                            + "'" + cidade + "', "
                            + "'" + estado + "')";

                    if (bd.insert(query)) {
                        JOptionPane.showMessageDialog(frame, "Usuário cadastrado com sucesso!");

                        String[] options = {"Voluntariar", "Cadastrar Horta"};
                        int opcao2 = JOptionPane.showOptionDialog(frame, "Gostaria de:", "Escolha uma opção",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

                        if (opcao2 == 0) {
                            cadastrarVoluntario();
                        } else if (opcao2 == 1) {
                            cadastrarHorta();
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame, "Erro ao cadastrar usuário.");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Erro ao processar a data de nascimento.");
                }
            }
        });

        searchHortaButton.addActionListener(e -> {
            String estado = JOptionPane.showInputDialog(frame, "Estado que fica a Horta:");
            if (estado != null && !estado.isEmpty()) {
                String query = "SELECT * FROM horta WHERE estado = '" + estado + "'";
                ResultSet set = bd.select(query);

                if (set == null) {
                    JOptionPane.showMessageDialog(frame, "Horta não encontrada.");
                } else {
                    try {
                        boolean encontrado = false;
                        StringBuilder resultados = new StringBuilder();
                        while (set.next()) {
                            CadastroHorta horta = new CadastroHorta(
                                    set.getString("estado"),
                                    set.getString("cidade"),
                                    set.getString("nome_horta"),
                                    set.getString("nome_responsavel"),
                                    set.getInt("capacidade_max_membros"),
                                    set.getInt("tamanho"),
                                    set.getString("resumo_horta")
                            );
                            resultados.append(horta.toString()).append("\n\n");
                            encontrado = true;
                        }
                        if (encontrado) {
                            JOptionPane.showMessageDialog(frame, resultados.toString());
                        } else {
                            JOptionPane.showMessageDialog(frame, "Horta não encontrada.");
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frame, "Erro ao ler lista: " + ex.getMessage());
                    }
                }
            }
        });

        exitButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Obrigado por usar o Horta Facil. Ate logo!");
            System.exit(0);
        });
    }

    private static void cadastrarVoluntario() {
        JFrame frame = new JFrame();
        JPanel volunteerPanel = new JPanel(new GridLayout(0, 1));
        JTextField motivoField = new JTextField();

        volunteerPanel.add(new JLabel("Por que você gostaria de ser voluntário(a)?"));
        volunteerPanel.add(motivoField);

        int result = JOptionPane.showConfirmDialog(frame, volunteerPanel,
            "Cadastro de Voluntário", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String motivo = motivoField.getText();

            String query = "INSERT INTO VOLUNTARIO (Pergunta_Por_que_quer_ser_um_voluntario) VALUES ('" + motivo + "')";
            if (bd.insert(query)) {
                String estado = JOptionPane.showInputDialog(frame, "Onde você gostaria de ser voluntário(a)?\nDigite o estado para pesquisar as hortas próximas a você");
                if (estado != null && !estado.isEmpty()) {
                    consultarHorta(estado);
                    String escolha = JOptionPane.showInputDialog(frame, "Qual horta você gostaria de fazer parte?");
                    if (escolha != null && !escolha.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Cadastrado realizado com sucesso!\nEm alguns dias você receberá um e-mail com as informações necessárias para seu voluntariado\nObrigado por ajudar!");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Erro ao cadastrar.");
            }
        }
    }

    private static void cadastrarHorta() {
        JFrame frame = new JFrame();
        JPanel hortaPanel = new JPanel(new GridLayout(0, 1));
        JTextField nomeField = new JTextField();
        JTextField responsavelField = new JTextField();
        JTextField estadoField = new JTextField();
        JTextField cidadeField = new JTextField();
        JTextField membrosField = new JTextField();
        JTextField tamanhoField = new JTextField();
        JTextField descricaoField = new JTextField();

        hortaPanel.add(new JLabel("Nome da Horta:"));
        hortaPanel.add(nomeField);
        hortaPanel.add(new JLabel("Responsável:"));
        hortaPanel.add(responsavelField);
        hortaPanel.add(new JLabel("Estado:"));
        hortaPanel.add(estadoField);
        hortaPanel.add(new JLabel("Cidade:"));
        hortaPanel.add(cidadeField);
        hortaPanel.add(new JLabel("Membros:"));
        hortaPanel.add(membrosField);
        hortaPanel.add(new JLabel("Tamanho Horta:"));
        hortaPanel.add(tamanhoField);
        hortaPanel.add(new JLabel("Descrição da Horta:"));
        hortaPanel.add(descricaoField);

        int result = JOptionPane.showConfirmDialog(frame, hortaPanel,
            "Cadastro de Horta", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String nome = nomeField.getText();
            String responsavel = responsavelField.getText();
            String estado = estadoField.getText();
            String cidade = cidadeField.getText();
            int membros = Integer.parseInt(membrosField.getText());
            int tamanho = Integer.parseInt(tamanhoField.getText());
            String descricao = descricaoField.getText();

            String query = "INSERT INTO HORTA (estado, cidade, nome_horta, nome_responsavel, capacidade_max_membros, tamanho, resumo_horta) VALUES ("
                    + "'" + estado + "', "
                    + "'" + cidade + "', "
                    + "'" + nome + "', "
                    + "'" + responsavel + "', "
                    + "'" + membros + "', "
                    + "'" + tamanho + "', "
                    + "'" + descricao + "')";

            if (bd.insert(query)) {
                JOptionPane.showMessageDialog(frame, "Horta cadastrada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(frame, "Erro ao cadastrar horta.");
            }
        }
    }

    private static void consultarHorta(String estado) {
        String query = "SELECT * FROM horta WHERE estado = '" + estado + "'";
        ResultSet set = bd.select(query);

        if (set == null) {
            JOptionPane.showMessageDialog(null, "Horta não encontrada.");
        } else {
            try {
                boolean encontrado = false;
                StringBuilder resultados = new StringBuilder();
                while (set.next()) {
                    CadastroHorta horta = new CadastroHorta(
                            set.getString("estado"),
                            set.getString("cidade"),
                            set.getString("nome_horta"),
                            set.getString("nome_responsavel"),
                            set.getInt("capacidade_max_membros"),
                            set.getInt("tamanho"),
                            set.getString("resumo_horta")
                    );
                    resultados.append(horta.toString()).append("\n\n");
                    encontrado = true;
                }
                if (encontrado) {
                    JOptionPane.showMessageDialog(null, resultados.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "Horta não encontrada.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao ler lista: " + ex.getMessage());
            }
        }
    }
}
