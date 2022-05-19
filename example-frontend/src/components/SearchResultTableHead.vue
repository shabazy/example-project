<script>
  import SearchResultTableHeadRow from './SearchResultTableHeadRow.vue';
  export default {
    components: {SearchResultTableHeadRow},
    data() {
      return {
        name: "Name",
        url: "Photo"
      }
    }
  }
</script>
<template>
  <thead>
    <tr>
      <SearchResultTableHeadRow :name="name" />
      <SearchResultTableHeadRow :name="url" />
    </tr>
  </thead>
</template>