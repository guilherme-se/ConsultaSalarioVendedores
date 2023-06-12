package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Funcionario {
  private String name;
  private CategoriaTrabalhador level;
  private  Double salarioBase;

  private Departament departament;
  private List<HoraDeContrato> contratos = new ArrayList<>();

  public Funcionario(){

  }

  public Funcionario(String name, CategoriaTrabalhador level, Double salarioBase, Departament departament) {
    this.name = name;
    this.level = level;
    this.salarioBase = salarioBase;
    this.departament = departament;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CategoriaTrabalhador getLevel() {
    return level;
  }

  public void setLevel(CategoriaTrabalhador level) {
    this.level = level;
  }

  public Double getSalarioBase() {
    return salarioBase;
  }

  public void setSalarioBase(Double salarioBase) {
    this.salarioBase = salarioBase;
  }

  public Departament getDepartament() {
    return departament;
  }

  public void setDepartament(Departament departament) {
    this.departament = departament;
  }

  public List<HoraDeContrato> getContratos() {
    return contratos;
  }


  public void addContrato(HoraDeContrato contrato){
    contratos.add(contrato);
  }

  public void removeContrato(HoraDeContrato contrato){
    contratos.remove(contrato);
  }

  public double calculo(int year,int month){
    double sum = salarioBase;
    Calendar cal = Calendar.getInstance();
    for (HoraDeContrato c : contratos){
        cal.setTime(c.getDate());
      int c_year = cal.get(Calendar.YEAR);
      int c_month = 1 + cal.get(Calendar.MONTH);
      if (year == c_year && month == c_month) {
        sum += c.totalValor();
      }
    }
    return sum;
  }

}
