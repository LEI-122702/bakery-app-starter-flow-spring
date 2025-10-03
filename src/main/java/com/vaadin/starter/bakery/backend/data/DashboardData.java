package com.vaadin.starter.bakery.backend.data;

import java.util.LinkedHashMap;
import java.util.List;

import com.vaadin.starter.bakery.backend.data.entity.Product;

/**
 * Classe que contém os dados estatísticos e de entregas a serem apresentados
 * no dashboard da aplicação de padaria.
 */
public class DashboardData {

	/** Estatísticas globais de entregas. */
	private DeliveryStats deliveryStats;

	/** Lista com o número de entregas realizadas em cada dia do mês atual. */
	private List<Number> deliveriesThisMonth;

	/** Lista com o número de entregas realizadas em cada mês do ano atual. */
	private List<Number> deliveriesThisYear;

	/** Matriz com as vendas mensais, onde cada linha representa um mês. */
	private Number[][] salesPerMonth;

	/** Mapa de produtos e respetiva quantidade de entregas realizadas. */
	private LinkedHashMap<Product, Integer> productDeliveries;

	/**
	 * Obtém as estatísticas globais de entregas.
	 *
	 * @return objeto {@link DeliveryStats} com dados consolidados.
	 */
	public DeliveryStats getDeliveryStats() {
		return deliveryStats;
	}

	/**
	 * Define as estatísticas globais de entregas.
	 *
	 * @param deliveryStats objeto {@link DeliveryStats} a atribuir.
	 */
	public void setDeliveryStats(DeliveryStats deliveryStats) {
		this.deliveryStats = deliveryStats;
	}

	/**
	 * Obtém a lista de entregas deste mês.
	 *
	 * @return lista de números representando entregas diárias.
	 */
	public List<Number> getDeliveriesThisMonth() {
		return deliveriesThisMonth;
	}

	/**
	 * Define a lista de entregas deste mês.
	 *
	 * @param deliveriesThisMonth lista de números representando entregas diárias.
	 */
	public void setDeliveriesThisMonth(List<Number> deliveriesThisMonth) {
		this.deliveriesThisMonth = deliveriesThisMonth;
	}

	/**
	 * Obtém a lista de entregas deste ano
	 *
	 * @return lista de números representando entregas mensais.
	 */
	public List<Number> getDeliveriesThisYear() {
		return deliveriesThisYear;
	}

	/**
	 * Define a lista de entregas deste ano.
	 *
	 * @param deliveriesThisYear lista de números representando entregas mensais.
	 */
	public void setDeliveriesThisYear(List<Number> deliveriesThisYear) {
		this.deliveriesThisYear = deliveriesThisYear;
	}

	/**
	 * Define a matriz de vendas por mês.
	 *
	 * @param salesPerMonth matriz em que cada linha corresponde a um mês
	 *                      e contém os valores de vendas.
	 */
	public void setSalesPerMonth(Number[][] salesPerMonth) {
		this.salesPerMonth = salesPerMonth;
	}

	/**
	 * Obtém os dados de vendas de um determinado mês.
	 *
	 * @param i índice do mês (0 = janeiro, 1 = fevereiro, ...).
	 * @return array de números com os valores de vendas desse mês.
	 */
	public Number[] getSalesPerMonth(int i) {
		return salesPerMonth[i];
	}

	/**
	 * Obtém o mapa de produtos e respetivas quantidades de entregas.
	 *
	 * @return mapa de {@link Product} e quantidade de entregas.
	 */
	public LinkedHashMap<Product, Integer> getProductDeliveries() {
		return productDeliveries;
	}

	/**
	 * Define o mapa de produtos e respetivas quantidades de entregas.
	 *
	 * @param productDeliveries mapa de {@link Product} e quantidade de entregas.
	 */
	public void setProductDeliveries(LinkedHashMap<Product, Integer> productDeliveries) {
		this.productDeliveries = productDeliveries;
	}

}
