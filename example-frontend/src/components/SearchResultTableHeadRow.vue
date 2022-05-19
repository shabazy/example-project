<script>
  export default {
    props: {
      name: {
        type: String,
        required: true
      }
    }
  }
</script>
<template>
  <td class="tg-0lax contact-column-title">{{ name }}</td>
</template>
<style type="text/css">
.tg-0lax{text-align:left;vertical-align:top}
</style>