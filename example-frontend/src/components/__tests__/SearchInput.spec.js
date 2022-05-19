import { mount } from '@cypress/vue'
import SearchInput from '../SearchInput.vue'

describe('Search input component is testing', () => {
    it('playground', () => {
        mount(SearchInput, { props: { pageCount: 5 } })
    })

    it('renders properly', () => {
        mount(SearchInput)
        cy.get('#search-input').type("home").should('have.value', "home")
    })
})
