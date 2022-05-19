import { mount } from '@cypress/vue'
import SearchResultTableRow from '../SearchResultTableRow.vue'

const componentProps = {
    props: {
        name: "Homer Simpson",
        url: "http://localhost/photo"
    }
}

describe('SearchResultTableRow component is testing', () => {
    it('playground', () => {
        mount(SearchResultTableRow, componentProps)
    })

    it('SearchResultTableRow component renders properly', () => {
        mount(SearchResultTableRow, componentProps)
        cy.get('.contact-list-row').find('td').eq(0).click().contains("Homer Simpson")
    })
})
