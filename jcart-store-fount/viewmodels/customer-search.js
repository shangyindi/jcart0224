var app = new Vue({
    el: '#app',
    data: {
        pageInfo:'',
        pageNum:1,
    },
    mounted() {
        console.log('view mounted');
        this.searchCustomer();
    },
    methods:{
        searchCustomer(){
           axios.get('/customer/search',{
               params:{
                   pageNum:this.pageNum
               }
           }).then(function (response) {
               console.log(response)
               app.pageInfo=response.data;
           }).catch(function (error) {
               console.log(error)
           })     
        },
        ifstatus(val){
            if(val.status == 0){
                return '禁用';
            }else if(val.status == 1){
                return '启用';
            }else if(val.status == 2){
                return '不安全';
            }
        }
    }

})