import { mount } from '@cypress/vue'
import SearchResultTableHeadRow from '../SearchResultTableHeadRow.vue'

describe('SearchResultTableHeadRow component is testing', () => {
    it('playground', () => {
        mount(SearchResultTableHeadRow, {
            props: {
                name: "Name"
            }
        })
    })

    it('SearchResultTableHeadRow component renders properly', () => {
        mount(SearchResultTableHeadRow, {
            props: {
                name: "Name"
            }
        })
        cy.get('.contact-column-title').click().contains("Name")
    })
})
