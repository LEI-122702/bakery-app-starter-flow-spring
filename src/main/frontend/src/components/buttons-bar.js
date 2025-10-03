import { html, css, LitElement } from 'lit';

/**
 * `buttons-bar` é um componente de barra de botões reutilizável.
 *
 * Este componente organiza botões e informações adicionais em
 * diferentes slots (`left`, `info`, `right`).
 *
 * Funcionalidades:
 * - Layout responsivo com flexbox.
 * - Suporte a sombra opcional (removida com o atributo `no-scroll`).
 * - Organização automática em ecrãs pequenos (mobile-friendly).
 *
 * Slots disponíveis:
 * - `left`: Botões ou elementos alinhados à esquerda.
 * - `info`: Informações ou textos alinhados ao centro/direita.
 * - `right`: Botões ou elementos alinhados à direita.
 */
class ButtonsBarElement extends LitElement {

  /**
   * Define os estilos CSS do componente.
   *
   * Inclui layout flexível, espaçamento e responsividade
   * (ajuste automático para ecrãs < 600px).
   */
  static get styles() {
    return css`
      :host {
        flex: none;
        display: flex;
        flex-wrap: wrap;
        transition: box-shadow 0.2s;
        justify-content: space-between;
        padding-top: var(--lumo-space-s);
        align-items: baseline;
        box-shadow: 0 -3px 3px -3px var(--lumo-shade-20pct);
      }

      :host([no-scroll]) {
        box-shadow: none;
      }

      :host ::slotted([slot='info']),
      .info {
        text-align: right;
        flex: 1;
      }

      ::slotted(vaadin-button) {
        margin: var(--lumo-space-xs);
      }

      @media (max-width: 600px) {
        :host ::slotted([slot='info']) {
          order: -1;
          min-width: 100%;
          flex-basis: 100%;
        }
      }
    `;
  }

  /**
   * Renderiza o HTML do componente, usando slots
   * para permitir a inserção de conteúdo externo.
   *
   * @returns {import("lit").TemplateResult} Estrutura HTML do componente.
   */
  render() {
    return html`
      <slot name="left"></slot>
      <slot name="info"><div class="info"></div></slot>
      <slot name="right"></slot>
    `;
  }

  /**
   * Nome da tag customizada usada no HTML.
   * @returns {string}
   */
  static get is() {
    return 'buttons-bar';
  }
}

// Regista
