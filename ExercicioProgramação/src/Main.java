import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import ContaBanco.Conta;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        Scanner ponto = new Scanner(System.in);
        int escolha;


        System.out.println("Seja Bem-vindo, ao caixa eletrônico");
        System.out.println("Escolha uma das opções abaixo, para realizar uma ação :");
        System.out.println();
        Conta conta = new Conta();
        do{
            System.out.println("1.Cadastrar Conta");
            System.out.println("2.Efetuar Deposito");
            System.out.println("3.Efetuar Saque");
            System.out.println("4.Efetuar transferencia");
            System.out.println("5.Finalizar");
            switch (escolha = ponto.nextInt()) {
                case 1:

                    System.out.println("Tipo de Conta : ");
                    System.out.println("1.Conta Corrente.");
                    System.out.println("2.Conta Poupança.");
                    try {
                        conta.VerificaTipoConta(Integer.parseInt(getTipoConta()));
                        conta.cadastroConta(getCPF(),getNome(),getSenha());
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                    break;
                case 2:
                    System.out.println("Siga os procedimentos a baixo para efetuar a operação");
                    try {
                        if (conta.consultaDocument(getCPF()) == true){
                            System.out.println("Falha na consulta!!! " +
                                    "CPF não encontrado verifique com representante local para auxilia-lo");
                            System.out.println();
                        }else{
                            conta.consultarTipoConta(Integer.parseInt(getTipoConta()));
                            conta.verificaConta(getAgencia(),getNumeroConta());
                            conta.verificaValor(getValor());
                            conta.verificaSenha(getSenha());
                            conta.operacao(escolha);
                        }
                    }catch (Exception ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Siga os procedimentos a baixo para efetuar a operação");
                   try{
                        if (conta.consultaDocument(getCPF())){
                            System.out.println("Falha na consulta!!! " +
                                    "CPF não encontrado verifique com representante local para auxilia-lo");
                            System.out.println();
                        }else{
                            conta.consultarTipoConta(Integer.parseInt(getTipoConta()));
                            conta.verificaConta(getAgencia(),getNumeroConta());
                            conta.verificaValor(getValor());
                            conta.verificaSenha(getSenha());
                            conta.operacao(escolha);
                        }
                    }catch (Exception ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 4:
                    try {
                        System.out.println("Siga os procedimentos a baixo para efetuar a operação");
                        System.out.println("Dados de transferidor :");
                        if (conta.consultaDocument(getCPF())){
                            System.out.println("Falha na consulta!!! " +
                                    "CPF não encontrado verifique com representante local para auxilia-lo");
                            System.out.println();
                        }else{
                            conta.consultarTipoConta(Integer.parseInt(getTipoConta()));
                            conta.verificaConta(getAgencia(),getNumeroConta());
                            System.out.println();
                            System.out.println("Dados de Conta Destino :");
                            if (conta.consultaDocumentDestino(getCPF())) {
                                System.out.println("Dados Incorretos");
                            }else{
                                conta.verificaConta(getAgencia(), getNumeroConta());
                                conta.verificaValor(getValor());
                                conta.verificaSenha(getSenha());
                                conta.transferenciaValor(getValor());
                            }
                        }
                    }catch (Exception ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Tenha um bom dia.");
                    break;
                default:
                    System.out.println("Digite um dos valores acima!!!");
                    break;
            }
        }while(escolha !=5);
    }
    private static  String getNome() throws IOException {
        System.out.println("Digite seu Nome :");
        return reader.readLine();
    }

    private static  String getCPF() throws IOException {
        System.out.println("Digite seu CPF :");
        return reader.readLine();
    }
    private static  String getSenha() throws IOException {
        System.out.println("Digite sua Senha :");
        return reader.readLine();
    }
    private static  String getTipoConta() throws IOException {
        System.out.println("Digite seu Tipo de Conta :");
        return reader.readLine();
    }
    private static  double getValor() throws IOException {
        System.out.println("Digite o valor para operação :");
        return Double.parseDouble(reader.readLine());
    }
    private static  String getAgencia() throws IOException {
        System.out.println("Digite sua Agencia :");
        return reader.readLine();
    }
    private static  String getNumeroConta() throws IOException {
        System.out.println("Digite seu Numero de Conta :");
        return reader.readLine();
    }

}