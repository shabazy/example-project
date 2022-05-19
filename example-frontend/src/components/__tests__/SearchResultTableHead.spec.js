import { mount } from '@cypress/vue'
import SearchResultTableHead from '../SearchResultTableHead.vue'

describe('SearchResultTableHead component is testing', () => {
    it('playground', () => {
        mount(SearchResultTableHead)
    })

    it('SearchResultTableHead component renders properly', () => {
        mount(SearchResultTableHead)
        cy.get('thead').find("tr").find("td").should("have.length", 2)
    })
})
