import { mount } from '@cypress/vue'
import ResetButton from '../ResetButton.vue'

describe('ResetButton component is testing', () => {
    it('playground', () => {
        mount(ResetButton)
    })

    it('ResetButton renders properly', () => {
        cy.once('uncaught:exception', () => false);
        mount(ResetButton)
        cy.get('.reset-button').find('button').contains("Reset")
    })
})
