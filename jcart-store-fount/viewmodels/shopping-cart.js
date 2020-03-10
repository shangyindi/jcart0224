var app = new Vue({
    el: '#app',
    data: {
       myProducts:[],
    },
    computed:{
        totalPrice(){
            var subTotalPrices = this.myProducts.map(p => {
                return p.unitPrice * p.discount * p.quantity;
            });
            var totalPrice = subTotalPrices.reduce((a, b) => a + b, 0);
            var totalPriceStr = totalPrice.toFixed(2);
            totalPrice = parseFloat(totalPriceStr);
            return totalPrice;
        }
    },
    mounted(){
        console.log('view  mounted ')
        var myProducts = localStorage['myShoppingCart'];
        this.myProducts = myProducts ? JSON.parse(myProducts) : [];
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