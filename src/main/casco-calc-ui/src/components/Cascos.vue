<template>
  <v-container>
    <v-data-table
        :headers="headers"
        :items="cascos"
        item-key="name"
        :loading="loading"
        class="elevation-1"
      >
        <template v-slot:top>
            <v-toolbar flat color="white">
              <v-toolbar-title>Cascos</v-toolbar-title>
              <v-divider
                class="mx-4"
                inset
                vertical
              ></v-divider>
              <v-spacer></v-spacer>
            </v-toolbar>
          </template>
      </v-data-table>
  </v-container>
</template>

<script>
import backend from '../backend'

  export default {
    data: () => ({
      monthly: false,
      loading: false,
      headers: [
        { text: 'Reg. number', align: 'start', sortable: true, value: 'car.plateNumber'},
        { text: 'Annual payment', value: 'annual' },
        { text: 'Producer', value: 'car.producer' },
        { text: 'First registration', value: 'car.firstRegistration' },
        { text: 'Mileage', value: 'car.mileage' },
        { text: 'Prev. indemnity', value: 'car.previousIndemnity' },
      ],
      cascos: [],
    }),

    created () {
      this.initialize()
    },
    methods: {
      initialize () {
          this.loading = true
          backend.getCascos()
              .then(response => {
                    this.cascos = response.data
                    this.loading = false
                 }).catch(error => {
                    this.loading = false
                    //EventBus.$emit(types.NOT_BUSY)
                    console.log('response error: ' + JSON.stringify(error.response.data))
                  })
      },
    },
  }
</script>
