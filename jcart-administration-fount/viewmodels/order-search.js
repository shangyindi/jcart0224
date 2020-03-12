var app = new Vue({
    el: '#app',
    data: {
        pageInfo:'',
        pageNum:1,
        statuses:[{value:1,label:'上架'},
                {value:0,label:'下架'}]
    },
    mounted(){
        console.log('View mounted');
        //进行赋值
        this.searchOrder();
    },
    methods:{
        handlePageChange(val){
            console.log('page change')
            this.pageNum = val;
            this.searchProduct();
        },
        searchOrder(){
            axios.get('http://localhost:8080/order/search', {
                params: {
                   pageNum:this.pageNum,
                   pageInfo:this.pageInfo,
                }
            })
                .then(function (response) {
                    console.log(response);
                    app.pageInfo = response.data;    
                })
                .catch(function (error) {
                    console.log(error);
                });
        }
    }
})