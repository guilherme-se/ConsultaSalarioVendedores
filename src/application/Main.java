package application;

import entities.CategoriaTrabalhador;
import entities.Departament;
import entities.Funcionario;
import entities.HoraDeContrato;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws ParseException {

    Scanner sc = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    System.out.print("digite o nome do departamento: ");
    String departamentoNome = sc.nextLine();

    System.out.println("digite a data do trabalho realizado: ");
    System.out.print("digite seu nome: ");
    String funcionarioNome = sc.nextLine();

    System.out.print("digite seu nivel do cargo: ");
    String categoriaFuncionario = sc.nextLine();

    System.out.print("Salario base: ");
    Double salarioBase = sc.nextDouble();

    Funcionario funcionario = new Funcionario(funcionarioNome, CategoriaTrabalhador.valueOf(categoriaFuncionario),salarioBase,new Departament(departamentoNome));

    System.out.print("Quantos contratos voce tem? ");
    int n = sc.nextInt();

    for (int i=1; i<=n; i++){
        System.out.println("digite a data do " + i + " contrato: ");
        System.out.print("Data (DD/MM/YYYY): ");
        Date contratoData = sdf.parse(sc.next());
        System.out.print("Valor por hora: ");
        Double valorPorHora = sc.nextDouble();
        System.out.print("Duração do trabalho (horas): ");
        int horas = sc.nextInt();
        HoraDeContrato contrato = new HoraDeContrato(contratoData,valorPorHora,horas);
        funcionario.addContrato(contrato);
    }

    System.out.println();
    System.out.print("Digite o mes e o ano para calcular o seu salario (MM/YYYY): ");
    String mesAno = sc.next();
    int mes = Integer.parseInt(mesAno.substring(0, 2));
    int ano = Integer.parseInt(mesAno.substring(3));
    System.out.println("Nome: " + funcionario.getName());
    System.out.println("Departamento: " + funcionario.getDepartament().getName());
    System.out.println("voce recebeu na data " + mesAno + ": " + String.format("%.2f", funcionario.calculo(ano, mes)));


    sc.close();
  }

}