<script>
export default {
  methods: {
    makeSearch(value) {
      this.$store.commit("setSearchName", value)
      this.$store.commit("setCurrentPageNumber", 1)
      this.$store.dispatch("getSearchData", {name: value, page: this.$store.state.currentPageNumber})
    }
  },
  watch: {
    searchInput: function (value) {
      clearTimeout(this.timeout)
      this.timeout = setTimeout(() => {
        this.makeSearch(value)
      }, 1500)
    }
  },
  data() {
    return {
      placeholder: "type a name",
      searchInput: ""
    }
  }
}
</script>
<template>
  <span>
    <input type="text" id="search-input" v-model="searchInput" @keyup.enter="makeSearch(searchInput)" :placeholder="placeholder">
  </span>
</template>
<style type="text/css">
  #search-input {
    padding: 10px;
    font-size: 14px;
    border: 1px solid grey;
    width: 70%;
    background: #f1f1f1;
    margin-bottom: 30px;
  }
</style>