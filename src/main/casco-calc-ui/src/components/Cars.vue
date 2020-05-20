<template>
  <v-container>
    <v-data-table
        v-model="selected"
        :headers="headers"
        :items="cars"
        item-key="name"
        :loading="loading"
        class="elevation-1">
        <template v-slot:top>
            <v-toolbar flat color="white">
              <v-toolbar-title>Cars</v-toolbar-title>
              <v-divider
                class="mx-4"
                inset
                vertical
              ></v-divider>
              <v-spacer></v-spacer>
              <v-dialog v-model="dialog" max-width="500px">
<!--
                <template v-slot:activator="{ on }">
                  <v-btn color="primary" dark class="mb-2" v-on="on">New</v-btn>
                </template>
                -->
                <v-card>
                  <v-card-title>
                    <span class="headline">{{ formTitle }}</span>
                  </v-card-title>

                  <v-card-text>
                    <v-container>
                      <v-row>
                        <v-col cols="12" sm="6" md="4">
                          <v-text-field v-model="editedItem.plateNumber" label="Reg. number"></v-text-field>
                        </v-col>
                        <v-col cols="12" sm="6" md="4">
                          <v-text-field v-model="editedItem.firstRegistration" label="First registration"></v-text-field>
                        </v-col>
                        <v-col cols="12" sm="6" md="4">
                          <v-text-field v-model="editedItem.purchasePrice" label="Purchase price"></v-text-field>
                        </v-col>
                        <v-col cols="12" sm="6" md="4">
                          <v-text-field v-model="editedItem.producer" label="Producer"></v-text-field>
                        </v-col>
                        <v-col cols="12" sm="6" md="4">
                          <v-text-field v-model="editedItem.mileage" label="Mileage"></v-text-field>
                        </v-col>
                        <v-col cols="12" sm="6" md="4">
                          <v-text-field v-model="editedItem.prev_indemnity" label="Prev. indemnity"></v-text-field>
                        </v-col>
                      </v-row>
                    </v-container>
                  </v-card-text>
                  <!--
                  <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn color="blue darken-1" text @click="close">Cancel</v-btn>
                    <v-btn color="blue darken-1" text @click="save">Save</v-btn>
                  </v-card-actions>
                  -->
                </v-card>
              </v-dialog>
            </v-toolbar>
          </template>
          <template v-slot:item.actions="{ item }">
            <v-icon
              small
              class="mr-2"
              @click="editItem(item)">
              mdi-pencil
            </v-icon>
            <v-icon
              small
              @click="deleteItem(item)">
              mdi-delete
            </v-icon>
          </template>
          <template v-slot:no-data>
            <v-btn color="primary" @click="initialize">Reset</v-btn>
          </template>
      </v-data-table>
  </v-container>
</template>

<script>
import backend from '../backend'
import * as constant from '../constants'

  export default {
    data: () => ({
      dialog: false,
      singleSelect: false,
      selected: [],
      loading: false,
      options: {},
      headers: [
        { text: 'Reg. number', align: 'start', sortable: true, value: 'plateNumber'},
        { text: 'First registration', value: 'firstRegistration' },
        { text: 'Purchase price', value: 'purchasePrice' },
        { text: 'Producer', value: 'producer' },
        { text: 'Mileage', value: 'mileage' },
        { text: 'Prev. indemnity', value: 'previousIndemnity' },
        //{ text: 'Actions', value: 'actions', sortable: false },
      ],
      cars: [],
      editedIndex: -1,
      editedItem: {
        plateNumber: '',
        firstRegistration: 0,
        purchasePrice: 0,
        producer: '',
        mileage: 0,
        prevIndemnity: 0.,
      },
      defaultItem: {
        plateNumber: '',
        firstRegistration: 0,
        purchasePrice: 0,
        producer: '',
        mileage: 0,
        prevIndemnity: 0.,
      },
    }),

    computed: {
      formTitle () {
        return this.editedIndex === -1 ? 'New Item' : 'Edit Item'
      },
    },

    watch: {
      dialog (val) {
        val || this.close()
      },
    },

    created () {
      this.initialize()
    },

    methods: {
      initialize () {
          this.loading = true
          backend.doWithCars(constant.GET_METHOD)
              .then(response => {
                    this.cars = response.data
                    this.loading = false
                 }).catch(error => {
                    this.loading = false
                    //EventBus.$emit(types.NOT_BUSY)
                    console.log('response error: ' + JSON.stringify(error.response.data))
                  })

      },

      editItem (item) {
        this.editedIndex = this.cars.indexOf(item)
        this.editedItem = Object.assign({}, item)
        this.dialog = true
      },

      deleteItem (item) {
        const index = this.cars.indexOf(item)
        confirm('Are you sure you want to delete this item?') && this.desserts.splice(index, 1)
      },

      close () {
        this.dialog = false
        this.$nextTick(() => {
          this.editedItem = Object.assign({}, this.defaultItem)
          this.editedIndex = -1
        })
      },

      save () {
        if (this.editedIndex > -1) {
          Object.assign(this.cars[this.editedIndex], this.editedItem)
        } else {
          this.cars.push(this.editedItem)
        }
        this.close()
      },
    },
  }
</script>
