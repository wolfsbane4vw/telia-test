<template>
  <b-container fluid="fluid">
    <language-change v-bind:from-language="fromLanguage" v-on:changeLan="changeLanguage"></language-change>
    <word-creation v-on:sendWord="saveNewWord"></word-creation>
    <!--TODO:Setup the divider differently-->
    <b-row>
      <p class="m-auto">OR</p>
    </b-row>
    <search v-on:search="searchForWord"></search>
  </b-container>
</template>

<script>

  import Search from "../components/Search";
  import LanguageChange from "../components/LanguageChange";
  import WordCreation from "../components/WordCreation";
  import axios from 'axios'

  export default {
    name: 'Home',
    components: {
      WordCreation,
      Search,
      LanguageChange
    },
    data: function () {
      return {
        fromLanguage: "English",
      }
    },

    methods: {
      changeLanguage(newLanguage) {
        this.fromLanguage = newLanguage;
      },

      async saveNewWord(newWord, newMeanings){
        if(this.fromLanguage === "English"){
          let converted = {
            word: newWord,
            estMeaning:[]
          };
          newMeanings.forEach(element => converted.estMeaning.push({word:element.meaning}));

          await axios.post(process.env.VUE_APP_API + '/english/add', converted);
        }
      },

      async searchForWord(word) {
        if (this.fromLanguage === "English") {
          //let returningWord = await axios.get(process.env.VUE_APP_API + '/english/search/' + word);
          console.log(word);
        }
      }
    }
  }
</script>
