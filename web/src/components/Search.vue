<template>
  <b-row>
    <b-col class="m-auto py-1" cols="4">
      <b-input-group size="lg">
        <b-form-input type="text" v-model="searchWord"/>
        <b-input-group-append>
          <b-button variant="info" @click="searchForWord">
            Search
            <b-icon-search class="mx-1"/>
          </b-button>
        </b-input-group-append>
      </b-input-group>
    </b-col>
  </b-row>
</template>

<script>
  export default {
    name: "Search",
    data: function () {
      return{
        searchWord: null
      }
    },
    methods: {
      searchForWord() {
        this.$emit("search", this.searchWord);
        this.searchWord = null;
      }
    }
  }
</script>

<style scoped>

</style>
