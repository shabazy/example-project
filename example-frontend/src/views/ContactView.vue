<script setup>
import SearchInput from '@/components/SearchInput.vue'
import ResetButton from '@/components/ResetButton.vue'
import SearchResultTable from '@/components/SearchResultTable.vue'
import SearchPagination from "@/components/SearchPagination.vue";
</script>
<template>
  <div class="contact-main">
    <div class="search-input-container">
      <SearchInput />
      <ResetButton />
    </div>
    <SearchResultTable />
    <SearchPagination />
  </div>
</template>

<style type="text/css">
* {
  box-sizing: border-box;
}
.search-input-container {
  width: 14rem;
}
/* Clear floats */
.contact-main::after {
  content: "";
  clear: both;
  display: table;
}
.contact-column-title{font-weight: bold;}
</style>