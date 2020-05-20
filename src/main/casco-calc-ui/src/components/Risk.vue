<template>
  <v-container>
    <v-data-table
        v-model="selected"
        :headers="headers"
        :items="risks"
        item-key="name"
        :hide-default-footer="true"
        class="elevation-1"
      >
        <template v-slot:top>
            <v-toolbar flat color="white">
              <v-toolbar-title>{{ riskName }}</v-toolbar-title>
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
                          <v-text-field v-model="editedItem.name" label="Name"></v-text-field>
                        </v-col>
                        <v-col cols="12" sm="6" md="4">
                          <v-text-field v-model="editedItem.value" label="Value"></v-text-field>
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
          <template v-if="showUse" v-slot:item.inUse="{ item }">
                  <v-checkbox v-model="item.inUse" @change="saveUse(item)"></v-checkbox>
          </template>
          <template v-slot:item.actions="{ item }">
            <v-icon
              small
              class="mr-2"
              @click="editItem(item)"
            >
              mdi-pencil
            </v-icon>
            <v-icon
              small
              @click="deleteItem(item)"
            >
              mdi-delete
            </v-icon>
          </template>
          <template v-slot:no-data>
                  <v-btn color="primary" dark class="mb-2" @click="initialize">Reset</v-btn>
          </template>
      </v-data-table>
  </v-container>
</template>
<script>
import backend from '../backend'
import * as constant from '../constants'
import EventBus from '../event-bus'
import * as types from '../event-types.js'

  export default {
    props: ['riskName', 'showUse'],
    data: () => ({
      dialog: false,
      singleSelect: false,
      selected: [],
      headers: [],
      risks: [],
      editedIndex: -1,
      editedItem: {
        name: '',
        value: 0.,
      },
      defaultItem: {
        name: '',
        value: 0.,
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
            console.log("initialize")
            if (this.riskName === constant.AVG_PURCHASE_PRICE) {
              this.headers = [
                { text: 'Producer', value: 'producer' },
                { text: 'Price', value: 'price', sortable: false }]
            } else {
              this.headers = [
                { text: 'Name', value: 'name' },
                { text: 'Value', value: 'value', sortable: false }]
            }
          if (this.showUse) {
            this.headers.push({ text: 'In use', value: 'inUse' })
          }
          //this.headers.push({ text: 'Action', value: 'actions', sortable: false})

          backend.doWithRiskData(constant.GET_METHOD, this.riskName)
              .then(response => {
                    this.risks = response.data
                 }).catch(error => {
                    EventBus.$emit(types.ERROR_HAPPENED, error.message)
                    console.log('response error: ' + JSON.stringify(error.response.data))
                  })
       },

      editItem (item) {
        this.editedIndex = this.risks.indexOf(item)
        this.editedItem = Object.assign({}, item)
        this.dialog = true
      },

      deleteItem (item) {
        const index = this.risks.indexOf(item)
        confirm('Are you sure you want to delete this item?') && this.risks.splice(index, 1)
      },

      close () {
        this.dialog = false
        this.$nextTick(() => {
          this.editedItem = Object.assign({}, this.defaultItem)
          this.editedIndex = -1
        })
      },
      saveUse(item) {
        console.log("Risk saveUse: " + JSON.stringify(item))
        this.editedIndex = this.risks.indexOf(item)
        backend.doWithRiskData(constant.PUT_METHOD, this.riskName, item.id, item)
            .then(response => {
                  Object.assign(this.risks[this.editedIndex], response.data)
               }).catch(error => {
                  EventBus.$emit(types.ERROR_HAPPENED, error.message)
                  console.log('response error: ' + JSON.stringify(error.response.data))
                })
      },
      save () {
        //console.log("Save risk: " + JSON.stringify(this.editedItem))
        if (this.editedIndex > -1) {
          backend.doWithRiskData(constant.PUT_METHOD, this.riskName,
            this.editedItem.id, this.editedItem)
            .then(response => {
                  console.log('put response: ' + JSON.stringify(response))
                  Object.assign(this.risks[this.editedIndex], this.editedItem)
               }).catch(error => {
                  EventBus.$emit(types.ERROR_HAPPENED, error.message)
                  console.log('response error: ' + JSON.stringify(error.message))
                })
        } else {
          backend.doWithRiskData(constant.POST_METHOD, this.riskName, null, this.editedItem)
            .then(response => {
                   console.log('post response: ' + JSON.stringify(response))
                   this.risks.push(response.data)
               }).catch(error => {
                  EventBus.$emit(types.ERROR_HAPPENED, error.message)
                  console.log('response error: ' + JSON.stringify(error.message))
                })
        }
        this.close()
      },
    },
  }
</script>
