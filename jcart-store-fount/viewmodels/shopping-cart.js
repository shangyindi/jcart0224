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
            if(confirm('确认删除？')){
            this.myProducts.splice(index,1);
            localStorage['myShoppingCart'] = JSON.stringify(this.myProducts);
            this.$message.success('删除购物车成功');
            }
        },
        handleUpdate(index,row){
            console.log('view upload click')
            localStorage['myShoppingCart'] = JSON.stringify(this.myProducts);
            this.$message.success('修改购物车成功');
        }
    },

})