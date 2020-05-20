import Vue from 'vue'
import Router from 'vue-router'
import RiskManagement from '@/components/RiskManagement'
import Cars from '@/components/Cars'
import Cascos from '@/components/Cascos'

Vue.use(Router)

const router = new Router({
  routes: [
    {
      path: '/risks',
      name: 'RiskManagement',
      component: RiskManagement,
      beforeEnter: guardRoute
    },
   {
      path: '/cars',
      name: 'Cars',
      component: Cars,
      beforeEnter: guardRoute
    },
   {
      path: '/cascos',
      name: 'Cascos',
      component: Cascos,
      beforeEnter: guardRoute
    },
   ]
})

function guardRoute (to, from, next) {
    //console.log("next to" + JSON.stringify(to));
    next();
}
export default router
