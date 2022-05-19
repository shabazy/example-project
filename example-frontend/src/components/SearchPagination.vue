<script>
  export default {
    methods: {
      setPageCount(pageNumber) {
        this.$store.commit("setCurrentPageNumber", pageNumber)
        this.$store.dispatch("getSearchData", {
          name: this.$store.state.searchName,
          page: pageNumber
        })
      }
    }
  }
</script>
<template>
  <div v-if="this.$store.state.result.pageCount > 0" class="pagination">
    <a v-for="pageNumber in this.$store.state.result.pageCount"
       href="#"
       class="link-item"
       @click="setPageCount(pageNumber)"
       :class="{'link-item-selected': pageNumber === this.$store.state.currentPageNumber}">{{ pageNumber }}</a>
  </div>
</template>
<style type="text/css">
  .pagination {
    margin-top: 2rem;
  }
  .pagination a {
    float: left;
  }
  .link-item {
    margin: 10px;padding: 10px;background-color: red;color: white;font-style: normal;font-weight: bold;
  }
  .link-item-selected {
    background-color: white;
    color: red;
  }
</style>