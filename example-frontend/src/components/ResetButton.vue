<script>
  export default {
    methods: {
      resetInput() {
        document.getElementById("search-input").value = ""
        this.$store.commit("setSearchName", "")
        this.$store.commit("setCurrentPageNumber", 1)
        this.$store.dispatch("getSearchData", {name: "", page: 1})
      }
    }
  }
</script>
<template>
  <span class="reset-button">
      <button type="submit" @click="resetInput">Reset</button>
  </span>
</template>
<style type="text/css">
/* Style the submit button */
.reset-button button {
  width: 30%;
  padding: 10px;
  background: #2196F3;
  color: white;
  font-size: 14px;
  border: 1px solid grey;
  border-left: none; /* Prevent double borders */
  cursor: pointer;
}

.reset-button button:hover {
  background: #0b7dda;
}

</style>