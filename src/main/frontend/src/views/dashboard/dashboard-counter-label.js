import { html, css, LitElement } from 'lit';

/**
 * Componente web <dashboard-counter-label> que apresenta
 * um contador com título, subtítulo e um espaço para gráfico.
 *
 * É utilizado no dashboard da aplicação para exibir valores
 * numéricos destacados (como estatísticas ou métricas) com
 * cores e estilos configuráveis.
 *
 * Extende {@link LitElement} da biblioteca Lit.
 */
class DashboardCounterLabel extends LitElement {
  /**
   * Define os estilos CSS específicos para o componente.
   *
   * @returns {CSSResult} Conjunto de regras CSS aplicadas ao shadow DOM.
   */
  static get styles() {
    return css`
      :host {
        position: relative;
        text-align: center;
        height: calc(18vh - 64px);
        min-height: 180px;
        display: block;
      }

      :host(.green) .count-digit {
        color: #55bf3b;
      }

      :host(.red) .count-digit {
        color: #ff473a;
      }

      :host(.blue) .count-digit {
        color: #1877f3;
      }

      :host(.gray) .count-digit {
        color: rgba(45, 71, 105, 0.7);
      }

      .content {
        padding: 10px;
      }

      .count-wrapper {
        display: block;
        text-align: center;
        padding-top: 12px;
        margin-bottom: 18px;
      }

      .count-digit {
        font-size: 44px;
      }

      .subtitle {
        color: var(--lumo-secondary-text-color);
        font-size: 14px;
      }

      h4 {
        margin: 0;
      }

      .chart-wrapper {
        position: absolute;
        top: 0;
        left: 0;
        height: 120px;
        width: 100%;
      }
    `;
  }

  /**
   * Renderiza a estrutura HTML do componente,
   * incluindo espaço para gráfico, contador, título e subtítulo
   *
   * @returns {TemplateResult} Template do Lit a ser renderizado.
   */
  render() {
    return html`
      <div class="chart-wrapper">
        <slot></slot>
      </div>

      <div class="content">
        <div class="count-wrapper">
          <span id="count" class="count-digit"></span>
        </div>

        <h4 id="title"></h4>
        <div id="subtitle" class="subtitle"></div>
      </div>
    `;
  }

  /**
   * Nome do custom element a ser registado no navegador.
   *
   * @returns {string} Nome da tag HTML personalizada.
   */
  static get is() {
    return 'dashboard-counter-label';
  }
}

/**
 * Registo do componente <dashboard-counter-label>
 * no Custom Elements Registry do browser.
 */
customElements.define(DashboardCounterLabel.is, DashboardCounterLabel);
