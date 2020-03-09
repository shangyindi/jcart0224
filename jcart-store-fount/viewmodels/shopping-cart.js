var app = new Vue({
    el: '#app',
    data: {
       myProducts:[]
    },
    mounted(){
        console.log('view  mounted ')
        var myShoppingCart = localStorage['myShoppingCart'];
        this.myProducts = JSON.parse(myShoppingCart)
    },
    methods: {
        handleDelete(index,row){
            console.log('view deleted click');
            this.myProducts.splice(index,1);
            localStorage['myShoppingCart'] = JSON.stringify(this.myProducts);
        }
    },

})