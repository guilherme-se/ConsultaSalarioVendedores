package entities;

import java.util.Date;

public class HoraDeContrato {
  private Date date;
  private Double valorPorHora;
  private Integer horas;

  public HoraDeContrato(){

  }

  public HoraDeContrato(Date date, Double valorPorHora, Integer horas) {
    this.date = date;
    this.valorPorHora = valorPorHora;
    this.horas = horas;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Double getValorPorHora() {
    return valorPorHora;
  }

  public void setValorPorHora(Double valorPorHora) {
    this.valorPorHora = valorPorHora;
  }

  public Integer getHoras() {
    return horas;
  }

  public void setHoras(Integer horas) {
    this.horas = horas;
  }

  public double totalValor(){
    return valorPorHora * horas;
  }
}
