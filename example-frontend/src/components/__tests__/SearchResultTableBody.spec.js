import { mount } from '@cypress/vue'
import SearchResultTableBody from '../SearchResultTableBody.vue'

const customProps = {
    props: {
        result: {
            items: [
                {
                    name: "Homer Simpson",
                    photo: "http://localhost/photo1"
                },
                {
                    name: "Maggie Simpson",
                    photo: "http://localhost/photo2"
                }
            ]
        }
    }
}

describe('SearchResultTableBody component is testing', () => {
    it('playground', () => {
        mount(SearchResultTableBody, customProps)
    })

    it('SearchResultTableBody component renders properly with not empty items', () => {
        mount(SearchResultTableBody, customProps)
        cy.get('tbody').find("tr.contact-list-row").should("have.length", 2)
        cy.get('tbody').find("tr.contact-list-row").eq(0).contains("Homer Simpson")
    })

    it('SearchResultTableBody component renders properly with empty items', () => {
        mount(SearchResultTableBody, {
            props: {
                result: {
                    items: []
                }
            }
        })
        cy.get('tbody').find("tr.contact-list-row").should("have.length", 1)
        cy.get('tbody').find("tr.contact-list-row").eq(0).contains("There is no result...")
    })
})
