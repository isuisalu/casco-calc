(function(e){function t(t){for(var i,r,o=t[0],l=t[1],c=t[2],u=0,m=[];u<o.length;u++)r=o[u],Object.prototype.hasOwnProperty.call(n,r)&&n[r]&&m.push(n[r][0]),n[r]=0;for(i in l)Object.prototype.hasOwnProperty.call(l,i)&&(e[i]=l[i]);d&&d(t);while(m.length)m.shift()();return s.push.apply(s,c||[]),a()}function a(){for(var e,t=0;t<s.length;t++){for(var a=s[t],i=!0,o=1;o<a.length;o++){var l=a[o];0!==n[l]&&(i=!1)}i&&(s.splice(t--,1),e=r(r.s=a[0]))}return e}var i={},n={app:0},s=[];function r(t){if(i[t])return i[t].exports;var a=i[t]={i:t,l:!1,exports:{}};return e[t].call(a.exports,a,a.exports,r),a.l=!0,a.exports}r.m=e,r.c=i,r.d=function(e,t,a){r.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:a})},r.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},r.t=function(e,t){if(1&t&&(e=r(e)),8&t)return e;if(4&t&&"object"===typeof e&&e&&e.__esModule)return e;var a=Object.create(null);if(r.r(a),Object.defineProperty(a,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var i in e)r.d(a,i,function(t){return e[t]}.bind(null,i));return a},r.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return r.d(t,"a",t),t},r.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},r.p="/";var o=window["webpackJsonp"]=window["webpackJsonp"]||[],l=o.push.bind(o);o.push=t,o=o.slice();for(var c=0;c<o.length;c++)t(o[c]);var d=l;s.push([0,"chunk-vendors"]),a()})({0:function(e,t,a){e.exports=a("56d7")},"56d7":function(e,t,a){"use strict";a.r(t);a("e260"),a("e6cf"),a("cca6"),a("a79d");var i=a("2b0e"),n=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("v-app",[a("v-navigation-drawer",{attrs:{color:e.color,"expand-on-hover":e.expandOnHover,"mini-variant":e.miniVariant,right:e.right,permanent:e.permanent,src:e.bg,app:"",dark:""},model:{value:e.drawer,callback:function(t){e.drawer=t},expression:"drawer"}},[a("v-list",{staticClass:"py-0",attrs:{dense:"",nav:""}},[a("v-list-item",{class:e.miniVariant&&"px-0",attrs:{"two-line":""}},[a("v-list-item-avatar",[a("img",{attrs:{src:"https://cdn.vuetifyjs.com/images/logos/vuetify-logo-dark.png"}})]),a("v-list-item-content",[a("v-list-item-title",[e._v("Casco calc")])],1)],1),a("v-divider"),e._l(e.items,(function(t){return a("v-list-item",{key:t.title,attrs:{to:t.path}},[a("v-list-item-icon",[a("v-icon",[e._v(e._s(t.icon))])],1),a("v-list-item-content",[a("v-list-item-title",[e._v(e._s(t.title))])],1)],1)}))],2)],1),a("v-content",[a("v-alert",{attrs:{dismissible:"",type:"error",transition:"scale-transition"},model:{value:e.showAlert,callback:function(t){e.showAlert=t},expression:"showAlert"}},[e._v(e._s(e.alertText))]),a("v-container",{attrs:{fluid:""}},[a("router-view")],1)],1)],1)},s=[],r=(a("d3b7"),a("25f0"),new i["a"]),o=r,l="ERROR_HAPPENED",c={data:function(){return{showAlert:!1,alertText:"",drawer:!0,items:[{title:"Risks",icon:"mdi-alert",path:"/risks"},{title:"Cars",icon:"mdi-image",path:"/cars"},{title:"Cascos",icon:"mdi-view-dashboard",path:"/cascos"}],color:"primary",colors:["primary","blue","success","red","teal"],right:!1,permanent:!0,miniVariant:!1,expandOnHover:!0,background:!1}},created:function(){o.$on(l,(function(e){this.showAlert=!0,this.alertText=e.toString()}))},computed:{bg:function(){return this.background?"https://cdn.vuetifyjs.com/images/backgrounds/bg-2.jpg":void 0}}},d=c,u=a("2877"),m=a("6544"),v=a.n(m),f=a("0798"),p=a("7496"),h=a("a523"),g=a("a75b"),b=a("ce7e"),k=a("132d"),x=a("8860"),y=a("da13"),I=a("8270"),V=a("5d23"),_=a("34c3"),C=a("f774"),w=Object(u["a"])(d,n,s,!1,null,null,null),O=w.exports;v()(w,{VAlert:f["a"],VApp:p["a"],VContainer:h["a"],VContent:g["a"],VDivider:b["a"],VIcon:k["a"],VList:x["a"],VListItem:y["a"],VListItemAvatar:I["a"],VListItemContent:V["a"],VListItemIcon:_["a"],VListItemTitle:V["b"],VNavigationDrawer:C["a"]});var N=a("f309"),S=a("5607");i["a"].use(N["a"],{directives:{Ripple:S["a"]}});var T=new N["a"]({icons:{iconfont:"mdi"}}),R=a("8c4f"),$=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("v-container",{staticClass:"grey lighten-5"},[a("v-row",{attrs:{"no-gutters":""}},[e._l(2,(function(t){return[a("v-col",{key:t,attrs:{justify:"center"}},[a("v-card",{staticClass:"pa-2",attrs:{outlined:"",tile:""}},[a("risk",{attrs:{"risk-name":e.riskNames[t-1],"show-use":1===t}})],1)],1)]}))],2),a("v-row",{attrs:{"no-gutters":""}},[a("v-col",{attrs:{justify:"center"}},[a("v-card",{staticClass:"pa-2",attrs:{outlined:"",tile:""}},[a("risk",{attrs:{"risk-name":e.riskNames[2]}})],1)],1),a("v-col",{attrs:{align:"center"}},[a("v-card",{staticClass:"pa-2",attrs:{tile:""}},[a("v-btn",{staticClass:"mb-2",attrs:{color:"normal",dark:""},on:{click:e.recalculate}},[e._v("Recalculate")])],1)],1)],1)],1)},j=[],P=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("v-container",[a("v-data-table",{staticClass:"elevation-1",attrs:{headers:e.headers,items:e.risks,"item-key":"name","hide-default-footer":!0},scopedSlots:e._u([{key:"top",fn:function(){return[a("v-toolbar",{attrs:{flat:"",color:"white"}},[a("v-toolbar-title",[e._v(e._s(e.riskName))]),a("v-divider",{staticClass:"mx-4",attrs:{inset:"",vertical:""}}),a("v-spacer"),a("v-dialog",{attrs:{"max-width":"500px"},scopedSlots:e._u([{key:"activator",fn:function(t){var i=t.on;return[a("v-btn",e._g({staticClass:"mb-2",attrs:{color:"primary",dark:""}},i),[e._v("New")])]}}]),model:{value:e.dialog,callback:function(t){e.dialog=t},expression:"dialog"}},[a("v-card",[a("v-card-title",[a("span",{staticClass:"headline"},[e._v(e._s(e.formTitle))])]),a("v-card-text",[a("v-container",[a("v-row",[a("v-col",{attrs:{cols:"12",sm:"6",md:"4"}},[a("v-text-field",{attrs:{label:"Name"},model:{value:e.editedItem.name,callback:function(t){e.$set(e.editedItem,"name",t)},expression:"editedItem.name"}})],1),a("v-col",{attrs:{cols:"12",sm:"6",md:"4"}},[a("v-text-field",{attrs:{label:"Value"},model:{value:e.editedItem.value,callback:function(t){e.$set(e.editedItem,"value",t)},expression:"editedItem.value"}})],1)],1)],1)],1),a("v-card-actions",[a("v-spacer"),a("v-btn",{attrs:{color:"blue darken-1",text:""},on:{click:e.close}},[e._v("Cancel")]),a("v-btn",{attrs:{color:"blue darken-1",text:""},on:{click:e.save}},[e._v("Save")])],1)],1)],1)],1)]},proxy:!0},e.showUse?{key:"item.inUse",fn:function(t){var i=t.item;return[a("v-checkbox",{on:{change:function(t){return e.saveUse(i)}},model:{value:i.inUse,callback:function(t){e.$set(i,"inUse",t)},expression:"item.inUse"}})]}}:null,{key:"item.actions",fn:function(t){var i=t.item;return[a("v-icon",{staticClass:"mr-2",attrs:{small:""},on:{click:function(t){return e.editItem(i)}}},[e._v(" mdi-pencil ")]),a("v-icon",{attrs:{small:""},on:{click:function(t){return e.deleteItem(i)}}},[e._v(" mdi-delete ")])]}},{key:"no-data",fn:function(){return[a("v-btn",{staticClass:"mb-2",attrs:{color:"primary",dark:""},on:{click:e.initialize}},[e._v("Reset")])]},proxy:!0}],null,!0),model:{value:e.selected,callback:function(t){e.selected=t},expression:"selected"}})],1)},D=[],J=(a("c975"),a("a434"),a("bc3a")),A=a.n(J),E="get",z="post",M="put",W="delete",U="Risk coefficients",L="Make coefficients",F="Average purchase price",B="",H=B+"/risks",q=B+"/risk",G=B+"/make_risks",K=B+"/make_risk",Q=B+"/prices",X=B+"/price",Y=B+"/cars",Z=B+"/car",ee=B+"/cascos",te=B+"/recalculate",ae={doWithRiskData:function(e,t,a,i){if(t===U){if(e===E)return A.a.get(H);if(e===z)return A.a.post(q,i);if(e===M)return A.a.put(q+"/"+a,i);if(e===W)return A.a.delete(q+"/"+a)}else if(t===L){if(e===E)return A.a.get(G);if(e===z)return A.a.post(K,i);if(e===M)return A.a.put(K+"/"+a,i);if(e===W)return A.a.delete(K+"/"+a)}else if(t===F){if(e===E)return A.a.get(Q);if(e===z)return A.a.post(X,i);if(e===M)return A.a.put(X+"/"+a,i);if(e===W)return A.a.delete(X+"/"+a)}},doWithCars:function(e,t,a){return e===E?A.a.get(Y):e===z?A.a.post(Z,a):e===M?A.a.put(Z+"/"+t,a):e===W?A.a.delete(Z+"/"+t):void 0},recalculate:function(){return A.a.get(te)},getCascos:function(){return A.a.get(ee)}},ie={props:["riskName","showUse"],data:function(){return{dialog:!1,singleSelect:!1,selected:[],headers:[],risks:[],editedIndex:-1,editedItem:{name:"",value:0},defaultItem:{name:"",value:0}}},computed:{formTitle:function(){return-1===this.editedIndex?"New Item":"Edit Item"}},watch:{dialog:function(e){e||this.close()}},created:function(){this.initialize()},methods:{initialize:function(){var e=this;console.log("initialize"),this.riskName===F?this.headers=[{text:"Producer",value:"producer"},{text:"Price",value:"price",sortable:!1}]:this.headers=[{text:"Name",value:"name"},{text:"Value",value:"value",sortable:!1}],this.showUse&&this.headers.push({text:"In use",value:"inUse"}),this.headers.push({text:"Action",value:"actions",sortable:!1}),ae.doWithRiskData(E,this.riskName).then((function(t){e.risks=t.data})).catch((function(e){o.$emit(l,e.message),console.log("response error: "+JSON.stringify(e.response.data))}))},editItem:function(e){this.editedIndex=this.risks.indexOf(e),this.editedItem=Object.assign({},e),this.dialog=!0},deleteItem:function(e){var t=e.id,a=this.risks.indexOf(e),i=this;ae.doWithRiskData(W,this.riskName,t,null).then((function(e){console.log("response: "+JSON.stringify(e.status)),i.risks.splice(a,1)})).catch((function(e){o.$emit(l,e.message),console.log("response error: "+JSON.stringify(e.message))}))},close:function(){var e=this;this.dialog=!1,this.$nextTick((function(){e.editedItem=Object.assign({},e.defaultItem),e.editedIndex=-1}))},saveUse:function(e){this.editedIndex=this.risks.indexOf(e);var t=this.editedIndex,a=this;ae.doWithRiskData(M,this.riskName,e.id,e).then((function(e){Object.assign(a.risks[t],e.data)})).catch((function(e){o.$emit(l,e.message),console.log("response error: "+JSON.stringify(e.response.data))}))},save:function(){var e=this.editedIndex,t=this;this.editedIndex>-1?ae.doWithRiskData(M,this.riskName,this.editedItem.id,this.editedItem).then((function(a){Object.assign(t.risks[e],a.data)})).catch((function(e){o.$emit(l,e.message),console.log("response error: "+JSON.stringify(e.message))})):ae.doWithRiskData(z,this.riskName,null,this.editedItem).then((function(e){t.risks.push(e.data)})).catch((function(e){o.$emit(l,e.message),console.log("response error: "+JSON.stringify(e.message))})),this.close()}}},ne=ie,se=a("8336"),re=a("b0af"),oe=a("99d9"),le=a("ac7c"),ce=a("62ad"),de=a("8fea"),ue=a("169a"),me=a("0fd9"),ve=a("2fa4"),fe=a("8654"),pe=a("71d9"),he=a("2a7f"),ge=Object(u["a"])(ne,P,D,!1,null,null,null),be=ge.exports;v()(ge,{VBtn:se["a"],VCard:re["a"],VCardActions:oe["a"],VCardText:oe["b"],VCardTitle:oe["c"],VCheckbox:le["a"],VCol:ce["a"],VContainer:h["a"],VDataTable:de["a"],VDialog:ue["a"],VDivider:b["a"],VIcon:k["a"],VRow:me["a"],VSpacer:ve["a"],VTextField:fe["a"],VToolbar:pe["a"],VToolbarTitle:he["a"]});var ke={components:{risk:be},data:function(){return{riskNames:[U,L,F],risks:[],make_risks:[],purchase_prices:[],riskValues:[]}},created:function(){this.initialize()},methods:{initialize:function(){},recalculate:function(){ae.recalculate()}}},xe=ke,ye=Object(u["a"])(xe,$,j,!1,null,null,null),Ie=ye.exports;v()(ye,{VBtn:se["a"],VCard:re["a"],VCol:ce["a"],VContainer:h["a"],VRow:me["a"]});var Ve=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("v-container",[a("v-data-table",{staticClass:"elevation-1",attrs:{headers:e.headers,items:e.cars,"item-key":"name",loading:e.loading},scopedSlots:e._u([{key:"top",fn:function(){return[a("v-toolbar",{attrs:{flat:"",color:"white"}},[a("v-toolbar-title",[e._v("Cars")]),a("v-divider",{staticClass:"mx-4",attrs:{inset:"",vertical:""}}),a("v-spacer"),a("v-dialog",{attrs:{"max-width":"500px"},scopedSlots:e._u([{key:"activator",fn:function(t){var i=t.on;return[a("v-btn",e._g({staticClass:"mb-2",attrs:{color:"primary",dark:""}},i),[e._v("New")])]}}]),model:{value:e.dialog,callback:function(t){e.dialog=t},expression:"dialog"}},[a("v-card",[a("v-card-title",[a("span",{staticClass:"headline"},[e._v(e._s(e.formTitle))])]),a("v-card-text",[a("v-container",[a("v-row",[a("v-col",{attrs:{cols:"12",sm:"6",md:"4"}},[a("v-text-field",{attrs:{label:"Reg. number"},model:{value:e.editedItem.plateNumber,callback:function(t){e.$set(e.editedItem,"plateNumber",t)},expression:"editedItem.plateNumber"}})],1),a("v-col",{attrs:{cols:"12",sm:"6",md:"4"}},[a("v-text-field",{attrs:{label:"First registration"},model:{value:e.editedItem.firstRegistration,callback:function(t){e.$set(e.editedItem,"firstRegistration",t)},expression:"editedItem.firstRegistration"}})],1),a("v-col",{attrs:{cols:"12",sm:"6",md:"4"}},[a("v-text-field",{attrs:{label:"Purchase price"},model:{value:e.editedItem.purchasePrice,callback:function(t){e.$set(e.editedItem,"purchasePrice",t)},expression:"editedItem.purchasePrice"}})],1),a("v-col",{attrs:{cols:"12",sm:"6",md:"4"}},[a("v-text-field",{attrs:{label:"Producer"},model:{value:e.editedItem.producer,callback:function(t){e.$set(e.editedItem,"producer",t)},expression:"editedItem.producer"}})],1),a("v-col",{attrs:{cols:"12",sm:"6",md:"4"}},[a("v-text-field",{attrs:{label:"Mileage"},model:{value:e.editedItem.mileage,callback:function(t){e.$set(e.editedItem,"mileage",t)},expression:"editedItem.mileage"}})],1),a("v-col",{attrs:{cols:"12",sm:"6",md:"4"}},[a("v-text-field",{attrs:{label:"Prev. indemnity"},model:{value:e.editedItem.previousIndemnity,callback:function(t){e.$set(e.editedItem,"previousIndemnity",t)},expression:"editedItem.previousIndemnity"}})],1)],1)],1)],1),a("v-card-actions",[a("v-spacer"),a("v-btn",{attrs:{color:"blue darken-1",text:""},on:{click:e.close}},[e._v("Cancel")]),a("v-btn",{attrs:{color:"blue darken-1",text:""},on:{click:e.save}},[e._v("Save")])],1)],1)],1)],1)]},proxy:!0},{key:"item.actions",fn:function(t){var i=t.item;return[a("v-icon",{staticClass:"mr-2",attrs:{small:""},on:{click:function(t){return e.editItem(i)}}},[e._v(" mdi-pencil ")]),a("v-icon",{attrs:{small:""},on:{click:function(t){return e.deleteItem(i)}}},[e._v(" mdi-delete ")])]}},{key:"no-data",fn:function(){return[a("v-btn",{attrs:{color:"primary"},on:{click:e.initialize}},[e._v("Reset")])]},proxy:!0}]),model:{value:e.selected,callback:function(t){e.selected=t},expression:"selected"}})],1)},_e=[],Ce={data:function(){return{dialog:!1,singleSelect:!1,selected:[],loading:!1,options:{},headers:[{text:"Reg. number",align:"start",sortable:!0,value:"plateNumber"},{text:"First registration",value:"firstRegistration"},{text:"Purchase price",value:"purchasePrice"},{text:"Producer",value:"producer"},{text:"Mileage",value:"mileage"},{text:"Prev. indemnity",value:"previousIndemnity"},{text:"Actions",value:"actions",sortable:!1}],cars:[],editedIndex:-1,editedItem:{id:"",plateNumber:"",firstRegistration:0,purchasePrice:0,producer:"",mileage:0,prevIndemnity:0},defaultItem:{id:"",plateNumber:"",firstRegistration:0,purchasePrice:0,producer:"",mileage:0,prevIndemnity:0}}},computed:{formTitle:function(){return-1===this.editedIndex?"New Item":"Edit Item"}},watch:{dialog:function(e){e||this.close()}},created:function(){this.initialize()},methods:{initialize:function(){var e=this;this.loading=!0,ae.doWithCars(E).then((function(t){console.log("cars get response: "+JSON.stringify(t.data[0])),e.cars=t.data,e.loading=!1})).catch((function(t){e.loading=!1,console.log("response error: "+JSON.stringify(t.response.data))}))},editItem:function(e){this.editedIndex=this.cars.indexOf(e),this.editedItem=Object.assign({},e),this.dialog=!0},deleteItem:function(e){var t=e.id,a=this.cars.indexOf(e),i=this;ae.doWithCars(W,t,null).then((function(e){console.log("response: "+JSON.stringify(e.status)),i.cars.splice(a,1)})).catch((function(e){o.$emit(l,e.message),console.log("response error: "+JSON.stringify(e.message))}))},close:function(){var e=this;this.dialog=!1,this.$nextTick((function(){e.editedItem=Object.assign({},e.defaultItem),e.editedIndex=-1}))},save:function(){var e=this,t=this;this.editedIndex>-1?ae.doWithCars(M,this.editedItem.id,this.editedItem).then((function(t){console.log("put response: "+JSON.stringify(t)),Object.assign(e.cars[e.editedIndex],t.data)})).catch((function(e){o.$emit(l,e.message),console.log("response error: "+JSON.stringify(e.message))})):ae.doWithCars(z,null,this.editedItem).then((function(e){console.log("post response: "+JSON.stringify(e)),t.cars.push(e.data)})).catch((function(e){o.$emit(l,e.message),console.log("response error: "+JSON.stringify(e.message))})),this.close()}}},we=Ce,Oe=Object(u["a"])(we,Ve,_e,!1,null,null,null),Ne=Oe.exports;v()(Oe,{VBtn:se["a"],VCard:re["a"],VCardActions:oe["a"],VCardText:oe["b"],VCardTitle:oe["c"],VCol:ce["a"],VContainer:h["a"],VDataTable:de["a"],VDialog:ue["a"],VDivider:b["a"],VIcon:k["a"],VRow:me["a"],VSpacer:ve["a"],VTextField:fe["a"],VToolbar:pe["a"],VToolbarTitle:he["a"]});var Se=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("v-container",[a("v-data-table",{staticClass:"elevation-1",attrs:{headers:e.headers,items:e.cascos,"item-key":"name",loading:e.loading},scopedSlots:e._u([{key:"top",fn:function(){return[a("v-toolbar",{attrs:{flat:"",color:"white"}},[a("v-toolbar-title",[e._v("Cascos")]),a("v-divider",{staticClass:"mx-4",attrs:{inset:"",vertical:""}}),a("v-spacer"),a("v-switch",{staticClass:"mx-2",attrs:{label:"Monthly payment"},model:{value:e.monthly,callback:function(t){e.monthly=t},expression:"monthly"}})],1)]},proxy:!0}])})],1)},Te=[],Re={data:function(){return{monthly:!1,loading:!1,headers:[{text:"Reg. number",align:"start",sortable:!0,value:"car.plateNumber"},{text:"Annual payment",value:"annual"},{text:"Producer",value:"car.producer"},{text:"First registration",value:"car.firstRegistration"},{text:"Mileage",value:"car.mileage"},{text:"Prev. indemnity",value:"car.previousIndemnity"}],cascos:[]}},created:function(){this.initialize()},methods:{initialize:function(){var e=this;this.loading=!0,ae.getCascos().then((function(t){e.cascos=t.data,e.loading=!1})).catch((function(t){e.loading=!1,console.log("response error: "+JSON.stringify(t.response.data))}))}},watch:{monthly:function(e){console.log("Switch monthly: "+this.monthly+" val: "+e),this.monthly?this.headers.splice(2,0,{text:"Monthly payment",value:"monthly"}):this.headers.splice(2,1)}}},$e=Re,je=a("b73d"),Pe=Object(u["a"])($e,Se,Te,!1,null,null,null),De=Pe.exports;v()(Pe,{VContainer:h["a"],VDataTable:de["a"],VDivider:b["a"],VSpacer:ve["a"],VSwitch:je["a"],VToolbar:pe["a"],VToolbarTitle:he["a"]}),i["a"].use(R["a"]);var Je=new R["a"]({routes:[{path:"/risks",name:"RiskManagement",component:Ie,beforeEnter:Ae},{path:"/cars",name:"Cars",component:Ne,beforeEnter:Ae},{path:"/cascos",name:"Cascos",component:De,beforeEnter:Ae}]});function Ae(e,t,a){a()}var Ee=Je;i["a"].config.productionTip=!1,i["a"].prototype.$http=A.a,new i["a"]({vuetify:T,router:Ee,render:function(e){return e(O)}}).$mount("#app")}});
//# sourceMappingURL=app.6c3f7196.js.map