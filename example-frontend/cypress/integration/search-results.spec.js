// https://docs.cypress.io/api/introduction/api.html

describe('search results', () => {
  it('should see homer results successfully', () => {
    cy.visit('/')
    cy.get("input#search-input").type("homer")
    cy.wait(500)
    cy.get(".contact-list-row").eq(0).find("td").eq(0).click().contains("Homer")
    cy.get(".contact-list-row").eq(0).find("img").should("be.visible")
  })

  it('should see there is no result with reset button', () => {
    cy.get(".reset-button").click()
    cy.get("input#search-input").click().should("have.value", "")
    cy.get("input#search-input").type("aaaaa")
    cy.wait(2000)
    cy.get(".contact-list-row").eq(0).find("td").eq(0).contains("There is no result...")
  });

  it('should see mar results as 2 pagination and the first one should be selected', () => {
    cy.get(".reset-button").click()
    cy.get("input#search-input").type("mar")
    cy.get(".pagination").eq(0).find("a").should("have.length", 2)
    cy.get(".pagination").eq(0).find("a").eq(0).should("have.class", "link-item-selected")
  })
})
