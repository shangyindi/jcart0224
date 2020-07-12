var app = new Vue({
    el: '#app',
    data: {
        pageInfo:'',
        pageNum:1,
        statuses:[{value:1,label:'待处理'},
                {value:0,label:'已退货'}]
    },
    mounted(){
        console.log('View mounted');
        //进行赋值
        this.searchReturn();
    },
    methods:{
        handlePageChange(val){
            console.log('page change')
            this.pageNum = val;
            this.searchReturn();
        },
        searchReturn(){
            axios.get('http://localhost:8080/return/search', {
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