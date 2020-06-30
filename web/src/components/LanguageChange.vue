<template>
  <b-row class="text-center">
    <b-col cols="4" class="m-auto">
      <h2> {{fromLanguage}} to {{toLanguage}}
        <span class="mx-2">
          <b-icon-arrow-left-right v-on:click="changeLanguage"/>
        </span>
      </h2>
    </b-col>
  </b-row>
</template>

<script>
  export default {
    props: {
      fromLanguage: String
    },

    name: "LanguageChange",
    data: function () {
      return {}
    },

    computed: {
      toLanguage: function () {
        return this.fromLanguage === "Estonian" ? "English" : "Estonian"
      }
    },

    methods: {
      changeLanguage() {
        this.$emit("changeLan", this.toLanguage)
      }
    }
  }
</script>

<style scoped>

</style>
