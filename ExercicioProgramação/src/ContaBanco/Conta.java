package ContaBanco;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

public class Conta extends pessoas {
     Hashtable<String, String> conta = new Hashtable<>();

      protected String[] nomes = new String[9999];

     protected String[] senhas = new String[9999];
    protected int[] saldos = new int[9999];
    protected String[] tipocontaCorrentes = new String[9999];
    protected String[] tipocontaPoupancas = new String[9999];

    Random aleatorio = new Random();

    private String confirmacaoNumero;
    private String confirmacaoNumeroDestino;
    double ValorTransicao;
    private int tipoconta;
    private String agencia;
    private String senha;
    private int numeroConta;
    private double saldo;

    public  Conta(){}

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public int getTipoconta() {
        return tipoconta;
    }

    public void setTipoconta(int tipoconta) {
        this.tipoconta = tipoconta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString(String cpf, String nome) {
        return "Conta{" +
                " CPF = " + cpf +
                ", Nome = " + nome +
                ", tipoconta = " + tipoconta +
                ", agencia = " + agencia +
                ", numeroConta = " + numeroConta +
                ", saldo = " + saldo +
                '}';
    }

    public void VerificaTipoConta (int tipoContaNumero){
        do {

            if (tipoContaNumero != 1 && tipoContaNumero != 2){
                System.out.println("Utiliza a apenas opções acima!!! ");
            }else {
                setTipoconta(tipoContaNumero);
            }
            }while (tipoContaNumero != 1 && tipoContaNumero != 2);
    }



    public void cadastroConta(String Cpf,String nome,String senhaConta){
        int numeroAleatorio = aleatorio.nextInt(10000);
        setAgencia(String.valueOf(254));
        setSenha(senhaConta);
        setNumeroConta(numeroAleatorio);
        conta.put(Cpf, String.valueOf(getNumeroConta()));
        setSaldo(0);
        System.out.println();

        System.out.println("Confirmação :");
        System.out.println(toString(Cpf,nome));
        System.out.println();

        nomes[getNumeroConta()] = nome;
        saldos[getNumeroConta()] = (int) getSaldo();
        if (getTipoconta() == 1){
            tipocontaCorrentes[getNumeroConta()] = String.valueOf(getTipoconta());
        } else if (getTipoconta() == 2) {
            tipocontaPoupancas[getNumeroConta()] = String.valueOf(getTipoconta());
        }

        senhas[getNumeroConta()] = senhaConta;

    }

    public boolean consultaDocument(String cpf){
       if (conta.get(cpf) == null){
           return  true;
       }else{
           confirmacaoNumero = conta.get(cpf);
           return false;
       }
    }

    public void consultarTipoConta(int tipoconta){
        if (tipoconta == 1){
            System.out.println("Conta Corrente Selecionada");
        } else if (tipoconta == 2) {
            System.out.println("Conta Poupança Selecionada");
        }else{
            System.out.println("Digite o tipo de conta descrito acima!!!");
        }
    }

    public void verificaConta(String agencia, String numeroConta){
        if (!agencia.equals("254") && !numeroConta.equals(confirmacaoNumero)){
            System.out.println("Dados informados estão incorretos");
        }
    }
    public void verificaValor(double valor){
         if (valor <= 0){
             System.out.println("O valor informado não pode ser ser menor que 0!!!");
         }else{
             ValorTransicao = valor;
         }
    }

    public  void verificaSenha(String senha){
        if (senha.equals(senhas[Integer.parseInt(confirmacaoNumero)])){
            System.out.println("Senha Confirmada!!");
            System.out.println("Saldo Anterior : "+saldos[Integer.parseInt(confirmacaoNumero)]);
        }else{
            System.out.println("Senha incorreta, tente novamente!!!");
        }
    }
    public void operacao(int escolha){
        if (escolha == 2){
            saldos[Integer.parseInt(confirmacaoNumero)] += ValorTransicao;
        } else if (escolha == 3) {
            saldos[Integer.parseInt(confirmacaoNumero)] -= ValorTransicao;
        }
        System.out.println("Operação Realizada com Sucesso!!!");
        System.out.println("Saldo Atual : "+saldos[Integer.parseInt(confirmacaoNumero)]);
        System.out.println();
    }

    public boolean consultaDocumentDestino(String cpf){
        if (conta.get(cpf) == null){
            return  true;
        }else{
            confirmacaoNumeroDestino = conta.get(cpf);
            return false;
        }
    }
    public void transferenciaValor(double valor){
        saldos[Integer.parseInt(confirmacaoNumero)] -= valor;
        saldos[Integer.parseInt(confirmacaoNumeroDestino)] += valor;

        System.out.println("Operação Realizado com Sucesso");
        System.out.println("Saldo Atual de Conta : "+saldos[Integer.parseInt(confirmacaoNumero)]);
    }



}