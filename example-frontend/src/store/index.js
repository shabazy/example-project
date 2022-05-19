import { createStore } from 'vuex'
import axios from "axios";

export default createStore({
  state: {
    searchName: null,
    currentPageNumber: 1,
    result: {
      items: [],
      pageCount: 0
    }
  },
  mutations: {
    setCurrentPageNumber(state, number) {
      state.currentPageNumber = number
    },
    setSearchResult(state, result) {
      state.result.items = result.content
      state.result.pageCount = result.totalPages
    },
    setSearchName(state, name) {
      state.searchName = name
    }
  },
  actions: {
    getSearchData({commit}, {name, page}) {
      let queryString = "";
      if (name) {
        queryString += "&name=" + name
      }
      page = page - 1; // spring boot pagination starts with 0.
      axios.get(process.env.CONTACT_API_URL+"/?size=10&page="+page+queryString).then(
          response => {
            commit("setSearchResult", response.data)
          }
      )
    }
  },
  getters: {

  }
})