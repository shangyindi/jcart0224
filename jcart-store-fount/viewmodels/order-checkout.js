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
        comment:''
    },mounted(){
        console.log('view mounted')
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
        }
    },

})