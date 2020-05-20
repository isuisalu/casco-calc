<template>
  <v-container class="grey lighten-5">
    <v-row no-gutters>
      <template v-for="n in 2">
        <v-col :key="n" justify = "center">
          <v-card class="pa-2" outlined tile>
            <risk v-bind:risk-name="riskNames[n - 1]"
                v-bind:show-use = "n === 1"/>
           </v-card>
        </v-col>
      </template>
    </v-row>
    <v-row no-gutters>
        <v-col justify = "center">
          <v-card class="pa-2" outlined tile>
             <risk v-bind:risk-name="riskNames[2]" />
          </v-card>
        </v-col>
        <v-col align = "center">
          <v-card class="pa-2" tile>
            <v-btn color="normal" dark class="mb-2" @click="recalculate">Recalculate</v-btn>
          </v-card>
        </v-col>
    </v-row>
  </v-container>
</template>
<script>
import risk from '@/components/Risk'
import * as constant from '../constants'
import backend from '../backend'

export default {
      components: {
        risk
      },
    data: () => ({
       riskNames: [constant.RISK_COEFFICIENTS, constant.MAKE_RISK_COEFFICIENTS,
            constant.AVG_PURCHASE_PRICE],
       risks: [],
       make_risks: [],
       purchase_prices: [],
       riskValues: [],
    }),
    created () {
      this.initialize()
    },
    methods: {
     initialize () {
     },
     recalculate () {
       backend.recalculate()
     }
   },
  }
</script>
