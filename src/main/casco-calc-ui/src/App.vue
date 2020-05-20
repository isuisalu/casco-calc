<template>
  <v-app>
        <v-navigation-drawer
          v-model="drawer"
          :color="color"
          :expand-on-hover="expandOnHover"
          :mini-variant="miniVariant"
          :right="right"
          :permanent="permanent"
          :src="bg"
          app
          dark>
          <v-list dense nav class="py-0">
            <v-list-item two-line :class="miniVariant && 'px-0'">
              <v-list-item-avatar>
                <img src="https://cdn.vuetifyjs.com/images/logos/vuetify-logo-dark.png">
              </v-list-item-avatar>

              <v-list-item-content>
                <v-list-item-title>Casco calc</v-list-item-title>
              </v-list-item-content>
            </v-list-item>

            <v-divider></v-divider>

            <v-list-item
              v-for="item in items"
              :key="item.title"
              :to="item.path">
              <v-list-item-icon>
                <v-icon>{{ item.icon }}</v-icon>
              </v-list-item-icon>

              <v-list-item-content>
                <v-list-item-title>{{ item.title }}</v-list-item-title>
              </v-list-item-content>
            </v-list-item>
          </v-list>
        </v-navigation-drawer>
            <v-content>
               <v-alert
                    v-model="showAlert"
                    dismissible
                    type="error"
                    transition="scale-transition">{{alertText}}</v-alert>
              <v-container fluid>
                  <router-view></router-view>
              </v-container>
            </v-content>
  </v-app>
</template>

<script>
import EventBus from './event-bus'
import * as types from './event-types.js'

  export default {
    data () {
      return {
        showAlert: false,
        alertText: '',
        drawer: true,
        items: [
          { title: 'Risks', icon: 'mdi-alert', path: '/risks' },
          { title: 'Cars', icon: 'mdi-image', path: '/cars' },
          { title: 'Cascos', icon: 'mdi-view-dashboard', path: '/cascos' },
        ],
        color: 'primary',
        colors: [
          'primary',
          'blue',
          'success',
          'red',
          'teal',
        ],
        right: false,
        permanent: true,
        miniVariant: false,
        expandOnHover: true,
        background: false,
      }
    },
    created: function () {
      EventBus.$on(types.ERROR_HAPPENED, function (error) {
        this.showAlert = true
        this.alertText = error.toString()
      })
    },
    computed: {
      bg () {
        return this.background ? 'https://cdn.vuetifyjs.com/images/backgrounds/bg-2.jpg' : undefined
      },
    },
  }
</script>

