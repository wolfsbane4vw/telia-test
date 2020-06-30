<template>
  <div>
    <!--ADD NEW WORD BUTTON-->
    <b-row class=" my-3 bg-dark " cols="4">
      <b-col class="m-auto text-center">
        <b-button variant="danger" size="lg" class="my-2" v-on:click="showCreationFields">
          Add a new word
        </b-button>
      </b-col>
    </b-row>

    <!--FIELDS-->
    <div v-if="showField">
      <b-row class="justify-content-center align-content-center">
        <b-col cols="4">
          <b-form-input type="text" v-model="word"></b-form-input>
        </b-col>

        <b-col cols="4">
          <!--DYNAMIC INPUT-->
          <b-row v-for="(meaning, counter) in meanings" v-bind:key="counter">
            <b-input-group class="mb-1">
              <b-form-input type="text" v-model="meaning.meaning"></b-form-input>
              <b-input-group-append class="mx-2 my-auto">
                <b-icon-plus-circle v-if="counter === last" font-scale="1.5" @click="addMeaning()" class="mx-2 my-2"/>
                <b-icon-trash-fill v-else font-scale="1.5" @click="deleteMeaning" class="mx-2 my-2"/>
              </b-input-group-append>
            </b-input-group>
          </b-row>
        </b-col>
      </b-row>
      <b-row class="justify-content-center my-2">
        <b-button variant="danger" @click="saveWord">Save new word</b-button>
      </b-row>
    </div>

  </div>
</template>

<script>
  export default {
    name: "WordCreation",
    data: function () {
      return {
        showField: false,
        word: "",
        meanings: [{
          meaning:""
        }]
      }
    },

    computed: {
      last() {
        return Object.keys(this.meanings).length-1;
      }
    },

    methods: {
      showCreationFields() {
        this.showField = true;
      },
      addMeaning() {
        this.meanings.push({
          meaning: ""
        })
      },
      deleteMeaning(counter) {
        this.meanings.splice(counter, 1)
      },
      saveWord() {
        this.$emit("sendWord", this.word, this.meanings)
      }
    }
  }
</script>

<style scoped>

</style>
