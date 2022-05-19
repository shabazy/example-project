<script>
  import SearchResultTableBody from "./SearchResultTableBody.vue";
  import SearchResultTableHead from "./SearchResultTableHead.vue";
  export default {
    mounted() {
      this.getContent()
    },
    methods: {
      getContent() {
        this.$store.dispatch("getSearchData", {name: null, page: 1})
      }
    },
    components: {
      SearchResultTableBody,
      SearchResultTableHead
    }
  }
</script>
<template>
  <div class="main-container">
    <table class="tg">
      <SearchResultTableHead v-if="this.$store.state.result.items.length > 0" />
      <SearchResultTableBody :result="this.$store.state.result" />
    </table>
  </div>
</template>
<style>
.main-container {
  padding-bottom: 2rem;
}
.tg  {border-collapse:collapse;border-spacing:0;}
.tg td{border-color:beige;border-style:solid;border-width:1px;font-family:Arial, sans-serif;font-size:14px;
  overflow:hidden;padding:10px 15px;word-break:normal;}
.tg th{border-color:black;border-style:solid;border-width:1px;font-family:Arial, sans-serif;font-size:14px;
  font-weight:normal;overflow:hidden;padding:10px 5px;word-break:normal;}
</style>