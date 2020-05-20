import axios from 'axios'
import * as constant from './constants'

const BASE_URL = ''
const RISKS_URL = BASE_URL + '/risks'
const RISK_URL = BASE_URL + '/risk'
const MAKES_URL = BASE_URL + '/make_risks'
const MAKE_URL = BASE_URL + '/make_risk'
const PRICES_URL = BASE_URL + '/prices'
const PRICE_URL = BASE_URL + '/price'
const CARS_URL = BASE_URL + '/cars'
const CAR_URL = BASE_URL + '/car'
const CASCOS_URL = BASE_URL + '/cascos'
const RECALC_URL = BASE_URL + '/recalculate'

export default {

    doWithRiskData: function(methodName, dataName, id, data) {
        if (dataName === constant.RISK_COEFFICIENTS) {
            if (methodName === constant.GET_METHOD) {
                return axios.get(RISKS_URL)
            } else if (methodName === constant.POST_METHOD) {
                return axios.post(RISK_URL, data)
            } else if (methodName === constant.PUT_METHOD) {
                return axios.put(RISK_URL + "/" + id, data)
            } else if (methodName === constant.DELETE_METHOD) {
                return axios.delete(RISK_URL + "/" + id)
            }
        } else if (dataName === constant.MAKE_RISK_COEFFICIENTS) {
            if (methodName === constant.GET_METHOD) {
                return axios.get(MAKES_URL)
            } else if (methodName === constant.POST_METHOD) {
                return axios.post(MAKE_URL, data)
            } else if (methodName === constant.PUT_METHOD) {
                return axios.put(MAKE_URL + "/" + id, data)
            } else if (methodName === constant.DELETE_METHOD) {
                return axios.delete(MAKE_URL + "/" + id)
            }
        } else if (dataName === constant.AVG_PURCHASE_PRICE) {
            if (methodName === constant.GET_METHOD) {
                return axios.get(PRICES_URL)
            } else if (methodName === constant.POST_METHOD) {
                return axios.post(PRICE_URL, data)
            } else if (methodName === constant.PUT_METHOD) {
                return axios.put(PRICE_URL + "/" + id, data)
            } else if (methodName === constant.DELETE_METHOD) {
                return axios.delete(PRICE_URL + "/" + id)
            }
        }
    },
    doWithCars: function (methodName, id, data) {
        if (methodName === constant.GET_METHOD) {
            return axios.get(CARS_URL)
        } else if (methodName === constant.POST_METHOD) {
            return axios.post(CAR_URL, data)
        } else if (methodName === constant.PUT_METHOD) {
            return axios.put(CAR_URL + "/" + id, data)
        } else if (methodName === constant.DELETE_METHOD) {
            return axios.delete(CAR_URL + "/" + id)
        }
    },
    recalculate: function () {
        return axios.get(RECALC_URL)
    },
    getCascos: function() {
        return axios.get(CASCOS_URL)
    }
}