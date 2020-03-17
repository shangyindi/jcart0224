var app = new Vue({
    el: '#app',
    data: {
        orderId:'',
        selectedPayMethods:'',
        customerName:'',
        totalPrice:'',
        rewordPoints:'',
        createTimestamp:'',
        updateTimestamp:'',
        selectedShipMethods:'',
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
        orderProducts:[],
        shipAddress:'',
        shipPrice:'',
        comment:'',
        orderHistory:[],
        selectStatus:'',
        statuses:[
            {
                value: 0,
                label: '待处理'
              }, {
                value: 1,
                label: '已发货'
              }, {
                value: 2,
                label: '待收货'
              }, {
                value: 4,
                label: '处理中'
              }
        ],
        customerNotified:false
    },
    mounted(){
        console.log('view mounted');
        var url = new URL(location.href);
        this.orderId = url.searchParams.get("orderId");
        if (!this.orderId) {
            alert('orderId is null')
            return;
        }
        //进行赋值
        this.getByOrder();
        this.getOrderHistory();
    },
    methods:{
        getByOrder(){
            axios.get('/order/getByOrderId',{
                params:{
                    orderId:this.orderId
            }}).then(function (response) {
                console.log(response);
                app.customerName = response.data.customerName;
                app.totalPrice = response.data.totalPrice;
                app.rewordPoints = response.data.rewordPoints;
                app.createTimestamp = response.data.createTimestamp;
                app.updateTimestamp = response.data.updateTimestamp;    
                app.shipAddress = response.data.shipAddress;
                app.shipPrice = response.data.shipPrice;
                app.comment = response.data.comment;
                app.orderProducts = response.data.orderProducts;
                app.selectedShipMethods = response.data.shipMethod;
                app.selectedPayMethods = response.data.payMethod;
            }).catch(function (error) {
                console.log(error);    
            })    
        },
        getOrderHistory(){
            axios.get('/orderHistory/getByOrderList',{
                params:{
                    orderId:this.orderId
                }
            }).then(function (response) {
                console.log(response)
                app.orderHistory = response.data;
            }).catch(function (error) {
                console.log(error)
            })
        },
        addOrderHistory(){
            axios.post('/orderHistory/create',{
                orderId:this.orderId,
                orderStatus:this.selectStatus,
                comment:this.comment,
                customerNotified:this.customerNotified
            }).then(function (response) {
                console.log(response) 
                alert('添加订单历史成功');   
            }).catch(function (error) {
                console.log(error)
            })
        }
    }
})