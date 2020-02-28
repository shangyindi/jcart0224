var app = new Vue({
    el: '#app',
    data: {
        pageInfo:''
    },
    methods:{
        searchProduct(){
            axios.get('http://localhost:8080/product/search', {
                params: {
                   
                }
            })
                .then(function (response) {
                    console.log(response);
                })
                .catch(function (error) {
                    console.log(error);
                });
        }
    }
})