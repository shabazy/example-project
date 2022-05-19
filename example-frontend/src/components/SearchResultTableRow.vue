<script>
  export default {
    props: {
      name: {
        type: String,
        required: true
      },
      url: {
        type: String,
        required: false
      }
    }
  }
</script>
<template>
  <tr class="contact-list-row">
    <td>{{ name }}</td>
    <td v-if="url" class="center"><img :src="url" /></td>
  </tr>
</template>
<style>
.contact-list-row td img {
  height: 10em;
  padding: 1em;
}
.center {
  text-align:center;
  display:block;
}
</style>