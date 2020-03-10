var app = new Vue({
    el: '#app',
    data: {
        myAddresses: [],
        payMethods: [
            {
                value: 0,
                label: '借记卡',
            }, {
                value: 1,
                label: '微信',
            }, {
                value: 2,
                label: '支付宝',
            }, {
                value: 3,
                label: '天天',
            }, {
                value: 4,
                label: '信用卡',
            },
        ],
        shipMethods: [
            {
                value: 0,
                label: '顺丰',
            }, {
                value: 1,
                label: '中通',
            }, {
                value: 2,
                label: '韵达',
            }, {
                value: 3,
                label: '天天',
            }, {
                value: 4,
                label: 'EMS',
            }
        ],
        selectedShipAddressId: '',
        selectedInvoiceAddressId: '',
        selectedPayMethods: 1,
        selectedShipMethods: 1,
        comment:'',
        myProducts:[],
        shipPrice:5.0,
    },computed:{
        totalPrice(){
            var subTotalPrices = this.myProducts.map(p => {
                return p.unitPrice * p.discount * p.quantity;
            });
            var totalPrice = subTotalPrices.reduce((a, b) => a + b, 0);
            var totalPriceStr = totalPrice.toFixed(2);
            totalPrice = parseFloat(totalPriceStr);
            return totalPrice;
        },
        orderProducts(){
            var orderProducts = this.myProducts.map(p => {
                var orderProduct = new Object();
                orderProduct.productId = p.productId;
                orderProduct.quantity = p.quantity;
                return orderProduct;
            })
            return orderProducts;
        }
    },mounted(){
        console.log('view mounted')
        var myProducts = localStorage['myShoppingCart'];
        this.myProducts = myProducts ? JSON.parse(myProducts) : [];
        this.getMyAddress();
    },
    methods: {
        getMyAddress() {
            axios.get('/address/getCustomerAddress')
            .then(function (response) {
               console.log(response);
               app.myAddresses = response.data;
            }).catch(function (error) {
                console.log(error)
            })
        },
        handleCheckoutOrder(){
            console.log('click checkoutOrder')
            this.checkout();
        },
        checkout(){
            axios.post('/order/checkout',{
                shipMethod:this.selectedShipMethods,
                shipAddressId:this.selectedShipAddressId,
                comment:this.comment,
                payMethod:this.selectedPayMethods,
                invoiceAddressId:this.selectedInvoiceAddressId,
                orderProducts:this.orderProducts
            })
            .then(function (response) {
                console.log(response)
                alert('下单成功');
            }).catch(function (error) {
                console.log(error)
            })
        }
    },

})