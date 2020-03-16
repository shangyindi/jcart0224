var app = new Vue({
    el: '#app',
    data: {
        customerId: '',
        username: '',
        realName: '',
        mobile: '',
        email: '',
        selectStatus: '',
        createTimestamp: '',
        defaultAddress: '',
        statuses: [{
            value: 0,
            label: '禁用'
        }, {
            value: 1,
            label: '启用'
        }, {
            value: 2,
            label: '不安全'
        }]
    },
    mounted() {
        console.log('View mounted');
        var url = new URL(location.href);
        this.customerId = url.searchParams.get("customerId");
        if (!this.customerId) {
            alert('customerId is null')
            return;
        }
        //进行赋值
        this.getByIdCustomer();
    },
    methods: {
        getByIdCustomer() {
            axios.get('http://localhost:8080/customer/getById', {
                params: {
                    customerId: this.customerId
                }
            })
                .then(function (response) {
                    console.log(response);
                    var customer = response.data;
                    app.customerId = customer.customerId;
                    app.selectStatus = customer.status;
                    app.defaultAddress = customer.defaultAddress;
                    app.createTimestamp = customer.createTimestamp;
                    app.email = customer.email;
                    app.mobile = customer.mobile;
                    app.realName = customer.realName;
                    app.username = customer.username;
                })
                .catch(function (error) {
                    console.log(error);
                });
        },
        setStatus(){
            axios.post('/customer/setStatus',{
                customerId:this.customerId,
                status:this.selectStatus
            }).then(function (response) {
                console.log(response)
                alert('修改状态成功');
            }).catch(function (error) {
                console.log(error)
            })
        }
    }
})