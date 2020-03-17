var app = new Vue({
    el: '#app',
    data: {
        selectReason:'',
        statuses:[
            {
                value: 0,
                label: '发货过期'
              }, {
                value: 1,
                label: '订单错误'
              }, {
                value: 2,
                label: '收到错误商品'
              }, {
                value: 3,
                label: '质量问题'
              }
        ],
        orderId:'',
        orderTime:'',
        customerName:'',
        mobile:'',
        email:'',
        productCode:'',
        productName:'',
        quantity:'',
        opened:false,
        comment:''
    },
    computed: {
        orderTimestamp() {
            return this.orderTime.getTime();
        }
    },
    methods: {
        handleReturnClick() {
            console.log('return click')
            this.ReturnApply();
        },
        ReturnApply() {
            axios.post('/return/apply', {
               orderId:this.orderId,
               orderTime:this.orderTimestamp,
               customerName:this.customerName,
               mobile:this.mobile,
               email:this.email,
               productCode:this.productCode,
               productName:this.productName,
               quantity:this.quantity,
               opened:this.opened,
               comment:this.comment,
               reason:this.selectReason
            }).then(function (response) {
                console.log(response)
                alert('申请退货成功');
            }).catch(function (error) {
                console.log(error)
            })
        }
    },

})