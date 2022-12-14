import Vue from 'vue'
import router from './router'
import app from './App.vue'
import ViewUI from 'view-design';
import Axios from 'axios'
import 'view-design/dist/styles/iview.css';
import 'view-ui-plus/dist/styles/viewuiplus.css'

Axios.defaults.withCredentials = true

Vue.use(ViewUI);

var vm = new Vue({
    el: '#app',
    render: c => c(app),
    router,
    // router
})