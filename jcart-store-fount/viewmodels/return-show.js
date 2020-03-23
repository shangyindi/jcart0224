var app = new Vue({
    el: '#app',
    data: {
        returnId:'',
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
        orderTimestamp:'',
        customerName:'',
        mobile:'',
        email:'',
        productCode:'',
        productName:'',
        quantity:'',
        opened:false,
        comment:'',
        createTimestamp:'',
    },
    mounted(){
        console.log('view mounted');
        var url = new URL(location.href);
        this.returnId = url.searchParams.get("returnId");
        if(!this.returnId){
            alert("returnId is null")
            return;
        }
        this.getById();
    },
    methods: {
        getById(){
            axios.get('/return/getById',
            {
                params:{
                    returnId:this.returnId
                }
            }).then(function (response) {
            console.log(response)
            var aReturn = response.data;
            app.orderId=aReturn.orderId;
            app.orderTimestamp=aReturn.orderTimestamp;
            app.customerName=aReturn.customerName;
            app.mobile=aReturn.mobile;
            app.email=aReturn.email;
            app.selectReason=aReturn.reason;
            app.opened=aReturn.opened;
            app.comment=aReturn.comment;
            app.quantity=aReturn.quantity;
            app.productCode=aReturn.productCode;
            app.productName=aReturn.productName;
            }).catch(function (error) {
                console.log(error)
            })
        },
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