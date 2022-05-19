<script>
import SearchResultTableRow from "./SearchResultTableRow.vue";
export default {
  props: {
    result: {
      type: Object,
      required: true
    }
  },
  components: {SearchResultTableRow}
}
</script>
<template>
  <tbody>
    <SearchResultTableRow v-if="this.$props.result.items.length > 0" v-for="item in this.$props.result.items" :name="item.name" :url="item.url" :key="item.id" />
    <SearchResultTableRow v-else name="There is no result..."/>
  </tbody>
</template>
